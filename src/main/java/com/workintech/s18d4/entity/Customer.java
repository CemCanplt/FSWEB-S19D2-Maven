package com.workintech.s18d4.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "customer", schema = "fsweb")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
// ID değişkeni genelde Long olur. Eğer başka bir tür kullanıyorsan, bunu kendine göre değiştir.

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "salary")
    private double salary;

    // CascadeType.ALL, CascadeType.REMOVE, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    @JsonManagedReference// fetch = FetchType.LAZY, FetchType.EAGER
    private List<Account> accounts = new ArrayList<>();

    // CascadeType.ALL, CascadeType.REMOVE, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH
    @OneToOne(cascade = CascadeType.ALL) // fetch = FetchType.LAZY, FetchType.EAGER
    @JoinColumn(name = "address_id") // mappedBy = "joinColumnName"
    @JsonManagedReference("customer-address")
    private Address address;

}
