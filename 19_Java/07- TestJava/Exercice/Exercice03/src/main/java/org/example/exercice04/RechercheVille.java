package org.example.exercice04;

import jdk.jshell.spi.ExecutionControl;

import java.util.ArrayList;
import java.util.List;

public class RechercheVille {

    private List<String> villes = List.of("Paris", "Budapest", "Skopje", "Rotterdam", "Valence", "Vancouver",
            "Amsterdam", "Vienne", "Sydney", "New York",
            "Londres",
            "Bangkok",
            "Hong Kong",
            "Dubaï",
            "Rome",
            "Istanbul");

    public List<String> rechercher(String mot) {
        if (mot.length() < 2){
            throw new NotFoundException();
        }else{
            List<String> villesRecherche = new ArrayList<>();
            for (String v : villes){
                if (v.toLowerCase().startsWith(mot.toLowerCase())){
                    villesRecherche.add(v);
                }
            }
            return villesRecherche;
        }

    }

}
