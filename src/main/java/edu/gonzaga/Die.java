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

public class Die {
    int value = 0;
    boolean locked = false;
    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.removePropertyChangeListener(listener);
    }

    public void lock() { locked = true; }
    public void unlock() { locked = false; }

    public void roll() {
        if(!locked) {
            Random rand = new Random(); //instance of random class
            int upperbound = 6;
            this.setValue(rand.nextInt(upperbound) + 1);
        }
    }

    private void setValue(int newValue) {
        int oldValue = this.value;
        this.value = newValue;
        this.pcs.firePropertyChange("dievalue", oldValue, newValue);
    }

    public int getValue() {
        return value;
    }

    public String toString() {
        return "Die value: " + value;
    }
}