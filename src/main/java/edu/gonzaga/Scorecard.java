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

public class Scorecard {

    private int aces = 0;
    private int twos = 0;
    private int threes = 0;
    private int fours = 0;
    private int fives = 0;
    private int sixes = 0;
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
        // Score aces
        Integer[] allDiceInHand = hand.getFullHand();
        for (int i = 0; i < 5; i++){
            if (allDiceInHand[i] == 1){
                aces++;
            }
        }

        // Score twos
        for (int i = 0; i < 5; i++){
            if (allDiceInHand[i] == 2){
                twos++;
            }
        }
        twos = twos * 2;

        // Score threes
        for (int i = 0; i < 5; i++){
            if (allDiceInHand[i] == 3){
                threes++;
            }
        }
        threes = threes * 3;

        // Score fours
        for (int i = 0; i < 5; i++){
            if (allDiceInHand[i] == 4){
                fours++;
            }
        }
        fours = fours * 4;

        // Score fives
        for (int i = 0; i < 5; i++){
            if (allDiceInHand[i] == 5){
                fives++;
            }
        }
        fives = fives * 5;

        // Score sixes
        for (int i = 0; i < 5; i++){
            if (allDiceInHand[i] == 6){
                sixes++;
            }
        }
        sixes = sixes * 6;
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
        Integer[] allDiceInHand = hand.getFullHand();

        // Scores three of a kind
        if (numMatchingDice == 3 || numMatchingDice == 4){
            for (int i = 0; i < 5; i++){
                tempScore += allDiceInHand[i];
            }
            threeOfAKind = tempScore;
            tempScore = 0;
        }
        else{
            threeOfAKind = 0;
        }

        // Scores 4 of a kind
        if (numMatchingDice == 4){
            for (int i = 0; i < 5; i++){
                tempScore += allDiceInHand[i];
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
            chance += allDiceInHand[i];
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
        Integer[] allDiceInHand = hand.getFullHand();

        for (int i = 0; i < 7; i++){
            currentNumMatchingDice = 0;

            for (int j = 0; j < 5; j++){
                if (allDiceInHand[j] == i){
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
        Integer[] allDiceInHand = hand.getFullHand();

        for (int i = 0; i < 5; i++){
            if (i == 0){
                lengthOfSequence = 1;
            }
            else if (allDiceInHand[i] == allDiceInHand[i - 1] + 1){
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
        Integer[] allDiceInHand = hand.getFullHand();

        if ((allDiceInHand[0] == allDiceInHand[1]) && (allDiceInHand[0] ==
                allDiceInHand[2])){
            if (allDiceInHand[3] == allDiceInHand[4]){
                return true;
            }
            else{
                return false;
            }
        }
        else if (allDiceInHand[0] == allDiceInHand[1]){
            if ((allDiceInHand[2] == allDiceInHand[3]) && allDiceInHand[2] ==
                    allDiceInHand[4]){
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
        System.out.println("Score " + aces + " on the 1 line");
        System.out.println("Score " + twos + " on the 2 line");
        System.out.println("Score " + threes + " on the 3 line");
        System.out.println("Score " + fours + " on the 4 line");
        System.out.println("Score " + fives + " on the 5 line");
        System.out.println("Score " + sixes + " on the 6 line");

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