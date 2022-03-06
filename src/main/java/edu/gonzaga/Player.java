package edu.gonzaga;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    Die oneDice = new Die();
    Scanner getInput = new Scanner(System.in);
    ArrayList<Integer> settings = new ArrayList<>();
    String playAgain = "y";

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

    public void playGame(){
        gameConfig();

        while (playAgain.equals("y")){


            // This needs to be fixed this only works for the ones being called, let user choose
            upperScorecard.setActualScores(0);
            upperScorecard.setActualScores(1);
            upperScorecard.setActualScores(2);
            upperScorecard.setActualScores(3);
            upperScorecard.setActualScores(4);
            upperScorecard.setActualScores(5);
            upperScorecard.outputAllActualScores();

            threeOfAKindScore.isChosen();
            threeOfAKindScore.outputActualScore();


            fourOfAKindScore.isChosen();
            fourOfAKindScore.outputActualScore();

            fullHouseScore.isChosen();
            fullHouseScore.outputActualScore();

            smallStraightScore.isChosen();
            smallStraightScore.outputActualScore();

            largeStraightScore.isChosen();
            largeStraightScore.outputActualScore();

            yahtzeeScorecard.isChosen();
            yahtzeeScorecard.outputActualScore();

            chanceScore.isChosen();
            chanceScore.outputActualScore();

            System.out.println("Enter 'y' to play again");
            playAgain = getInput.nextLine();
        }
    }

    private void singleTurn(){
        initialRoll();

        allReRolls();

        hand.sortDice();

        calculateScores();

        printPossibleScores();

        getWhichScoreToKeep();

    }

    private void gameConfig(){
        hand.readInConfig();
        hand.userSelectedSettings();
    }

    private void initialRoll(){
        hand.rollHand(oneDice);
        hand.outputRoll();
    }

    private void allReRolls(){
        settings = hand.getReadInFromFile();
        if (settings.get(2) > 1){
            for (Integer i = 1; i < settings.get(2); i++){
                hand.getWhichToReRoll();
                hand.reRollDice(oneDice);
                hand.outputRoll();
            }
        }
    }

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

    private void printPossibleScores(){
        System.out.println("Your possible scores are:");

        upperScorecard.outputAllPossibleScores();
        threeOfAKindScore.outputPossibleScore();
        fourOfAKindScore.outputPossibleScore();
        fullHouseScore.outputPossibleScore();
        smallStraightScore.outputPossibleScore();
        largeStraightScore.outputPossibleScore();
        yahtzeeScorecard.outputPossibleScore();
        chanceScore.outputPossibleScore();
    }

    private String getWhichScoreToKeep(){
        System.out.println("\nWhich score would you like to keep?");
        System.out.println("Enter the number for the upper scores or the first three letters for any value in the lower scorecard");
        return getInput.nextLine();
    }
}
