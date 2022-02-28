package edu.gonzaga;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;


public class GeneralTest {
    @Test
    void alwaysTrue() {
        Assertions.assertTrue(true);
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
}
