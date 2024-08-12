package com.example.demo_aspect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class DemoAspectApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoAspectApplication.class, args);
    }

}
