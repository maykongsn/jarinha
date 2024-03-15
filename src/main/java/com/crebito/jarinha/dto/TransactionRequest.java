package com.crebito.jarinha.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TransactionRequest {
  @JsonProperty("valor")
  private Long amount;

  @JsonProperty("descricao")
  @Size(min = 1, max = 10, message = "A descrição deve conter de 1 a 10 caracteres")
  private String description;

  @JsonProperty("tipo")
  @Size(min = 1, max = 1)
  @Pattern(regexp = "[cd]", message = "O tipo deve ser apenas 'c' ou 'd'")
  private String type;
}
