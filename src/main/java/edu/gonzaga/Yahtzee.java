/**
 * This program rolls and scores the dice for a game of yahtzee
 * CPSC 224-02, Spring 2022
 * HW1 Yahtzee Rolling and Scoring
 * Source: Most of the Die.java file written by Dr. Crandall
 *
 * @author Sean Burke
 * @version v1.1 3/7/22
 */
package edu.gonzaga;

/*
*  This is the main class for the Yahtzee project.
*  It really should just instantiate another class and run
*   a method of that other class.
*/

/** Main program class for launching Yahtzee program. */
public class Yahtzee {
    public static void main(String[] args) throws Exception {
        Boolean seeScores;
        Player player1 = new Player();

        player1.gameConfig();
        player1.singleTurn();
        player1.singleTurn();
        //maybe just always output score

    }
}