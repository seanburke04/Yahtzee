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
            settings = hand.getUserSettings();
            if (settings.get(2) > 1){
                for (Integer i = 1; i < settings.get(2); i++){
                    hand.getWhichToReRoll();
                    hand.reRollDice(oneDice);
                    hand.outputRoll();
                }
            }
            hand.sortDice();

            //Score methods go here
            upperScorecard.calcScore(hand.getFullHand());
            upperScorecard.outputActualScore();

            threeOfAKindScore.calcScore(hand.getFullHand());
            threeOfAKindScore.outputActualScore();

            fourOfAKindScore.calcScore((hand.getFullHand()));
            fourOfAKindScore.outputActualScore();

            fullHouseScore.calcScore(hand.getFullHand());
            fullHouseScore.outputActualScore();

            smallStraightScore.calcScore(hand.getFullHand());
            smallStraightScore.outputActualScore();

            largeStraightScore.calcScore(hand.getFullHand());
            largeStraightScore.outputActualScore();

            yahtzeeScorecard.calcScore(hand.getFullHand());
            yahtzeeScorecard.outputActualScore();

            chanceScore.calcScore(hand.getFullHand());
            chanceScore.outputActualScore();

            System.out.println("Enter 'y' to play again");
            playAgain = getInput.nextLine();
        }
    }
}
