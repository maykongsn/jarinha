package com.crebito.jarinha.controller;

import com.crebito.jarinha.domain.Transaction;
import com.crebito.jarinha.dto.TransactionRequest;
import com.crebito.jarinha.dto.TransactionResponse;
import com.crebito.jarinha.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clientes")
@RequiredArgsConstructor
public class AccountController {
  private final AccountService accountService;

  @GetMapping(path = "/{id}/extrato")
  public ResponseEntity<List<Transaction>> statement(@PathVariable Long id) {
    return new ResponseEntity<>(accountService.statement(id), HttpStatus.OK);
  }

  @PostMapping(path = "/{id}/transacoes")
  public ResponseEntity<TransactionResponse> transaction(@PathVariable Long id, @Validated @RequestBody TransactionRequest request) {
    return new ResponseEntity<>(accountService.createTransaction(id, request), HttpStatus.CREATED);
  }
}
