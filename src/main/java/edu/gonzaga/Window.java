package edu.gonzaga;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Window {
    private String workingDirectory = System.getProperty("user.dir");
    private String iconPath = workingDirectory + "/src/media/Logos/dicecup.jpg";
    private ImageIcon yahtzeeIcon = new ImageIcon(iconPath);
    private JFrame frame = new JFrame("Yahtzee!");
    private SettingsWindow settingsMenu = new SettingsWindow();


    //Add panels inside the panel and adjust layout so it fits on screen properly

    public void runWindow(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(500, 200, 600, 400);

        frame.setIconImage(yahtzeeIcon.getImage());
        addComponents();
        settingsMenu.displayDefaultSettings();
        settingsMenu.addToButtonPanel();
        settingsMenu.yesNoButtonFunctionality();
    }

    private void addComponents(){
        frame.add(BorderLayout.WEST, settingsMenu.getGenericTextArea());
        frame.add(BorderLayout.EAST, settingsMenu.getRightPanel());
        frame.add(BorderLayout.SOUTH, settingsMenu.getButtonPanel());
    }

    public void makeVisible(Boolean visible){
        frame.setVisible(visible);
    }
}
