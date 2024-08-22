package org.example.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.example.dto.UserDtoGet;
import org.example.dto.UserDtoPost;
import org.example.entity.User;
import org.example.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class UserService {

    @Inject
    UserRepository userRepository;

    public List<UserDtoGet> getAllUsers() {
        return userRepository.findAll().stream().map(UserDtoGet::new).toList();
    }

    public UserDtoGet getUserById(long id) {
        Optional<User> user = userRepository.findByIdOptional(id);
        return user.map(UserDtoGet::new).orElse(null);
    }

    @Transactional
    public UserDtoGet addUser(UserDtoPost userDtoPost) {
        User user = userDtoPost.convertToUser();
        userRepository.persist(user);
        return new UserDtoGet(user);
    }

    public UserDtoGet updateUser(long id, UserDtoPost userDtoPost) {
        Optional<User> user = userRepository.findByIdOptional(id);
        if (user.isPresent()) {
            User userToUpdate = user.get();
            userToUpdate.setName(userDtoPost.getName());
            userToUpdate.setUsername(userDtoPost.getUsername());
            userToUpdate.setPassword(userDtoPost.getPassword());
            userRepository.persist(userToUpdate);
            return new UserDtoGet(userToUpdate);
        } else return null;
    }

    @Transactional
    public boolean deleteUser(long id) {
        userRepository.deleteById(id);
        return true;
    }
}
