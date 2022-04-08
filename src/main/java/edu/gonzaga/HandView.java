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

public class HandView {
    JPanel myPanel;
    ArrayList<DieView> dieViews;
    JButton rollButton;
    Hand hand;

    void setupPanel() {
        myPanel = new JPanel();

        // Borders can change the style of widget edges
        Border blackline = BorderFactory.createLineBorder(Color.black);

        // FlowLayout is the default left to right kind of layout
        myPanel.setLayout(new FlowLayout());

        // Box layout can go vertically
        //myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.PAGE_AXIS));

        myPanel.setSize(600, 100);
        myPanel.setBorder(blackline);
    }

    void setupDiceViews() {
        for( int i = 0; i < 5; i++ ) {
            DieView newView = new DieView();
            newView.setDieToView(hand.getDieAt(i));
            dieViews.add(newView);
            myPanel.add(newView);
        }
    }

    void setupRollButton() {
        rollButton = new JButton("Roll!");
        rollButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("Button pressed to roll");
                        hand.roll();
                    }
                }
        );
        myPanel.add(rollButton);
    }

    HandView(Hand newHand) {
        hand = newHand;
        dieViews = new ArrayList<>();

        setupPanel();
        setupDiceViews();
        setupRollButton();

    }

    public JPanel getPanel() {
        return myPanel;
    }
}