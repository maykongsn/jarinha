package com.crebito.jarinha.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

public record BalanceResponse(@JsonProperty("total") Long amount,
                              @JsonProperty("data_extrato") LocalDateTime statementDate,
                              @JsonProperty("limite") Long limit) {}

