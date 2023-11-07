package home_work_2.arrays;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task2_4Test {

    private final int[] arr1 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    private final int[] arr2 = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
    private final int[] arr3 = {0, -1, -2, -3, -4, -5, -6, -7, -8, -9};
    private final int[] arr4 = {0, -1, 2, -3, 4, -5, 6, -7, 8, -9};
    private final int[] arr5 = {2, 0, 5, 8, 2};


    @Test
    public void task1_1() {
        int result = Task2_4.task1(arr1);
        assertEquals(20, result);
    }

    @Test
    public void task1_2() {
        int result = Task2_4.task1(arr2);
        assertEquals(20, result);
    }

    @Test
    public void task1_3() {
        int result = Task2_4.task1(arr3);
        assertEquals(0, result);
    }

    @Test
    public void task1_4() {
        int result = Task2_4.task1(arr4);
        assertEquals(20, result);
    }

    @Test
    public void task1_5() {
        int result = Task2_4.task1(arr5);
        assertEquals(12, result);
    }

    @Test
    public void task2_1() {
        int result = Task2_4.task2(arr1);
        assertEquals(8, result);
    }

    @Test
    public void task2_2() {
        int result = Task2_4.task2(arr2);
        assertEquals(9, result);
    }

    @Test
    public void task2_3() {
        int result = Task2_4.task2(arr3);
        assertEquals(0, result);
    }

    @Test
    public void task2_4() {
        int result = Task2_4.task2(arr4);
        assertEquals(8, result);
    }

    @Test
    public void task2_5() {
        int result = Task2_4.task2(arr5);
        assertEquals(5, result);
    }

    @Test
    public void task3_1() {
        String result = Task2_4.task3(arr1);
        assertEquals("0 1 2 3 4 ", result);
    }

    @Test
    public void task3_2() {
        String result = Task2_4.task3(arr2);
        assertEquals("4 3 2 1 0 ", result);
    }

    @Test
    public void task3_3() {
        String result = Task2_4.task3(arr3);
        assertEquals("-5 -6 -7 -8 -9 ", result);
    }

    @Test
    public void task3_4() {
        String result = Task2_4.task3(arr4);
        assertEquals("-1 -3 -5 -7 -9 ", result);
    }

    @Test
    public void task3_5() {
        String result = Task2_4.task3(arr5);
        assertEquals("2 0 2 ", result);
    }

    @Test
    public void task4_1() {
        int[] result = Task2_4.task4(arr1);
        assertEquals(0, result[0]);
        assertEquals(1, result[1]);
    }

    @Test
    public void task4_2() {
        int[] result = Task2_4.task4(arr2);
        assertEquals(1, result[0]);
        assertEquals(0, result[1]);
    }

    @Test
    public void task4_3() {
        int[] result = Task2_4.task4(arr3);
        assertEquals(-8, result[0]);
        assertEquals(-9, result[1]);
    }

    @Test
    public void task4_4() {
        int[] result = Task2_4.task4(arr4);
        assertEquals(-7, result[0]);
        assertEquals(-9, result[1]);
    }

    @Test
    public void task4_5() {
        int[] result = Task2_4.task4(arr5);
        assertEquals(2, result[0]);
        assertEquals(0, result[1]);
    }


    @Test
    public void task5_1() {
        Task2_4.task5(5, 3, arr1);
        assertEquals("[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]", Arrays.toString(arr1));
    }

    @Test
    public void task5_2() {
        Task2_4.task5(3, 5, arr1);
        assertEquals("[1, 2, 6, 7, 8, 9, 0, 0, 0, 0]", Arrays.toString(arr1));
    }

    @Test
    public void task5_3() {
        Task2_4.task5(3, 5, arr2);
        assertEquals("[9, 8, 7, 6, 2, 1, 0, 0, 0, 0]", Arrays.toString(arr2));
    }

    @Test
    public void task5_4() {
        Task2_4.task5(3, 5, arr3);
        assertEquals("[-1, -2, -3, -4, -5, -6, -7, -8, -9, 0]", Arrays.toString(arr3));
    }

    @Test
    public void task5_5() {
        Task2_4.task5(3, 5, arr4);
        assertEquals("[-1, 2, -3, -5, 6, -7, 8, -9, 0, 0]", Arrays.toString(arr4));
    }

    @Test
    public void task5_6() {
        Task2_4.task5(3, 5, arr5);
        assertEquals("[2, 8, 2, 0, 0]", Arrays.toString(arr5));
    }

    @Test
    public void task6_1() {
        int result = Task2_4.task6(arr1);
        assertEquals(45, result);
    }

    @Test
    public void task6_2() {
        int result = Task2_4.task6(arr2);
        assertEquals(45, result);
    }

    @Test
    public void task6_3() {
        int result = Task2_4.task6(arr3);
        assertEquals(45, result);
    }

    @Test
    public void task6_4() {
        int result = Task2_4.task6(arr4);
        assertEquals(45, result);
    }

    @Test
    public void task6_5() {
        int result = Task2_4.task6(arr5);
        assertEquals(17, result);
    }

    @Test
    public void task6_6() {
        int result = Task2_4.task6(new int[]{12, 104, 81});
        assertEquals(17, result);
    }
}