package com.sau.bankingmanagement.repository;

import com.sau.bankingmanagement.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account,Integer> {
    Optional<Account> findByBranch(String branch);

    @Query("select a from Account a where a.branch LIKE CONCAT('%',:query,'%')")
    List<Account> searchBranch(String query);
}
