package home_work_1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Task4_6Test {

    @Test
    public void isLeapYear1() {
        boolean year = Task4_6.isLeapYear((short) -2004);
        assertTrue(year);
    }

    @Test
    public void isLeapYear2() {
        boolean year = Task4_6.isLeapYear((short) -2000);
        assertTrue(year);
    }

    @Test
    public void isLeapYear3() {
        boolean year = Task4_6.isLeapYear((short) -1900);
        assertFalse(year);
    }

    @Test
    public void isLeapYear4() {
        boolean year = Task4_6.isLeapYear((short) 0);
        assertTrue(year);
    }

    @Test
    public void isLeapYear5() {
        boolean year = Task4_6.isLeapYear((short) -0);
        assertTrue(year);
    }

    @Test
    public void isLeapYear6() {
        boolean year = Task4_6.isLeapYear((short) 1900);
        assertFalse(year);
    }

    @Test
    public void isLeapYear7() {
        boolean year = Task4_6.isLeapYear((short) 2000);
        assertTrue(year);
    }

    @Test
    public void isLeapYear8() {
        boolean year = Task4_6.isLeapYear((short) 2004);
        assertTrue(year);
    }
}