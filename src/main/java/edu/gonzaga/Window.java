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

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * This class controls the window for the user to interact with (main GUI driver)
 */
public class Window {
    static GraphicsConfiguration gc;
    String workingDirectory = System.getProperty("user.dir");
    String iconPath = workingDirectory + "/src//Media/Logos/dicecup.jpg";
    ImageIcon yahtzeeIcon = new ImageIcon(iconPath);
    JFrame mainWindow;

    Hand hand;
    HandView handView;

    SettingsView userSettings;

    /**
     * Initializes everything for the main frame
     */
    void setupMainWindow() {
        mainWindow = new JFrame(gc);
        mainWindow.setTitle("Yahtzee!");
        mainWindow.setSize(600, 400);
        mainWindow.setLocation(500,200);
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setIconImage(yahtzeeIcon.getImage());
    }

    /**
     * Passes settings to the game class from the SettingsView class
     * @return ArrayList<Integer></Integer> settings
     */
    public ArrayList<Integer> passSettings(){return userSettings.getUserSettings();}

    /**
     * Sets the frame to visible
     */
    void startGUI() {
        mainWindow.setVisible(true);
    }

    /**
     * Calls hand constructor so hand methods are called within that class
     */
    void setupHand() {
        hand = new Hand();
    }

    /**
     * Calls handView constructor so handView methods are called within that class
     */
    void setupHandView() {
        handView = new HandView(hand);
    }

    /**
     * Calls SettingsView constructor so SettingsView methods are called within that class
     */
    void setupUserSettings(){userSettings = new SettingsView();}

    /**
     * Removes components from the main frame
     * @param component
     */
    void removeComponent(Component component){
        mainWindow.remove(component);
        mainWindow.revalidate();
        mainWindow.repaint();
    }

    /**
     * Default constructor for the Window class, calls other methods only
     */
    public Window() {
        setupHand();
        setupHandView();
        setupMainWindow();
        setupUserSettings();

        //Why is this here? no effect on current program
        /*
        DieView dv = new DieView();
        dv.setDieToView(hand.getDieAt(0));

        Die die = hand.getDieAt(0);
        die.roll();

         */

        //For Settings window
        mainWindow.add(BorderLayout.WEST, userSettings.getDisplayDefaultSettingsPanel());
        mainWindow.add(BorderLayout.EAST, userSettings.getSettingsPanel());

        //This makes Crandall's code work
        //mainWindow.add(BorderLayout.EAST, handView.getPanel());

        //mainWindow.add(scorecardView.getPanel());
        //mainWindow.add(player.get(0).playerView.getPanel());
        //playerView.get(0).getPanel();
        //mainWindow.add(player.get(1).playerView.getPanel());

        startGUI();
    }
}
