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
public class AdditionalProductInfo   {
  @JsonProperty("vodProductAdditionalInfo")
  private VodProductAdditionalInfo vodProductAdditionalInfo;

}

