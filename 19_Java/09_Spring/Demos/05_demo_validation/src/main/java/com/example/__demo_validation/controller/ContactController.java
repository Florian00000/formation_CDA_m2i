package com.example.__demo_validation.controller;

import com.example.__demo_validation.model.Contact;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ResponseStatusException;

@Controller
public class ContactController {
    @GetMapping("/form")
    public String form(Model model){
        model.addAttribute("contact", new Contact());
        return "form";
    }

    @PostMapping("/add")
    public String addContact(@Valid @ModelAttribute("contact") Contact contact, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "form";
        } else {
            return "form-confirm";
        }
    }

    @GetMapping("/pb")
    public String pb(){
        if(true) {
            throw new ResponseStatusException(HttpStatus.I_AM_A_TEAPOT);
        }
        return "form";
    }
}
