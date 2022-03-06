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
        String scoreToKeep;

        initialRoll();

        allReRolls();

        hand.sortDice();

        calculateScores();

        printPossibleScores();

        scoreToKeep = getWhichScoreToKeep();

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
        ArrayList<Boolean> used = new ArrayList<>();

        used = upperScorecard.getIsUsed();

        System.out.println("Your possible scores are:");

        // Outputs all available possible scores in the upper scorecard
        for(Integer i = 0; i < used.size(); i++){
            if(!used.get(i)){
                upperScorecard.outputPossibleScoreParticular(i);
            }
        }

        // Outputs all available possible scores in the lower scorecard
        if(!threeOfAKindScore.getIsUsed()){
            threeOfAKindScore.outputPossibleScore();
        }
        if(!fourOfAKindScore.getIsUsed()){
            fourOfAKindScore.outputPossibleScore();
        }
        if(!fullHouseScore.getIsUsed()){
            fullHouseScore.outputPossibleScore();
        }
        if(!smallStraightScore.getIsUsed()){
            smallStraightScore.outputPossibleScore();
        }
        if(!largeStraightScore.getIsUsed()){
            largeStraightScore.outputPossibleScore();
        }
        if(!yahtzeeScorecard.getIsUsed()){
            yahtzeeScorecard.outputPossibleScore();
        }
        if(chanceScore.getIsUsed()){
            chanceScore.outputPossibleScore();
        }
    }

    private String getWhichScoreToKeep(){
        System.out.println("\nWhich score would you like to keep?");
        System.out.println("Enter the number for the upper scores or one of the following codes");
        System.out.println("Three of a kind = TOK\nFour of a kind = FOK\nFull House = FH\nSmall Straight = SS");
        System.out.println("Large Straight = LS\nYahtzee = YTZ\nChance = CH");
        return getInput.nextLine();
    }

    private Boolean seeScorecard(){
        String seeScore;
        System.out.println("Enter \"S\" to see Scorecard or press any button to continue");
        seeScore = getInput.nextLine();

        if(seeScore == "S"){
            return true;
        }
        else{
            return false;
        }
    }

    /*
    private void verifyInput(String chosenScoreToKeep) throws Exception {
        Integer convertedString; //this throws an exception when it is actually a string

        // Upper scorecard is a special case that needs to be handled in a particular way
        // Check to see is selection is isUsed else throw exception (in else case all inputs invalid)
        convertedString = Integer.valueOf(chosenScoreToKeep);

        if (convertedString > 0 && convertedString < upperScorecard.getPossibleScores().size()){
            // check if it isUsed
        }
        else if (isLowerSelection(chosenScoreToKeep)){
            //check if it isUsed
        }
        else{
            throw new Exception("Invalid input");
        }
        // call methods to assign actual score and mark isUsed as true
    }

     */

    //This is only for a string maybe ask if they are choosing from upper or lower scorecard?
    private Boolean isLowerSelection(String chosenLowerScore){
        Boolean selected = false;

        //NEED TO CHECK IF ISUSED  IS ALREADY SET
        switch(chosenLowerScore){
            case "TOK":
                if (!threeOfAKindScore.getIsUsed()){
                    selected = true;
                    threeOfAKindScore.setIsUsed(true);
                    threeOfAKindScore.isChosen();
                }
                else{
                    selected = false;
                }
                break;
            case "FOK":
                if (!fourOfAKindScore.getIsUsed()){
                    selected = true;
                    fourOfAKindScore.setIsUsed(true);
                    threeOfAKindScore.isChosen();
                }
                else{
                    selected = false;
                }
                break;
            case "FH":
                if (!fullHouseScore.getIsUsed()){
                    selected = true;
                    fullHouseScore.setIsUsed(true);
                    fullHouseScore.isChosen();
                }
                else{
                    selected = false;
                }
                break;
            case "SS":
                if (!smallStraightScore.getIsUsed()){
                    selected = true;
                    smallStraightScore.setIsUsed(true);
                    smallStraightScore.isChosen();
                }
                else{
                    selected = false;
                }
                break;
            case "LS":
                if (!largeStraightScore.getIsUsed()){
                    selected = true;
                    largeStraightScore.setIsUsed(true);
                    largeStraightScore.isChosen();
                }
                else{
                    selected = false;
                }
                break;
            case "YTZ":
                if (!yahtzeeScorecard.getIsUsed()){
                    selected = true;
                    yahtzeeScorecard.setIsUsed(true);
                    yahtzeeScorecard.isChosen();
                }
                else{
                    selected = false;
                }
                break;
            case "CH":
                if (!chanceScore.getIsUsed()){
                    selected = true;
                    chanceScore.setIsUsed(true);
                    chanceScore.isChosen();
                }
                else{
                    selected = false;
                }
                break;
            default:
                selected = false;
        }
        return selected;
    }
}
