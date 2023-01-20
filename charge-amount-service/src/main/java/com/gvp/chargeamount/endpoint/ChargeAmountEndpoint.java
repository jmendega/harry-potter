package com.gvp.chargeamount.endpoint;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.google.gson.Gson;
import com.gvp.chargeamount.api.definition.ChargeAmountgGvpApi;
import com.gvp.chargeamount.api.model.ErrorChargeAmount;
import com.gvp.chargeamount.api.model.RequestChargeAmount;
import com.gvp.chargeamount.api.model.ResponseChargeAmount;
import com.telefonica.schemas.unica.soap.payment.v2.types.ChargeAmountRequest;
import com.telefonica.schemas.unica.soap.payment.v2.types.ChargeAmountResponse;
import com.telefonica.schemas.unica.soap.payment.v2.types.TransactionOperationStatusType;

import lombok.extern.slf4j.Slf4j;
import retrofit2.Call;
import retrofit2.Response;

@Slf4j
@Endpoint
public class ChargeAmountEndpoint {

	@Value("${application.charge-amount-gvp.config.app-key}")
	String appKey;
	@Value("${application.charge-amount-gvp.config.app-id}")
	String appId;
	@Value("${application.charge-amount-gvp.config.operation}")
	String operation;
	@Value("${application.charge-amount-gvp.config.system}")
	String system;
	@Value("${application.charge-amount-gvp.config.msgType}")
	String msgType;
	@Value("${application.charge-amount-gvp.config.authorization}")
	String authorization;

	@Autowired
	ChargeAmountgGvpApi chargeAmountgGvpApi;
	@Autowired
	ModelMapper modelMapper;

	private static final String NAMESPACE_URI = "http://www.telefonica.com/schemas/UNICA/SOAP/payment/v2/types";

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "chargeAmount")
	@ResponsePayload
	public ChargeAmountResponse chargeAmountRequest(@RequestPayload ChargeAmountRequest chargeAmount) {
		RequestChargeAmount requestChargeAmount = modelMapper.map(chargeAmount, RequestChargeAmount.class);

		Call<ResponseChargeAmount> callChargeAmount = chargeAmountgGvpApi.chargeAmountGvp(appKey, appId,
				requestChargeAmount, getHeadersChargeAmount());
		Response<ResponseChargeAmount> responseChargeAmount;
		try {
			responseChargeAmount = callChargeAmount.execute();

			if (responseChargeAmount.isSuccessful()) {
				ChargeAmountResponse response = modelMapper.map(responseChargeAmount.body(),
						ChargeAmountResponse.class);
				response.setTransactionOperationStatus(TransactionOperationStatusType
						.fromValue(responseChargeAmount.body().getTransactionOperationStatus()));

				return response;
			} else {
				Gson gson = new Gson();
				ErrorChargeAmount errorChargeAmount = gson.fromJson(responseChargeAmount.errorBody().string(), ErrorChargeAmount.class);
				log.error("Error charge-amount-gvp : Request  : {} , Response : {} ", requestChargeAmount.toString(),
						errorChargeAmount.toString());

				throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
						errorChargeAmount.getExceptionDetail().get(0).getMessage());
			}
		} catch (IOException e) {
			log.error("Error de conexion charge-amount-gvp : {} ", HttpStatus.INTERNAL_SERVER_ERROR + e.getMessage());
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}

	}

	private Map<String, String> getHeadersChargeAmount() {
		Map<String, String> headers = new HashMap<>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");

		headers.put("timestamp", sdf.format(new Timestamp(System.currentTimeMillis())));
		headers.put("operation", operation);
		headers.put("system", system);
		headers.put("execId", UUID.randomUUID().toString());
		headers.put("msgType", msgType);
		headers.put("authorization", authorization);
		return headers;
	}

}
