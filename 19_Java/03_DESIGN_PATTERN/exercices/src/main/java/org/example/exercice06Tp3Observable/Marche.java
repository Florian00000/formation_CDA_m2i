package org.example.exercice06Tp3Observable;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Marche extends Thread implements Runnable {
    private List<Action> listeActions;

    public Marche() {
        listeActions = new ArrayList<Action>();
        for (int i = 0; i < 10; i++) {
            listeActions.add(new Action());
        }
    }

    public void ajustementPrix(){
        listeActions.forEach(Action::setPrix);

    }

    public void lancementMarche() throws RuntimeException{
        while (true){
            try{
                sleep(10000);
                ajustementPrix();
            }catch (InterruptedException e){
                throw new RuntimeException(e);
            }

        }

    }

}
