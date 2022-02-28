package edu.gonzaga;

import java.util.ArrayList;

public class ScoreUpper extends Scorecard{
    private ArrayList<Integer> scores = new ArrayList<>();
    private ArrayList<Boolean> isUsed = new ArrayList<>();
    private Integer DEFAULT_SCORE = 0;
    private Boolean DEFAULT_USE = false;

    /**
     * Default constructor
     */
    public ScoreUpper(){
        super();
        scores.add(DEFAULT_SCORE);
        isUsed.add(DEFAULT_USE);
    }

    /**
     * Constructor that calculates the score
     * @param allDiceInHand, userSettings dice values in a hand
     */
    public ScoreUpper(ArrayList<Integer> allDiceInHand, ArrayList<Integer> userSettings){
        super();
        Integer numSides = userSettings.get(0);
        Integer count = 0;

        //Initializes both array lists
        for (Integer i =0; i < numSides; i++){
            scores.add(DEFAULT_SCORE);
            isUsed.add(DEFAULT_USE);
        }

        for (Integer j = 0; j < allDiceInHand.size(); j++){
            for (Integer k = 0; k < allDiceInHand.size(); k++){
                if (allDiceInHand.get(j) == allDiceInHand.get(k)){
                    count++;
                }
            }
            scores.set(allDiceInHand.get(j) - 1, count * allDiceInHand.get(j));

            count = 0;
        }
    }

    /**
     * How to know if the user has already chosen this for a score value
     * @param whichIsUsed always be true as it is only called if it is true
     */
    public void setIsUsed(Integer whichIsUsed){isUsed.set(whichIsUsed, true);}

    /**
     * Getter for isUsed
     * @return isUsed
     */
    public ArrayList<Boolean> getIsUsed(){return isUsed;}

    /**
     * Getter for score
     * @return score
     */
    public ArrayList<Integer> getScore(){return scores;}

    @Override
    public void outputScore(){
        System.out.println("Score " + scores + " for the upper scorecard");
    }

    /**
     * Outputs the calculated score
     * @param whichToPrint
     */
    public void outputScore(Integer whichToPrint) {
        System.out.println("Score " + scores.get(whichToPrint) + " on the " + (whichToPrint + 1) + " line");
    }
}
