package com.sau.bankingmanagement.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="customer")
public class Customer {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="customerName",length = 16)
    private String name;
    @Column(name="customerAddress", length = 32)
    private String address;
    @Column(name="customerCity",length = 16)
    private String city;

    @OneToMany(mappedBy = "id",cascade = CascadeType.ALL)
    private List<Withdrawal> withdrawals;
}
