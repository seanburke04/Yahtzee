/**
 * This program rolls and scores the dice for a game of yahtzee
 * CPSC 224-02, Spring 2022
 * HW1 Yahtzee Rolling and Scoring
 * Source: Most of the Die.java file written by Dr. Crandall
 *
 * @author Sean Burke
 * @version v1.0 1/26/22
 */
package edu.gonzaga;

/*
* Class to handle each hand of dice
*/

import java.util.Scanner;
import java.util.ArrayList;
import java.util.*;

public class HandOfDice {

    Scanner getInput = new Scanner(System.in);
    Scanner configInput = new Scanner(System.in);

    private Die singleDie = new Die();
    private String userSelectionReRoll;
    private ArrayList<Integer> userSettings = new ArrayList<Integer>();
    private ArrayList<Integer> fullHand = new ArrayList<Integer>(); // Array for the hand of dice
    private ArrayList<Integer> readInFromFile = new ArrayList<Integer>();

    /**
     * Reads in values from the file and puts the values in an array
     */
    public void readInConfig(){
        // Default Values
        readInFromFile.add(6);
        readInFromFile.add(5);
        readInFromFile.add(3);
    }

    /**
     * Lets user decide how many dice to play with, how many sides each dice
     * has and the number of rolls they get
     *
     * @param readInSettings
     */
    public void userSelectedSettings(ArrayList<Integer> readInSettings){
        String changeConfig;

        // Report read in settings to the user
        System.out.print("You are playing with " + readInSettings.get(1));
        System.out.println(" " + readInSettings.get(0) + "-sided dice");
        System.out.print("You get " + readInSettings.get(2));
        System.out.println(" rolls per hand");

        // Asks the user if they want to change the configuration
        System.out.print("\nEnter 'y' if you would like to change ");
        System.out.print("the configuration ");
        changeConfig = configInput.nextLine();

        // Changes the configuration if the user wants
        if(changeConfig.charAt(0) == 'y'){
            System.out.print("Enter the number of sides on each die ");
            userSettings.add(configInput.nextInt());
            System.out.print("\nEnter the number of dice in play ");
            userSettings.add(configInput.nextInt());
            System.out.print("\nEnter the number of rolls per hand ");
            userSettings.add(configInput.nextInt());
            System.out.print("\n");
        }
        // Else set default game values
        else{
            userSettings.add(6);
            userSettings.add(5);
            userSettings.add(3);
        }
    }

    /**
     * Getter for the full hand array
     *
     * @return full hand array
     */
    public ArrayList<Integer> getFullHand(){return fullHand;}

    /**
     * Getter for the userSettings array
     *
     * @return userSettings array
     */
    public ArrayList<Integer> getUserSettings(){return userSettings;}

    /**
     * Rolls a set of dice for a full hand
     */
    public void rollHand(Integer numDice){
        for (Integer i = 0; i < numDice; i++){
            fullHand.add(singleDie.getSideUp());
            singleDie.roll();
            fullHand.set(i, singleDie.getSideUp());
        }
    }

    /**
     * Outputs the roll of a full hand to the console
     */
    public void outputRoll(){
        System.out.print("Your roll was:");

        for (Integer i = 0; i < fullHand.size(); i++){
            System.out.print(" " + fullHand.get(i));
        }
        System.out.print("\n");
    }

    /**
     * Gets which dice to re roll from the user and verifies valid input
     */
    public void getWhichToReRoll(){
        boolean isValid = false;

        System.out.println("Enter dice to keep (y or n) ");
        userSelectionReRoll = getInput.nextLine();

        while (!isValid){
            for (int i = 0; i < userSelectionReRoll.length(); i++){
                if (userSelectionReRoll.charAt(i) != 'y' && userSelectionReRoll.charAt(i) != 'n'){
                    System.out.println("Input invalid please try again");

                    System.out.println("Enter dice to keep (y or n) ");
                    userSelectionReRoll = getInput.nextLine();
                }
            }

            if (userSelectionReRoll.length() != 5){
                System.out.println("Input invalid please try again");

                System.out.println("Enter dice to keep (y or n) ");
                userSelectionReRoll = getInput.nextLine();
            }
            else{
                isValid = true;
            }
        }
    }

    /**
     * Re rolls all the dice according to the user's specifications
     */
    public void reRollDice(){
        Integer sideUp = singleDie.getSideUp();

        for (int i = 0; i < userSelectionReRoll.length(); i++){
            if (userSelectionReRoll.charAt(i) == 'n'){
                singleDie.roll();
                fullHand.set(i, sideUp);
            }
        }
    }

    /**
     * Sorts the dice in ascending order and prints it to the console
     */
    public void sortDice(){
        Collections.sort(fullHand);

        System.out.print("Your sorted hand is:");
        for (Integer i = 0; i < fullHand.size(); i++){
            System.out.print(" " + fullHand.get(i));
        }
        System.out.print("\n");
    }

    /**
     * Calls all functions for the dice roll to shorten main
     */
    public void callDiceRollingMethods(){
        readInConfig();
        userSelectedSettings(readInFromFile);
        // Initial roll
        rollHand(userSettings.get(1));
        outputRoll();

        // re roll number 1
        getWhichToReRoll();
        reRollDice();
        outputRoll();

        // re roll number 2
        getWhichToReRoll();
        reRollDice();
        outputRoll();

        sortDice();
    }
}