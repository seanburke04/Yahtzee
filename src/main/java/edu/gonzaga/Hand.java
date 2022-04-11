/**
 * This program plays through a whole game of Yahtzee through a GUI
 * CPSC 224-02, Spring 2022
 * HW4 Yahtzee GUI
 * Source: Most of the Die.java, DiceImages.java, DieView.java, Hand.java, HandView.java, Window.java
 * files written by Dr. Crandall
 *
 * @author Sean Burke
 * @version v1.4 4/10/22
 */

package edu.gonzaga;

import java.util.ArrayList;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

/**
 * Controls a hand of dice
 */

public class Hand implements PropertyChangeListener {
    ArrayList<Die> dice;
    ArrayList<Integer> settings;

    /**
     * Constructor, sets up hand with the proper number of dice
     * @param userSettings
     */
    public Hand(ArrayList<Integer> userSettings) {
        settings = userSettings;
        dice = new ArrayList<>();
        for (int i = 0; i < settings.get(1); i++ ) {
            Die currDie = new Die(settings.get(0));
            dice.add(currDie);
            currDie.addPropertyChangeListener(this::propertyChange);
        }
    }

    /**
     * Sets what happens when the listener is fired
     * @param e
     */
    public void propertyChange(PropertyChangeEvent e) {
        String propertyName = e.getPropertyName();
        if ("dievalue".equals(propertyName)) {
            System.out.println(("Die changed to: " + e.getNewValue()));
        }
        // } else if ("focusedWindow".equals(propertyName) {
        //    ...
        // }
    }

    /**
     * Gets the die at a particular index
     * @param index
     * @return die
     */
    public Die getDieAt(int index) {
        return dice.get(index);
    }

    /**
     * Rolls entire hand of dice
     */
    public void roll() {
        for( Die die : dice ) {
            die.roll();
        }
    }

    /**
     * Converts the hand of dice into a string
     * @return handString
     */
    public String toString() {
        String ret = "";
        ret += "Hand: ";
        for( Die die : dice ) {
            ret += die.toString() + " | ";
        }
        return ret;
    }
}