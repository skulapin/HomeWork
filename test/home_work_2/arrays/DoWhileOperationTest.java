package home_work_2.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DoWhileOperationTest {

    int[] arr1 = {1, 2, 3, 4, 5};
    int[] arr2 = {5, 4, 3, 2, 1};
    int[] arr3 = {};
    IArraysOperation printArray = new DoWhileOperation();

    @Test
    public void printAllElements1() {
        String result = printArray.printAllElements(arr1);
        assertEquals("1 2 3 4 5", result);
    }

    @Test
    public void printAllElements2() {
        String result = printArray.printAllElements(arr2);
        assertEquals("5 4 3 2 1", result);
    }

    @Test
    public void printAllElements3() {
        String result = printArray.printAllElements(arr3);
        assertEquals("", result);
    }

    @Test
    public void printSecondElements1() {
        String result = printArray.printSecondElements(arr1);
        assertEquals("2 4", result);
    }

    @Test
    public void printSecondElements2() {
        String result = printArray.printSecondElements(arr2);
        assertEquals("4 2", result);
    }

    @Test
    public void printSecondElements3() {
        String result = printArray.printSecondElements(arr3);
        assertEquals("", result);
    }

    @Test
    public void printAllElementsInReverse1() {
        String result = printArray.printAllElementsInReverse(arr1);
        assertEquals("5 4 3 2 1", result);
    }

    @Test
    public void printAllElementsInReverse2() {
        String result = printArray.printAllElementsInReverse(arr2);
        assertEquals("1 2 3 4 5", result);
    }

    @Test
    public void printAllElementsInReverse3() {
        String result = printArray.printAllElementsInReverse(arr3);
        assertEquals("", result);
    }
}