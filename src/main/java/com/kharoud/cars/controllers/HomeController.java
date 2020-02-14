package com.kharoud.cars.controllers;

import com.kharoud.cars.models.Cars;
import com.kharoud.cars.models.Cart;
import com.kharoud.cars.models.Customer;
import com.kharoud.cars.repository.CarsRepository;
import com.kharoud.cars.repository.CartRepository;
import com.kharoud.cars.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class HomeController {


    private Cart cart;
    private Customer customer;

    private CarsRepository carsRepository;
    private CustomerRepository customerRepository;
    private CartRepository cartRepository;

    public HomeController(CarsRepository carsRepository, CustomerRepository customerRepository, CartRepository cartRepository) {
        this.carsRepository = carsRepository;
        this.customerRepository = customerRepository;
        this.cartRepository = cartRepository;
    }

    @PostMapping("/login")
    public void login(@PathParam("uname") String user, @PathParam("pass") String pass){

    }
    @RequestMapping("/update")
    public List<Cart> home(){

        customer = new Customer();
        customer.setEmail("Dskharoud3@gmail.com");
        customer.setName("Kharoud");
        customerRepository.save( customer );

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

        carsRepository.save( cars );
        carsRepository.save( cars1 );

        cart = new Cart();
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

    @RequestMapping("/cust")
    public List<Customer> getCust(){


        customer.setName("asdf");
        customer.setEmail("asdf");
        customerRepository.save( customer);

        return customerRepository.findAll();
    }


}
