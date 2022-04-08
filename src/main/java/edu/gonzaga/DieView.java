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

    public DieView(String buttonText) {
        super(buttonText);
        images = new DiceImages("src/Media/Dice/");
    }

    public DieView() {
        super("");
        images = new DiceImages("src/Media/Dice/");

        setSize(40,40);
        setIcon(images.getDieImage(1));
    }

    public void lock() {
        locked = true;
        updateLockedState();
    }

    public void unlock() {
        locked = false;
        updateLockedState();
    }

    void toggleLocked() {
        locked = !locked;
        updateLockedState();
    }

    void updateLockedState() {
        Border blackline = BorderFactory.createLineBorder(Color.black);
        Border redline = BorderFactory.createLineBorder(Color.red);
        if(locked) {
            setBorder(redline);
            dieToView.lock();
        } else {
            setBorder(blackline);
            dieToView.unlock();
        }
    }

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

    public void propertyChange(PropertyChangeEvent e) {
        String propertyName = e.getPropertyName();
        if ("dievalue".equals(propertyName)) {
            System.out.println(("DieView sees value changed to: " + e.getNewValue()));
            setIcon(images.getDieImage((int) e.getNewValue()));
        }
    }

}