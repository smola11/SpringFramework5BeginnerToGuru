package com.maciej.spring5jokesapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:chuck-config.xml") // search for such file
public class Spring5jokesappApplication {

    public static void main(String[] args) {
        SpringApplication.run(Spring5jokesappApplication.class, args);
    }
}
