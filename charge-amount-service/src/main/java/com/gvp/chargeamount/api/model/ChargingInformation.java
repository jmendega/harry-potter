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
public class ChargingInformation   {
  @JsonProperty("description")
  private String description;

  @JsonProperty("amount")
  private String amount;

  @JsonProperty("code")
  private String code;

}

