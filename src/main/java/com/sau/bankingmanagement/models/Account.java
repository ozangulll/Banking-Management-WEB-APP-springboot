package com.sau.bankingmanagement.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;
import org.springframework.format.annotation.NumberFormat;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="account")
public class Account {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "Id should not be null")
    @Min(value=1, message = "Id should be bigger than 0")
    private int id;
    @NotEmpty(message = "Branch should not be empty.")
    @Column(name="accountBranch",length=16)
    private String branch;
    @NotNull(message = "balance should not be null")
    @Column(name="accountBalance")
    private BigDecimal balance;

    @OneToMany(mappedBy = "account",cascade = CascadeType.ALL)
    private List<Withdrawal> withdrawals;
}
