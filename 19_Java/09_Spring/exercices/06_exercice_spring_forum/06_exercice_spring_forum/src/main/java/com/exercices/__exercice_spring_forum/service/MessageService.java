package com.exercices.__exercice_spring_forum.service;

import com.exercices.__exercice_spring_forum.dao.MessageRepository;
import com.exercices.__exercice_spring_forum.entitie.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    private final MessageRepository messageRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    public boolean saveMessage(Message message) {
         messageRepository.save(message);
        return true;
    }
}
