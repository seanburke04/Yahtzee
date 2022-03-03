package edu.gonzaga;

import java.util.ArrayList;

public class YahtzeeScore extends Scorecard{
    /**
     * Default constructor
     */
    public YahtzeeScore(){
        this.name = "Yahtzee";
        this.possibleScore = 0;
        this.actualScore = 0;
        this.isUsed = false;
        // this.menuOption =  WHAT SHOULD THIS BE?
        //ADD MENU OPTION CHECK?
    }

    @Override
    public void calcScore(ArrayList<Integer> allDiceInHand){
        Integer numMatchingDice = matching(allDiceInHand);

        if (numMatchingDice == allDiceInHand.size()){
            this.possibleScore = 50;
        }
    }

    /**
     * How to know if the user has already chosen this for a score value
     * @param used always be true as it is only called if it is true
     */
    public void setIsUsed(Boolean used){this.isUsed = used;}

    /**
     * Getter for isUsed
     * @return isUsed
     */
    public Boolean getIsUsed(){return this.isUsed;}

    public Integer getPossibleScore(){return this.possibleScore;}

    public Integer getActualScore(){return this.actualScore;}

    /**
     * Outputs the calculated score
     */
    @Override
    public void outputPossibleScore() {
        System.out.println("Possible score " + this.possibleScore + " on the Yahtzee line");
    }

    @Override
    public void outputActualScore(){
        System.out.println("Score " + this.actualScore + " on the Yahtzee line");
    }
}
