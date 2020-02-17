package com.kharoud.cars.repository;

import com.kharoud.cars.models.Cart;
import com.kharoud.cars.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

    void deleteByCustomer(Customer customer);

    Cart findByCustomer(Customer customer);
}
