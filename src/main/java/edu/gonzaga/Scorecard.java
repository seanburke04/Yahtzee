/**
 * This program plays through a whole game of Yahtzee through a GUI
 * CPSC 224-02, Spring 2022
 * HW4 Yahtzee GUI
 * Source: Most of the Die.java, DiceImages.java, DieView.java, Hand.java, HandView.java, Window.java
 * files written by Dr. Crandall
 *
 * @author Sean Burke
 * @version v1.4 4/10/22
 */

package edu.gonzaga;

/**
 * Class to handle scoring
 */
import javax.swing.*;
import java.util.ArrayList;

public abstract class Scorecard {
    String name;
    Integer possibleScore;
    Integer actualScore;
    Boolean isUsed;

    /**
     * Finds the number of dice that match in a hand
     *
     * @param allDiceInHand dice values in a hand
     * @return number of matching dice
     */
    public Integer matching(ArrayList<Integer> allDiceInHand){
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
    public Integer sequentialDice(ArrayList<Integer> allDiceInHand){
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
    public Boolean fullHouseCheck(ArrayList<Integer> allDiceInHand){

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
     * If the score is chosen set actual score
     */
    public void isChosen(){
        actualScore = possibleScore;
    }

    /**
     * Makes a text field of the potential score for output to the GUI
     * @return scoreLine
     */
    public abstract JTextField makePossibleScoreView();

    /**
     * Makes a text field to be handed to the scorecard view for output to the GUI
     * @return scoreLine
     */
    public abstract JTextField makeScoreView();

    /**
     * Abstract function to calculate scores
     * @param allDiceInHand hand of dice
     */
    public abstract void calcScore(ArrayList<Integer> allDiceInHand);

    /**
     * Outputs the calculated possible scores to the console
     */
    public abstract void outputPossibleScore();

    /**
     * Outputs the calculated actual scores to the console
     */
    public abstract void outputActualScore();
}
