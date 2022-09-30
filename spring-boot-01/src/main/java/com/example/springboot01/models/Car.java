package com.example.springboot01.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
public class Car extends Vehicle {
    private String color;

    public Car(int year, String model, String plate, String color) {
        super(year, model, plate);
        this.color = color;
    }


}
