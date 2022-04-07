/**
 * This program rolls and scores the dice for a game of yahtzee
 * CPSC 224-02, Spring 2022
 * HW1 Yahtzee Rolling and Scoring
 * Source: Most of the Die.java file written by Dr. Crandall
 *
 * @author Sean Burke
 * @version v1.1 3/7/22
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

    private String userSelectionReRoll;
    private ArrayList<Integer> fullHand = new ArrayList<Integer>(); // Array for the hand of dice
    private ArrayList<Integer> userSettings = new ArrayList<Integer>(3);

    private static final Integer NUM_SIDES_INDEX = 0;
    private static final Integer NUM_DICE_INDEX = 1;
    private static final Integer NUM_ROLLS_INDEX = 2;

    void setFullHand(Integer one, Integer two, Integer three, Integer four, Integer five){
        fullHand.clear();
        fullHand.add(one);
        fullHand.add(two);
        fullHand.add(three);
        fullHand.add(four);
        fullHand.add(five);
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

    public void setUserSettings(ArrayList<Integer> settings){userSettings = settings;}

    /**
     * Rolls a set of dice for a full hand
     */
    public void rollHand(Die singleDie){
        fullHand.clear();

        for (Integer i = 0; i < userSettings.get(1); i++){
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
        System.out.println("Enter dice to keep (y or n) ");
        userSelectionReRoll = getInput.nextLine();
    }

    /**
     * Re rolls all the dice according to the user's specifications
     */
    public void reRollDice(Die singleDie){
        Integer sideUp;

        if(userSelectionReRoll.length() == fullHand.size()){
            for (int i = 0; i < userSelectionReRoll.length(); i++){
                if (userSelectionReRoll.charAt(i) == 'n'){
                    singleDie.roll();
                    sideUp = singleDie.getSideUp();
                    fullHand.set(i, sideUp);
                }
            }
        }
        else{
            throw new ArrayIndexOutOfBoundsException("Input string too long");
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
}