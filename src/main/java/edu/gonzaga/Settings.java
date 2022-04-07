package edu.gonzaga;

import java.util.ArrayList;

public class Settings {
    private ArrayList<Integer> userSettings = new ArrayList<>(3);

    public Settings(){
        // Num sides
        userSettings.add(6);

        // Num Dice
        userSettings.add(5);

        // Num Rolls
        userSettings.add(3);
    }

    public void setNumDice(Integer numDice){
        userSettings.set(1, numDice);
    }

    public void setNumSides(Integer numSides){
        userSettings.set(0, numSides);
    }

    public void setNumRolls(Integer numRolls){
        userSettings.set(2, numRolls);
    }

    public ArrayList<Integer> getUserSettings(){return userSettings;}
}
