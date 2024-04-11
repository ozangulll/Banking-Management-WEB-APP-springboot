package com.sau.bankingmanagement.repository;

import com.sau.bankingmanagement.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository <Customer,Integer>{

Optional<Customer> findbyAdress(String address);
//optional means it can be nullable or not.
// A container object which may or may not contain a non-null value.
// eğer null ise isPresent() false döndürecek. bu işlevi controller tarafında kullanalım. Unutma

}
