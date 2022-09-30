package com.example.springboot01.service;

import com.example.springboot01.exception.CustomerAlreadyExistsException;
import com.example.springboot01.exception.CustomerNotExistsException;
import com.example.springboot01.models.Customer;
import com.example.springboot01.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public List<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomer(int id) {
       return customerRepository.findCustomer(id);
    }

    public Customer saveCustomer(Customer customer) {
        Customer isCustomerExists = customerRepository.findCustomerBySsid(customer.getSsid());
        if(isCustomerExists != null) {
            throw new CustomerAlreadyExistsException("Customer is exist with ssid: " + customer.getSsid());
        }
         return customerRepository.save(customer);
    }

    public void deleteCustomer(int id) {
        Customer isCustomerExists = customerRepository.findCustomer(id);
        if(isCustomerExists == null) {
            throw new CustomerNotExistsException("Customer with id : " +id+   "is NOT exist for deleteing...");
        }

        customerRepository.delete(isCustomerExists);

    }
}
