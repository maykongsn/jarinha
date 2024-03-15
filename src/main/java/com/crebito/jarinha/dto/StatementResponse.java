package com.crebito.jarinha.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class StatementResponse {
  @JsonProperty("saldo")
  BalanceResponse balance;

  @JsonProperty("ultimas_transacoes")
  List<TransactionStatementResponse> transactions;
}
