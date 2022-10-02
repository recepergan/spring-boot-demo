package com.example.springboot02.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@Entity
public class Posts extends BaseTodoRequest  {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int postsId;

    private int userId;
    private int id;
    private String title;
    private String body;

}
