package com.sau.bankingmanagement.repository;

import com.sau.bankingmanagement.dtos.WithdrawalView;
import com.sau.bankingmanagement.models.Account;
import com.sau.bankingmanagement.models.Customer;
import com.sau.bankingmanagement.models.Withdrawal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WithdrawalRepository extends JpaRepository <Withdrawal,Integer> {

    List<Withdrawal> findByCustomer(Customer customer);

    List<Withdrawal> findByAccount(Account account);
}
