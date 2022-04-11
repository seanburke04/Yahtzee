/**
 * This program plays through a whole game of Yahtzee through a GUI
 * CPSC 224-02, Spring 2022
 * HW4 Yahtzee GUI
 * Source: Most of the Die.java, DiceImages.java, DieView.java, Hand.java, HandView.java, Window.java
 * files written by Dr. Crandall
 *
 * @author Sean Burke
 * @version v1.4 4/10/22
 */

package edu.gonzaga;

import javax.swing.*;
import java.util.ArrayList;

public class ScorecardView {
    JTextField scorecardTitle = new JTextField("Scorecard:");
    JTextField possibleScorecardTitle = new JTextField("Possible scores:");
    JPanel scorecardPanel = new JPanel();
    JPanel possibleScorecardPanel = new JPanel();

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

    /**
     * Adds possible scores for the upper lines to the possible score panel
     * @param possibleUpperLines
     */
    void addPossibleScoreUpper(ArrayList<JTextField> possibleUpperLines){
        for(int i = 0; i < possibleUpperLines.size(); i++){
            possibleScorecardPanel.add(possibleUpperLines.get(i));
        }
    }

    /**
     * Adds possible score for three of a kind to the possible score panel
     * @param TOKPossible
     */
    void possibleThreeOfAKindScore(JTextField TOKPossible){
        possibleScorecardPanel.add(TOKPossible);
    }

    /**
     * Adds possible score for four of a kind to the possible score panel
     * @param FOKPossible
     */
    void possibleFourOfAKindScore(JTextField FOKPossible){
        possibleScorecardPanel.add(FOKPossible);
    }

    /**
     * Adds possible score for the full house line to the possible score panel
     * @param FHPossible
     */
    void possibleFullHouseScore(JTextField FHPossible){
        possibleScorecardPanel.add(FHPossible);
    }

    /**
     * Adds possible score for the small straight line to the possible score panel
     * @param SSPossible
     */
    void possibleSmallStraightScore(JTextField SSPossible){
        possibleScorecardPanel.add(SSPossible);
    }

    /**
     * Adds possible score for the large straight line to the possible score panel
     * @param LSPossible
     */
    void possibleLargeStraightScore(JTextField LSPossible){
        possibleScorecardPanel.add(LSPossible);
    }

    /**
     * Adds possible score for the yahtzee line to the possible score panel
     * @param YPossible
     */
    void possibleYahtzeeScore(JTextField YPossible){
        possibleScorecardPanel.add(YPossible);
    }

    /**
     * Adds possible score for the chance line to the possible score panel
     * @param CPossible
     */
    void possibleChanceScore(JTextField CPossible){
        possibleScorecardPanel.add(CPossible);
    }

    /**
     * Getter for the possible score panel
     * @return possibleScorePanel
     */
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
