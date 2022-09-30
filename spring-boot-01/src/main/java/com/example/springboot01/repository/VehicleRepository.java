package com.example.springboot01.repository;

import com.example.springboot01.models.Customer;
import com.example.springboot01.models.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle,Integer> {
}
