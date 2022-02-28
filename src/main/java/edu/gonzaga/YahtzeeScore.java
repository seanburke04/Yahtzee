package edu.gonzaga;

import java.util.ArrayList;

public class YahtzeeScore extends Scorecard{
    private Integer score;
    private Boolean isUsed;
    private static final Integer DEFAULT_SCORE = 0;
    private static final Boolean DEFAULT_USE = false;

    /**
     * Default constructor
     */
    public void YahtzeeScore(){
        score = DEFAULT_SCORE;
        isUsed = DEFAULT_USE;
    }

    /**
     * Constructor that calculates the score
     * @param allDiceInHand dice values in a hand
     */
    public void YahtzeeScore(ArrayList<Integer> allDiceInHand){
        isUsed = DEFAULT_USE;

        Integer numMatchingDice = matching(allDiceInHand);

        if (numMatchingDice == allDiceInHand.size()){
            score = 50;
        }
        else{
            score = DEFAULT_SCORE;
        }
    }

    /**
     * How to know if the user has already chosen this for a score value
     * @param used always be true as it is only called if it is true
     */
    public void setIsUsed(Boolean used){isUsed = used;}

    /**
     * Getter for isUsed
     * @return isUsed
     */
    public Boolean getIsUsed(){return isUsed;}

    /**
     * Getter for score
     * @return score
     */
    public Integer getScore(){return score;}

    /**
     * Outputs the calculated score
     */
    @Override
    public void outputScore() {
        System.out.println("Score " + score + " on the Yahtzee line");
    }
}
