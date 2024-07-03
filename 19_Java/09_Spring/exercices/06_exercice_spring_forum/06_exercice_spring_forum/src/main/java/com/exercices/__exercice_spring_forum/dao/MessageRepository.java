package com.exercices.__exercice_spring_forum.dao;

import com.exercices.__exercice_spring_forum.entitie.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Integer> {
    List <Message> findAllByOriginalMessage(Message originalMessage);
}
