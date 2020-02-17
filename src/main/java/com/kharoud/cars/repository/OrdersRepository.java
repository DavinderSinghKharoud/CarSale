package com.kharoud.cars.repository;

import com.kharoud.cars.models.Customer;
import com.kharoud.cars.models.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer> {

    void deleteByCustomer( Customer customer);
}
