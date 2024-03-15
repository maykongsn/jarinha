package com.crebito.jarinha.repository;

import com.crebito.jarinha.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
  List<Transaction> findTop10ByAccountIdOrderByCreatedAtDesc(Long id);
}
