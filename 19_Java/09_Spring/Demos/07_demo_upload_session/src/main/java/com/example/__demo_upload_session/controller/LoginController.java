package com.example.__demo_upload_session.controller;

import com.example.__demo_upload_session.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password) {
        if(loginService.login(username, password)) {
            return "protected";
        }
        return "login";
    }

    @GetMapping("/protected")
    public String protectedPage() {
        if(loginService.isLogged()){
            return "protected";
        }
        return "login";
    }

    @GetMapping("/logout")
    public String logout() {
        loginService.logout();
        return "login";
    }
}
