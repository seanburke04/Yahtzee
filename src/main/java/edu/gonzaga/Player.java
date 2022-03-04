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

            System.out.println("Enter 'y' to play again");
            playAgain = getInput.nextLine();
        }
    }
}
