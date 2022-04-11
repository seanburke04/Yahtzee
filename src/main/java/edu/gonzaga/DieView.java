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

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class DieView extends JButton implements PropertyChangeListener{
    boolean locked = false;
    DiceImages images;
    Die dieToView;
    Integer dieValues;

    /**
     * Constructor that calls diceImages to be loaded and sets buttonText
     * @param buttonText
     */
    public DieView(String buttonText) {
        super(buttonText);
        images = new DiceImages("src/Media/Dice/");
    }

    /**
     * Default constructor that sets die button size and loads images to be used
     */
    public DieView() {
        super("");
        images = new DiceImages("src/Media/Dice/");

        setSize(40,40);
        setIcon(images.getDieImage(1));
    }

    /**
     * Locks the die so it can no longer be rolled
     */
    public void lock() {
        locked = true;
        updateLockedState();
    }

    /**
     * Unlocks the die so it can be rolled
     */
    public void unlock() {
        locked = false;
        updateLockedState();
    }

    /**
     * Toggles locked state of the die
     */
    void toggleLocked() {
        locked = !locked;
        updateLockedState();
    }

    /**
     * Visually changes the die button so the user knows if it is locked
     */
    void updateLockedState() {
        Border blackLine = BorderFactory.createLineBorder(Color.black);
        Border redLine = BorderFactory.createLineBorder(Color.red);
        if(locked) {
            setBorder(redLine);
            dieToView.lock();
        } else {
            setBorder(blackLine);
            dieToView.unlock();
        }
    }

    /**
     * Sets the die being viewed and can toggle its locked state
     * @param newDieToView
     */
    void setDieToView(Die newDieToView) {
        dieToView = newDieToView;
        dieToView.addPropertyChangeListener(this::propertyChange);
        addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        toggleLocked();
                        System.out.println("Button pressed to lock: " + locked);
                    }
                }
        );
    }

    /**
     * Getter for die values
     * @return dieValues
     */
    public Integer getDieValues(){return dieValues;}

    /**
     * Sets what happens when the die is pressed
     * @param e
     */
    public void propertyChange(PropertyChangeEvent e) {
        String propertyName = e.getPropertyName();
        if ("dievalue".equals(propertyName)) {
            System.out.println(("DieView sees value changed to: " + e.getNewValue()));
            dieValues = (Integer) e.getNewValue();
            setIcon(images.getDieImage((int) e.getNewValue()));
        }
    }
}