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
        // ADD CONSTRUCTORS IF NEEDED maybe have constructors call the functions?

        HandOfDice hand = new HandOfDice();
        Scorecard score = new Scorecard();

        hand.callDiceRollingMethods();

        score.scoreUpper(hand);
        score.scoreLower(hand);
        score.outputScore();
    }
}
