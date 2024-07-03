package com.exercices.__exercice_spring_forum.controller;

import com.exercices.__exercice_spring_forum.entitie.User;
import com.exercices.__exercice_spring_forum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String login() {
        return "user/login";
    }

    @PostMapping("/")
    public String login(@RequestParam String username, @RequestParam String password){
        if (userService.login(username, password)) {
            return "redirect:/forum";
        }else{
            return "redirect:/";
        }
    }

    @GetMapping("/signup")
    public String signup(Model model) {
        model.addAttribute("user", new User());
        return "user/register";
    }

    @PostMapping("/signup")
    public String signup(@ModelAttribute("user") User user) {
        boolean response = userService.registerUser(user);
        if (response) {
            return "redirect:/";
        }else{
            return "user/register";
        }
    }
}
