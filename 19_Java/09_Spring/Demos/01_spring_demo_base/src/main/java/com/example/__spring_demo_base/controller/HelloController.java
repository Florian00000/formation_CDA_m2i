package com.example.__spring_demo_base.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class HelloController {

    @RequestMapping("/")
    public String sayHello(){
        System.out.println("Coucou");
        return "hello";
    }

    @RequestMapping("/coucou")
    // Conversion automatique de la valeur de retour en format JSON
    @ResponseBody
    public List<String> getPersons(){
        return List.of("Toto", "Tata", "Titi");
    }

    @RequestMapping("/home/person")
    public String personName(Model model) {
        model.addAttribute("firstname", "Toto");
        model.addAttribute("lastname", "Doe");

        List<String> persons = List.of("Toto", "Tata", "Titi");

        model.addAttribute("persons", persons);

        return "person/details";
    }
}
