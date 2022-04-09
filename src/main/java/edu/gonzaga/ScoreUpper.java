package edu.gonzaga;

import javax.swing.*;
import java.util.ArrayList;

public class ScoreUpper {
    private ArrayList<Integer> actualScores = new ArrayList<>();
    private ArrayList<Boolean> isUsed = new ArrayList<>();
    private ArrayList<Integer> possibleScores = new ArrayList<>();
    private ArrayList<Integer> userSettings = new ArrayList<>();
    private Boolean bonus = false;
    private Integer numSides;
    private Integer DEFAULT_SCORE = 0;
    private Boolean DEFAULT_USE = false;
    private ArrayList<JTextField> scoreLines = new ArrayList<>();

    /**
     * Default constructor
     */
    public ScoreUpper() {
        actualScores.add(DEFAULT_SCORE);
        possibleScores.add(DEFAULT_SCORE);
        isUsed.add(DEFAULT_USE);
    }

    public ScoreUpper(Integer numSides){
        JTextField tempText = new JTextField();

        tempText.setEditable(false);
        actualScores.add(DEFAULT_SCORE);
        possibleScores.add(DEFAULT_SCORE);
        isUsed.add(DEFAULT_USE);

        for(int i = 0; i < numSides; i++){
            tempText.setText("Score 0 on the " + (i + 1) + " line\n");
            scoreLines.add(tempText);
        }
    }

    /**
     * Setter for actualScores
     * @param index
     */
    public void setActualScores(Integer index){
        actualScores.set(index, possibleScores.get(index));
    }

    /**
     * Constructor that initializes the size of the Array Lists
     *
     * @param userSettingsPassedIn number of dice and how many sides each dice has
     */
    public ScoreUpper(ArrayList<Integer> userSettingsPassedIn) {
        if (userSettingsPassedIn.size() > 1){
            numSides = userSettingsPassedIn.get(0);
        }
        else{
            numSides = 6;
        }

        //Initializes both array lists
        for (Integer i = 0; i < numSides; i++) {
            actualScores.add(DEFAULT_SCORE);
            possibleScores.add(DEFAULT_SCORE);
            isUsed.add(DEFAULT_USE);
        }
    }

    /**
     * resets the possible scores ArrayList, there were some issues with multiple turns stacking in the array
     */
    private void resetPossibleScores(){
        for(Integer i = 0; i < possibleScores.size(); i++){
            possibleScores.set(i, 0);
        }
    }

    /**
     * Getter for if bonus is true
     * @return bonus
     */
    public Boolean getBonus(){return bonus;}

    /**
     * Calculates the scores for the upper scorecard
     *
     * @param allDiceInHand hand of dice
     */
    public void calcScore(ArrayList<Integer> allDiceInHand) {
        Integer count = 0;
        Integer total = 0;

        resetPossibleScores();

        for (Integer j = 0; j < allDiceInHand.size(); j++) {
            for (Integer k = 0; k < allDiceInHand.size(); k++) {
                if (allDiceInHand.get(j) == allDiceInHand.get(k)) {
                    count++;
                }
            }
            possibleScores.set(allDiceInHand.get(j) - 1, count * allDiceInHand.get(j));

            count = 0;
        }
        for(Integer i = 0; i < actualScores.size(); i++){
            total += actualScores.get(i);
        }
        if(total >= 63){
            bonus = true;
        }
    }

    /**
     * How to know if the user has already chosen this for a score value
     *
     * @param whichIsUsed always be true as it is only called if it is true
     */
    public void setIsUsed(Integer whichIsUsed) {
        isUsed.set(whichIsUsed, true);
    }

    public void isChosen(Integer whichIsChosen){
        actualScores.set(whichIsChosen, possibleScores.get(whichIsChosen));
    }

    /**
     * Getter for isUsed
     *
     * @return isUsed keeps the scores from being used multiple times
     */
    public ArrayList<Boolean> getIsUsed() {
        return isUsed;
    }

    /**
     * Getter for possible scores
     *
     * @return possibleScores
     */
    public ArrayList<Integer> getPossibleScores() {
        return possibleScores;
    }

    /**
     * Getter for actual scores
     *
     * @return actualScores
     */
    public ArrayList<Integer> getActualScores() {
        return actualScores;
    }

    public ArrayList<JTextField> makeScoreView(){
        for(int i = 0; i < actualScores.size(); i++){
            scoreLines.get(i).setText("Score " + actualScores.get(i) + " on the " + (i + 1) + " line");
        }
        return scoreLines;
    }

    /**
     * Outputs a particular actual score
     *
     * @param whichToPrint selection for which score to output
     */
    public void outputActualScoreParticular(Integer whichToPrint) {
        System.out.println("Score " + actualScores.get(whichToPrint) + " on the " + (whichToPrint + 1) + " line");
    }

    /**
     * outputs all of the actual scores
     */
    public void outputAllActualScores(){
        for (Integer i = 0; i < actualScores.size(); i++){
            System.out.println("Score " + actualScores.get(i) + " on the " + (i + 1) + " line");
        }
    }

    /**
     * outputs a particular possible score
     * @param whichToPrint
     */
    public void outputPossibleScoreParticular(Integer whichToPrint) {
        System.out.println("Score " + possibleScores.get(whichToPrint) + " on the " + (whichToPrint + 1) + " line");
    }

    /**
     * outputs all possible scores
     */
    public void outputAllPossibleScores(){
        for (Integer i = 0; i < possibleScores.size(); i++){
            System.out.println("Score " + possibleScores.get(i) + " on the " + (i + 1) + " line");
        }
    }
}