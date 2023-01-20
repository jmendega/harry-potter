package com.gvp.chargeamount.api.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ErrorChargeAmount {

	@JsonProperty("code")
	private String code;
	@JsonProperty("localizedMessage")
	private String localizedMessage;
	@JsonProperty("message")
	private String message;
	@JsonProperty("category")
	private String category;
	@JsonProperty("resolved")
	private String resolved;
	@JsonProperty("exceptionDetail")
	private List<ExceptionDetail> exceptionDetail;

}
