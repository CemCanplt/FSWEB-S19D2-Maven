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
@Table(name = "adress", schema = "fsweb")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
// ID değişkeni genelde Long olur. Eğer başka bir tür kullanıyorsan, bunu kendine göre değiştir.

    @Column(name = "street")
    private String street;

    @Column(name = "no")
    private int no;

    @Column(name = "city")
    private String city;

    @Column(name = "country")
    private String country;

    @Column(name = "description")
    private String description;

    // CascadeType.ALL, CascadeType.REMOVE, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH}) // fetch = FetchType.LAZY, FetchType.EAGER
    @JsonBackReference("customer-address")
    private Customer customer;

}
