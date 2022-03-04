/**
 * This program rolls and scores the dice for a game of yahtzee
 * CPSC 224-02, Spring 2022
 * HW1 Yahtzee Rolling and Scoring
 * Source: Most of the Die.java file written by Dr. Crandall
 *
 * @author Sean Burke
 * @version v1.1 3/3/22
 */
package edu.gonzaga;

import java.util.ArrayList;

public class Chance extends Scorecard{
    /**
     * Default constructor
     */
    public Chance() {
        this.name = "Chance";
        this.possibleScore = 0;
        this.actualScore = 0;
        this.isUsed = false;
        // this.menuOption =  WHAT SHOULD THIS BE?
        //ADD MENU OPTION CHECK?
    }

    /**
     * Overridden function that calculates the score for the hand of dice
     * @param allDiceInHand hand of dice
     */
    @Override
    public void calcScore(ArrayList<Integer> allDiceInHand){
        for (Integer i = 0; i < allDiceInHand.size(); i++){
            this.possibleScore += allDiceInHand.get(i);
        }
    }

    /**
     * How to know if the user has already chosen this for a score value
     * @param used always be true as it is only called if it is true
     */
    public void setIsUsed(Boolean used){this.isUsed = used;}

    /**
     * Getter for isUsed
     * @return isUsed keeps from using this score multiple times
     */
    public Boolean getIsUsed(){return this.isUsed;}

    /**
     * Getter for possible score
     * @return possibleScore
     */
    public Integer getPossibleScore(){return this.possibleScore;}

    /**
     * getter for actual score
     * @return actualScore
     */
    public Integer getActualScore(){return this.actualScore;}

    /**
     * Outputs the calculated possible score
     */
    @Override
    public void outputPossibleScore(){
        System.out.println("Possible score " + this.possibleScore + " on the Chance line");
    }

    /**
     * Outputs the calculated actual score
     */
    @Override
    public void outputActualScore(){
        System.out.println("Score " + this.actualScore + " on the Chance line");
    }
}
