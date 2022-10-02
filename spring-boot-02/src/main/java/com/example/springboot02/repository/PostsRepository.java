package com.example.springboot02.repository;

import com.example.springboot02.model.Posts;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostsRepository extends CrudRepository<Posts,Integer> {
}
