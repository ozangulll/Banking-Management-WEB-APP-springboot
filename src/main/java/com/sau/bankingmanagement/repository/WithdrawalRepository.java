package com.sau.bankingmanagement.repository;

import com.sau.bankingmanagement.models.Withdrawals;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WithdrawalRepository extends JpaRepository <Withdrawals,Integer> {
}
