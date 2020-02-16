package com.kharoud.cars.repository;


import com.kharoud.cars.models.Customer;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

       Customer findByUsernameEqualsAndPasswordEquals(String username, String password);


}
