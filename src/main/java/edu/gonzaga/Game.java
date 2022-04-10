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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Main driver class for the whole game
 */
public class Game {
    Hand hand;
    HandView handView;

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
    ArrayList<Integer> dieValues = new ArrayList<>();

    JLabel scoreSelectLabel = new JLabel("Select which score to keep: ");
    JPanel scoreSelectPanel = new JPanel();
    JComboBox scoreSelect = new JComboBox();

    void setupScoreSelect(){
        for(int i = 1; i < (settings.get(0) + 1); i++){
            scoreSelect.addItem(i);
        }
        scoreSelect.addItem("Three of a Kind");
        scoreSelect.addItem("Four of a Kind");
        scoreSelect.addItem("Full House");
        scoreSelect.addItem("Small Straight");
        scoreSelect.addItem("Large Straight");
        scoreSelect.addItem("Yahtzee");
        scoreSelect.addItem("Chance");
    }

    void scoreSelectFunctionality(){
        scoreSelect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(int i = 0; i < settings.get(0); i++){
                    if(scoreSelect.getSelectedItem() == String.valueOf(i)){
                        if(upperScoreLines.getIsUsed().get(i) == false){
                            upperScoreLines.setIsUsed(i);
                            upperScoreLines.isChosen(i);
                        }
                        else{
                            System.out.println("That is already chosen");
                            System.exit(1);
                        }
                    }
                }
                if(scoreSelect.getSelectedItem() == "Three of a Kind"){
                    if(threeOfAKindScoreLine.getIsUsed()){
                        System.out.println("That is already chosen");
                        System.exit(1);
                    }
                    else{
                        threeOfAKindScoreLine.setIsUsed(true);
                        threeOfAKindScoreLine.isChosen();
                    }
                }
                else if(scoreSelect.getSelectedItem() == "Four of a Kind"){
                    if(fourOfAKindScoreLine.getIsUsed()){
                        System.out.println("That is already chosen");
                        System.exit(1);
                    }
                    else{
                        fourOfAKindScoreLine.setIsUsed(true);
                        fourOfAKindScoreLine.isChosen();
                    }
                }
                else if(scoreSelect.getSelectedItem() == "Full House"){
                    if(fullHouseScoreLine.getIsUsed()){
                        System.out.println("That is already chosen");
                        System.exit(1);
                    }
                    else{
                        fullHouseScoreLine.setIsUsed(true);
                        fullHouseScoreLine.isChosen();
                    }
                }
                else if(scoreSelect.getSelectedItem() == "Small Straight"){
                    if(smallStraightScoreLine.getIsUsed()){
                        System.out.println("That is already chosen");
                        System.exit(1);
                    }
                    else{
                        smallStraightScoreLine.setIsUsed(true);
                        smallStraightScoreLine.isChosen();
                    }
                }
                else if(scoreSelect.getSelectedItem() == "Large Straight"){
                    if(largeStraightScoreLine.getIsUsed()){
                        System.out.println("That is already chosen");
                        System.exit(1);
                    }
                    else{
                        largeStraightScoreLine.setIsUsed(true);
                        largeStraightScoreLine.isChosen();
                    }
                }
                else if(scoreSelect.getSelectedItem() == "Yahtzee"){
                    if(yahtzeeScoreLine.getIsUsed()){
                        System.out.println("That is already chosen");
                        System.exit(1);
                    }
                    else{
                        yahtzeeScoreLine.setIsUsed(true);
                        yahtzeeScoreLine.isChosen();
                    }
                }
                else if(scoreSelect.getSelectedItem() == "Chance"){
                    if(chanceScoreLine.getIsUsed()){
                        System.out.println("That is already chosen");
                        System.exit(1);
                    }
                    else{
                        chanceScoreLine.setIsUsed(true);
                        chanceScoreLine.isChosen();
                    }
                }
                scoreSelectPanel.setVisible(false);
            }
        });
    }

    void addToScoreSelectPanel(){
        scoreSelectPanel.add(scoreSelectLabel);
        scoreSelectPanel.add(scoreSelect);
    }

    JPanel getScoreSelectPanel(){return scoreSelectPanel;}

    void calcScores(){
        upperScoreLines.calcScore(dieValues);
        threeOfAKindScoreLine.calcScore(dieValues);
        fourOfAKindScoreLine.calcScore(dieValues);
        fullHouseScoreLine.calcScore(dieValues);
        smallStraightScoreLine.calcScore(dieValues);
        largeStraightScoreLine.calcScore(dieValues);
        yahtzeeScoreLine.calcScore(dieValues);
        chanceScoreLine.calcScore(dieValues);
    }

    HandView getHandView(){return handView;}

    /**
     * Calls hand constructor so hand methods are called within that class
     */
    void setupHand() {
        hand = new Hand(settings);
    }

    /**
     * Calls handView constructor so handView methods are called within that class
     */
    void setupHandView() {
        handView = new HandView(hand, settings);
    }

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

    /**
     * Sets up all the scorecard classes
     */
    private void initializeScorecard(){
        upperScoreLines = new ScoreUpper(settings);
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
        setupHand();
        setupHandView();
    }

    private void singleTurn(){}

    JPanel makePossibleScorecard(){
        displayScorecard.addPossibleScoreUpper(upperScoreLines.makePossibleScoreView());
        displayScorecard.possibleThreeOfAKindScore(threeOfAKindScoreLine.makePossibleScoreView());
        displayScorecard.possibleFourOfAKindScore(fourOfAKindScoreLine.makePossibleScoreView());
        displayScorecard.possibleFullHouseScore(fullHouseScoreLine.makePossibleScoreView());
        displayScorecard.possibleSmallStraightScore(smallStraightScoreLine.makePossibleScoreView());
        displayScorecard.possibleLargeStraightScore(largeStraightScoreLine.makePossibleScoreView());
        displayScorecard.possibleYahtzeeScore(yahtzeeScoreLine.makePossibleScoreView());
        displayScorecard.possibleChanceScore(chanceScoreLine.makePossibleScoreView());

        return displayScorecard.getPossibleScorecardPanel();
    }

    /**
     * Adds all score lines to a panel and passes it to the Window
     * @return displayScorecard
     */
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
