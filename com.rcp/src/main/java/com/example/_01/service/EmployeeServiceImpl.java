package com.example._01.service;

import com.example._01.dao.EmployeeDAO;
import com.example._01.model.Employee;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService<Employee> {


    EmployeeDAO employeeDAO;

    //@Autowired
    public EmployeeServiceImpl(@Qualifier("employeeDAOHibernateImpl") EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee findById(int id) {
        return null;
    }

    @Override
    public Employee save(Employee employee) {
        return (Employee) employeeDAO.save(employee);
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public Employee update(Employee object) {
        return null;
    }
}
