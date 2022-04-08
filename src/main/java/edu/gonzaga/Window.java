package edu.gonzaga;

import javax.swing.*;
import java.awt.*;

public class Window {
    static GraphicsConfiguration gc;
    String workingDirectory = System.getProperty("user.dir");
    String iconPath = workingDirectory + "/src//Media/Logos/dicecup.jpg";
    ImageIcon yahtzeeIcon = new ImageIcon(iconPath);
    JFrame mainWindow;

    Hand hand;
    HandView handView;

    void setupMainWindow() {
        mainWindow = new JFrame(gc);
        mainWindow.setTitle("Yahtzee!");
        mainWindow.setSize(600, 400);
        mainWindow.setLocation(200,200);
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setIconImage(yahtzeeIcon.getImage());
    }

    void startGUI() {
        mainWindow.setVisible(true);
    }

    void setupHand() {
        hand = new Hand();
    }

    void setupHandView() {
        handView = new HandView(hand);
    }

    public Window() {
        setupHand();
        setupHandView();
        setupMainWindow();

        DieView dv = new DieView();
        dv.setDieToView(hand.getDieAt(0));

        Die die = hand.getDieAt(0);
        die.roll();

        mainWindow.add(handView.getPanel());
        //mainWindow.add(scorecardView.getPanel());
        //mainWindow.add(player.get(0).playerView.getPanel());
        //playerView.get(0).getPanel();
        //mainWindow.add(player.get(1).playerView.getPanel());

        startGUI();
    }
}
