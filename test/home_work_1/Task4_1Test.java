package home_work_1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task4_1Test {

    @Test
    public void getOddNumber1() {
        int oddNumber = Task4_1.getOddNumber(5, 8);
        assertEquals(5, oddNumber);
    }

    @Test
    public void getOddNumber2() {
        int oddNumber = Task4_1.getOddNumber(8, 5);
        assertEquals(5, oddNumber);
    }

    @Test
    public void getOddNumber3() {
        int oddNumber = Task4_1.getOddNumber(5, -8);
        assertEquals(5, oddNumber);
    }

    @Test
    public void getOddNumber4() {
        int oddNumber = Task4_1.getOddNumber(-8, 5);
        assertEquals(5, oddNumber);
    }

    @Test
    public void getOddNumber5() {
        int oddNumber = Task4_1.getOddNumber(-5, 8);
        assertEquals(-5, oddNumber);
    }

    @Test
    public void getOddNumber6() {
        int oddNumber = Task4_1.getOddNumber(8, -5);
        assertEquals(-5, oddNumber);
    }

    @Test
    public void getOddNumber7() {
        int oddNumber = Task4_1.getOddNumber(5, 5);
        assertEquals(0, oddNumber);
    }

    @Test
    public void getOddNumber8() {
        int oddNumber = Task4_1.getOddNumber(5, 7);
        assertEquals(0, oddNumber);
    }

    @Test
    public void getOddNumber9() {
        int oddNumber = Task4_1.getOddNumber(6, 8);
        assertEquals(0, oddNumber);
    }
}