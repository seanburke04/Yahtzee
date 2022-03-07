package edu.gonzaga;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GeneralTest {
    @Test
    void alwaysTrue() {
        Assertions.assertTrue(true);
    }

    @Test
    void verifyLowerTest(){
        Player testPlayer = new Player();
        ThreeOfAKind threeOfAKindTest = new ThreeOfAKind();
        Boolean actual;

        testPlayer.verifyLowerScorecard("TOK");
        actual = threeOfAKindTest.getIsUsed();
        assertEquals(false, actual);
    }
}
