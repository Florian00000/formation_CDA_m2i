package org.example.dto;

import lombok.Data;
import org.example.entity.User;

@Data
public class UserDtoPost {

    private String name;
    private String username;
    private String password;

    public User convertToUser() {
        return User.builder().name(name).username(username).password(password).build();
    }
}
