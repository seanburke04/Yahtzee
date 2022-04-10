package edu.gonzaga;

import javax.swing.*;
import java.util.ArrayList;

public class ScorecardView {
    JTextField scorecardTitle = new JTextField("Scorecard:");
    JPanel scorecardPanel = new JPanel();

    /*
    Also maybe to the same thing for the possible scores
     */

    /**
     * Default constructor, initializes scorecard basics
     */
    public ScorecardView(){
        scorecardPanel.setLayout(new BoxLayout(scorecardPanel, BoxLayout.Y_AXIS));
        scorecardTitle.setEditable(false);
        scorecardPanel.add(scorecardTitle);
    }

    /**
     * Adds the upper scorecard JTextFields to the scorecard panel
     * @param scoreUpperLines
     */
    public void addScoreUpper(ArrayList<JTextField> scoreUpperLines){
        for(int i = 0; i < scoreUpperLines.size(); i++){
            scorecardPanel.add(scoreUpperLines.get(i));
        }
    }

    /**
     * Adds the three of a kind score line JTextField to the scorecard panel
     * @param TOKScore
     */
    public void addThreeOfAKindScore(JTextField TOKScore){scorecardPanel.add(TOKScore);}

    /**
     * Adds the four of a kind score line JTextField to the scorecard panel
     * @param FOKScore
     */
    public void addFourOfAKindScore(JTextField FOKScore){scorecardPanel.add(FOKScore);}

    /**
     * Adds the full house score line JTextField to the scorecard panel
     * @param FHScore
     */
    public void addFullHouseScore(JTextField FHScore){scorecardPanel.add(FHScore);}

    /**
     * Adds the small straight score line JTextField to the scorecard panel
     * @param SSScore
     */
    public void addSmallStraightScore(JTextField SSScore){scorecardPanel.add(SSScore);}

    /**
     * Adds the large straight score line JTextField to the scorecard panel
     * @param LSScore
     */
    public void addLargeStraightScore(JTextField LSScore){scorecardPanel.add(LSScore);}

    /**
     * Adds the yahtzee score line JTextField to the scorecard panel
     * @param YScore
     */
    public void addYahtzeeScore(JTextField YScore){scorecardPanel.add(YScore);}

    /**
     * Adds the chance score line JTextField to the scorecard panel
     * @param CScore
     */
    public void addChanceScore(JTextField CScore){scorecardPanel.add(CScore);}

    /**
     * Getter for the scorecard panel
     * @return scorecardPanel
     */
    public JPanel getScorecardPanel(){return scorecardPanel;}
}
