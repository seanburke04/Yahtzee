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