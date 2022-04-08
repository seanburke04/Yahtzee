/**
 * This program rolls and scores the dice for a game of yahtzee
 * CPSC 224-02, Spring 2022
 * HW1 Yahtzee Rolling and Scoring
 * Source: Most of the Die.java file written by Dr. Crandall
 *
 * @author Sean Burke
 * @version v1.1 3/7/22
 */
package edu.gonzaga;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    Die oneDice = new Die();
    Scanner getScoreSelection = new Scanner(System.in);
    Scanner seeScoreSelection = new Scanner(System.in);
    Scanner whichCardSelection = new Scanner(System.in);
    ArrayList<Integer> settings = new ArrayList<>();

    // Dice control class
    HandOfDice hand = new HandOfDice();
    // Score classes
    ScoreUpper upperScorecard = new ScoreUpper(settings);
    ThreeOfAKind threeOfAKindScore = new ThreeOfAKind();
    FourOfAKind fourOfAKindScore = new FourOfAKind();
    FullHouse fullHouseScore = new FullHouse();
    SmallStraight smallStraightScore = new SmallStraight();
    LargeStraight largeStraightScore = new LargeStraight();
    YahtzeeScore yahtzeeScorecard = new YahtzeeScore();
    Chance chanceScore = new Chance();


    public void playGame() throws Exception {
        for(Integer i = 0; i < (upperScorecard.getPossibleScores().size() + 7); i++){
            singleTurn();
        }
    }

    public void passUserSettings(ArrayList<Integer> userSettings){
        hand.setUserSettings(userSettings);
    }

    /**
     * Calls all methods required for a single turn in a yahtzee game
     * @throws Exception invalid input
     */
    public void singleTurn() throws Exception {
        String scoreToKeep;
        Boolean upperScorecard;

        outputEntireScorecard();

        initialRoll();

        allReRolls();

        hand.sortDice();

        calculateScores();

        printPossibleScores();

        upperScorecard = whichCard();

        scoreToKeep = getWhichScoreToKeep();

        verifyUpperScorecard(scoreToKeep);
        verifyLowerScorecard(scoreToKeep);
    }

    /**
     * Controls the initial roll
     */
    private void initialRoll(){
        hand.rollHand(oneDice);
        hand.outputRoll();
    }

    /**
     * controls all re rolls for the hand
     */
    private void allReRolls(){
        settings = hand.getUserSettings();
        if (settings.get(2) > 1){
            for (Integer i = 1; i < settings.get(2); i++){
                hand.getWhichToReRoll();
                hand.reRollDice(oneDice);
                hand.outputRoll();
            }
        }
    }

    /**
     * calculates scores for all score lines
     */
    private void calculateScores(){
        upperScorecard.calcScore(hand.getFullHand());
        threeOfAKindScore.calcScore(hand.getFullHand());
        fourOfAKindScore.calcScore((hand.getFullHand()));
        fullHouseScore.calcScore(hand.getFullHand());
        smallStraightScore.calcScore(hand.getFullHand());
        largeStraightScore.calcScore(hand.getFullHand());
        yahtzeeScorecard.calcScore(hand.getFullHand());
        chanceScore.calcScore(hand.getFullHand());
    }

    /**
     * prints all possible scores to the console
     */
    private void printPossibleScores(){
        ArrayList<Boolean> used = new ArrayList<>();

        used = upperScorecard.getIsUsed();

        System.out.println("Your possible scores are:");

        // Outputs all available possible scores in the upper scorecard
        for(Integer i = 0; i < used.size(); i++){
            if(!used.get(i)){
                upperScorecard.outputPossibleScoreParticular(i);
            }
        }

        // Outputs all available possible scores in the lower scorecard
        if(!threeOfAKindScore.getIsUsed()){
            threeOfAKindScore.outputPossibleScore();
        }
        if(!fourOfAKindScore.getIsUsed()){
            fourOfAKindScore.outputPossibleScore();
        }
        if(!fullHouseScore.getIsUsed()){
            fullHouseScore.outputPossibleScore();
        }
        if(!smallStraightScore.getIsUsed()){
            smallStraightScore.outputPossibleScore();
        }
        if(!largeStraightScore.getIsUsed()){
            largeStraightScore.outputPossibleScore();
        }
        if(!yahtzeeScorecard.getIsUsed()){
            yahtzeeScorecard.outputPossibleScore();
        }
        if(!chanceScore.getIsUsed()){
            chanceScore.outputPossibleScore();
        }
    }

    /**
     * Get which score the user wants to keep
     * @return whichScoreToKeep
     */
    private String getWhichScoreToKeep(){
        System.out.println("\nWhich score would you like to keep?");
        System.out.println("Enter the number for the upper scores or one of the following codes");
        System.out.println("Three of a kind = TOK\nFour of a kind = FOK\nFull House = FH\nSmall Straight = SS");
        System.out.println("Large Straight = LS\nYahtzee = YTZ\nChance = CH");
        return getScoreSelection.nextLine();
    }

    /**
     * Allows the user to see the whole scorecard
     * @return bool that returns whether or not the user wants to see the scorecard
     */
    private Boolean seeScorecard(){
        String seeScore;
        System.out.println("Enter \"S\" to see Scorecard or press any button to continue");
        seeScore = seeScoreSelection.nextLine();

        if(seeScore == "S"){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Outputs the entire scorecard
     */
    public void outputEntireScorecard(){
        upperScorecard.outputAllActualScores();
        threeOfAKindScore.outputActualScore();
        fourOfAKindScore.outputActualScore();
        fullHouseScore.outputActualScore();
        smallStraightScore.outputActualScore();
        largeStraightScore.outputActualScore();
        yahtzeeScorecard.outputActualScore();
        chanceScore.outputActualScore();

        if(upperScorecard.getBonus()){
            System.out.println("Score: 35 on the bonus line");
        }
    }

    /**
     * Gets whether the user wants to select a score from the upper or lower scorecard
     * @return true for upper, false for lower
     */
    private Boolean whichCard() {
        String choice;

        System.out.println("Enter \"U\" to choose an upper score or \"L\" for a lower score");
        choice = whichCardSelection.nextLine();


        // Returns true if the user wants to use the upper scorecard
        if(choice == "U"){
            return true;
        }
        // Returns false if the user wants to use the lower scorecard
        else {
            return false;
        }
    }

    /**
     * Verifies that the selected score can be used
     * @param chosenUpperScore which score line has been chosen
     */
    private void verifyUpperScorecard(String chosenUpperScore){
        ArrayList<Boolean> used = new ArrayList<>();
        Integer whichScore;
        used = upperScorecard.getIsUsed();

        try{
            whichScore = Integer.parseInt(chosenUpperScore);
        } catch (NumberFormatException e){
            whichScore = -1;
        }


        if(whichScore != -1){
            upperScorecard.setIsUsed(whichScore - 1);
            upperScorecard.isChosen(whichScore - 1);
        }
    }

    /**
     * Verifies that the selected score can be used
     * @param chosenLowerScore which score line has been chosen
     */
    public void verifyLowerScorecard(String chosenLowerScore){
        switch(chosenLowerScore){
            case "TOK":
                if (!threeOfAKindScore.getIsUsed()){
                    threeOfAKindScore.setIsUsed(true);
                    threeOfAKindScore.isChosen();
                }
                break;
            case "FOK":
                if (!fourOfAKindScore.getIsUsed()){
                    fourOfAKindScore.setIsUsed(true);
                    threeOfAKindScore.isChosen();
                }
                break;
            case "FH":
                if (!fullHouseScore.getIsUsed()){
                    fullHouseScore.setIsUsed(true);
                    fullHouseScore.isChosen();
                }
                break;
            case "SS":
                if (!smallStraightScore.getIsUsed()){
                    smallStraightScore.setIsUsed(true);
                    smallStraightScore.isChosen();
                }
                break;
            case "LS":
                if (!largeStraightScore.getIsUsed()){
                    largeStraightScore.setIsUsed(true);
                    largeStraightScore.isChosen();
                }
                break;
            case "YTZ":
                if (!yahtzeeScorecard.getIsUsed()){
                    yahtzeeScorecard.setIsUsed(true);
                    yahtzeeScorecard.isChosen();
                }
                break;
            case "CH":
                if (!chanceScore.getIsUsed()){
                    chanceScore.setIsUsed(true);
                    chanceScore.isChosen();
                }
                break;
        }
    }
}
