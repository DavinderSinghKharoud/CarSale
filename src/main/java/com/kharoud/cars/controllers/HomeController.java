package com.kharoud.cars.controllers;

import com.kharoud.cars.models.Cars;
import com.kharoud.cars.models.Cart;
import com.kharoud.cars.models.Customer;
import com.kharoud.cars.repository.CarsRepository;
import com.kharoud.cars.repository.CartRepository;
import com.kharoud.cars.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@Controller
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

    @PostMapping("/login/{user}/{pass}")
    public String login(@PathVariable("user") String user, @PathVariable("pass") String pass) {
        Customer cus = customerRepository.findByUsernameEqualsAndPasswordEquals(user, pass);
        if( cus != null){
            return "Welcome";
        }else{
            return "login";
        }
    }

    @PostMapping(value = "/create", consumes = "application/json", produces = "application/json")
    public Customer create(@RequestBody Customer customer ) {

        customerRepository.save( customer );
        return customer;
    }

    @GetMapping(value = "/edit/{id}", produces = "application/json")
    @ResponseBody
    public Customer Edit(Model model, @PathVariable("id") String id) {

        Customer cust = customerRepository.findById(Integer.valueOf( id )).orElse(null);
        model.addAttribute("customer", cust );
        return cust;
    }

    @GetMapping(value = "/delete/{id}", produces = "application/json")
    @ResponseBody
    public Customer deleteCust (Model model, @PathVariable("id") String id) {

        Customer cust = customerRepository.findById(Integer.valueOf( id )).orElse(null);
        customerRepository.deleteById( Integer.valueOf( id ));
        return cust;
    }


//
//    @RequestMapping("/update")
//    public List<Cart> home() {
//
//        customer = new Customer();
//        customer.setEmail("Dskharoud3@gmail.com");
//        customer.setName("Kharoud");
//        customerRepository.save(customer);
//
//        Cars cars = new Cars();
//        cars.setName("Mustang");
//        cars.setColor("Black");
//        cars.setEngine("High power");
//        cars.setPrice(1000);
//
//
//        Cars cars1 = new Cars();
//        cars1.setName("Challenger");
//        cars1.setColor("Black");
//        cars1.setEngine("High power");
//        cars1.setPrice(1000);
//
//        carsRepository.save(cars);
//        carsRepository.save(cars1);
//
//        cart = new Cart();
//        cart.setCustomer(customer);
//        cart.getCarsList().add(cars);
//        cart.getCarsList().add(cars1);
//
//        cartRepository.save(cart);
//
//        return cartRepository.findAll();
//    }
//
//    @RequestMapping("/cart")
//    public List<Cart> getCart() {
//
//        return cartRepository.findAll();
//    }

    @RequestMapping(value = "/cust", produces = "application/json")
    @ResponseBody
    public List<Customer> getCust() {

        customer = new Customer();
        customer.setName("asdf");
        customer.setEmail("asdf");
        customer.setUsername("sunny");
        customer.setPassword("1");
        customer.setPhonenumber("1241241");
        customerRepository.save(customer);

        return customerRepository.findAll();
    }


}
