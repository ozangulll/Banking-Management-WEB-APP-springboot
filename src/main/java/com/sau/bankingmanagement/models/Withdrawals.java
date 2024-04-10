package com.sau.bankingmanagement.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="withdrawals")
public class Withdrawals {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="withdrawalId")
    private int withdrawalid;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customers customer;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Accounts account;

    @CreationTimestamp
    @Column(name="transactionDate")
    private LocalDateTime date;
    @Column(name="amount")
    private BigDecimal amount;
}
