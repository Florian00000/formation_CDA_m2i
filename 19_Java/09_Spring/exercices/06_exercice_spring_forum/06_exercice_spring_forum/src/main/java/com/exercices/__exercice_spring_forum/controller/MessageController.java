package com.exercices.__exercice_spring_forum.controller;

import com.exercices.__exercice_spring_forum.entitie.Message;
import com.exercices.__exercice_spring_forum.entitie.User;
import com.exercices.__exercice_spring_forum.service.MessageService;
import com.exercices.__exercice_spring_forum.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
public class MessageController {

    private final UserService userService;
    private final MessageService messageService;

    @Autowired
    private HttpSession _session;

    @Autowired
    public MessageController(UserService userService, MessageService messageService) {
        this.userService = userService;
        this.messageService = messageService;
    }

    @GetMapping("/forum")
    public String forum(Model model) {
        if (userService.isLogged()) {
            model.addAttribute("messages", messageService.getAllMessages());
            model.addAttribute("formatter", DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm"));
            return "message/listMessage";
        } else {
            return "redirect:/";
        }
    }

    @GetMapping("/forum/new")
    public String newMessage(Model model) {
        if (userService.isLogged()) {
            model.addAttribute("message", new Message());
            return "/message/messageForm";
        } else {
            return "redirect:/";
        }
    }

    @PostMapping("/forum/new")
    public String newMessage(@ModelAttribute("message") Message message) {
        message.setAuthor((User) _session.getAttribute("user"));
        message.setDateTime(LocalDateTime.now());
        messageService.saveMessage(message);
        return "redirect:/forum";

    }

    @GetMapping("/forum/{idMessage}")
    public String showMessage(@PathVariable("idMessage") int idMessage, Model model) {
        if (userService.isLogged()) {
            model.addAttribute("message", messageService.getMessageById(idMessage));
            //Liste de toutes les réponses possibles
            model.addAttribute("responses", messageService.getAllResponses(messageService.getMessageById(idMessage)));

            //Réponse possible
            model.addAttribute("newResponse", new Message());

            model.addAttribute("formatter", DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm"));
            return "/message/messageDetail";
        }else{
            return "redirect:/";
        }
    }

    @PostMapping("/forum/{idMessage}")
    public String responseToMessage(@PathVariable("idMessage") int idMessage, @ModelAttribute("newResponse") Message response, Model model) {
        if (userService.isLogged()) {
            //On recherche le mesage original
            Message message = messageService.getMessageById(idMessage);

            //On crée la réponse
            response.setAuthor((User) _session.getAttribute("user"));
            response.setDateTime(LocalDateTime.now());
            response.setOriginalMessage(message);
            messageService.saveMessage(response);
            return "redirect:/forum/" + idMessage;
        }else {
            return "redirect:/";
        }
    }


}
