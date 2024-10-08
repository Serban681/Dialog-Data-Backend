package com.example.shopbackend.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "shop_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy="id")
    private List<Order> orders;

    @Column(name="first_name", nullable = false)
    private String firstName;

    @Column(name="last_name", nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String email;

    @Column(name="phone_number", nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private String password;

    @ManyToOne
    @JoinColumn(name="default_delivery_address_id", nullable = false)
    private Address default_delivery_address;

    @ManyToOne
    @JoinColumn(name="default_billing_address_id", nullable = false)
    private Address default_billing_address;

    @PrePersist
    @PreUpdate
    private void checkAddresses() {
        if(default_delivery_address != null && default_delivery_address.equals(default_billing_address)) {
            default_billing_address = default_delivery_address;
        }
    }
}
