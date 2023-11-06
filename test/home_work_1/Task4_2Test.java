package home_work_1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task4_2Test {

    @Test
    public void getMiddleNumber1() {
        int middleNumber = Task4_2.getMiddleNumber(-4, 0, 7);
        assertEquals(0, middleNumber);
    }

    @Test
    public void getMiddleNumber2() {
        int middleNumber = Task4_2.getMiddleNumber(-4, 7, 0);
        assertEquals(0, middleNumber);
    }

    @Test
    public void getMiddleNumber3() {
        int middleNumber = Task4_2.getMiddleNumber(0, 7, -4);
        assertEquals(0, middleNumber);
    }

    @Test
    public void getMiddleNumber4() {
        int middleNumber = Task4_2.getMiddleNumber(0, -4, 7);
        assertEquals(0, middleNumber);
    }

    @Test
    public void getMiddleNumber5() {
        int middleNumber = Task4_2.getMiddleNumber(7, 0, -4);
        assertEquals(0, middleNumber);
    }

    @Test
    public void getMiddleNumber6() {
        int middleNumber = Task4_2.getMiddleNumber(7, -4, 0);
        assertEquals(0, middleNumber);
    }

    @Test
    public void getMiddleNumber7() {
        int middleNumber = Task4_2.getMiddleNumber(7, 7, 0);
        assertEquals(Integer.MAX_VALUE, middleNumber);
    }

    @Test
    public void getMiddleNumber8() {
        int middleNumber = Task4_2.getMiddleNumber(7, 0, 7);
        assertEquals(Integer.MAX_VALUE, middleNumber);
    }

    @Test
    public void getMiddleNumber9() {
        int middleNumber = Task4_2.getMiddleNumber(0, 7, 7);
        assertEquals(Integer.MAX_VALUE, middleNumber);
    }

    @Test
    public void getMiddleNumber10() {
        int middleNumber = Task4_2.getMiddleNumber(7, 7, 7);
        assertEquals(Integer.MAX_VALUE, middleNumber);
    }
}