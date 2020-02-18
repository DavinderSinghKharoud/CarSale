package com.kharoud.cars.models;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Component
public class Cars {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "car_gen")
    private int carId;


    @OneToMany(cascade = CascadeType.ALL)
    private List<Orders> orders = new ArrayList<>();

    private String name;
    private String color;
    private String engine;
    private int price;

    @Override
    public String toString() {
        return "Cars{" +
                "carId=" + carId +
                ", orders=" + orders +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", engine='" + engine + '\'' +
                ", price=" + price +
                '}';
    }

    public Cars() {
    }


    public int getCarId() {
        return carId;
    }

    public Cars setCarId(int carId) {
        this.carId = carId;
        return this;
    }

    public String getName() {
        return name;
    }

    public Cars setName(String name) {
        this.name = name;
        return this;
    }

    public String getColor() {
        return color;
    }

    public Cars setColor(String color) {
        this.color = color;
        return this;
    }

    public String getEngine() {
        return engine;
    }

    public Cars setEngine(String engine) {
        this.engine = engine;
        return this;
    }

    public int getPrice() {
        return price;
    }

    public Cars setPrice(int price) {
        this.price = price;
        return this;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }
}
