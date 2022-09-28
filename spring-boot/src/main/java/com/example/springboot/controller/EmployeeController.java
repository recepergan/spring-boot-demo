package com.example.springboot.controller;

import com.example.springboot.model.Employee;
import com.example.springboot.service.EmployeeServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EmployeeController {

    //DI types
    //1.field injection - direk alan üzerinde
    //2.setter injection
    //3.constructor injection

    //--field injection
    /*@Autowired
    EmployeeService employeeService;*/

    // ----setter injection----
    /*@Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }*/


   private final EmployeeServiceImpl employeeService;

    @GetMapping("employees")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return new ResponseEntity<>(employeeService.findAll(), HttpStatus.OK);

    }

    @GetMapping("employees/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return employeeService.findById(id);

    }

    @PostMapping("employees")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {

        return new ResponseEntity<>((Employee)employeeService.save(employee), HttpStatus.OK);

    }

    @PutMapping("employees")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {

        return new ResponseEntity<>((Employee)employeeService.update(employee), HttpStatus.OK);

    }

    @DeleteMapping("employees/{id}")
    public String deleteEmployeeById(@PathVariable Long id) {
         employeeService.deletedById(id);
        return "Deleted...";

    }




}
