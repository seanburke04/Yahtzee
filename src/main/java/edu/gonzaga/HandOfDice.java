package edu.gonzaga;

/*
* Class to roll a hand of dice
*/

import java.util.Scanner;

public class HandOfDice {

    Scanner getInput = new Scanner(System.in);

    Die die1 = new Die();
    Die die2 = new Die();
    Die die3 = new Die();
    Die die4 = new Die();
    Die die5 = new Die();

    // Function to roll each hand
    public void rollHand(){
        die1.roll();
        die2.roll();
        die3.roll();
        die4.roll();
        die5.roll();
    }

    // Function to output roll
    public void outputRoll(){
        System.out.print("Your roll was: " + die1 + " " + die2 + " " + die3);
        System.out.println(" " + die4 + " " + die5);
    }

    // Function to get user re roll this function also checks if the input is valid
    public String whichToReRoll(){
        String userSelection;
        Boolean isValid = false;

        System.out.println("Enter dice to keep (y or n) ");
        userSelection = getInput.nextLine();

        while (!isValid){
            for (int i = 0; i < userSelection.length(); i++){
                if (userSelection.charAt(i) != 'y' && userSelection.charAt(i) != 'n'){
                    System.out.println("Input invalid please try again");

                    System.out.println("Enter dice to keep (y or n) ");
                    userSelection = getInput.nextLine();
                }
            }

            if (userSelection.length() != 5){
                System.out.println("Input invalid please try again");

                System.out.println("Enter dice to keep (y or n) ");
                userSelection = getInput.nextLine();
            }
            else{
                isValid = true;
            }
        }
        return userSelection;
    }
}
