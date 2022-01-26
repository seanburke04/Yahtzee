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
    public Integer[] fullHand = new Integer[5]; // Array for the hand of dice

    /** rolls each hand */
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

    /** outputs roll */
    public void outputRoll(){
        System.out.print("Your roll was: " + fullHand[0] + " ");
        System.out.print(fullHand[1] + " " + fullHand[2] + " " + fullHand[3]);
        System.out.println(" " + fullHand[4]);
    }

    /** get user re roll this function also checks if the input is valid */
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

    /** Decides which dice need to be rolled and calls the roll function again */
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

    /** This sorts the hand of dice in ascending order */
    public void sortDice(){
        Arrays.sort(fullHand);
        System.out.print("Your sorted hand is: " + fullHand[0] + " ");
        System.out.print(fullHand[1] + " " + fullHand[2] + " " + fullHand[3]);
        System.out.println(" " + fullHand[4]);
    }

    /** Calls all necessary functions for rolling dice */
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