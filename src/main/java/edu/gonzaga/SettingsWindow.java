package edu.gonzaga;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        yesFunction();
        noFunction();
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

    /*
    Adds functionality to the yes button
    Added here to make sure this works
    Kept as placeholder until I add actual functionality
    Possible issue with removing components from frame as this does not have access
     */
    private void yesFunction(){
        yes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                defaultSettings.setText("Pressed yes");
            }
        });
    }

    private void noFunction(){
        no.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                defaultSettings.setText("Pressed No");
            }
        });
    }
}
