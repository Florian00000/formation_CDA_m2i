package org.example.exercice04;

import jdk.jshell.spi.ExecutionControl;

import java.util.ArrayList;
import java.util.List;

public class RechercheVille {

    private List<String> villes = List.of("Paris", "Budapest", "Skopje", "Rotterdam", "Valence", "Vancouver", "Amsterdam");

    public List<String> rechercher(String mot) {
        if (mot.length() < 2){
            throw new NotFoundException();
        }else{
           return villes = new ArrayList<>();
        }

    }

}
