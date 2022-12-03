package com.example.springbootdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@Controller
public class HelloController {

    @Value("${developer.name: recep}")
    private String developerName;

    @Value("${server.port}")
    private int serverPort;

    List<Student> students = new ArrayList<Student>();

    //endpoint
    //  @RequestMapping(value = "/hello", method = RequestMethod.GET,produces = MediaType.APPLICATION_XML_VALUE)
    @RequestMapping(value = "/hello")
    public StringResponse sayHello(@RequestParam(required = false) String name, @RequestParam int year) {
        return new StringResponse("Hello " + name + ", from " + year + "developer name " + developerName + "servervport" + serverPort);
    }

    @RequestMapping(value= "/hello/{name}/{year}")
    @ResponseStatus(value = HttpStatus.I_AM_A_TEAPOT, reason = "There is an error during request ...")
    public String sayMyName(@PathVariable String name, @PathVariable(required = false) int year) {
        return ("Hello " + name + ", from " + year);
    }

    @GetMapping("/greeting/{id}")
    public ResponseEntity<String> greeting(@RequestHeader("Connection") String connection, @PathVariable int id) {

        HttpHeaders headers = new HttpHeaders();
        headers.add("my-custome-header", "Test header");


        //  return new ResponseEntity<>("Id : " + id + ", Connection:" +connection,HttpStatus.OK);
        // return ResponseEntity.ok().body("Id : " +id+ ", connection" +connection)
        //return ResponseEntity.status(HttpStatus.ACCEPTED).body("Id :" + id + ", connection" + connection);
        return new ResponseEntity<>("Id : " + id + ", cookie:" + connection, headers, HttpStatus.OK);
    }

    @GetMapping("/custom")
    public void customHeader(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String cookie = request.getHeader("cookie");

        response.setHeader(("custom-header"), "Recep");
        response.setHeader(("cookie"), cookie + "patikadev");
        response.setStatus(201);
        response.getWriter().println("Hello World...");


    }

    @GetMapping("/calculatee/{operation}")
    public String calculatee(@PathVariable String operation,@RequestParam int num1,@RequestParam int num2) {
        int result = 0;
        if (operation.equals("sum")) {
            result = num1 + num2;
        }else if(operation.equals("substract")) {
            result = num1 - num2;
        }else if(operation.equals("divide"))
        {
            result = num1 / num2;
        }else
            result = num1 * num2;

        String result1 = String.valueOf(result);

        return result1;
    }


    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudent() {

        students.add(new Student(1, "Koray", 38));
        students.add(new Student(2, "Ali", 28));
        students.add(new Student(3, "Velş", 18));

        return ResponseEntity.ok().body(students);


    }

    @PostMapping("/students")
    public ResponseEntity<List<Student>> addStudent(@RequestBody List<Student> students) {
         /*  for(Student student: students) {
               this.students.add(student);
           }*/

        students.stream().collect(Collectors.toCollection(() -> this.students));

           // this.students.addAll(students);


            return ResponseEntity.ok().body(this.students);
    }

    @GetMapping("*")
    public ResponseEntity<String> fallBackMethod() {
        return new ResponseEntity<>("There is no endpoint like that...",HttpStatus.NOT_FOUND);
    }

    //http://localhost:8081/sum?num1=10&num2=20
    //output ----> 10+20=30
  /*  @GetMapping("/calculate/{operation}/{num1}/{num2}")
    public String calculate(@PathVariable String operation,@PathVariable int num1,@PathVariable int num2) {

        int result = 0;
      if (operation.equals("+")) {
          result = num1 + num2;
      }else if(operation.equals("-")) {
          result = num1 - num2;
      }else if(operation.equals("*"))
        {
          result = num1 * num2;
        }
      String result1 = String.valueOf(result);

      return result1;
    }  */


    //http://localhost:8081/sum?num1=10&num2=20
    //output ----> 10+20=30
    @GetMapping("/calculate/{operation}")
    public String calculate(@PathVariable String operation,@RequestParam int num1,@RequestParam int num2) {

        int result = 0;
        if (operation.equals("sum")) {
            result = num1 + num2;
        }else if(operation.equals("substract")) {
            result = num1 - num2;
        }else if(operation.equals("divide"))
        {
            result = num1 / num2;
        }else
            result = num1 * num2;

        String result1 = String.valueOf(result);

        return result1;
    }


}
