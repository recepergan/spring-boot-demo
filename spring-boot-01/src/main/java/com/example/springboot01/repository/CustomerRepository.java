package com.example.springboot01.repository;

import com.example.springboot01.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository

public interface CustomerRepository extends JpaRepository<Customer,Long>{
    @Query("from Customer c where c.id=?1")
    Customer findCustomer(int id);

    //select * from customer where ssid=3333
    //method(name) driven query
    Customer findCustomerBySsid(long ssid);
}
