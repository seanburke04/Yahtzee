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

public class Chance extends Scorecard{
    JTextField scoreLine = new JTextField();
    /**
     * Default constructor
     */
    public Chance() {
        this.name = "Chance";
        this.possibleScore = 0;
        this.actualScore = 0;
        this.isUsed = false;
        scoreLine.setText("Score 0 on the Chance line\n");
        scoreLine.setEditable(false);
    }

    /**
     * Overridden function that calculates the score for the hand of dice
     * @param allDiceInHand hand of dice
     */
    @Override
    public void calcScore(ArrayList<Integer> allDiceInHand){
        this.possibleScore = 0;
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
     * Changes the possible score text for output to the GUI
     * @return scoreLine
     */
    @Override
    public JTextField makePossibleScoreView() {
        scoreLine.setText("Possible score " + this. possibleScore + " on the Chance line\n");
        return scoreLine;
    }

    /**
     * Changes the text for this scoreLine
     * @return scoreLine
     */
    @Override
    public JTextField makeScoreView() {
        scoreLine.setText("Score " + this.actualScore + " on the Chance line\n");
        return scoreLine;
    }

    /**
     * Outputs the calculated possible score
     */
    @Override
    public void outputPossibleScore(){
        System.out.println("Score " + this.possibleScore + " on the Chance line");
    }

    /**
     * Outputs the calculated actual score
     */
    @Override
    public void outputActualScore(){
        System.out.println("Score " + this.actualScore + " on the Chance line");
    }
}