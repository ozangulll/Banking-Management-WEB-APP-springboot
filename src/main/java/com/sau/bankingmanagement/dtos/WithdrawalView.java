package com.sau.bankingmanagement.dtos;

import com.sau.bankingmanagement.models.Account;
import com.sau.bankingmanagement.models.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class WithdrawalView {
    private Customer customer;
    private Account account;
    private LocalDateTime transactionDate;
    private BigDecimal amount;

}
