package com.example.__demo_spring_jpa.controller;

import com.example.__demo_spring_jpa.entity.Person;
import com.example.__demo_spring_jpa.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("personnes", personService.findAll());
        return "home";
    }

    @GetMapping("/addForm")
    public String addForm(Model model){
        model.addAttribute("person", new Person());
        return "add-person";
    }

    @PostMapping("/addPerson")
    public String addPerson(@ModelAttribute("person") Person person){
        personService.save(person);
        return "redirect:/";
    }
}
