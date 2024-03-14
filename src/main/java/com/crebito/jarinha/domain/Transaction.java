package com.crebito.jarinha.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "transactions")
public class Transaction {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Long amount;

  private String type;

  private String description;

  @ManyToOne
  @JoinColumn(name = "account_id")
  private Account account;

  @Column(name = "created_at")
  @CreationTimestamp
  private LocalDateTime createdAt;
}
