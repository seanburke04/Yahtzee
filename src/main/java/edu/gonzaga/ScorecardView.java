package edu.gonzaga;

import javax.swing.*;
import java.util.ArrayList;

public class ScorecardView {
    JPanel buttonPanel = new JPanel();
    JButton showScore = new JButton("Show Scores");
    //Use JRadioButton instead to select for possible scores?
    //Maybe possible scores should be a different class?
    String scorecardText = new String();
    JTextArea possibleScoresText = new JTextArea();
    ArrayList<Integer> allPlayerScores = new ArrayList<>();

    //Need to change all instances of output scores for every class, can then put them all here
    //to change the scorecardText, maybe put this class instance in player class so
    //that Window can access it easier? make sure it's public
    //public void getScores()

    private void addButtonToPanel(){
        buttonPanel.add(showScore);
    }

    public void getScores(ArrayList<Integer> scores){allPlayerScores = scores;}

    private void setScorecardText(String scores){scorecardText = scores;}

    //update possible scores after each roll (except maybe last)?
    //Check prof code there may be something about handling locked states

    public String getScorecardText(){
        updateScorecardText();
        return scorecardText;
    }

    private void updateScorecardText(){
        Integer count = 0;
        scorecardText = "Player 1's Scorecard:\n";
        for(int i = 0; i < (allPlayerScores.size() - 7); i++){
            scorecardText = scorecardText + "Score " + allPlayerScores.get(i) + " on the " + (i + 1) + " line\n";
            count++;
        }
        /*
        scorecardText.append("Score " + allPlayerScores.get(count + 1) + " on the Three of a Kind line\n");
        scorecardText.append("Score " + allPlayerScores.get(count + 2) + " on the Four of a Kind line\n");
        scorecardText.append("Score " + allPlayerScores.get(count + 3) + " on the Full House line\n");
        scorecardText.append("Score " + allPlayerScores.get(count + 4) + " on the Small Straight line\n");
        scorecardText.append("Score " + allPlayerScores.get(count + 5) + " on the Large Straight line\n");
        scorecardText.append("Score " + allPlayerScores.get(count + 6) + " on the Yahtzee line\n");
        scorecardText.append("Score " + allPlayerScores.get(count + 7) + " on the Chance line");

         */
    }

    //private void buttonFunctionality()

    // NEED A WAY TO START GAME AFTER SETTINGS WINDOW

    // Need to print possible scores as well

    // Fix existing code, still printing to console

    //Don't need observer if you have update scorecard button, maybe use roll button to update scorecard?

    //what else?
}
