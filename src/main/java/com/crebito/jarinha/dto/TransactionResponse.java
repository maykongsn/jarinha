package com.crebito.jarinha.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TransactionResponse {
  private Long balance;
  private Long limit;
}
