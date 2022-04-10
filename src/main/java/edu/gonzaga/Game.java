/**
 * This program plays through a whole game of Yahtzee through a GUI
 * CPSC 224-02, Spring 2022
 * HW4 Yahtzee GUI
 * Source: Most of the Die.java, DiceImages.java, DieView.java, Hand.java, HandView.java, Window.java
 * files written by Dr. Crandall
 *
 * @author Sean Burke
 * @version v1.4 4/8/22
 */
package edu.gonzaga;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Main driver class for the whole game
 */
public class Game {
    ScorecardView displayScorecard;
    ScoreUpper upperScoreLines;
    ThreeOfAKind threeOfAKindScoreLine;
    FourOfAKind fourOfAKindScoreLine;
    SmallStraight smallStraightScoreLine;
    LargeStraight largeStraightScoreLine;
    FullHouse fullHouseScoreLine;
    YahtzeeScore yahtzeeScoreLine;
    Chance chanceScoreLine;

    ArrayList<Integer> settings = new ArrayList<>();

    /**
     * Setter for the settings array
     * @param userSettings
     */
    public void setSettings(ArrayList<Integer> userSettings){settings = userSettings;}

    /**
     * Getter for the settings array
     * @return settings
     */
    public ArrayList<Integer> getSettings() {
        return settings;
    }

    private void initializeScorecard(){
        upperScoreLines = new ScoreUpper(settings.get(1));
        displayScorecard = new ScorecardView();
        threeOfAKindScoreLine = new ThreeOfAKind();
        fourOfAKindScoreLine = new FourOfAKind();
        smallStraightScoreLine = new SmallStraight();
        largeStraightScoreLine = new LargeStraight();
        fullHouseScoreLine = new FullHouse();
        yahtzeeScoreLine = new YahtzeeScore();
        chanceScoreLine = new Chance();
    }

    //need to get die values from hand, also figure out which class has them
    void startGame(){
        initializeScorecard();
    }

    private void singleTurn(){}

    JPanel makeScorecard(){
        displayScorecard.addScoreUpper(upperScoreLines.makeScoreView());
        displayScorecard.addThreeOfAKindScore(threeOfAKindScoreLine.makeScoreView());
        displayScorecard.addFourOfAKindScore(fourOfAKindScoreLine.makeScoreView());
        displayScorecard.addFullHouseScore(fullHouseScoreLine.makeScoreView());
        displayScorecard.addSmallStraightScore(smallStraightScoreLine.makeScoreView());
        displayScorecard.addLargeStraightScore(largeStraightScoreLine.makeScoreView());
        displayScorecard.addYahtzeeScore(yahtzeeScoreLine.makeScoreView());
        displayScorecard.addChanceScore(chanceScoreLine.makeScoreView());

        return displayScorecard.getScorecardPanel();
    }
}
