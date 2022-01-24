package edu.gonzaga;

/*
* Class to handle scoring
*/

public class Scorecard {

    HandOfDice handToScore = new HandOfDice();
    public Integer aces;
    public Integer twos;
    public Integer threes;
    public Integer fours;
    public Integer fives;
    public Integer sixes;

    public void scoreUpper(HandOfDice hand){
        // Score aces
        for (Integer i = 0; i < 5; i++){
            if (hand.fullHand[i] == 1){
                aces++;
            }
        }

        // Score twos
        for (Integer i = 0; i < 5; i++){
            if (hand.fullHand[i] == 2){
                twos++;
            }
        }

        // Score threes
        for (Integer i = 0; i < 5; i++){
            if (hand.fullHand[i] == 3){
                threes++;
            }
        }

        // Score fours
        for (Integer i = 0; i < 5; i++){
            if (hand.fullHand[i] == 4){
                fours++;
            }
        }

        // Score fives
        for (Integer i = 0; i < 5; i++){
            if (hand.fullHand[i] == 5){
                fives++;
            }
        }

        // Score sixes
        for (Integer i = 0; i < 5; i++){
            if (hand.fullHand[i] == 6){
                sixes++;
            }
        }
    }

    public void outputScore(){
        System.out.println("Score " + aces + " on the 1 line");
    }
}
