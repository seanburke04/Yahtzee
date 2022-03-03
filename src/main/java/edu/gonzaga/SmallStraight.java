package edu.gonzaga;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class SmallStraight extends Scorecard{
    /**
     * Default constructor
     */
    public SmallStraight(){
        this.name = "Small Straight";
        this.possibleScore = 0;
        this.actualScore = 0;
        this.isUsed = false;
        // this.menuOption =  WHAT SHOULD THIS BE?
        //ADD MENU OPTION CHECK?
    }

    @Override
    public void calcScore(ArrayList<Integer> allDiceInHand){
        Integer lengthOfStraight = sequentialDice(allDiceInHand);

        if (lengthOfStraight >= 4){
            this.possibleScore = 30;
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
        System.out.println("Possible score " + this.possibleScore + " on the Small Straight line");
    }

    @Override
    public void outputActualScore(){
        System.out.println("Score " + this.actualScore + " on the Small Straight line");
    }
}
