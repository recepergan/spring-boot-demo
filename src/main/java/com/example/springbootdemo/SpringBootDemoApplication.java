package com.example.springbootdemo;

import dev.patika.oop.inheritance1.Circle;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:foo.properties")
public class SpringBootDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoApplication.class, args);
       // Circle circle = new Circle();
      /*  circle.setRadius(10);
        circle.getArea();
        System.out.println("Area of circle :" + circle.getArea());  */
    }

}
