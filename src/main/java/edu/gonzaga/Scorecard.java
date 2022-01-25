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
    private int chance = 0;

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
        twos = twos * 2;

        // Score threes
        for (int i = 0; i < 5; i++){
            if (hand.fullHand[i] == 3){
                threes++;
            }
        }
        threes = threes * 3;

        // Score fours
        for (int i = 0; i < 5; i++){
            if (hand.fullHand[i] == 4){
                fours++;
            }
        }
        fours = fours * 4;

        // Score fives
        for (int i = 0; i < 5; i++){
            if (hand.fullHand[i] == 5){
                fives++;
            }
        }
        fives = fives * 5;

        // Score sixes
        for (int i = 0; i < 5; i++){
            if (hand.fullHand[i] == 6){
                sixes++;
            }
        }
        sixes = sixes * 6;
    }

    // Score lower part of the scorecard
    public void scoreLower(HandOfDice hand){
        int numMatchingDice = matching(hand);
        int numMatchingDiceSet2 = matching(hand);
        int tempScore = 0;

        // Scores three of a kind
        if (numMatchingDice == 3){
            for (int i = 0; i < 5; i++){
                tempScore += hand.fullHand[i];
            }
            threeOfAKind = tempScore;
            tempScore = 0;
        }
        else{
            threeOfAKind = 0;
        }

        // Scores 4 of a kind
        if (numMatchingDice == 4){
            for (int i = 0; i < 5; i++){
                tempScore += hand.fullHand[i];
            }
            fourOfAKind = tempScore;
            tempScore = 0;
        }
        else{
            fourOfAKind = 0;
        }

        // Scores Full House

        // Scores Yahtzee
        if (numMatchingDice == 5){
            yahtzee = 50;
        }

        // Scores Chance
        for (int i = 0; i < 5; i++){
            chance += hand.fullHand[i];
        }
    }

    // Finds how many dice match
    // The second call doesn't work it would likely output the same value as the first call
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
        System.out.println("Score " + threeOfAKind + " on the 3 of a Kind " +
                "line");
        System.out.println("Score " + fourOfAKind + " on the 4 of a Kind " +
                "line");
        System.out.println("Score " + fullHouse + " on the Full House line");
        System.out.println("Score " + smallStraight + " on the Small " +
                "Straight line");
        System.out.println("Score " + largeStraight + " on the Large" +
                "Straight line");
        System.out.println("Score " + yahtzee + " on the Yahtzee line");
        System.out.println("Score " + chance + " on the Chance line");
    }
}
