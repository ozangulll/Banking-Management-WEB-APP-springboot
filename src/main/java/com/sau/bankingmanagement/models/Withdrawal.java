package com.sau.bankingmanagement.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Check;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.jmx.export.annotation.ManagedResource;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="withdrawals")
@Check(constraints = "amount=>0")
public class Withdrawal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="withdrawalId")
    private int withdrawalid;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    @CreationTimestamp
    @Column(name="transactionDate")
    private LocalDateTime date;

    @Column(name="amount")
    private BigDecimal amount;
}
