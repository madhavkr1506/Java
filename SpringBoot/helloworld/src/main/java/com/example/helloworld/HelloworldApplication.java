package com.example.helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class HelloworldApplication {
    public static void main(String[] args) {
        SpringApplication.run(HelloworldApplication.class, args);
    }

    @RestController
    class HelloWorldController{
        @GetMapping("/")
        public String hello(){
            return "Hello World!";
        }
    }
}
