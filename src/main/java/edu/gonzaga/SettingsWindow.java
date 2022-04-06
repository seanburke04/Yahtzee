package edu.gonzaga;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsWindow {
    private JTextArea genericTextArea = new JTextArea();
    private JPanel buttonPanel = new JPanel();
    private JButton yesButton = new JButton("Yes");
    private JButton noButton = new JButton("No");
    private JComboBox numDice = new JComboBox();
    private JComboBox numSides = new JComboBox();
    private JComboBox numRolls = new JComboBox();
    private JPanel rightPanel = new JPanel();
    private JTextArea numDiceText = new JTextArea("Number of Dice: ");
    private JTextArea numSidesText = new JTextArea("Number of Sides: ");
    private JTextArea numRollsText = new JTextArea("Number of Rolls: ");

    public JTextArea getGenericTextArea(){return genericTextArea;}

    public JPanel getRightPanel(){return rightPanel;}

    public JPanel getButtonPanel(){return buttonPanel;}

    public void displayDefaultSettings(){
        genericTextArea.setEditable(false);
        genericTextArea.setText(" Default Yahtzee settings:\n");
        genericTextArea.append(" Number of dice: 5\n");
        genericTextArea.append(" Number of sides: 6\n");
        genericTextArea.append(" Total number of rolls: 3\n\n");
        genericTextArea.append(" Would you like to play with the default settings?");
    }

    public void addToButtonPanel(){
        buttonPanel.add(yesButton);
        buttonPanel.add(noButton);
    }

    private void setupComboBoxes(){
        //Num dice options
        numDice.addItem(5);
        numDice.addItem(6);
        numDice.addItem(7);

        //Num sides options
        numSides.addItem(6);
        numSides.addItem(8);
        numSides.addItem(12);

        //Num rolls options
        for(int i = 1; i < 11; i++){
            numRolls.addItem(i);
        }
    }

    private void addToRightPanel(){
        setupComboBoxes();

        //Needs to be cleaned up
        rightPanel.setLayout(new GridLayout(3,2));

        numDiceText.setEditable(false);
        rightPanel.add(numDiceText);
        rightPanel.add(numDice);

        numSidesText.setEditable(false);
        rightPanel.add(numSidesText);
        rightPanel.add(numSides);

        numRollsText.setEditable(false);
        rightPanel.add(numRollsText);
        rightPanel.add(numRolls);
    }

    public void yesNoButtonFunctionality(){
        yesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                genericTextArea.setText(" Pressed Yes");
            }
        });

        noButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                genericTextArea.setText(" Default Yahtzee settings:\n");
                genericTextArea.append(" Number of dice: 5\n");
                genericTextArea.append(" Number of sides: 6\n");
                genericTextArea.append(" Total number of rolls: 3\n\n");
                addToRightPanel();
                buttonPanel.setVisible(false);
            }
        });
    }
}
