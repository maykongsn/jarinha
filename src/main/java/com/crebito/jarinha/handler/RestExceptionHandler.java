package com.crebito.jarinha.handler;

import com.crebito.jarinha.exception.AccountNotFoundException;
import com.crebito.jarinha.exception.InvalidAmountException;
import com.crebito.jarinha.exception.InvalidTransactionException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {
  @ExceptionHandler(AccountNotFoundException.class)
  public ResponseEntity<String> handleAccountNotFoundException(AccountNotFoundException exception) {
    return ResponseEntity.notFound().build();
  }

  @ExceptionHandler(InvalidAmountException.class)
  public ResponseEntity<String> handleInvalidAmountException(InvalidAmountException exception) {
    return ResponseEntity.unprocessableEntity().body(exception.getMessage());
  }

  @ExceptionHandler(InvalidTransactionException.class)
  public ResponseEntity<String> handleInvalidTransactionException(InvalidTransactionException exception) {
    return ResponseEntity.badRequest().body(exception.getMessage());
  }
}
