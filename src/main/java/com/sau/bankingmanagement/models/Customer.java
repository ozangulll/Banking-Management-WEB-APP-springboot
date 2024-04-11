package com.sau.bankingmanagement.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="customerId")
    private int id;
    @Column(name="customerName",length = 16)
    private String name;
    @Column(name="customerAddress", length = 32)
    private String address;
    @Column(name="customerCity",length = 16)
    private String city;
}
