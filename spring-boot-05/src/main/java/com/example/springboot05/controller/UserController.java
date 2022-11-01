package com.example.springboot05.controller;

import com.example.springboot05.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @GetMapping("/index")
    public String showUserList(Model theModel) {
        theModel.addAttribute("users",userRepository.findAll());
        return "index";


    }
}
