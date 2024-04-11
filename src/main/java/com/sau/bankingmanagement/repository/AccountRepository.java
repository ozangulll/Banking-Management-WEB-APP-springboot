package com.sau.bankingmanagement.repository;

import com.sau.bankingmanagement.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Integer> {
}
