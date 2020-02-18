package com.kharoud.cars.models;


import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Component
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Cart_gen")
    private int cartId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn( name = "custId")
    private Customer customer;

    @OneToMany
    private List<Cars> carsList = new ArrayList<>();

    public Cart() {
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Cars> getCarsList() {
        return carsList;
    }

    public void setCarsList(List<Cars> carsList) {
        this.carsList = carsList;
    }
}
