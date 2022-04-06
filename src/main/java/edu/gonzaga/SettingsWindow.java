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
    private JPanel numDicePanel = new JPanel();
    private JPanel numSidesPanel = new JPanel();
    private JPanel numRollsPanel = new JPanel();
    private JTextArea numDiceText = new JTextArea("Number of Dice: ");
    private JTextArea numSidesText = new JTextArea("Number of Sides: ");
    private JTextArea numRollsText = new JTextArea("Number of Rolls: ");
    private JButton confirm = new JButton("Confirm");

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

    private void setupSubPanels(){
        setupComboBoxes();

        numDiceText.setEditable(false);
        numDicePanel.add(numDiceText);
        numDicePanel.add(numDice);

        numSidesText.setEditable(false);
        numSidesPanel.add(numSidesText);
        numSidesPanel.add(numSides);

        numRollsText.setEditable(false);
        numRollsPanel.add(numRollsText);
        numRollsPanel.add(numRolls);
    }

    private void addToRightPanel(){
        setupSubPanels();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));

        rightPanel.add(numDicePanel);
        rightPanel.add(numSidesPanel);
        rightPanel.add(numRollsPanel);
        rightPanel.add(confirm);
    }

    //Look at last thing in pocket to see how to remove components
    //Put confirm button at bottom of the screen after doing this
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

        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                genericTextArea.setText("Selection confirmed");
                rightPanel.setVisible(false);
            }
        });
    }
}
