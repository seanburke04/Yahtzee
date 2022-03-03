package edu.gonzaga;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScoreTests {
    @Test
    void scoreUpperTest1(){
        ArrayList<Integer> actualScore;
        Integer expectedScore = 3;
        ArrayList<Integer> testHand = new ArrayList<>();
        ArrayList<Integer> fakeUserSettings = new ArrayList<>();
        fakeUserSettings.add(6);
        testHand.add(1);
        testHand.add(1);
        testHand.add(1);
        testHand.add(4);
        testHand.add(5);

        ScoreUpper scoreUpper1 = new ScoreUpper(testHand, fakeUserSettings);
        actualScore = scoreUpper1.getScore();
        assertEquals(expectedScore, actualScore.get(0));
    }

    @Test
    void scoreUpperTest2(){
        ArrayList<Integer> actualScore;
        Integer expectedScore = 4;
        ArrayList<Integer> testHand = new ArrayList<>();
        ArrayList<Integer> fakeUserSettings = new ArrayList<>();
        fakeUserSettings.add(6);
        testHand.add(2);
        testHand.add(2);
        testHand.add(1);
        testHand.add(4);
        testHand.add(5);

        ScoreUpper scoreUpper2 = new ScoreUpper(testHand, fakeUserSettings);
        actualScore = scoreUpper2.getScore();
        assertEquals(expectedScore, actualScore.get(1));
    }

    @Test
    void scoreUpperTest3(){
        ArrayList<Integer> actualScore;
        Integer expectedScore = 15;
        ArrayList<Integer> testHand = new ArrayList<>();
        ArrayList<Integer> fakeUserSettings = new ArrayList<>();
        fakeUserSettings.add(6);
        testHand.add(3);
        testHand.add(3);
        testHand.add(3);
        testHand.add(3);
        testHand.add(3);

        ScoreUpper scoreUpper3 = new ScoreUpper(testHand, fakeUserSettings);
        actualScore = scoreUpper3.getScore();
        assertEquals(expectedScore, actualScore.get(2));
    }

    @Test
    void scoreUpperTest4(){
        ArrayList<Integer> actualScore;
        Integer expectedScore = 4;
        ArrayList<Integer> testHand = new ArrayList<>();
        ArrayList<Integer> fakeUserSettings = new ArrayList<>();
        fakeUserSettings.add(6);
        testHand.add(1);
        testHand.add(1);
        testHand.add(1);
        testHand.add(4);
        testHand.add(5);

        ScoreUpper scoreUpper4 = new ScoreUpper(testHand, fakeUserSettings);
        actualScore = scoreUpper4.getScore();
        assertEquals(expectedScore, actualScore.get(3));
    }

    @Test
    void scoreUpperTest5(){
        ArrayList<Integer> actualScore;
        Integer expectedScore = 0;
        ArrayList<Integer> testHand = new ArrayList<>();
        ArrayList<Integer> fakeUserSettings = new ArrayList<>();
        fakeUserSettings.add(6);
        testHand.add(1);
        testHand.add(1);
        testHand.add(1);
        testHand.add(4);
        testHand.add(3);

        ScoreUpper scoreUpper5 = new ScoreUpper(testHand, fakeUserSettings);
        actualScore = scoreUpper5.getScore();
        assertEquals(expectedScore, actualScore.get(4));
    }

    @Test
    void scoreUpperTest6(){
        ArrayList<Integer> actualScore;
        Integer expectedScore = 30;
        ArrayList<Integer> testHand = new ArrayList<>();
        ArrayList<Integer> fakeUserSettings = new ArrayList<>();
        fakeUserSettings.add(6);
        testHand.add(6);
        testHand.add(6);
        testHand.add(6);
        testHand.add(6);
        testHand.add(6);

        ScoreUpper scoreUpper6 = new ScoreUpper(testHand, fakeUserSettings);
        actualScore = scoreUpper6.getScore();
        assertEquals(expectedScore, actualScore.get(5));
    }

    @Test
    void ChanceTest(){
        Integer actualScore;
        Integer expectedScore = 15;
        ArrayList<Integer> testHand = new ArrayList<>();
        testHand.add(1);
        testHand.add(2);
        testHand.add(3);
        testHand.add(4);
        testHand.add(5);

        Chance chanceScore = new Chance(testHand);
        actualScore = chanceScore.getScore();
        assertEquals(expectedScore, actualScore);
    }

    @Test
    void threeOfAKindTest(){
        Integer actualScore;
        Integer expectedScore = 12;
        ArrayList<Integer> testHand = new ArrayList<>();
        testHand.add(1);
        testHand.add(1);
        testHand.add(1);
        testHand.add(4);
        testHand.add(5);

        ThreeOfAKind threeOfAKindScore = new ThreeOfAKind(testHand);
        actualScore = threeOfAKindScore.getScore();
        assertEquals(expectedScore, actualScore);
    }

    @Test
    void fullHouseTest(){
        Integer actualScore;
        Integer expectedScore = 25;
        ArrayList<Integer> testHand = new ArrayList<>();
        testHand.add(1);
        testHand.add(1);
        testHand.add(1);
        testHand.add(2);
        testHand.add(2);

        FullHouse fullHouseTest = new FullHouse(testHand);
        actualScore = fullHouseTest.getScore();
        assertEquals(expectedScore, actualScore);
    }

    @Test
    void fourOfAKindTest(){
        Integer actualScore;
        Integer expectedScore = 9;
        ArrayList<Integer> testHand = new ArrayList<>();
        testHand.add(1);
        testHand.add(1);
        testHand.add(1);
        testHand.add(1);
        testHand.add(5);

        FourOfAKind fourOfAKindScore = new FourOfAKind(testHand);
        actualScore = fourOfAKindScore.getScore();
        assertEquals(expectedScore, actualScore);
    }

    @Test
    void smallStraightTest(){
        Integer actualScore;
        Integer expectedScore = 30;
        ArrayList<Integer> testHand = new ArrayList<>();
        testHand.add(1);
        testHand.add(1);
        testHand.add(2);
        testHand.add(3);
        testHand.add(4);

        SmallStraight smallStraightTest = new SmallStraight(testHand);
        actualScore = smallStraightTest.getScore();
        assertEquals(expectedScore, actualScore);
    }

    @Test
    void largeStraightTest(){
        Integer actualScore;
        Integer expectedScore = 40;
        ArrayList<Integer> testHand = new ArrayList<>();
        testHand.add(1);
        testHand.add(2);
        testHand.add(3);
        testHand.add(4);
        testHand.add(5);

        LargeStraight largeStraightTest = new LargeStraight(testHand);
        actualScore = largeStraightTest.getScore();
        assertEquals(expectedScore, actualScore);
    }

    @Test
    void yahtzeeScoreTest(){
        Integer actualScore;
        Integer expectedScore = 50;
        ArrayList<Integer> testHand = new ArrayList<>();
        testHand.add(1);
        testHand.add(1);
        testHand.add(1);
        testHand.add(1);
        testHand.add(1);

        YahtzeeScore yahtzeeScoreTest = new YahtzeeScore(testHand);
        actualScore = yahtzeeScoreTest.getScore();
        assertEquals(expectedScore, actualScore);
    }
}