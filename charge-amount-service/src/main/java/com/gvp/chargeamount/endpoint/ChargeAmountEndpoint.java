package com.gvp.chargeamount.endpoint;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.telefonica.schemas.unica.soap.payment.v2.types.ChargeAmountRequest;
import com.telefonica.schemas.unica.soap.payment.v2.types.ChargeAmountResponse;

@Endpoint
public class ChargeAmountEndpoint {

	private static final String NAMESPACE_URI = "http://www.telefonica.com/schemas/UNICA/SOAP/payment/v2/types";

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "chargeAmount")
	@ResponsePayload
	public ChargeAmountResponse chargeAmountRequest(@RequestPayload ChargeAmountRequest chargeAmount) {
		ChargeAmountResponse response = new ChargeAmountResponse();
		response.setTransactionId("demoVAluh");

		return response;
	}

}
