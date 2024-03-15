package com.crebito.jarinha.controller;

import com.crebito.jarinha.domain.Account;
import com.crebito.jarinha.domain.Transaction;
import com.crebito.jarinha.dto.*;
import com.crebito.jarinha.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("clientes")
@RequiredArgsConstructor
public class AccountController {
  private final AccountService accountService;

  @GetMapping(path = "/{id}/extrato")
  public ResponseEntity<StatementResponse> statement(@PathVariable Long id) {
    Account account = accountService.findAccountById(id);

    BalanceResponse balanceResponse = new BalanceResponse(account.getBalance(), LocalDateTime.now(), account.getLimit());

    List<TransactionStatementResponse> transactions = accountService.getLastTransactions(id)
            .stream()
            .map(transaction -> new TransactionStatementResponse(transaction.getAmount(), transaction.getType(), transaction.getDescription(), transaction.getCreatedAt()))
            .toList();

    return new ResponseEntity<>(new StatementResponse(balanceResponse, transactions), HttpStatus.OK);
  }

  @PostMapping(path = "/{id}/transacoes")
  public ResponseEntity<TransactionResponse> transaction(@PathVariable Long id, @Validated @RequestBody TransactionRequest request) {
    return new ResponseEntity<>(accountService.createTransaction(id, request), HttpStatus.CREATED);
  }
}
