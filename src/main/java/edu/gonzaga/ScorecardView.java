package edu.gonzaga;

import javax.swing.*;

public class ScorecardView {
    JPanel buttonPanel = new JPanel();
    JButton showScore = new JButton("Show Scores");
    //Use JRadioButton instead to select for possible scores?
    //Maybe possible scores should be a different class?
    JTextArea scorecardText = new JTextArea();
    JTextArea possibleScoresText = new JTextArea();

    //public void getScores()

    private void addButtonToPanel(){
        buttonPanel.add(showScore);
    }

    private void setScorecardText(String scores){scorecardText.setText(scores);}

    //update possible scores after each roll (except maybe last)?
    //Check prof code there may be something about handling locked states

    //use public change support
    //public void updateScorecardText()

    //private void buttonFunctionality()

    // NEED A WAY TO START GAME AFTER SETTINGS WINDOW

    // Need to print possible scores as well

    // Fix existing code, still printing to console

    //Don't need observer if you have update scorecard button, maybe use roll button to update scorecard?

    // Make the window class drive everything, put SettingsWindow in Window, so it can manipulate buttons

    //what else?
}
