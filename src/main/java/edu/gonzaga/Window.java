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

public class Window {
    static GraphicsConfiguration gc;
    String workingDirectory = System.getProperty("user.dir");
    String iconPath = workingDirectory + "/src//Media/Logos/dicecup.jpg";
    ImageIcon yahtzeeIcon = new ImageIcon(iconPath);
    JFrame mainWindow;

    Hand hand;
    HandView handView;

    SettingsView userSettings;

    void setupMainWindow() {
        mainWindow = new JFrame(gc);
        mainWindow.setTitle("Yahtzee!");
        mainWindow.setSize(600, 400);
        mainWindow.setLocation(500,200);
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setIconImage(yahtzeeIcon.getImage());
    }

    public ArrayList<Integer> passSettings(){return userSettings.getUserSettings();}

    void startGUI() {
        mainWindow.setVisible(true);
    }

    void setupHand() {
        hand = new Hand();
    }

    void setupHandView() {
        handView = new HandView(hand);
    }

    void setupUserSettings(){userSettings = new SettingsView();}

    void removeComponent(Component component){
        mainWindow.remove(component);
        mainWindow.revalidate();
        mainWindow.repaint();
    }

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
