package org.example.exercice03TpBuilderEtAbstractFactory;

import org.example.exercice03TpBuilderEtAbstractFactory.entity.Batiment;
import org.example.exercice03TpBuilderEtAbstractFactory.entity.personnage.Personnage;

import java.util.List;

public class GameManager {

    private List<Batiment> batiments;
    private List<Personnage> personnages;

    public void addBatiment (Batiment batiment) {
        batiments.add(batiment);
        checkDebloquables();
    }

    private void addPersonnage (Personnage personnage) {
        personnages.add(personnage);
        checkDebloquables();
    }

    private void checkDebloquables(){

    }

    private void debloquerEquipement(String equipement, String characterType){

    }


}
