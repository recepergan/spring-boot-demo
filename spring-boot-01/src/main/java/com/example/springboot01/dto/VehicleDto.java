package com.example.springboot01.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleDto {

    private int year;
    private String model;
    private String plate;
    private int customerId;
}
