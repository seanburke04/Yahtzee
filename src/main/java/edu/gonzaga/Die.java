/**
 * This program plays through a whole game of Yahtzee through a GUI
 * CPSC 224-02, Spring 2022
 * HW4 Yahtzee GUI
 * Source: Most of the Die.java, DiceImages.java, DieView.java, Hand.java, HandView.java, Window.java
 * files written by Dr. Crandall
 *
 * @author Sean Burke
 * @version v1.4 4/8/22
 */
package edu.gonzaga;

import java.util.Random;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyChangeListener;

/**
 * This class controls a single die
 */

public class Die {
    int value = 0;
    boolean locked = false;
    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    /**
     * Adds a listener to the die for updating
     * @param listener
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.addPropertyChangeListener(listener);
    }

    /**
     * Removes listener from die when it is no longer needed
     * @param listener
     */
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.removePropertyChangeListener(listener);
    }

    /**
     * Locks the die so it cannot be changed
     */
    public void lock() { locked = true; }

    /**
     * Unlocks the die so it can be changed
     */
    public void unlock() { locked = false; }

    /**
     * Rolls the die if it is not locked
     */
    public void roll() {
        if(!locked) {
            Random rand = new Random(); //instance of random class
            int upperbound = 6;
            this.setValue(rand.nextInt(upperbound) + 1);
        }
    }

    /**
     * Sets the value of the die and fires the listener
     * @param newValue
     */
    private void setValue(int newValue) {
        int oldValue = this.value;
        this.value = newValue;
        this.pcs.firePropertyChange("dievalue", oldValue, newValue);
    }

    /**
     * Getter for dice value
     * @return value
     */
    public int getValue() {
        return value;
    }

    /**
     * Converts the die value to a string
     * @return value
     */
    public String toString() {
        return "Die value: " + value;
    }
}