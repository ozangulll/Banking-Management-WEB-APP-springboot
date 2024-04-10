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
public class Customers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="customerId")
    private int id;
    @Column(name="customerName")
    private String name;
    @Column(name="customerAddress")
    private String address;
    @Column(name="customerCity")
    private String city;
}
