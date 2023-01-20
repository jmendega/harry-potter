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
public class ChargingMetaData   {
  @JsonProperty("purchaseCategoryCode")
  private String purchaseCategoryCode;

  @JsonProperty("channel")
  private String channel;

  @JsonProperty("serviceId")
  private String serviceId;

  @JsonProperty("productId")
  private String productId;

  @JsonProperty("clientDate")
  private String clientDate;

  @JsonProperty("additionalProductInfo")
  private AdditionalProductInfo additionalProductInfo;

}

