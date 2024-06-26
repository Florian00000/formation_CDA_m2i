package com.example.__demo_validation.model;

import com.example.__demo_validation.validation.MyValid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Contact {
    @NotNull(message = "Ce champ doit être rempli !")
    @NotBlank()
    @MyValid()
    private String firstname;

    @NotNull
    @Size(min = 3, message = "3 minimum svp !")
    @MyValid(value = "tata", message = "Le message doit contenir tata !")
    private String lastname;

    @Min(18)
    @Max(77)
    private Integer age;
}
