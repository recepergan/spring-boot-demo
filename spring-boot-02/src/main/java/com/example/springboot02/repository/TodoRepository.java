package com.example.springboot02.repository;

import com.example.springboot02.model.ToDo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends CrudRepository<ToDo,Integer> {
}
