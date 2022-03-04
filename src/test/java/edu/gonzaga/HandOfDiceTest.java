package edu.gonzaga;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HandOfDiceTest {
    @Test
    void alwaysTrue() {
        Assertions.assertTrue(true);
    }

    @Test
    void sortDiceTest(){
        HandOfDice handOfDiceTest = new HandOfDice();
        handOfDiceTest.setFullHand(3, 2, 5, 1, 6);
        handOfDiceTest.sortDice();

        ArrayList<Integer> actualSort = new ArrayList<>();
        actualSort.add(1);
        actualSort.add(2);
        actualSort.add(3);
        actualSort.add(5);
        actualSort.add(6);

        assertEquals(handOfDiceTest.getFullHand(), actualSort);
    }
}
