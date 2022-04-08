package edu.gonzaga;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    Settings settings = new Settings();

    SettingsView(){
        setupComboBoxes();
        comboBoxListeners();
        addToSubPanels();
        addToSettingsPanel();
        setDisplayText();
        addToDisplayDefaultSettingsPanel();
    }

    public JPanel getSettingsPanel(){return settingsPanel;}

    public JPanel getDisplayDefaultSettingsPanel(){return displayDefaultSettingsPanel;}

    void addToDisplayDefaultSettingsPanel(){displayDefaultSettingsPanel.add(displayDefaultSettings);}

    void setDisplayText(){
        displayDefaultSettings.setText("Default Settings:\n");
        displayDefaultSettings.append("Number of Sides: 6\n");
        displayDefaultSettings.append("Number of Dice: 5");
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
                settings.setNumDice((Integer) numDice.getSelectedItem());
            }
        });
        numSides.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settings.setNumSides((Integer) numSides.getSelectedItem());
            }
        });
        numRolls.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settings.setNumRolls((Integer) numRolls.getSelectedItem());
            }
        });
    }
}
