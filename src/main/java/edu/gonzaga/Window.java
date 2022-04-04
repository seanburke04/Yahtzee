package edu.gonzaga;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Window {
    //Icon
    private String workingDirectory = System.getProperty("user.dir");
    private String iconPath = workingDirectory + "/src/media/Logos/dicecup.jpg";
    private ImageIcon yahtzeeIcon = new ImageIcon(iconPath);

    private SettingsWindow settingsMenu = new SettingsWindow();

    //Frame
    private JFrame frame = new JFrame("Yahtzee!");

    public void makeWindow(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(500, 200, 600, 400);

        frame.setIconImage(yahtzeeIcon.getImage());
        addSettingsMenu();
    }

    private void addSettingsMenu(){
        settingsMenu.windowPrep();
        frame.add(BorderLayout.CENTER, settingsMenu.getDefaultSettings());
        frame.add(BorderLayout.SOUTH, settingsMenu.getPanel());
    }

    public void makeVisible(Boolean visible){
        frame.setVisible(visible);
    }
}
