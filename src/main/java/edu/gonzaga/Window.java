package edu.gonzaga;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Window {
    private String workingDirectory = System.getProperty("user.dir");
    private String iconPath = workingDirectory + "/src/media/Logos/dicecup.jpg";
    private ImageIcon yahtzeeIcon = new ImageIcon(iconPath);
    private JFrame frame = new JFrame("Yahtzee!");
    private JTextArea genericTextArea = new JTextArea();
    private JPanel centerPanel = new JPanel();
    private JPanel bottomPanel = new JPanel();
    private JButton yesButton = new JButton("Yes");
    private JButton noButton = new JButton("No");
    private JComboBox numDice = new JComboBox();
    private JComboBox numSides = new JComboBox();
    private JComboBox numRolls = new JComboBox();
    private JPanel numDicePanel = new JPanel();
    private JPanel numSidesPanel = new JPanel();
    private JPanel numRollsPanel = new JPanel();
    private JLabel numDiceText = new JLabel("Number of Dice: ");
    private JLabel numSidesText = new JLabel("Number of Sides: ");
    private JLabel numRollsText = new JLabel("Number of Rolls: ");
    private JButton confirm = new JButton("Confirm");
    private ArrayList<Integer> userSettings = new ArrayList<>(3);
    private Player player1 = new Player();

    public Window(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(500, 200, 600, 400);
        frame.getContentPane().setBackground(Color.WHITE);

        frame.setIconImage(yahtzeeIcon.getImage());

        // Num sides
        userSettings.add(6);

        // Num Dice
        userSettings.add(5);

        // Num Rolls
        userSettings.add(3);
    }



    //All game stuff runs through here
    private void startGame(){
        genericTextArea.setText(player1.getScoreText());
        frame.setVisible(true);
    }

    public void runGameWindow(){
        callSetupMethods();
        addSettingsComponents();
        frame.setVisible(true);
    }

    private void addSettingsComponents(){
        frame.add(BorderLayout.WEST, genericTextArea);
        frame.add(BorderLayout.CENTER, centerPanel);
        frame.add(BorderLayout.SOUTH, bottomPanel);
    }

    private void callSetupMethods(){
        displayDefaultSettings();
        addToBottomPanel();
        yesNoButtonFunctionality();
    }

    private void displayDefaultSettings(){
        genericTextArea.setEditable(false);
        genericTextArea.setText(" Default Yahtzee settings:\n");
        genericTextArea.append(" Number of dice: 5\n");
        genericTextArea.append(" Number of sides: 6\n");
        genericTextArea.append(" Total number of rolls: 3\n\n");
        genericTextArea.append(" Would you like to play with the default settings?");
    }

    private void addToBottomPanel(){
        bottomPanel.add(yesButton);
        bottomPanel.add(noButton);
    }

    private void setupComboBoxes(){
        //Num dice options
        numDice.addItem(5);
        numDice.addItem(6);
        numDice.addItem(7);

        //Num sides options
        numSides.addItem(6);
        numSides.addItem(8);
        numSides.addItem(12);

        //Num rolls options
        for(int i = 1; i < 11; i++){
            numRolls.addItem(i);
        }
        comboBoxListeners();
    }

    private void comboBoxListeners(){
        numDice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userSettings.set(1,(Integer) numDice.getSelectedItem());
            }
        });

        numSides.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userSettings.set(0,(Integer) numSides.getSelectedItem());
            }
        });

        numRolls.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userSettings.set(2,(Integer) numRolls.getSelectedItem());
            }
        });
    }

    private void setupSubPanels(){
        setupComboBoxes();

        numDicePanel.add(numDiceText);
        numDicePanel.add(numDice);

        numSidesPanel.add(numSidesText);
        numSidesPanel.add(numSides);

        numRollsPanel.add(numRollsText);
        numRollsPanel.add(numRolls);
    }

    private void addToRightPanel(){
        setupSubPanels();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        centerPanel.add(numDicePanel);
        centerPanel.add(numSidesPanel);
        centerPanel.add(numRollsPanel);
    }

    private void yesNoButtonFunctionality(){
        yesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                genericTextArea.setText(" Playing with default settings");
                startGame();
            }
        });

        noButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                genericTextArea.setText(" Default Yahtzee settings:\n");
                genericTextArea.append(" Number of dice: 5\n");
                genericTextArea.append(" Number of sides: 6\n");
                genericTextArea.append(" Total number of rolls: 3\n\n");
                addToRightPanel();
                bottomPanel.remove(yesButton);
                bottomPanel.remove(noButton);
                bottomPanel.revalidate();
                bottomPanel.repaint();
                bottomPanel.add(confirm);
            }
        });

        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                genericTextArea.setText("Selection confirmed");
                centerPanel.setVisible(false);
                startGame();
            }
        });
    }
}
