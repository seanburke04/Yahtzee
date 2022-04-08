package edu.gonzaga;

import javax.swing.*;

public class Game {
    SettingsView userSettings;

    //Game has a window not the other way around
    //Main needs an instance of game, game needs an instance of Window

    void setupUserSettings(){userSettings = new SettingsView();}

    public Game(){
        setupUserSettings();
    }

    public JPanel passTextPanel(){return userSettings.getDisplayDefaultSettingsPanel();}

    public JPanel passComboBoxPanel(){return userSettings.getSettingsPanel();}
}
