package com.gvp.chargeamount.api.definition;

import java.util.Map;

import com.gvp.chargeamount.api.model.RequestChargeAmount;
import com.gvp.chargeamount.api.model.ResponseChargeAmount;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ChargeAmountgGvpApi {

	@POST("charge-amount-gvp/charge")
	Call<ResponseChargeAmount> chargeAmountGvp(@Query("APP_KEY") String appKey, @Query("APP_ID") String appId,
			@Body RequestChargeAmount requestChargeAmount,
			@HeaderMap Map<String, String> headers);
}
