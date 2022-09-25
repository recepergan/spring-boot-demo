package com.example._01.dao;

import com.example._01.model.Employee;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import java.util.List;

@Repository
public class EmployeeDAOJPAImpl implements EmployeeDAO<Employee> {

    //tanımladım fakat ihtiyaç yok spring boot ihtiyaç duyduğunda kendisi otomatik inject eder
   EntityManager entityManager;

   //@Autowired
    public EmployeeDAOJPAImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Employee> findAll() {
        return entityManager.createQuery("from Employee",Employee.class).getResultList();
    }

    @Override
    @Transactional
    public Employee findById(int id) {
        return null;
    }

    @Override
    @Transactional
    public Employee save(Employee employee) {
        return entityManager.merge(employee);
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public Employee update(Employee object) {
        return null;
    }
}
