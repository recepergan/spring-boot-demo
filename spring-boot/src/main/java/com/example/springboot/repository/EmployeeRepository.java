package com.example.springboot.repository;

import com.example.springboot.model.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Long> {

    @Query("select count(e) from Employee e")
    public int getNumberEmployeeNumber();

    @Query("select e.salary,count (e.salary) from Employee e group by e.salary")
    List<?> getSalaryWithGrouping();

    //method driven query
    List<Employee> findByFullName(String fullname);
    List<Employee> findByFullNameContaining(String str);
    List<Employee> findBySalaryGreaterThan(double salary);
    List<Employee> findTopBySalaryIsGreaterThan(double salary);

    void deleteByFullName(String fullname);


}
