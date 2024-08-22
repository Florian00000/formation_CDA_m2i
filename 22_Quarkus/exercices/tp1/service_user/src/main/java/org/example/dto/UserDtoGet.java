package org.example.dto;

import lombok.Data;
import org.example.entity.User;

@Data
public class UserDtoGet {

    private long id;
    private String name;
    private String username;

    public UserDtoGet(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.username = user.getUsername();
    }
}
