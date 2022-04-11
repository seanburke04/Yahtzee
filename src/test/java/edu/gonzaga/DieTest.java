package edu.gonzaga;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DieTest {
    @Test
    void testDefaultValue() {
        Integer expectedValue = 0;
        Die die = new Die(6);
        System.out.println("Default value should be 1");
        assertEquals(expectedValue, die.getValue());
    }

    @Test
    void testInitializedValue() {
        Integer expectedValue = 4;
        Die die = new Die(6);
        die.setValue(expectedValue);
        System.out.println("Initialized value should be 4");
        assertEquals(expectedValue, die.getValue());
    }
}