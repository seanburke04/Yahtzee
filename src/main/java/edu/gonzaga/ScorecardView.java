package edu.gonzaga;

import javax.swing.*;
import java.util.ArrayList;

public class ScorecardView {
    JTextField scorecardTitle = new JTextField("Scorecard:");
    JPanel scorecardPanel = new JPanel();

    /*
    Fix this to accommodate the text fields
    Also maybe to the same thing for the possible scores
    Also add java doc comments for all the methods associated with this
     */
    public ScorecardView(){
        scorecardPanel.setLayout(new BoxLayout(scorecardPanel, BoxLayout.Y_AXIS));
        scorecardTitle.setEditable(false);
        scorecardPanel.add(scorecardTitle);
    }

    public void addScoreUpper(ArrayList<JTextField> scoreUpperLines){
        for(int i = 0; i < scoreUpperLines.size(); i++){
            scorecardPanel.add(scoreUpperLines.get(i));
        }
    }

    public void addThreeOfAKindScore(JTextField TOKScore){scorecardPanel.add(TOKScore);}

    public void addFourOfAKindScore(JTextField FOKScore){scorecardPanel.add(FOKScore);}

    public void addFullHouseScore(JTextField FHScore){scorecardPanel.add(FHScore);}

    public void addSmallStraightScore(JTextField SSScore){scorecardPanel.add(SSScore);}

    public void addLargeStraightScore(JTextField LSScore){scorecardPanel.add(LSScore);}

    public void addYahtzeeScore(JTextField YScore){scorecardPanel.add(YScore);}

    public void addChanceScore(JTextField CScore){scorecardPanel.add(CScore);}

    public JPanel getScorecardPanel(){return scorecardPanel;}



    //Have each class make a text field with the score, and then get it here, add to panel, and put on window
}
