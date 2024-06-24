package com.example.__pathRequest.controller;

import com.example.__pathRequest.model.Contact;
import com.example.__pathRequest.service.ContactService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

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
}
