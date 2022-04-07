package edu.gonzaga;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Window {
    private String workingDirectory = System.getProperty("user.dir");
    private String iconPath = workingDirectory + "/src/media/Logos/dicecup.jpg";
    private ImageIcon yahtzeeIcon = new ImageIcon(iconPath);
    private JFrame frame = new JFrame("Yahtzee!");
    private SettingsWindow settingsMenu = new SettingsWindow();
    private JTextArea genericTextArea = new JTextArea();
    private JPanel centerPanel = new JPanel();
    private JPanel bottomPanel = new JPanel();

    public void runWindow(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(500, 200, 600, 400);
        frame.getContentPane().setBackground(Color.WHITE);

        frame.setIconImage(yahtzeeIcon.getImage());
    }

    public void getSettingsComponents(JTextArea textArea, JPanel mainPanel, JPanel secondPanel){
        genericTextArea = textArea;
        centerPanel = mainPanel;
        bottomPanel = secondPanel;
    }

    public void addSettingsComponents(){
        frame.add(BorderLayout.WEST, genericTextArea);
        frame.add(BorderLayout.CENTER, centerPanel);
        frame.add(BorderLayout.SOUTH, bottomPanel);
    }

    public void makeVisible(Boolean visible){
        frame.setVisible(visible);
    }
}
