package com.sau.bankingmanagement.repository;

import com.sau.bankingmanagement.models.Withdrawal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WithdrawalRepository extends JpaRepository <Withdrawal,Integer> {
}
