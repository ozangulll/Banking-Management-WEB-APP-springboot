package com.sau.bankingmanagement.repository;

import com.sau.bankingmanagement.models.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Accounts,Integer> {
}
