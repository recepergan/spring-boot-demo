package com.example.springboot.service;
import com.example.springboot.model.Employee;
import com.example.springboot.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl{


    final EmployeeRepository employeeRepository;

    //@Autowired
   /* public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }*/

    @Transactional(readOnly = true)
    public List<Employee> findAll() {
        List<Employee> employees = new ArrayList<>();

        Iterable<Employee> employeeIterable = employeeRepository.findAll();
        employeeIterable.iterator().forEachRemaining(employees :: add); //stream api
    return employees;

    }
    @Transactional
    public Employee findById(long id) {

        return employeeRepository.findById(id).get();
    }
    @Transactional
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }
    @Transactional
    public Employee update(Employee employee) {

        return employeeRepository.save(employee);
    }

    @Transactional
    public void deletedById(Long id) {
        employeeRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public int getAllEmployeeCount() {
       return employeeRepository.getNumberEmployeeNumber();
    }

      public List<?> getSalaryWithGrouping() {
        return employeeRepository.getSalaryWithGrouping();

    }

    public List<Employee> findByFullName(String fullname) {
        return employeeRepository.findByFullName(fullname);
    }
    public List<Employee> findByFullNameContaining(String str) {
       return employeeRepository.findByFullNameContaining(str);
    }


    public List<Employee> findBySalaryGreaterThan(double salary) {
        return employeeRepository.findBySalaryGreaterThan(salary);

    }

    public List<Employee> findTopBySalaryIsGreaterThan(double salary) {
     return employeeRepository.findTopBySalaryIsGreaterThan(salary);

    }

    @Transactional
    public void deleteByFullName(String fullname) {
        employeeRepository.deleteByFullName(fullname);
    }
}












