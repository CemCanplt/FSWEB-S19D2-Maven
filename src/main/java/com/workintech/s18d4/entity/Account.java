package com.workintech.s18d4.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "account", schema = "fsweb")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    // ID değişkeni genelde Long olur. Eğer başka bir tür kullanıyorsan, bunu kendine göre değiştir.

    @Column(name = "account_name")
    private String accountName;

    @Column(name = "money_amount")
    private double moneyAmount;


    // CascadeType.ALL, CascadeType.REMOVE, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH}) // fetch = FetchType.LAZY, FetchType.EAGER
    @JoinColumn(name = "customer_id") // mappedBy = "joinColumnName"
    @JsonBackReference
    private Customer customer;

}
