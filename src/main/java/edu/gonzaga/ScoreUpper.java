/**
 * This program rolls and scores the dice for a game of yahtzee
 * CPSC 224-02, Spring 2022
 * HW1 Yahtzee Rolling and Scoring
 * Source: Most of the Die.java file written by Dr. Crandall
 *
 * @author Sean Burke
 * @version v1.1 3/3/22
 */
package edu.gonzaga;

import java.util.ArrayList;

public class ScoreUpper extends Scorecard {
    private ArrayList<Integer> actualScores = new ArrayList<>();
    private ArrayList<Boolean> locked = new ArrayList<>();
    private ArrayList<Integer> possibleScores = new ArrayList<>();
    private ArrayList<Integer> userSettings = new ArrayList<>();
    private Integer numSides;
    private Integer DEFAULT_SCORE = 0;
    private Boolean DEFAULT_USE = false;

    /**
     * Default constructor
     */
    public ScoreUpper() {
        actualScores.add(DEFAULT_SCORE);
        possibleScores.add(DEFAULT_SCORE);
        locked.add(DEFAULT_USE);
    }

    /**
     * Constructor that initializes the size of the Array Lists
     *
     * @param userSettingsPassedIn number of dice and how many sides each dice has
     */
    public ScoreUpper(ArrayList<Integer> userSettingsPassedIn) {
        numSides = userSettingsPassedIn.get(0);

        //Initializes both array lists
        for (Integer i = 0; i < numSides; i++) {
            actualScores.add(DEFAULT_SCORE);
            possibleScores.add(DEFAULT_SCORE);
            locked.add(DEFAULT_USE);
        }
    }

    /**
     * Calculates the scores for the upper scorecard
     *
     * @param allDiceInHand hand of dice
     */
    @Override
    public void calcScore(ArrayList<Integer> allDiceInHand) {
        Integer count = 0;

        for (Integer j = 0; j < allDiceInHand.size(); j++) {
            for (Integer k = 0; k < allDiceInHand.size(); k++) {
                if (allDiceInHand.get(j) == allDiceInHand.get(k)) {
                    count++;
                }
            }
            possibleScores.set(allDiceInHand.get(j) - 1, count * allDiceInHand.get(j));

            count = 0;
        }
    }

    /**
     * How to know if the user has already chosen this for a score value
     *
     * @param whichIsUsed always be true as it is only called if it is true
     */
    public void setIsUsed(Integer whichIsUsed) {
        locked.set(whichIsUsed, true);
    }

    /**
     * Getter for isUsed
     *
     * @return isUsed keeps the scores from being used multiple times
     */
    public ArrayList<Boolean> getIsUsed() {
        return locked;
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

    /**
     * Outputs the possible scores
     */
    @Override
    public void outputPossibleScore() {
        System.out.println("Possible score" + possibleScores);
    }

    /**
     * Outputs the actual scores
     */
    @Override
    public void outputActualScore() {
        System.out.println("Score " + actualScores);
    }

    /**
     * Outputs a particular possible score
     *
     * @param whichToPrint selection for which score to output
     */
    public void outputPossibleScore(Integer whichToPrint) {
        System.out.println("Possible score " + possibleScores.get(whichToPrint) + " on the " + (whichToPrint + 1) + " line");
    }

    /**
     * Outputs a particular actual score
     *
     * @param whichToPrint selection for which score to output
     */
    public void outputActualScore(Integer whichToPrint) {
        System.out.println("Score " + actualScores.get(whichToPrint) + " on the " + (whichToPrint + 1) + " line");
    }
}
