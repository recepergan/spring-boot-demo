package com.example.springboot01.repository;

import com.example.springboot01.models.Accident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccidentRepository extends JpaRepository<Accident,Integer> {
}
