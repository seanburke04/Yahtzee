/* (C)2021 */
package edu.gonzaga;

/*
*  This is the main class for the Yahtzee project.
*  It really should just instantiate another class and run
*   a method of that other class.
*/

import java.util.Scanner;

/** Main program class for launching Yahtzee program. */
public class Yahtzee {
    public static void main(String[] args) {
        Scanner getInput = new Scanner(System.in);
        String playAgain = "y";

        while (playAgain.equals("y")){
            HandOfDice hand = new HandOfDice();
            Scorecard score = new Scorecard();

            hand.callDiceRollingMethods();

            score.scoreUpper(hand);
            score.scoreLower(hand);
            score.outputScore();

            System.out.println("Enter 'y' to play again");
            playAgain = getInput.nextLine();
        }
    }
}