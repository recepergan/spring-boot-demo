package com.example.springboot01.service;

import com.example.springboot01.dto.VehicleDto;
import com.example.springboot01.models.Customer;
import com.example.springboot01.models.Vehicle;
import com.example.springboot01.repository.CustomerRepository;
import com.example.springboot01.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleService {

    @Autowired
    VehicleRepository vehicleRepository;
    @Autowired
    CustomerRepository customerRepository;

    public Vehicle save(VehicleDto vehicleDto) {
       Customer foundCustomer = customerRepository.findCustomer(vehicleDto.getCustomerId());

       //manual mapping(DTO to Entity)
        Vehicle vehicle = new Vehicle();
        vehicle.setModel(vehicleDto.getModel());
        vehicle.setPlate((vehicleDto.getPlate()));
        vehicle.setYear(vehicleDto.getYear());
        vehicle.setCustomer(foundCustomer);



        return vehicleRepository.save(vehicle);
    }
}
