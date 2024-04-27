package com.sau.bankingmanagement.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="accounts")
public class Account {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="accountId")
    @NotNull(message = "Id should not be null")
    @Positive(message = "Id should be bigger than 0")
    private int id;
    @NotEmpty(message = "Branch should not be empty.")
    @Column(name="accountBranch",length=16)
    private String branch;
    @NotNull(message = "balance should not be null")
    @Column(name="accountBalance")
    private BigDecimal balance;
    @OneToMany(mappedBy = "Withdrawal",cascade = CascadeType.ALL)
    private Set<Withdrawal> withdrawals=new HashSet<>();
}
