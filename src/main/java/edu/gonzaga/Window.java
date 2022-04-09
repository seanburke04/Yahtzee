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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

    JLabel numSidesText = new JLabel("Number of Sides: ");
    JLabel numDiceText = new JLabel("Number of Dice: ");
    JLabel numRollsText = new JLabel("Number of Rolls: ");
    JComboBox numDice = new JComboBox();
    JComboBox numSides = new JComboBox();
    JComboBox numRolls = new JComboBox();
    JPanel numDicePanel = new JPanel();
    JPanel numSidesPanel = new JPanel();
    JPanel numRollsPanel = new JPanel();
    JPanel settingsPanel = new JPanel();
    JTextArea displayDefaultSettings = new JTextArea();
    JPanel displayDefaultSettingsPanel = new JPanel();
    JButton confirm = new JButton("Confirm");
    JPanel buttonPanel = new JPanel();

    static final Integer NUM_SIDES_INDEX = 0;
    static final Integer NUM_DICE_INDEX = 1;
    static final Integer NUM_ROLLS_INDEX = 2;
    static final Integer DEFAULT_SIDES = 6;
    static final Integer DEFAULT_DICE = 5;
    static final Integer DEFAULT_ROLLS = 3;

    ArrayList<Integer> userSettings = new ArrayList<>();

    Game game;

    Hand hand;
    HandView handView;

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

    void setupGame(){game = new Game();}

    /**
     * Calls handView constructor so handView methods are called within that class
     */
    void setupHandView() {
        handView = new HandView(hand);
    }

    /**
     * Prepares everything for the window
     */
    void setupUserSettings(){
        userSettings.add(DEFAULT_SIDES);
        userSettings.add(DEFAULT_DICE);
        userSettings.add(DEFAULT_ROLLS);

        setupComboBoxes();
        comboBoxListeners();
        addToSubPanels();
        addToSettingsPanel();
        setDisplayText();
        addToDisplayDefaultSettingsPanel();
        addToButtonPanel();
        buttonFunctionality();
    }

    /**
     * Adds listeners to combo boxes to get input
     */
    void comboBoxListeners(){
        numDice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userSettings.set(NUM_DICE_INDEX,(Integer) numDice.getSelectedItem());
                game.setSettings(userSettings);
            }
        });
        numSides.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userSettings.set(NUM_SIDES_INDEX, (Integer) numSides.getSelectedItem());
                game.setSettings(userSettings);
            }
        });
        numRolls.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userSettings.set(NUM_ROLLS_INDEX, (Integer) numRolls.getSelectedItem());
                game.setSettings(userSettings);
            }
        });
    }

    /**
     * Adds combo box panels to a single panel to be used by the window
     */
    void addToSettingsPanel(){
        settingsPanel.setLayout(new BoxLayout(settingsPanel, BoxLayout.Y_AXIS));
        settingsPanel.add(numSidesPanel);
        settingsPanel.add(numDicePanel);
        settingsPanel.add(numRollsPanel);
    }

    /**
     * Sets up combo box values
     */
    void setupComboBoxes(){
        //Num dice options
        numDice.addItem(5);
        numDice.addItem(6);
        numDice.addItem(7);
        //Num sides options
        numSides.addItem(6);
        numSides.addItem(8);
        numSides.addItem(12);
        //Num rolls options
        for(int i = 3; i < 6; i++){
            numRolls.addItem(i);
        }
    }

    /**
     * Sets the text to be displayed by the text area
     */
    void setDisplayText(){
        displayDefaultSettings.setText("Default Settings:\n");
        displayDefaultSettings.append("Number of Sides: 6\n");
        displayDefaultSettings.append("Number of Dice: 5\n");
        displayDefaultSettings.append("Number of Rolls: 3\n\n");
        displayDefaultSettings.append("Enter chosen settings on the right\n");
        displayDefaultSettings.append("If none are chosen the game will proceed with the default");
    }

    /**
     * Adds labels and combo boxes to their respective panels
     */
    void addToSubPanels(){
        numSidesPanel.add(numSidesText);
        numSidesPanel.add(numSides);

        numDicePanel.add(numDiceText);
        numDicePanel.add(numDice);

        numRollsPanel.add(numRollsText);
        numRollsPanel.add(numRolls);
    }

    /**
     * Adds textArea to its respective panel
     */
    void addToDisplayDefaultSettingsPanel(){displayDefaultSettingsPanel.add(displayDefaultSettings);}

    void addToButtonPanel(){buttonPanel.add(confirm);}

    void buttonFunctionality(){
        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeComponent(buttonPanel);
                removeComponent(displayDefaultSettingsPanel);
                removeComponent(settingsPanel);
                game.startGame();
                addGameComponents();
            }
        });
    }

    void addGameComponents(){
        mainWindow.add(BorderLayout.EAST, handView.getPanel());
        //Change this to scorecard
        mainWindow.add(BorderLayout.WEST, displayDefaultSettingsPanel);
        mainWindow.pack();
    }

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
        setupGame();
        setupUserSettings();

        //Why is this here? no effect on current program
        /*
        DieView dv = new DieView();
        dv.setDieToView(hand.getDieAt(0));

        Die die = hand.getDieAt(0);
        die.roll();

         */

        //For Settings window
        mainWindow.add(BorderLayout.WEST, displayDefaultSettingsPanel);
        mainWindow.add(BorderLayout.EAST, settingsPanel);
        mainWindow.add(BorderLayout.SOUTH, buttonPanel);

        //This makes Crandall's code work
        //mainWindow.add(BorderLayout.EAST, handView.getPanel());

        //mainWindow.add(scorecardView.getPanel());
        //mainWindow.add(player.get(0).playerView.getPanel());
        //playerView.get(0).getPanel();
        //mainWindow.add(player.get(1).playerView.getPanel());

        startGUI();
    }
}
