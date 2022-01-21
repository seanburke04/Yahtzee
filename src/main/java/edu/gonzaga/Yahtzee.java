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
        // Probably don't need this (maybe delete or change?)
        System.out.println("Hello Yahtzee");

        // Initial roll
        HandOfDice hand = new HandOfDice();
        hand.rollHand();
        hand.outputRoll();

        // re roll number 1
        hand.getWhichToReRoll();
        hand.reRollDice();
        hand.outputRoll();

        // re roll number 2
        // maybe add a way to check if they didn't re roll and not make the user do it again
        hand.getWhichToReRoll();
        hand.reRollDice();
        hand.outputRoll();

        //put the hand into and array you can do this in the roll method and update during the re roll

        /*
        Die die1 = new Die(6);
        System.out.println(die1);
        System.out.println("Now rolling our die!");
        die1.roll();
        System.out.println(die1);
        System.out.println("Cool, huh?");
        */


        // misspelled this wrod
    }
}
