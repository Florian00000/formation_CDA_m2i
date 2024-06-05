package org.example.exercice06Mock;

import jdk.jshell.spi.ExecutionControl;

import java.util.ArrayList;
import java.util.List;

public class Frame {
    private int score;
    private boolean lastFrame;
    private IGenerateur generateur;
    private List<Roll> rolls;

    public Frame(IGenerateur generateur, boolean lastFrame) {
        this.lastFrame = lastFrame;
        this.generateur = generateur;
        this.rolls = new ArrayList<>();
    }

    public boolean makeRoll() {
            if ((rolls.size() >= 2 && !lastFrame) || (rolls.size() >= 4 && lastFrame)) {
                return false;
            }

            if (score >= 10 && !lastFrame){
                return false;
            }else {
                int addScore = generateur.randomPin(10);
                this.rolls.add(new Roll(addScore));
                score += addScore;
                return true;
            }
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean isLastFrame() {
        return lastFrame;
    }

    public void setLastFrame(boolean lastFrame) {
        this.lastFrame = lastFrame;
    }

    public IGenerateur getGenerateur() {
        return generateur;
    }

    public void setGenerateur(IGenerateur generateur) {
        this.generateur = generateur;
    }

    public List<Roll> getRolls() {
        return rolls;
    }

    public void setRolls(List<Roll> rolls) {
        this.rolls = rolls;
    }
}
