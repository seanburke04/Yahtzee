package edu.gonzaga;

import java.util.ArrayList;

public class FourOfAKind extends Scorecard {
    /**
     * Default constructor
     */
    public FourOfAKind(){
        this.name = "Four of a Kind";
        this.possibleScore = 0;
        this.actualScore = 0;
        this.isUsed = false;
        // this.menuOption =  WHAT SHOULD THIS BE?
        //ADD MENU OPTION CHECK?
    }

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
     * @return isUsed
     */
    public Boolean getIsUsed(){return this.isUsed;}

    /**
     * Getter for score
     * @return score
     */
    public Integer getPossibleScore(){return this.possibleScore;}

    public Integer getActualScore(){return this.actualScore;}

    /**
     * Outputs the calculated score
     */
    @Override
    public void outputPossibleScore() {
        System.out.println("Possible score " + this.possibleScore + " on the Four of a Kind line");
    }

    @Override
    public void outputActualScore(){
        System.out.println("Score " + this.actualScore + " on the Four of a Kind line");
    }
}
