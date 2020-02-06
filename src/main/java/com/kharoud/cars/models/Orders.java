package com.kharoud.cars.models;

import javax.persistence.*;

@Entity
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cust_id")
    private Customer customer;

    private String ShippingAddress;




}
