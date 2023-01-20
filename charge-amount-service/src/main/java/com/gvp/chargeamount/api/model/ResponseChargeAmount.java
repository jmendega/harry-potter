package com.gvp.chargeamount.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ResponseChargeAmount   {
  @JsonProperty("transactionId")
  private String transactionId;

  @JsonProperty("transactionOperationStatus")
  private String transactionOperationStatus;

  @JsonProperty("totalAmountCharged")
  private String totalAmountCharged;
  
}

