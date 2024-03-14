package com.crebito.jarinha.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class InvalidAmountException extends RuntimeException {
  public InvalidAmountException(String message) {
    super(message);
  }
}
