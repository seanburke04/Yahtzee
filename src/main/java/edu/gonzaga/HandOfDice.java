package edu.gonzaga;

/*
* Class to roll a hand of dice
 */

public class HandOfDice {
    Die die1 = new Die();
    Die die2 = new Die();
    Die die3 = new Die();
    Die die4 = new Die();
    Die die5 = new Die();

    // Function to roll each hand
    public void rollHand(){
        die1.roll();
        die2.roll();
        die3.roll();
        die4.roll();
        die5.roll();
    }

    // Function to output roll
    public void outputRoll(){
        System.out.print("Your roll was: " + die1 + " " + die2 + " " + die3);
        System.out.println(" " + die4 + " " + die5);
    }
}
