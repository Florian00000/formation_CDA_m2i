package com.example.__spring_demo_base.service;

import org.springframework.stereotype.Service;

@Service("greetings")
public class GreetingsServiceEnglish implements GreetingsService{
    @Override
    public String sayHello() {
        return "Hello everyone !!!";
    }
}
