package edu.gonzaga;

import javax.swing.*;
import java.util.ArrayList;

public class SettingsWindow {
    private JButton yes = new JButton("Yes");
    private JButton no = new JButton("No");
    private JTextArea defaultSettings = new JTextArea();
    private ArrayList<Integer> settings = new ArrayList<>();
    private JPanel yesNoButtons = new JPanel();

    public void windowPrep(){
        initializeSettings();
        setDefaultSettings();
        addToPanel();
    }

    public JPanel getPanel(){return yesNoButtons;}

    public ArrayList<Integer> getSettings(){return settings;}

    public JTextArea getDefaultSettings(){return defaultSettings;}

    private void initializeSettings(){
        Integer numSides = 6;
        Integer numDice = 5;
        Integer numRolls = 3;

        settings.add(numSides);
        settings.add(numDice);
        settings.add(numRolls);
    }

    private void setDefaultSettings(){
        defaultSettings.setText("Default Yahtzee settings:\n");
        defaultSettings.append("Number of dice: 5\n");
        defaultSettings.append("Number of sides: 6\n");
        defaultSettings.append("Total number of rolls: 3\n\n");
        defaultSettings.append("Would you like to play with the default settings?");
    }

    private void addToPanel(){
        yesNoButtons.add(yes);
        yesNoButtons.add(no);
    }
}
