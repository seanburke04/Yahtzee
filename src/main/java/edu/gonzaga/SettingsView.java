package edu.gonzaga;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SettingsView {
    JLabel numSidesText = new JLabel("Number of Sides: ");
    JLabel numDiceText = new JLabel("Number of Dice: ");
    JLabel numRollsText = new JLabel("Number of Rolls: ");
    JComboBox numDice = new JComboBox();
    JComboBox numSides = new JComboBox();
    JComboBox numRolls = new JComboBox();
    JPanel numDicePanel = new JPanel();
    JPanel numSidesPanel = new JPanel();
    JPanel numRollsPanel = new JPanel();
    JPanel settingsPanel = new JPanel();
    JTextArea displayDefaultSettings = new JTextArea();
    JPanel displayDefaultSettingsPanel = new JPanel();

    static final Integer NUM_SIDES_INDEX = 0;
    static final Integer NUM_DICE_INDEX = 1;
    static final Integer NUM_ROLLS_INDEX = 2;
    static final Integer DEFAULT_SIDES = 6;
    static final Integer DEFAULT_DICE = 5;
    static final Integer DEFAULT_ROLLS = 3;

    ArrayList<Integer> userSettings = new ArrayList<>();

    SettingsView(){
        userSettings.add(DEFAULT_SIDES);
        userSettings.add(DEFAULT_DICE);
        userSettings.add(DEFAULT_ROLLS);

        setupComboBoxes();
        comboBoxListeners();
        addToSubPanels();
        addToSettingsPanel();
        setDisplayText();
        addToDisplayDefaultSettingsPanel();
    }

    public ArrayList<Integer> getUserSettings(){return userSettings;}

    public JPanel getSettingsPanel(){return settingsPanel;}

    public JPanel getDisplayDefaultSettingsPanel(){return displayDefaultSettingsPanel;}

    void addToDisplayDefaultSettingsPanel(){displayDefaultSettingsPanel.add(displayDefaultSettings);}

    void setDisplayText(){
        displayDefaultSettings.setText("Default Settings:\n");
        displayDefaultSettings.append("Number of Sides: 6\n");
        displayDefaultSettings.append("Number of Dice: 5\n");
        displayDefaultSettings.append("Number of Rolls: 3\n\n");
        displayDefaultSettings.append("Would you like to play with these settings?");
    }

    void addToSubPanels(){
        numSidesPanel.add(numSidesText);
        numSidesPanel.add(numSides);

        numDicePanel.add(numDiceText);
        numDicePanel.add(numDice);

        numRollsPanel.add(numRollsText);
        numRollsPanel.add(numRolls);
    }

    void addToSettingsPanel(){
        settingsPanel.setLayout(new BoxLayout(settingsPanel, BoxLayout.Y_AXIS));
        settingsPanel.add(numSidesPanel);
        settingsPanel.add(numDicePanel);
        settingsPanel.add(numRollsPanel);
    }

    void setupComboBoxes(){
        //Num dice options
        numDice.addItem(5);
        numDice.addItem(6);
        numDice.addItem(7);
        //Num sides options
        numSides.addItem(6);
        numSides.addItem(8);
        numSides.addItem(12);
        //Num rolls options
        for(int i = 3; i < 6; i++){
            numRolls.addItem(i);
        }
    }

    void comboBoxListeners(){
        numDice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userSettings.set(NUM_DICE_INDEX,(Integer) numDice.getSelectedItem());
            }
        });
        numSides.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userSettings.set(NUM_SIDES_INDEX, (Integer) numSides.getSelectedItem());
            }
        });
        numRolls.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userSettings.set(NUM_ROLLS_INDEX, (Integer) numRolls.getSelectedItem());
            }
        });
    }
}
