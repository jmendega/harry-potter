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
public class RequestChargeAmount   {
  @JsonProperty("endUserIdentifier")
  private EndUserIdentifier endUserIdentifier;

  @JsonProperty("chargingInformation")
  private ChargingInformation chargingInformation;

  @JsonProperty("chargingMetaData")
  private ChargingMetaData chargingMetaData;

  @JsonProperty("referenceCode")
  private String referenceCode;

}

