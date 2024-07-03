package com.exercices.__exercice_spring_forum.service;

import com.exercices.__exercice_spring_forum.dao.UserRepository;
import com.exercices.__exercice_spring_forum.entitie.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    private HttpSession _session;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean login(String username, String password) {
        User user = userRepository.findByName(username);
        if (user == null) {
            return false;
        }else {
            if ( user.getPassword().equals(password)) {
                _session.setAttribute("login", true);
                _session.setAttribute("user", user);
                return true;
            }else{
                return false;
            }
        }
    }

    public boolean isLogged(){
        try {
            return (boolean) _session.getAttribute("login");
        } catch (Exception e) {
            return false;
        }
    }


    public boolean registerUser(User user) {
        userRepository.save(user);
        return true;
    }

    public void logout(){
        _session.removeAttribute("login");
        _session.removeAttribute("user");
    }
}
