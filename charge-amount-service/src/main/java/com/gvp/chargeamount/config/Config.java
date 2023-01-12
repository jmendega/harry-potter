package com.gvp.chargeamount.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.ws.wsdl.wsdl11.SimpleWsdl11Definition;
import org.springframework.ws.wsdl.wsdl11.Wsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

import lombok.extern.slf4j.Slf4j;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Slf4j
@EnableWs
@Configuration
public class Config {
	
//	@Bean
//	ApiServiceImpl gestionApi() {
//		Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("https://harry-potter-service-1672868069915.azurewebsites.net/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//		log.info("Creating ApiServiceImpl rest client host {}", "http://hp-api.herokuapp.com/api/characters/");
//		return retrofit.create(ApiServiceImpl.class);
//	}
	
	@Bean
	public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(applicationContext);
		servlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean(servlet, "/Movistar_WS_GVP/*");
	}

//	@Bean(name = "chargeAmountWsdl")
//	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema schema) {
//		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
////		wsdl11Definition.setRequestSuffix("chargeAmount");
//		wsdl11Definition.setPortTypeName("PaymentPort");
//		wsdl11Definition.setLocationUri("/Movistar_WS_GVP/PaymentService");
//		wsdl11Definition.setTargetNamespace("http://www.telefonica.com/wsdl/UNICA/SOAP/payment/transaction/v2/services");
//		wsdl11Definition.setSchema(schema);
//		
//		return wsdl11Definition;
//	}
//	
//
//
//	@Bean
//	public XsdSchema chargeAmountSchema() {
//		return new SimpleXsdSchema(new ClassPathResource("xsd/UNICA_API_SOAP_payment_types_v2_2.xsd"));
//	}
	
	//http://localhost:8080/ws/services.wsdl --bean name is set to 'services'
    @Bean(name = "chargeAmountWsdl")
    public Wsdl11Definition defaultWsdl11Definition() {
        SimpleWsdl11Definition wsdl11Definition = new SimpleWsdl11Definition();
        wsdl11Definition.setWsdl(new ClassPathResource("schema/UNICA_API_SOAP_payment_transaction_services_v2_2_2.wsdl")); //your wsdl location
        return wsdl11Definition;
    }

}
