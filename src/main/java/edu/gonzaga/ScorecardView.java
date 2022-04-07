package edu.gonzaga;

import javax.swing.*;

public class ScorecardView {
    JPanel buttonPanel = new JPanel();
    JButton showScore = new JButton("Show Scores");
    JTextArea scorecardText = new JTextArea();
    JTextArea possibleScoresText = new JTextArea();

    //public void getScores()

    private void addButtonToPanel(){
        buttonPanel.add(showScore);
    }

    //update possible scores after each roll (except maybe last)?
    //Check prof code there may be something about handling locked states

    //use public change support
    //public void updateScorecardText()

    //private void buttonFunctionality()

    // NEED A WAY TO START GAME AFTER SETTINGS WINDOW

    // Need to print possible scores as well

    // Fix existing code, still printing to console

    //what else?
}
