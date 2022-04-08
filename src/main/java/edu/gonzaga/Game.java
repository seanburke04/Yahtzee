package edu.gonzaga;

import javax.swing.*;
import java.util.ArrayList;

public class Game {
    Window mainWindow;

    ArrayList<Integer> settings = new ArrayList<>();

    //Game has a window not the other way around
    //Main needs an instance of game, game needs an instance of Window

    void getSettings(){settings = mainWindow.passSettings();}

    void setupWindow(){mainWindow = new Window();}

    public Game(){
        setupWindow();
        getSettings();
    }
}
