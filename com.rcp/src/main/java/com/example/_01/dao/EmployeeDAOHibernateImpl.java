package com.example._01.dao;

import com.example._01.model.Employee;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDAOHibernateImpl implements  EmployeeDAO<Employee>{
    private static final Logger logger = LoggerFactory.getLogger(EmployeeDAOHibernateImpl.class);
    EntityManager entityManager;

   @Autowired
    public EmployeeDAOHibernateImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
       logger.debug("EmployeeDAOHibernateImpl is used ...");
       // System.out.println("EmployeeDAOHibernateImpl is used ...");
       Session session = entityManager.unwrap(Session.class);
       return session.createQuery("FROM Employee",Employee.class).getResultList();
    }

    @Override
    public Employee findById(int id) {
        return null;
    }

    @Override
    public Employee save(Employee object) {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public Employee update(Employee object) {
        return null;
    }
}
