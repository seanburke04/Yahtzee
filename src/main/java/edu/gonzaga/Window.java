package edu.gonzaga;

import javax.swing.*;
import java.awt.*;

public class Window {
    private String workingDirectory = System.getProperty("user.dir");
    private String iconPath = workingDirectory + "/src/media/Logos/dicecup.jpg";
    private ImageIcon yahtzeeIcon = new ImageIcon(iconPath);
    private JFrame frame = new JFrame("Yahtzee!");
    private SettingsWindow settingsMenu = new SettingsWindow();

    public void runWindow(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(500, 200, 600, 400);
        frame.getContentPane().setBackground(Color.WHITE);

        frame.setIconImage(yahtzeeIcon.getImage());
        addComponents();
        settingsMenu.displayDefaultSettings();
        settingsMenu.addToButtonPanel();
        settingsMenu.yesNoButtonFunctionality();
    }

    private void addComponents(){
        frame.add(BorderLayout.WEST, settingsMenu.getSettingsTextArea());
        frame.add(BorderLayout.CENTER, settingsMenu.getRightPanel());
        frame.add(BorderLayout.SOUTH, settingsMenu.getButtonPanel());
    }

    public void makeVisible(Boolean visible){
        frame.setVisible(visible);
    }
}
