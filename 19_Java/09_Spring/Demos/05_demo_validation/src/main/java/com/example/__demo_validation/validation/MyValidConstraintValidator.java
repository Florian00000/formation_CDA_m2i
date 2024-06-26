package com.example.__demo_validation.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class MyValidConstraintValidator implements ConstraintValidator<MyValid, String> {
    private String charContain;

    public void initialize(MyValid constraintAnnotation) {
        // Cette ligne initialise le champ charContain avec la valeur spécifiée dans l'annotation @MyValid
        charContain = constraintAnnotation.value();
    }

    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        boolean result;

        if(s != null) {
            result = s.contains(charContain);
        } else {
            result = true;
        }
        return result;
    }
}
