package edu.gonzaga;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    Die oneDice = new Die();
    Scanner getInput = new Scanner(System.in);
    ArrayList<Integer> settings = new ArrayList<>();
    String playAgain = "y";

    public void playGame(){
        while (playAgain.equals("y")){
            HandOfDice hand = new HandOfDice();
            //add score classes
            ScoreUpper upperScorecard = new ScoreUpper(settings);
            ThreeOfAKind threeOfAKindScore = new ThreeOfAKind();
            FourOfAKind fourOfAKindScore = new FourOfAKind();
            FullHouse fullHouseScore = new FullHouse();
            SmallStraight smallStraightScore = new SmallStraight();
            LargeStraight largeStraightScore = new LargeStraight();
            YahtzeeScore yahtzeeScorecard = new YahtzeeScore();
            Chance chanceScore = new Chance();

            hand.readInConfig();
            hand.userSelectedSettings();
            // Initial roll
            hand.rollHand(oneDice);
            hand.outputRoll();

            //Handle all re rolls
            settings = hand.getReadInFromFile();
            if (settings.get(2) > 1){
                for (Integer i = 1; i < settings.get(2); i++){
                    hand.getWhichToReRoll();
                    hand.reRollDice(oneDice);
                    hand.outputRoll();
                }
            }
            hand.sortDice();

            upperScorecard.calcScore(hand.getFullHand());
            upperScorecard.setActualScores(0);
            upperScorecard.setActualScores(1);
            upperScorecard.setActualScores(2);
            upperScorecard.setActualScores(3);
            upperScorecard.setActualScores(4);
            upperScorecard.setActualScores(5);
            upperScorecard.outputAllActualScores();

            threeOfAKindScore.calcScore(hand.getFullHand());
            threeOfAKindScore.isChosen();
            threeOfAKindScore.outputActualScore();

            fourOfAKindScore.calcScore((hand.getFullHand()));
            fourOfAKindScore.isChosen();
            fourOfAKindScore.outputActualScore();

            fullHouseScore.calcScore(hand.getFullHand());
            fullHouseScore.isChosen();
            fullHouseScore.outputActualScore();

            smallStraightScore.calcScore(hand.getFullHand());
            smallStraightScore.isChosen();
            smallStraightScore.outputActualScore();

            largeStraightScore.calcScore(hand.getFullHand());
            largeStraightScore.isChosen();
            largeStraightScore.outputActualScore();

            yahtzeeScorecard.calcScore(hand.getFullHand());
            yahtzeeScorecard.isChosen();
            yahtzeeScorecard.outputActualScore();

            chanceScore.calcScore(hand.getFullHand());
            chanceScore.isChosen();
            chanceScore.outputActualScore();

            System.out.println("Enter 'y' to play again");
            playAgain = getInput.nextLine();
        }
    }
}
