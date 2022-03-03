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
    public void outputPossibleScore(){
        System.out.println("Possible score " + this.possibleScore + " on the Chance line");
    }

    @Override
    public void outputActualScore(){
        System.out.println("Score " + this.actualScore + " on the Chance line");
    }
}
