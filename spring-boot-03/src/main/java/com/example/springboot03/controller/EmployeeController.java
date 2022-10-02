package com.example.springboot03.controller;

import com.example.springboot03.model.Employee;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class EmployeeController {


    List<Employee> employeeList = new ArrayList<>();

    @PostConstruct
    public void init() {

        Employee employee1 = Employee.builder().id(1).salary(2555).age(30).fullname("recep ergan").build();
        Employee employee2 = Employee.builder().id(2).salary(345).age(40).fullname("ergeg erf").build();
        Employee employee3 = Employee.builder().id(3).salary(4).age(50).fullname("öçjö esdrgan").build();

        employeeList.add(employee1);
        employeeList.add(employee2);
        employeeList.add(employee3);
    }

    @GetMapping("/employees")
    public String getAllEmployees(Model theModel) {
        theModel.addAttribute("employees",employeeList);
        return "employees";
    }

}
