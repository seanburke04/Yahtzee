package edu.gonzaga;

import javax.swing.*;
import java.util.ArrayList;

/** Class to score ThreeOfAKind. */
public class ThreeOfAKind extends Scorecard{
    JTextField scoreLine = new JTextField();
    /**
     * Default constructor
     */
    public ThreeOfAKind(){
        this.name = "Three of a Kind";
        this.possibleScore = 0;
        this.actualScore = 0;
        this.isUsed = false;

        scoreLine.setText("Score 0 on the Three of a Kind line\n");
        scoreLine.setEditable(false);
    }

    /**
     * Calculates the score for the hand of dice
     * @param allDiceInHand hand of dice
     */
    @Override
    public void calcScore(ArrayList<Integer> allDiceInHand){
        Integer numMatchingDice = matching(allDiceInHand);

        if (numMatchingDice >= 3){
            for (Integer i = 0; i < allDiceInHand.size(); i++){
                this.possibleScore += allDiceInHand.get(i);
            }
        }
        else{
            this.possibleScore = 0;
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
     * Getter for possible score
     * @return possibleScore
     */
    public Integer getPossibleScore(){return this.possibleScore;}

    /**
     * Getter for actual score
     * @return actualScore
     */
    public Integer getActualScore(){return this.actualScore;}

    /**
     * Changes the text for this scoreLine
     * @return scoreLine
     */
    @Override
    public JTextField makeScoreView() {
        scoreLine.setText("Score " + this.actualScore + " on the Three of a Kind line\n");
        return scoreLine;
    }

    /**
     * Outputs the calculated possible score
     */
    @Override
    public void outputPossibleScore(){
        System.out.println("Score " + this.possibleScore + " on the Three of a Kind line");
    }

    /**
     * Outputs the calculated actual score
     */
    @Override
    public void outputActualScore(){
        System.out.println("Score " + this.actualScore + " on the Three of a Kind line");
    }
}