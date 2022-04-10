package edu.gonzaga;

import javax.swing.*;
import java.util.ArrayList;

public class ScorecardView {
    JTextField scorecardTitle = new JTextField("Scorecard:");
    JTextField possibleScorecardTitle = new JTextField("Possible scores:");
    JPanel scorecardPanel = new JPanel();
    JPanel possibleScorecardPanel = new JPanel();

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
        possibleScorecardPanel.setLayout(new BoxLayout(possibleScorecardPanel, BoxLayout.Y_AXIS));
        possibleScorecardTitle.setEditable(false);
        possibleScorecardPanel.add(possibleScorecardTitle);
    }

    void addPossibleScoreUpper(ArrayList<JTextField> possibleUpperLines){
        for(int i = 0; i < possibleUpperLines.size(); i++){
            possibleScorecardPanel.add(possibleUpperLines.get(i));
        }
    }

    void possibleThreeOfAKindScore(JTextField TOKPossible){
        possibleScorecardPanel.add(TOKPossible);
    }
    void possibleFourOfAKindScore(JTextField FOKPossible){
        possibleScorecardPanel.add(FOKPossible);
    }

    void possibleFullHouseScore(JTextField FHPossible){
        possibleScorecardPanel.add(FHPossible);
    }

    void possibleSmallStraightScore(JTextField SSPossible){
        possibleScorecardPanel.add(SSPossible);
    }

    void possibleLargeStraightScore(JTextField LSPossible){
        possibleScorecardPanel.add(LSPossible);
    }

    void possibleYahtzeeScore(JTextField YPossible){
        possibleScorecardPanel.add(YPossible);
    }

    void possibleChanceScore(JTextField CPossible){
        possibleScorecardPanel.add(CPossible);
    }

    JPanel getPossibleScorecardPanel(){return possibleScorecardPanel;}

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
