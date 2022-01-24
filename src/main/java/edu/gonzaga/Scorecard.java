package edu.gonzaga;

/*
* Class to handle scoring
*/

public class Scorecard {

    private int aces = 0;
    private int twos = 0;
    private int threes = 0;
    private int fours = 0;
    private int fives = 0;
    private int sixes = 0;
    private int threeOfAKind;
    private int fourOfAKind;
    private int fullHouse;
    private int smallStraight;
    private int largeStraight;
    private int yahtzee;
    private int Chance;

    // Score upper part of the scorecard
    public void scoreUpper(HandOfDice hand){
        // Score aces
        for (int i = 0; i < 5; i++){
            if (hand.fullHand[i] == 1){
                aces++;
            }
        }

        // Score twos
        for (int i = 0; i < 5; i++){
            if (hand.fullHand[i] == 2){
                twos++;
            }
        }

        // Score threes
        for (int i = 0; i < 5; i++){
            if (hand.fullHand[i] == 3){
                threes++;
            }
        }

        // Score fours
        for (int i = 0; i < 5; i++){
            if (hand.fullHand[i] == 4){
                fours++;
            }
        }

        // Score fives
        for (int i = 0; i < 5; i++){
            if (hand.fullHand[i] == 5){
                fives++;
            }
        }

        // Score sixes
        for (int i = 0; i < 5; i++){
            if (hand.fullHand[i] == 6){
                sixes++;
            }
        }
    }

    // Score lower part of the scorecard
    public void scoreLower(HandOfDice hand){
        // Score three of a kind
        int numMatchingDice = matching(hand);
        int score = 0;

        if (numMatchingDice == 3){
            for (int i = 0; i < 5; i++){
                score += hand.fullHand[i];
            }
            threeOfAKind = score;
        }
        else{
            threeOfAKind = 0;
        }
    }

    // Finds how many dice match
    private int matching(HandOfDice hand){
        int numMatchingDice = 0;
        int currentNumMatchingDice = 0;

        for (int i = 0; i < 7; i++){
            currentNumMatchingDice = 0;

            for (int j = 0; j < 5; j++){
                if (hand.fullHand[j] == i){
                    currentNumMatchingDice++;
                }
            }
            if (currentNumMatchingDice > numMatchingDice){
                numMatchingDice = currentNumMatchingDice;
            }
        }
        return numMatchingDice;
    }

    public void outputScore(){
        // Outputs the score for the upper portion of the scorecard
        System.out.println("Score " + aces + " on the 1 line");
        System.out.println("Score " + twos + " on the 2 line");
        System.out.println("Score " + threes + " on the 3 line");
        System.out.println("Score " + fours + " on the 4 line");
        System.out.println("Score " + fives + " on the 5 line");
        System.out.println("Score " + sixes + " on the 6 line");

        // Outputs the score for the lower portion of the scorecard
        System.out.println("Score " + threeOfAKind + " on the 3 of a kind line");
    }
}
