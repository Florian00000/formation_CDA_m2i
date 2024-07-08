package com.example.demospring.service;

import com.example.demospring.dto.UserDtoPost;
import com.example.demospring.entity.User;
import com.example.demospring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getById (int id){
        return userRepository.findById(id).orElse(null);
    }

    public User create (UserDtoPost userDtoPost){
        User usercreated = User.builder()
                .firstName(userDtoPost.getFirstName())
                .lastName(userDtoPost.getLastName())
                .password(userDtoPost.getPassword())
                .build();
        return userRepository.save(usercreated);
    }

    public List<User> getAll (){
        return (List<User>) userRepository.findAll();
    }
}
