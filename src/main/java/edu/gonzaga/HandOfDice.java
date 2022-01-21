package edu.gonzaga;

/*
* Class to handle each hand of dice
*/

import java.util.Scanner;

public class HandOfDice {

    Scanner getInput = new Scanner(System.in);

    Die die1 = new Die();
    Die die2 = new Die();
    Die die3 = new Die();
    Die die4 = new Die();
    Die die5 = new Die();
    String userSelectionReRoll;

    /** rolls each hand */
    public void rollHand(){
        die1.roll();
        die2.roll();
        die3.roll();
        die4.roll();
        die5.roll();
    }

    /** outputs roll */
    public void outputRoll(){
        System.out.print("Your roll was: " + die1 + " " + die2 + " " + die3);
        System.out.println(" " + die4 + " " + die5);
    }

    /** get user re roll this function also checks if the input is valid */
    public void getWhichToReRoll(){
        boolean isValid = false;

        System.out.println("Enter dice to keep (y or n) ");
        userSelectionReRoll = getInput.nextLine();

        while (!isValid){
            for (int i = 0; i < userSelectionReRoll.length(); i++){
                if (userSelectionReRoll.charAt(i) != 'y' && userSelectionReRoll.charAt(i) != 'n'){
                    System.out.println("Input invalid please try again");

                    System.out.println("Enter dice to keep (y or n) ");
                    userSelectionReRoll = getInput.nextLine();
                }
            }

            if (userSelectionReRoll.length() != 5){
                System.out.println("Input invalid please try again");

                System.out.println("Enter dice to keep (y or n) ");
                userSelectionReRoll = getInput.nextLine();
            }
            else{
                isValid = true;
            }
        }
    }

    /** Decides which dices need to be rolled and calls the roll function again */
    public void reRollDice(){
        for (int i = 0; i < userSelectionReRoll.length(); i++){
            if (userSelectionReRoll.charAt(i) == 'y'){
                switch (i){
                    case 1:
                        die1.roll();
                        break;
                    case 2:
                        die2.roll();
                        break;
                    case 3:
                        die3.roll();
                        break;
                    case 4:
                        die4.roll();
                        break;
                    case 5:
                        die5.roll();
                        break;
                }
            }
        }
    }
}
