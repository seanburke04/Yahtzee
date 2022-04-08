package edu.gonzaga;

import javax.swing.*;

public class Game {
    SettingsView userSettings;

    void setupUserSettings(){userSettings = new SettingsView();}

    public Game(){
        setupUserSettings();
    }

    public JPanel passTextPanel(){return userSettings.getDisplayDefaultSettingsPanel();}

    public JPanel passComboBoxPanel(){return userSettings.getSettingsPanel();}
}
