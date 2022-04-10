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
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.border.Border;

/**
 * This class controls how the hand is viewed in the GUI
 */
public class HandView {
    Integer count = 0;
    JPanel myPanel;
    ArrayList<DieView> dieViews;
    ArrayList<Integer> settings;
    JButton rollButton;
    Hand hand;

    /**
     * Sets the border, layout and size of the panel
     */
    void setupPanel() {
        myPanel = new JPanel();

        // Borders can change the style of widget edges
        Border blackLine = BorderFactory.createLineBorder(Color.black);

        // FlowLayout is the default left to right kind of layout
        myPanel.setLayout(new FlowLayout());

        // Box layout can go vertically
        //myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.PAGE_AXIS));

        myPanel.setSize(600, 100);
        myPanel.setBorder(blackLine);
    }

    /**
     * Sets up the dice view
     */
    void setupDiceViews() {
        for( int i = 0; i < settings.get(1); i++ ) {
            DieView newView = new DieView();
            newView.setDieToView(hand.getDieAt(i));
            dieViews.add(newView);
            myPanel.add(newView);
        }
    }

    /**
     * Sets up the re-roll button and its function
     */
    void setupRollButton() {
        rollButton = new JButton("Roll!");
        rollButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("Button pressed to roll");
                        hand.roll();
                        count++;
                        //Obviously change this but this controls the number of rolls
                        if(count == settings.get(2)){
                            rollButton.setVisible(false);
                        }
                    }
                }
        );
        myPanel.add(rollButton);
    }

    /**
     * Constructor that sets up the view for a particular hand
     * @param newHand
     */
    HandView(Hand newHand, ArrayList<Integer> userSettings) {
        settings = userSettings;
        hand = newHand;
        dieViews = new ArrayList<>();

        setupPanel();
        setupDiceViews();
        setupRollButton();

    }

    /**
     * Getter for the panel
     * @return myPanel
     */
    public JPanel getPanel() {
        return myPanel;
    }
}