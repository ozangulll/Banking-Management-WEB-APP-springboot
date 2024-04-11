package com.sau.bankingmanagement.repository;

import com.sau.bankingmanagement.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account,Integer> {

    Optional<Account> findByBranch(String branch);
}
