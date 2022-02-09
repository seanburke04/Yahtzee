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

/**
* Class to handle scoring
*/
import java.util.ArrayList;

public class Scorecard {

    private ArrayList<Integer> userSettings = new ArrayList<Integer>();
    private ArrayList<Integer> upperScores = new ArrayList<Integer>();

    private int threeOfAKind;
    private int fourOfAKind;
    private int fullHouse;
    private int smallStraight;
    private int largeStraight;
    private int yahtzee;
    private int chance = 0;

    /**
     * Computes the scores for the upper part of the scorecard
     *
     * @param hand dice values values in a hand
     */
    public void scoreUpper(HandOfDice hand){
        ArrayList<Integer> allDiceInHand = hand.getFullHand();
        userSettings = hand.getUserSettings();
        Integer numSides = userSettings.get(0);
        Integer count = 0;

        for (Integer i = 0; i < numSides; i++) {
            upperScores.add(0);
        }

       for (Integer j = 0; j < allDiceInHand.size(); j++){
           for (Integer k = 0; k < allDiceInHand.size(); k++){
               if (allDiceInHand.get(j) == allDiceInHand.get(k)){
                   count++;
               }
           }

           if (j == 0){
               upperScores.set(0, count * allDiceInHand.get(j));
           }
           else{
               upperScores.set(allDiceInHand.get(j) - 1, count * allDiceInHand.get(j));
           }
            count = 0;
       }
    }

    /**
     * Computes the scores for the lower part of the scorecard
     *
     * @param hand dice values values in a hand
     */
    public void scoreLower(HandOfDice hand){
        int numMatchingDice = matching(hand);
        int lengthOfStraight = sequentialDice(hand);
        int tempScore = 0;
        ArrayList<Integer> allDiceInHand = hand.getFullHand();

        // Scores three of a kind
        if (numMatchingDice == 3 || numMatchingDice == 4){
            for (int i = 0; i < allDiceInHand.size(); i++){
                tempScore += allDiceInHand.get(i);
            }
            threeOfAKind = tempScore;
            tempScore = 0;
        }
        else{
            threeOfAKind = 0;
        }

        // Scores 4 of a kind
        if (numMatchingDice == 4){
            for (int i = 0; i < allDiceInHand.size(); i++){
                tempScore += allDiceInHand.get(i);
            }
            fourOfAKind = tempScore;
            tempScore = 0;
        }
        else{
            fourOfAKind = 0;
        }

        // Scores Full House
        if (fullHouseCheck(hand)){
            fullHouse = 25;
        }
        else{
            fullHouse = 0;
        }

        // Scores Small Straight
        if (lengthOfStraight == 4){
            smallStraight = 30;
        }
        else{
            smallStraight = 0;
        }

        // Scores Large Straight
        if (lengthOfStraight == 5){
            largeStraight = 40;
        }
        else{
            largeStraight = 0;
        }

        // Scores Yahtzee
        if (numMatchingDice == 5){
            yahtzee = 50;
        }

        // Scores Chance
        for (int i = 0; i < 5; i++){
            chance += allDiceInHand.get(i);
        }
    }

    /**
     * Finds the number of dice that match in a hand
     *
     * @param hand dice values values in a hand
     * @return number of matching dice
     */
    private int matching(HandOfDice hand){
        int numMatchingDice = 0;
        int currentNumMatchingDice = 0;
        ArrayList<Integer> allDiceInHand = hand.getFullHand();

        for (int i = 0; i < 7; i++){
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
     * @param hand dice values values in a hand
     * @return length of the sequence (straight)
     */
    private int sequentialDice(HandOfDice hand){
        int lengthOfSequence = 1;
        ArrayList<Integer> allDiceInHand = hand.getFullHand();

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
     * @param hand dice values in a hand
     * @return truth value for if there is a Full House
     */
    private Boolean fullHouseCheck(HandOfDice hand){
        ArrayList<Integer> allDiceInHand = hand.getFullHand();

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
    public void outputScore(){
        // Outputs the score for the upper portion of the scorecard
        for (Integer i = 0; i < upperScores.size(); i++){
            System.out.println("Score " + upperScores.get(i) + " on the " + (i + 1) + " line");
        }

        // Outputs the score for the lower portion of the scorecard
        System.out.println("Score " + threeOfAKind + " on the 3 of a Kind " +
                "line");
        System.out.println("Score " + fourOfAKind + " on the 4 of a Kind " +
                "line");
        System.out.println("Score " + fullHouse + " on the Full House line");
        System.out.println("Score " + smallStraight + " on the Small " +
                "Straight line");
        System.out.println("Score " + largeStraight + " on the Large" +
                "Straight line");
        System.out.println("Score " + yahtzee + " on the Yahtzee line");
        System.out.println("Score " + chance + " on the Chance line");
    }
}