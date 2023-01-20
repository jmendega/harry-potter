package com.gvp.chargeamount.config;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.Base64;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration.AccessLevel;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.SimpleWsdl11Definition;
import org.springframework.ws.wsdl.wsdl11.Wsdl11Definition;

import com.gvp.chargeamount.api.definition.ChargeAmountgGvpApi;

import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Slf4j
@EnableWs
@Configuration
public class Config {

	@Value("${application.config.url-mapping}")
	String urlMapping;
	@Value("${application.config.wsdl-path}")
	String wsdlPath;
	@Value("${application.config.trust-store}")
	String trustStore;
	@Value("${application.config.trust-store-password}")
	String password;

	@Bean
	ChargeAmountgGvpApi chargeAmoungGvpApi(@Value("${application.charge-amount-gvp.config.base-url}") String apiBaseUrl)
			throws UnrecoverableKeyException, KeyManagementException, KeyStoreException, NoSuchAlgorithmException,
			CertificateException, IOException {
		OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
		Retrofit retrofit = new Retrofit.Builder().baseUrl(apiBaseUrl).client(initSSL(builder))
				.addConverterFactory(GsonConverterFactory.create()).build();
		log.info("Creating ApiServiceImpl rest client host {}", apiBaseUrl);
		return retrofit.create(ChargeAmountgGvpApi.class);
	}

	@Bean
	public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(
			ApplicationContext applicationContext) {
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(applicationContext);
		servlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean<>(servlet, urlMapping);
	}

	@Bean(name = "chargeAmountWsdl")
	public Wsdl11Definition defaultWsdl11Definition() {
		SimpleWsdl11Definition wsdl11Definition = new SimpleWsdl11Definition();
		wsdl11Definition.setWsdl(new ClassPathResource(wsdlPath));
		return wsdl11Definition;
	}

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD)
				.setFieldAccessLevel(AccessLevel.PRIVATE);
		return modelMapper;
	}

	private OkHttpClient initSSL(OkHttpClient.Builder builder) throws KeyStoreException, NoSuchAlgorithmException,
			CertificateException, IOException, UnrecoverableKeyException, KeyManagementException {

		Base64.Decoder decoder = Base64.getDecoder();
		ByteArrayInputStream inputStream = new ByteArrayInputStream(decoder.decode(trustStore));

		KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
		keyStore.load(inputStream, new String(decoder.decode(password)).toCharArray());

		TrustManagerFactory trustManagerFactory = TrustManagerFactory
				.getInstance(TrustManagerFactory.getDefaultAlgorithm());
		trustManagerFactory.init(keyStore);
		TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
		if (trustManagers.length != 1 || !(trustManagers[0] instanceof X509TrustManager)) {
			throw new IllegalStateException("Unexpected default trust managers: " + Arrays.toString(trustManagers));
		}
		X509TrustManager trustManager = (X509TrustManager) trustManagers[0];

		SSLContext sslContext = SSLContext.getInstance("TLSv1.2");
		KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
		keyManagerFactory.init(keyStore, password.toCharArray());
		sslContext.init(null, trustManagers, new SecureRandom());

		builder.sslSocketFactory(sslContext.getSocketFactory(), trustManager).hostnameVerifier(new HostnameVerifier() {
			@Override
			public boolean verify(String requestedHost, SSLSession remoteServerSession) {
				return requestedHost.equalsIgnoreCase(remoteServerSession.getPeerHost());
			}
		}).build();

		return builder.build();

	}

}
