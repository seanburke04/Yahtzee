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

public class Game {
    Window mainWindow;

    ArrayList<Integer> settings = new ArrayList<>();

    void getSettings(){settings = mainWindow.passSettings();}

    void setupWindow(){mainWindow = new Window();}

    public Game(){
        setupWindow();
        getSettings();
    }
}
