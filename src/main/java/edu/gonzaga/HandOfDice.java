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
import java.util.Arrays;

public class HandOfDice {

    Scanner getInput = new Scanner(System.in);

    private Die die1 = new Die();
    private Die die2 = new Die();
    private Die die3 = new Die();
    private Die die4 = new Die();
    private Die die5 = new Die();
    private String userSelectionReRoll;
    private Integer[] fullHand = new Integer[5]; // Array for the hand of dice

    /**
     * Getter for the full hand array
     *
     * @return full hand array
     */
    public Integer[] getFullHand(){return fullHand;}

    /**
     * Rolls a set of dice for a full hand
     */
    public void rollHand(){
        die1.roll();
        die2.roll();
        die3.roll();
        die4.roll();
        die5.roll();

        fullHand[0] = die1.getSideUp();
        fullHand[1] = die2.getSideUp();
        fullHand[2] = die3.getSideUp();
        fullHand[3] = die4.getSideUp();
        fullHand[4] = die5.getSideUp();
    }

    /**
     * Outputs the roll of a full hand to the console
     */
    public void outputRoll(){
        System.out.print("Your roll was: " + fullHand[0] + " ");
        System.out.print(fullHand[1] + " " + fullHand[2] + " " + fullHand[3]);
        System.out.println(" " + fullHand[4]);
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
        for (int i = 0; i < userSelectionReRoll.length(); i++){
            if (userSelectionReRoll.charAt(i) == 'n'){
                if (i == 0){
                    die1.roll();
                }
                else if (i == 1){
                    die2.roll();
                }
                else if (i == 2){
                    die3.roll();
                }
                else if (i == 3){
                    die4.roll();
                }
                else if (i == 4){
                    die5.roll();
                }
            }
        }
        fullHand[0] = die1.getSideUp();
        fullHand[1] = die2.getSideUp();
        fullHand[2] = die3.getSideUp();
        fullHand[3] = die4.getSideUp();
        fullHand[4] = die5.getSideUp();
    }

    /**
     * Sorts the dice in ascending order and prints it to the console
     */
    public void sortDice(){
        Arrays.sort(fullHand);
        System.out.print("Your sorted hand is: " + fullHand[0] + " ");
        System.out.print(fullHand[1] + " " + fullHand[2] + " " + fullHand[3]);
        System.out.println(" " + fullHand[4]);
    }

    /**
     * Calls all functions for the dice roll to shorten main
     */
    public void callDiceRollingMethods(){
        // Initial roll
        rollHand();
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