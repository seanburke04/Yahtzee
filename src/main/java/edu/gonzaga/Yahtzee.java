/* (C)2021 */
package edu.gonzaga;

/*
*  This is the main class for the Yahtzee project.
*  It really should just instantiate another class and run
*   a method of that other class.
*/

/** Main program class for launching Yahtzee program. */
public class Yahtzee {
    public static void main(String[] args) {
        // FIX DIE.JAVA also make sure private and public is used properly
        // ADD CONSTRUCTORS IF NEEDED
        // FIX COMMENTS ABOVE EACH METHOD

        HandOfDice hand = new HandOfDice();
        Scorecard score = new Scorecard();

        // Initial roll
        hand.rollHand();
        hand.outputRoll();

        // re roll number 1
        hand.getWhichToReRoll();
        hand.reRollDice();
        hand.outputRoll();

        // re roll number 2
        // maybe add a way to check if they didn't re roll and not make theyn user do it again
        hand.getWhichToReRoll();
        hand.reRollDice();
        hand.outputRoll();

        //For testing purposes make sure to remove
        hand.fullHand[0] = 1;
        hand.fullHand[1] = 2;
        hand.fullHand[2] = 3;
        hand.fullHand[3] = 4;
        hand.fullHand[4] = 6;

        hand.sortDice();

        score.scoreUpper(hand);
        score.scoreLower(hand);
        score.outputScore();
    }
}
