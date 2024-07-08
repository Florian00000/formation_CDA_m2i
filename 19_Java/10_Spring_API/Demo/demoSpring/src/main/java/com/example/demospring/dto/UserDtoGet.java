package com.example.demospring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDtoGet {
    private int id;
    private String firstname;
    private String lastname;
}
