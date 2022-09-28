package com.example.springboot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import javax.persistence.*;
import java.util.Objects;

@Data
@NoArgsConstructor
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "fullname")
    private String fullName;

    private double salary;
    @Column(name = "phonenumber")
    private String phoneNumber;


}
