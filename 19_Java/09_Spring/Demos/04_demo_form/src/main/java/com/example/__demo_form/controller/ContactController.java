package com.example.__demo_form.controller;

import com.example.__demo_form.model.Contact;
import com.example.__demo_form.service.ContactService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
public class ContactController {
    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/")
    public String homePage(){
        return "pagea";
    }

    @GetMapping("/detail/{contactId}")
    public String detailPage(@PathVariable("contactId")UUID contactId, Model model){
        Contact contact = contactService.getContactById(contactId);
        model.addAttribute("contact", contact);
        return "pagec";
    }

    @GetMapping("/list")
    public String list(Model model){
        List<Contact> contacts = contactService.getAllContacts();
        model.addAttribute("contacts", contacts);
        return "pageb";
    }

    @GetMapping("/search") // /search?contactName=Toto
    public String showContact(@RequestParam(name = "contactName", required = false) String name, Model model){
        Contact contact = contactService.getContactByName(name);

        if(contact != null){
            model.addAttribute("contact", contact);
            return "pagec";
        } else {
            return "pagea";
        }
    }

    @GetMapping("/add")
    public String addContact(Model model) {
        model.addAttribute("contact", new Contact());
        return "form/form";
    }

    @PostMapping("/add")
    public String submitContact(@ModelAttribute("contact") Contact contact) {
        System.out.println(contact.getName());
        System.out.println(contact.getPhone());
        System.out.println(contact.getAge());
        return "redirect:/";
    }
}
