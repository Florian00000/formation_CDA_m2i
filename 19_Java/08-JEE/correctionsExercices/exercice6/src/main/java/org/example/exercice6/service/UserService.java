package org.example.exercice6.service;

import org.example.exercice6.exception.NotFoundException;
import org.example.exercice6.exception.UserAlreadyExists;
import org.example.exercice6.exception.WrongPasswordException;
import org.example.exercice6.model.User;
import org.example.exercice6.repository.UserRepository;

public class UserService {
    private UserRepository userRepository = new UserRepository();

    public User signUp(String name,String email,String password){
        User user = new User(name,email,password);
        User userFound = userRepository.findByEmail(email);
        if(userFound == null){
            return userRepository.add(user);
        }else {
            throw new UserAlreadyExists("User already exist !!!");
        }
    }

    public User signIn(String email, String password){
        User userFound = userRepository.findByEmail(email);
        if(userFound != null){
            if(password.equals(userFound.getPassword())){
                return userFound;
            }else {
                throw new WrongPasswordException("Wrong password");
            }
        }else {
            throw new UserAlreadyExists("User not found");
        }
    }

    public User findById(int id){
        User userFound = userRepository.finfById(id);
        if(userFound != null){
            return userFound;
        }else {
            throw new NotFoundException("User not found !!!");
        }

    }

}
