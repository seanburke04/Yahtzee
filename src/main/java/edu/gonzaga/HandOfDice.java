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

    private Die singleDie = new Die();
    private String userSelectionReRoll;
    private ArrayList<Integer> fullHand = new ArrayList<Integer>(); // Array for the hand of dice

    /**
     * Getter for the full hand array
     *
     * @return full hand array
     */
    public ArrayList<Integer> getFullHand(){return fullHand;}

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
        // Initial roll
        rollHand(5);
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