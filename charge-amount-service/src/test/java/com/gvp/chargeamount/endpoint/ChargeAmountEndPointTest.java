package com.gvp.chargeamount.endpoint;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.gvp.chargeamount.api.definition.ChargeAmountgGvpApi;
import com.gvp.chargeamount.api.model.RequestChargeAmount;
import com.gvp.chargeamount.api.model.ResponseChargeAmount;
import com.telefonica.schemas.unica.soap.payment.v2.types.ChargeAmountRequest;
import com.telefonica.schemas.unica.soap.payment.v2.types.ChargeAmountResponse;
import com.telefonica.schemas.unica.soap.payment.v2.types.ChargingInformationType;
import com.telefonica.schemas.unica.soap.payment.v2.types.ChargingMetaDataType;
import com.telefonica.schemas.unica.soap.payment.v2.types.ExtensionType;
import com.telefonica.schemas.unica.soap.payment.v2.types.TransactionOperationStatusType;
import com.telefonica.schemas.unica.soap.payment.v2.types.UserIdType;
import com.telefonica.schemas.unica.soap.payment.v2.types.VodProductAdditionalInfoType;

import okhttp3.MediaType;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.mock.Calls;

public class ChargeAmountEndPointTest {

	@Mock
	ChargeAmountgGvpApi chargeAmountgGvpApi;
	@Spy
	ModelMapper modelMapper;
	@InjectMocks
	ChargeAmountEndpoint chargeAmountEndpoint;
	ResponseChargeAmount responseChargeAmount;
	RequestChargeAmount requestChargeAmount;
	ChargeAmountRequest chargeAmount = new ChargeAmountRequest();
	UserIdType userIdType = new UserIdType();
	ChargingInformationType chargingInformationType = new ChargingInformationType();
	ChargingMetaDataType metaData = new ChargingMetaDataType();
	ExtensionType extensionType = new ExtensionType();
	VodProductAdditionalInfoType vodProduct = new VodProductAdditionalInfoType();
	Date date = new Date();

	@BeforeEach
	private void setUp() throws DatatypeConfigurationException {
		responseChargeAmount = ResponseChargeAmount.builder().totalAmountCharged("200").transactionId("transactionId")
				.transactionOperationStatus(TransactionOperationStatusType.PROCESSING.value()).build();

		chargingInformationType.setAmount(new BigDecimal(1000));
		chargingInformationType.setCode("code");
		chargingInformationType.getDescription().add("description");

		vodProduct.setGenre("genre");
		vodProduct.setProducer("producer");

		extensionType.setVodProductAdditionalInfo(vodProduct);

		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(date);

		metaData.setAdditionalProductInfo(extensionType);
		metaData.setChannel("channel");
		metaData.setClientDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar));
		metaData.setProductId("productId");
		metaData.setPurchaseCategoryCode("categoryCode");
		metaData.setServiceId("serviceId");

		userIdType.setAlias("alias");

		chargeAmount.setChargingInformation(chargingInformationType);
		chargeAmount.setChargingMetaData(metaData);
		chargeAmount.setEndUserIdentifier(userIdType);
		chargeAmount.setReferenceCode("referenceCode");

		MockitoAnnotations.openMocks(this);
	}

	@Test
	void chargeAmount() throws IOException {

		// Arrange
		Call<ResponseChargeAmount> CallChargeAmount = Calls.response(responseChargeAmount);
		when(chargeAmountgGvpApi.chargeAmountGvp(Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any()))
				.thenReturn(CallChargeAmount);

		// Act
		ChargeAmountResponse response = chargeAmountEndpoint.chargeAmountRequest(chargeAmount);

		// Assert
		assertNotNull(response);
		assertEquals(responseChargeAmount.getTransactionId(), response.getTransactionId());

	}
	
	@Test
	void chargeAmountConexionError() throws IOException {

		// Arrange
		Call<ResponseChargeAmount> CallChargeAmount = Calls.failure(new IOException());
		when(chargeAmountgGvpApi.chargeAmountGvp(Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any()))
				.thenReturn(CallChargeAmount);

		// Act - Assert
		assertThrows(ResponseStatusException.class, ()-> chargeAmountEndpoint.chargeAmountRequest(chargeAmount));

	}
	
	@Test
	void chargeAmountGvpError() throws IOException {

		// Arrange
		Call<ResponseChargeAmount> CallChargeAmount = Calls.response(getChargeAmountError());
		when(chargeAmountgGvpApi.chargeAmountGvp(Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any()))
				.thenReturn(CallChargeAmount);

		// Act - Assert
		assertThrows(ResponseStatusException.class, ()-> chargeAmountEndpoint.chargeAmountRequest(chargeAmount));

	}
	
	private Response<ResponseChargeAmount> getChargeAmountError() {
		String errorchargeAmountGvp = "{\r\n" + 
				"    \"code\": \"400\",\r\n" + 
				"    \"localizedMessage\": \"GenericError\",\r\n" + 
				"    \"message\": \"GenericError\",\r\n" + 
				"    \"category\": \"INVALID_REQUEST\",\r\n" + 
				"    \"resolved\": true,\r\n" + 
				"    \"exceptionDetail\": [\r\n" + 
				"        {\r\n" + 
				"            \"code\": \"1050\",\r\n" + 
				"            \"component\": \"charge-amount-gvp\",\r\n" + 
				"            \"message\": \"Error del cliente : El status que se obtuvo de customer verification es diferente a 0\",\r\n" + 
				"            \"arguments\": [\r\n" + 
				"                \"null\"\r\n" + 
				"            ],\r\n" + 
				"            \"endpoint\": \"[POST] /telefonica/v1/charge-amount-gvp/charge\"\r\n" + 
				"        }\r\n" + 
				"    ]\r\n" + 
				"}";
		return Response.error(HttpStatus.BAD_REQUEST.value(), ResponseBody.create(errorchargeAmountGvp, MediaType.parse("application/json")));
	}

}
