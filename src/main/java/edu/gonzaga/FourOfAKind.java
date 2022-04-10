package edu.gonzaga;

import javax.swing.*;
import java.util.ArrayList;

public class FourOfAKind extends Scorecard {
    JTextField scoreLine = new JTextField();
    /**
     * Default constructor
     */
    public FourOfAKind(){
        this.name = "Four of a Kind";
        this.possibleScore = 0;
        this.actualScore = 0;
        this.isUsed = false;
        scoreLine.setText("Score 0 on the Four of a Kind Line");
        scoreLine.setEditable(false);
    }

    /**
     * Calculates the possible score for the hand of dice
     * @param allDiceInHand hand of dice
     */
    @Override
    public void calcScore(ArrayList<Integer> allDiceInHand){
        Integer numMatchingDice = matching(allDiceInHand);

        if (numMatchingDice >= 4){
            for (Integer i = 0; i < allDiceInHand.size(); i++){
                this.possibleScore += allDiceInHand.get(i);
            }
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
     * Getter for the actual score
     * @return actualScore
     */
    public Integer getActualScore(){return this.actualScore;}

    @Override
    public JTextField makeScoreView() {
        scoreLine.setText("Score " + this.actualScore + " on the Four of a Kind line\n");
        return scoreLine;
    }

    /**
     * Outputs the calculated possible score
     */
    @Override
    public void outputPossibleScore() {
        System.out.println("Score " + this.possibleScore + " on the Four of a Kind line");
    }

    /**
     * Outputs the calculated actual score
     */
    @Override
    public void outputActualScore(){
        System.out.println("Score " + this.actualScore + " on the Four of a Kind line");
    }
}