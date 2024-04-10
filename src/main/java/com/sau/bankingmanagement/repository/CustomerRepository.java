package com.sau.bankingmanagement.repository;

import com.sau.bankingmanagement.models.Customers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository <Customers,Integer>{

}
