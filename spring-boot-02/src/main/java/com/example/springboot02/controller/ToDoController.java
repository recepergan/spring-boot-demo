package com.example.springboot02.controller;

import com.example.springboot02.model.ToDo;
import com.example.springboot02.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@RestController
public class ToDoController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    TodoRepository todoRepository;

    @GetMapping("/get/{id}")
    public ToDo getJsonFromRemoteTodoList(@PathVariable int id) {
        ToDo toDo = restTemplate.getForObject("https://jsonplaceholder.typicode.com/todos/" + id,ToDo.class);
        toDo.setLocalDateTime(LocalDateTime.now());
        todoRepository.save(toDo);
        return toDo;
    }

    @GetMapping("/getstr/{id}")
    public ResponseEntity<String> getJsonFromRemoteTodoListWithString(@PathVariable int id) {
        ResponseEntity<String> todoStr = restTemplate.getForEntity("https://jsonplaceholder.typicode.com/todos/" + id, String.class);

        return todoStr;
    }
}
