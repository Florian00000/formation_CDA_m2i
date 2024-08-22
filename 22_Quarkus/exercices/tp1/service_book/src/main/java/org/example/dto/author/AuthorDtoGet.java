package org.example.dto.author;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorDtoGet {

    private long id;
    private String name;
    private String biography;
    private String birthDate;
}
