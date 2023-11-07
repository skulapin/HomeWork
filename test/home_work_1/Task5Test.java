package home_work_1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Task5Test {

    @Test
    public void sleepIn1() {
        boolean answer = Task5.sleepIn(false, false);
        assertTrue(answer);
    }

    @Test
    public void sleepIn2() {
        boolean answer = Task5.sleepIn(true, false);
        assertFalse(answer);
    }

    @Test
    public void sleepIn3() {
        boolean answer = Task5.sleepIn(true, true);
        assertTrue(answer);
    }
}