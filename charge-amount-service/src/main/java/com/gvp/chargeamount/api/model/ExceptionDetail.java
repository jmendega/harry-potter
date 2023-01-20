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
public class ExceptionDetail {
	
	@JsonProperty("code")
	private String code;
	@JsonProperty("component")
	private String component;
	@JsonProperty("message")
	private String message;
	@JsonProperty("arguments")
	private List<String> arguments;
	@JsonProperty("endpoint")
	private String endpoint;

}
