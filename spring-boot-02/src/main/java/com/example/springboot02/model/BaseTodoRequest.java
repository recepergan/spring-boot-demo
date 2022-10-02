package com.example.springboot02.model;

import lombok.Data;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
public class BaseTodoRequest {

    private LocalDateTime localDateTime;

}