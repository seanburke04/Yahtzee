package edu.gonzaga;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

public class SettingsWindow {
    private JTextArea settingsTextArea = new JTextArea();
    private JPanel buttonPanel = new JPanel();
    private JButton yesButton = new JButton("Yes");
    private JButton noButton = new JButton("No");
    private JComboBox numDice = new JComboBox();
    private JComboBox numSides = new JComboBox();
    private JComboBox numRolls = new JComboBox();
    private JPanel centerPanel = new JPanel();
    private JPanel numDicePanel = new JPanel();
    private JPanel numSidesPanel = new JPanel();
    private JPanel numRollsPanel = new JPanel();
    private JLabel numDiceText = new JLabel("Number of Dice: ");
    private JLabel numSidesText = new JLabel("Number of Sides: ");
    private JLabel numRollsText = new JLabel("Number of Rolls: ");
    private JButton confirm = new JButton("Confirm");
    private ArrayList<Integer> userSettings = new ArrayList<>(3);
    private Boolean finished = false;

    public SettingsWindow(){
        // Num sides
        userSettings.add(6);

        // Num Dice
        userSettings.add(5);

        // Num Rolls
        userSettings.add(3);
    }

    public ArrayList<Integer> getUserSettings(){return userSettings;}

    public JTextArea getSettingsTextArea(){return settingsTextArea;}

    public Boolean getFinished(){return finished;}

    public JPanel getCenterPanel(){return centerPanel;}

    public JPanel getButtonPanel(){return buttonPanel;}

    public void callSetupMethods(){
        displayDefaultSettings();
        addToButtonPanel();
        yesNoButtonFunctionality();
    }

    private void displayDefaultSettings(){
        settingsTextArea.setEditable(false);
        settingsTextArea.setText(" Default Yahtzee settings:\n");
        settingsTextArea.append(" Number of dice: 5\n");
        settingsTextArea.append(" Number of sides: 6\n");
        settingsTextArea.append(" Total number of rolls: 3\n\n");
        settingsTextArea.append(" Would you like to play with the default settings?");
    }

    private void addToButtonPanel(){
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
        comboBoxListeners();
    }

    private void comboBoxListeners(){
        numDice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userSettings.set(1,(Integer) numDice.getSelectedItem());
            }
        });

        numSides.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userSettings.set(0,(Integer) numSides.getSelectedItem());
            }
        });

        numRolls.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userSettings.set(2,(Integer) numRolls.getSelectedItem());
            }
        });
    }

    private void setupSubPanels(){
        setupComboBoxes();

        numDicePanel.add(numDiceText);
        numDicePanel.add(numDice);

        numSidesPanel.add(numSidesText);
        numSidesPanel.add(numSides);

        numRollsPanel.add(numRollsText);
        numRollsPanel.add(numRolls);
    }

    private void addToRightPanel(){
        setupSubPanels();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        centerPanel.add(numDicePanel);
        centerPanel.add(numSidesPanel);
        centerPanel.add(numRollsPanel);
    }

    private void yesNoButtonFunctionality(){
        yesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settingsTextArea.setText(" Playing with default settings");
            }

        });

        noButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settingsTextArea.setText(" Default Yahtzee settings:\n");
                settingsTextArea.append(" Number of dice: 5\n");
                settingsTextArea.append(" Number of sides: 6\n");
                settingsTextArea.append(" Total number of rolls: 3\n\n");
                addToRightPanel();
                buttonPanel.remove(yesButton);
                buttonPanel.remove(noButton);
                buttonPanel.revalidate();
                buttonPanel.repaint();
                buttonPanel.add(confirm);
            }
        });

        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settingsTextArea.setText("Selection confirmed");
                centerPanel.setVisible(false);
                finished = true;
            }
        });
    }
}
