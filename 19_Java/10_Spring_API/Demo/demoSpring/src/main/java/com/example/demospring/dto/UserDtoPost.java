package com.example.demospring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDtoPost {
    private String firstName;
    private String lastName;
    private String password;
}
