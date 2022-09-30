package com.example.springboot01.controller;

import com.example.springboot01.dto.VehicleDto;
import com.example.springboot01.models.Vehicle;
import com.example.springboot01.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    @PostMapping("/vehicles")
    public Vehicle saveVehicle(@RequestBody VehicleDto vehicleDto) {
        return vehicleService.save(vehicleDto);
    }

}
