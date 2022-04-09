package edu.gonzaga;

import javax.swing.*;
import java.util.ArrayList;

public class ScorecardView {
    JTextArea displayScorecard = new JTextArea();
    JPanel scorecardPanel = new JPanel();
    ArrayList<Integer> scores = new ArrayList<>();

    ScorecardView(){initializeText();}

    ScorecardView(Integer numDice){
        for(int i = 0; i <= numDice; i++){
            scores.add(0);
        }
        initializeText();
    }

    void initializeText(){
        displayScorecard.setText("Scorecard:\n");
        for(int i = 0; i < (scores.size() - 7); i++){
            displayScorecard.append("Score 0 on the " + (i + 1) + " line\n");
        }
        displayScorecard.append("Score 0 on the Three of a Kind Line\n");
        displayScorecard.append("Score 0 on the Four of a Kind line\n");
        displayScorecard.append("Score 0 on the Full House line\n");
        displayScorecard.append("Score 0 on the Small Straight line\n");
        displayScorecard.append("Score 0 on the Large Straight line\n");
        displayScorecard.append("Score 0 on the Yahtzee line\n");
        displayScorecard.append("Score 0 on the Chance line \n");
    }
}
