/**
 * This program plays through a whole game of Yahtzee through a GUI
 * CPSC 224-02, Spring 2022
 * HW4 Yahtzee GUI
 * Source: Most of the Die.java, DiceImages.java, DieView.java, Hand.java, HandView.java, Window.java
 * files written by Dr. Crandall
 *
 * @author Sean Burke
 * @version v1.4 4/8/22
 */
package edu.gonzaga;

import java.util.ArrayList;

/**
 * Main driver class for the whole game
 */
public class Game {
    Window mainWindow;

    ArrayList<Integer> settings = new ArrayList<>();

    /**
     * Gets the settings set by the user to configure the game
     */
    void getSettings(){settings = mainWindow.passSettings();}

    /**
     * Sets up the window for the user to interact with
     */
    void setupWindow(){mainWindow = new Window();}

    /**
     * Default constructor, calls other methods only
     */
    public Game(){
        setupWindow();
        getSettings();
    }
}
