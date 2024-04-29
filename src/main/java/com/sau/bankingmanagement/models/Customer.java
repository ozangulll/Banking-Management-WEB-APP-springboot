package com.sau.bankingmanagement.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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
    @NotNull(message = "Id should not be null")
    @Min(value=1, message = "Id should be bigger than 0")
    private int id;
    @Column(name="customerName",length = 16)
    @NotEmpty(message = "Name should not be empty.")

    private String name;
    @NotEmpty(message = "Address should not be empty.")
    @Column(name="customerAddress", length = 32)
    @NotEmpty(message = "Branch should not be empty.")
    private String address;
    @NotEmpty(message = "City should not be empty.")
    @Column(name="customerCity",length = 16)
    private String city;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    private List<Withdrawal> withdrawals;
}
