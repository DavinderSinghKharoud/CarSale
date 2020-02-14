package com.kharoud.cars.repository;

import com.kharoud.cars.models.Cars;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarsRepository extends JpaRepository<Cars,Integer> {
}
