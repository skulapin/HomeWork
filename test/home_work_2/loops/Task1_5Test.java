package home_work_2.loops;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Task1_5Test {
    private final Task1_5 task = new Task1_5();

    @Test
    public void task1_1() {
        int maxNumber = task.task1(764580);
        assertEquals(8, maxNumber);
    }

    @Test
    public void task1_2() {
        int maxNumber = task.task1(-764580);
        assertEquals(8, maxNumber);
    }

    @Test
    public void task1_3() {
        int maxNumber = task.task1(0);
        assertEquals(0, maxNumber);
    }

    @Test
    public void task2_1() {
        double evenNumbersPercentage = task.task2(1000);
        boolean probability = false;

        if (evenNumbersPercentage >= 0 && evenNumbersPercentage <= 100) {
            probability = true;
        }
        assertTrue(probability);
    }

    @Test
    public void task2_2() {
        double evenNumbersPercentage = task.task2(-1000);
        boolean probability = false;

        if (evenNumbersPercentage >= 0 && evenNumbersPercentage <= 100) {
            probability = true;
        }

        assertFalse(probability);
    }

    @Test
    public void task2_3() {
        double evenNumbersPercentage = task.task2(0);
        boolean probability = false;

        if (evenNumbersPercentage >= 0 && evenNumbersPercentage <= 100) {
            probability = true;
        }

        assertFalse(probability);
    }

    @Test
    public void task3_1() {
        int[] oddAndEvenNumbers = task.task3(34560);
        assertEquals(3, oddAndEvenNumbers[0]);
        assertEquals(2, oddAndEvenNumbers[1]);
    }

    @Test
    public void task3_2() {
        int[] oddAndEvenNumbers = task.task3(-34560);
        assertEquals(3, oddAndEvenNumbers[0]);
        assertEquals(2, oddAndEvenNumbers[1]);
    }

    @Test
    public void task3_3() {
        int[] oddAndEvenNumbers = task.task3(0);
        assertEquals(1, oddAndEvenNumbers[0]);
        assertEquals(0, oddAndEvenNumbers[1]);
    }

    @Test
    public void task4_1() {
        String fibonacciSequence = task.task4(6);
        assertEquals("1 2 3 5 8 13", fibonacciSequence);
    }

    @Test
    public void task4_2() {
        String fibonacciSequence = task.task4(1);
        assertEquals("1", fibonacciSequence);
    }

    @Test
    public void task4_3() {
        String fibonacciSequence = task.task4(0);
        assertEquals("Введено не положительное число", fibonacciSequence);
    }

    @Test
    public void task4_4() {
        String fibonacciSequence = task.task4(-6);
        assertEquals("Введено не положительное число", fibonacciSequence);
    }

    @Test
    public void task5_1() {
        String sequence = task.task5(10, 35, 5);
        assertEquals("10 15 20 25 30 35", sequence);
    }

    @Test
    public void task5_2() {
        String sequence = task.task5(-10, 35, 5);
        assertEquals("-10 -5 0 5 10 15 20 25 30 35", sequence);
    }

    @Test
    public void task5_3() {
        String sequence = task.task5(-35, -10, 5);
        assertEquals("-35 -30 -25 -20 -15 -10", sequence);
    }

    @Test
    public void task5_4() {
        String sequence = task.task5(10, 35, 0);
        assertEquals("Введены некорректные данные", sequence);
    }

    @Test
    public void task5_5() {
        String sequence = task.task5(10, 35, -5);
        assertEquals("Введены некорректные данные", sequence);
    }

    @Test
    public void task5_6() {
        String sequence = task.task5(35, 10, 5);
        assertEquals("Введены некорректные данные", sequence);
    }


    @Test
    public void task6_1() {
        int reverseNumber = task.task6(3486);
        assertEquals(6843, reverseNumber);
    }

    @Test
    public void task6_2() {
        int reverseNumber = task.task6(-3486);
        assertEquals(-6843, reverseNumber);
    }

    @Test
    public void task6_3() {
        int reverseNumber = task.task6(0);
        assertEquals(0, reverseNumber);
    }

    @Test
    public void task6_4() {
        int reverseNumber = task.task6(5);
        assertEquals(5, reverseNumber);
    }

    @Test
    public void task6_5() {
        int reverseNumber = task.task6(-5);
        assertEquals(-5, reverseNumber);
    }
}