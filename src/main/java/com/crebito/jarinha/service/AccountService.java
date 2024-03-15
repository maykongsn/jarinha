package com.crebito.jarinha.service;

import com.crebito.jarinha.domain.Account;
import com.crebito.jarinha.domain.Transaction;
import com.crebito.jarinha.dto.TransactionRequest;
import com.crebito.jarinha.dto.TransactionResponse;
import com.crebito.jarinha.exception.AccountNotFoundException;
import com.crebito.jarinha.exception.InvalidAmountException;
import com.crebito.jarinha.exception.InvalidTransactionException;
import com.crebito.jarinha.repository.AccountRepository;
import com.crebito.jarinha.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService {
  private final TransactionRepository transactionRepository;
  private final AccountRepository accountRepository;

  public List<Transaction> getLastTransactions(Long id) {
    return transactionRepository.findTop10ByAccountIdOrderByCreatedAtDesc(id);
  }

  @Transactional
  public Account findAccountById(Long id) {
    return accountRepository.findById(id)
            .orElseThrow(() -> new AccountNotFoundException("Conta não encontrada"));
  }

  @Transactional
  public TransactionResponse createTransaction(Long accountId, TransactionRequest transactionRequest) {
    Account account = findAccountById(accountId);

    account.setBalance(calculateBalance(account, transactionRequest));
    accountRepository.save(account);

    transactionRepository.save(Transaction.builder()
            .amount(transactionRequest.getAmount())
            .type(transactionRequest.getType())
            .description(transactionRequest.getDescription())
            .account(account)
            .build()
    );

    return TransactionResponse.builder()
            .balance(account.getBalance())
            .limit(account.getLimit())
            .build();
  }

  private Long calculateBalance(Account account, TransactionRequest transaction) {
    if(transaction.getType().equals("d")) {
      if(account.getBalance() + account.getLimit() < transaction.getAmount()) {
        throw new InvalidAmountException("Limite insuficiente");
      }
      return account.getBalance() - transaction.getAmount();
    }

    if(transaction.getType().equals("c")) {
      return account.getBalance() + transaction.getAmount();
    }

    throw new InvalidTransactionException("Transação inválida");
  }
}
