package edu.gonzaga;

/*
* Class to handle scoring
 */

public class Scorecard {

    HandOfDice handToScore = new HandOfDice();
    public int aces;
    public int twos;
    public int threes;
    public int fours;
    public int fives;
    public int sixes;

    public void countAces(HandOfDice hand){
        for (int i = 0; i < 5; i++){
            if (hand.fullHand[i] == 1){
                aces++;
            }
        }
    }

    public void outputScore(){
        System.out.println("Score " + aces + " on the 1 line");
    }
}
