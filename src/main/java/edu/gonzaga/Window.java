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
    private JTextArea genericTextArea = new JTextArea();
    private JPanel buttonPanel = new JPanel();
    private JButton yesButton = new JButton("Yes");
    private JButton noButton = new JButton("No");

    public void runWindow(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(500, 200, 600, 400);

        frame.setIconImage(yahtzeeIcon.getImage());
        addComponents();
        displayDefaultSettings();
        addToButtonPanel();
    }

    public void setGenericTextArea(String text) {
        this.genericTextArea.setText(text);
    }

    private void displayDefaultSettings(){
        genericTextArea.setEditable(false);
        genericTextArea.setText(" Default Yahtzee settings:\n");
        genericTextArea.append(" Number of dice: 5\n");
        genericTextArea.append(" Number of sides: 6\n");
        genericTextArea.append(" Total number of rolls: 3\n\n");
        genericTextArea.append(" Would you like to play with the default settings?");
    }

    private void addComponents(){
        frame.add(BorderLayout.WEST, genericTextArea);
        //frame.add(BorderLayout.EAST, //DicePanel);
        frame.add(BorderLayout.SOUTH, buttonPanel);
    }

    private void addToButtonPanel(){
        buttonPanel.add(yesButton);
        buttonPanel.add(noButton);
    }

    public void makeVisible(Boolean visible){
        frame.setVisible(visible);
    }
}
