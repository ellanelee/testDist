package com.example.springhello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
public class SpringHelloApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringHelloApplication.class, args);
    }

}
