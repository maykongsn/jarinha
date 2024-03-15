package com.crebito.jarinha.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TransactionResponse {
  @JsonProperty("limite")
  private Long limit;

  @JsonProperty("saldo")
  private Long balance;
}
