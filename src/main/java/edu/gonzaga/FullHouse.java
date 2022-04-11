/**
 * This program plays through a whole game of Yahtzee through a GUI
 * CPSC 224-02, Spring 2022
 * HW4 Yahtzee GUI
 * Source: Most of the Die.java, DiceImages.java, DieView.java, Hand.java, HandView.java, Window.java
 * files written by Dr. Crandall
 *
 * @author Sean Burke
 * @version v1.4 4/10/22
 */

package edu.gonzaga;

import javax.swing.*;
import java.util.ArrayList;

public class FullHouse extends Scorecard{
    JTextField scoreLine = new JTextField();
    /**
     * Default constructor
     */
    public FullHouse(){
        this.name = "Full House";
        this.possibleScore = 0;
        this.actualScore = 0;
        this.isUsed = false;
        scoreLine.setText("Score 0 on the Full House line\n");
        scoreLine.setEditable(false);
    }

    /**
     * Calculates the score for the hand of dice
     * @param allDiceInHand hand of dice
     */
    @Override
    public void calcScore(ArrayList<Integer> allDiceInHand){
        if (fullHouseCheck(allDiceInHand)){
            possibleScore = 25;
        }
        else{
            possibleScore = 0;
        }
    }

    /**
     * How to know if the user has already chosen this for a score value
     * @param used always be true as it is only called if it is true
     */
    public void setIsUsed(Boolean used){this.isUsed = used;}

    /**
     * Getter for isUsed
     * @return isUsed keeps the score from being used multiple times
     */
    public Boolean getIsUsed(){return this.isUsed;}

    /**
     * getter for possible score
     * @return possibleScore
     */
    public Integer getPossibleScore(){return this.possibleScore;}

    /**
     * getter for actual score
     * @return actualScore
     */
    public Integer getActualScore(){return this.actualScore;}

    /**
     * Changes the text to output the possible score to the GUI
     * @return scoreLine
     */
    @Override
    public JTextField makePossibleScoreView() {
        scoreLine.setText("Possible score " + this.possibleScore + " on the Full House line\n");
        return scoreLine;
    }

    /**
     * Changes the text for this scoreLine
     * @return scoreLine
     */
    @Override
    public JTextField makeScoreView() {
        scoreLine.setText("Score " + this.actualScore + " on the Full House line\n");
        return scoreLine;
    }

    /**
     * Outputs the calculated possible score
     */
    @Override
    public void outputPossibleScore(){
        System.out.println("Score " + this.possibleScore + " on the Full House line");
    }

    /**
     * Outputs the calculated actual score
     */
    @Override
    public void outputActualScore(){
        System.out.println("Score " + this.actualScore + " on the Full House line");
    }
}