package com.sau.bankingmanagement.repository;

import com.sau.bankingmanagement.models.Account;
import com.sau.bankingmanagement.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository <Customer,Integer>{

    Optional<Customer> findByAddress(String address);

    @Query("select c from Customer c where c.name LIKE CONCAT('%',:query,'%')")
    List<Account> searchName(String query);



//optional means it can be nullable or not.
// A container object which may or may not contain a non-null value.
// eğer null ise isPresent() false döndürecek. bu işlevi controller tarafında kullanalım. Unutma

}
