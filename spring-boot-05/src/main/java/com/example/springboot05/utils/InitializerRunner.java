package com.example.springboot05.utils;

import com.example.springboot05.entity.User;
import com.example.springboot05.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitializerRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(InitializerRunner.class);

    @Autowired
    UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();


        userRepository.save(User.builder().name("Ali").age(23).email("a@a.com").build());
        userRepository.save(User.builder().age(35).name("Hasan").email("ha@ah.com").build());
        userRepository.save(User.builder().age(56).name("Ahmet").email("ahmet@ah.com").build());
        userRepository.save(User.builder().age(22).name("Ayşe").email("ayse@a.com").build());

        userRepository.findAll().forEach(user -> logger.info("{}",user));


    }
}
