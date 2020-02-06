package com.kharoud.cars.controllers;

import com.kharoud.cars.models.Cars;
import com.kharoud.cars.models.Cart;
import com.kharoud.cars.models.Customer;
import com.kharoud.cars.repository.CarsRepository;
import com.kharoud.cars.repository.CartRepository;
import com.kharoud.cars.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {

    @Autowired
    private Cart cart;

    @Autowired
    private Customer customer;

    private CarsRepository carsRepository;
    private CustomerRepository customerRepository;
    private CartRepository cartRepository;

    public HomeController(CarsRepository carsRepository, CustomerRepository customerRepository, CartRepository cartRepository) {
        this.carsRepository = carsRepository;
        this.customerRepository = customerRepository;
        this.cartRepository = cartRepository;
    }

    @RequestMapping("/update")
    public List<Cart> home(){

        customer.setEmail("Dskharoud2@gmail.com");
        customer.setName("Sunny");

        Cars cars = new Cars();
        cars.setName("Mustang");
        cars.setColor("Black");
        cars.setEngine("High power");
        cars.setPrice(1000);



        Cars cars1 = new Cars();
        cars1.setName("Challenger");
        cars1.setColor("Black");
        cars1.setEngine("High power");
        cars1.setPrice(1000);

        cart.setCustomer(customer);
        cart.getCarsList().add( cars );
        cart.getCarsList().add( cars1 );

        cartRepository.save( cart );

        return cartRepository.findAll();
    }

    @RequestMapping("/cart")
    public List<Cart> getCart(){

        return cartRepository.findAll();
    }


}
