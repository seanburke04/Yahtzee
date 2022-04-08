package edu.gonzaga;

import java.util.ArrayList;

public class Settings {
    static final Integer NUM_SIDES_INDEX = 0;
    static final Integer NUM_DICE_INDEX = 1;
    static final Integer NUM_ROLLS_INDEX = 2;
    static final Integer DEFAULT_SIDES = 6;
    static final Integer DEFAULT_DICE = 5;
    static final Integer DEFAULT_ROLLS = 3;

    ArrayList<Integer> userSettings = new ArrayList<>();

    Settings(){
        userSettings.add(DEFAULT_SIDES);
        userSettings.add(DEFAULT_DICE);
        userSettings.add(DEFAULT_ROLLS);
    }

    public ArrayList<Integer> getUserSettings(){return userSettings;}

    public void setNumSides(Integer numSides){userSettings.set(NUM_SIDES_INDEX, numSides);}

    public void setNumDice(Integer numDice){userSettings.set(NUM_DICE_INDEX, numDice);}

    public void setNumRolls(Integer numRolls){userSettings.set(NUM_ROLLS_INDEX, numRolls);}
}
