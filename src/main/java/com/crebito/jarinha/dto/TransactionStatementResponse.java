package com.crebito.jarinha.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public record TransactionStatementResponse(@JsonProperty("valor") Long amount,
                                           @JsonProperty("tipo") String type,
                                           @JsonProperty("descricao") String description,
                                           @JsonProperty("realizada_em") LocalDateTime createdAt) {}