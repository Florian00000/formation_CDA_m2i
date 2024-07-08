package com.example.demospring.dto;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDtoPost {
    @Size(min = 3,max = 20)
    private String firstName;
    @Size(min = 3,max = 20)
    private String lastName;
//    @Pattern(regexp ="a-z")
    private String password;
}
