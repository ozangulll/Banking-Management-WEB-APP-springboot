package com.sau.bankingmanagement.dtos;

import com.sau.bankingmanagement.models.Account;
import com.sau.bankingmanagement.models.Customer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class WithdrawalView {

    private int id;
    private int customerId;
    private int accountId;
    private String customerName;
    private String accountBranch;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime date;
    private BigDecimal amount;

}