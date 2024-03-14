package com.crebito.jarinha.domain;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "accounts")
public class Account {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  private Long balance;

  @Column(name = "limit_amount")
  private Long limit;
}
