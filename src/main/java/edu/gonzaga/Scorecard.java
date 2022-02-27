/**
 * This program rolls and scores the dice for a game of yahtzee
 * CPSC 224-02, Spring 2022
 * HW1 Yahtzee Rolling and Scoring
 * Source: Most of the Die.java file written by Dr. Crandall
 *
 * @author Sean Burke
 * @version v1.1 2/9/22
 */
package edu.gonzaga;

/**
* Class to handle scoring
*/
import java.util.ArrayList;

public abstract class Scorecard {
    HandOfDice hand = new HandOfDice();
    ArrayList<Integer> allDiceInHand = hand.getFullHand();

    /**
     * Finds the number of dice that match in a hand
     *
     * @param allDiceInHand dice values in a hand
     * @return number of matching dice
     */
    public int matching(ArrayList<Integer> allDiceInHand){
        int numMatchingDice = 0;
        int currentNumMatchingDice = 0;

        for (int i = 0; i < allDiceInHand.size(); i++){
            currentNumMatchingDice = 0;

            for (int j = 0; j < allDiceInHand.size(); j++){
                if (allDiceInHand.get(j) == i){
                    currentNumMatchingDice++;
                }
            }
            if (currentNumMatchingDice > numMatchingDice){
                numMatchingDice = currentNumMatchingDice;
            }
        }
        return numMatchingDice;
    }

    /**
     * Finds how many sequential dice there are in a hand (length of straight)
     *
     * @param allDiceInHand dice values in a hand
     * @return length of the sequence (straight)
     */
    private int sequentialDice(ArrayList<Integer> allDiceInHand){
        int lengthOfSequence = 1;

        for (int i = 0; i < allDiceInHand.size(); i++){
            if (i == 0){
                lengthOfSequence = 1;
            }
            else if (allDiceInHand.get(i) == allDiceInHand.get(i - 1) + 1){
                lengthOfSequence++;
            }
        }
        return lengthOfSequence;
    }

    /**
     * Checks if the hand of dice contains a Full House
     *
     * @param allDiceInHand dice values in a hand
     * @return truth value for if there is a Full House
     */
    private Boolean fullHouseCheck(ArrayList<Integer> allDiceInHand){

        if ((allDiceInHand.get(0) == allDiceInHand.get(1)) && (allDiceInHand.get(0) ==
                allDiceInHand.get(2))){
            if (allDiceInHand.get(3) == allDiceInHand.get(4)){
                return true;
            }
            else{
                return false;
            }
        }
        else if (allDiceInHand.get(0) == allDiceInHand.get(1)){
            if ((allDiceInHand.get(2) == allDiceInHand.get(3)) && allDiceInHand.get(2) ==
                    allDiceInHand.get(4)){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }
    }

    /**
     * Outputs the calculated scores to the console
     */
    public abstract void outputScore();
}