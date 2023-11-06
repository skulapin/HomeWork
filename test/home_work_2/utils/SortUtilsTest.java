package home_work_2.utils;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SortUtilsTest {
    int[] arr1 = {1, 2, 3, 4, 5, 6};
    int[] arr2 = {1, 1, 1, 1};
    int[] arr3 = {9, 1, 5, 99, 9, 9};
    int[] arr4 = {};
    int[] arr5 = {6, 5, 4, 3, 2, 1};
    int[] arr6 = {-2, 5, -93, 102, 62, -0};

    @Test
    public void sort1() {
        SortsUtils.sort(arr1);
        assertEquals("[1, 2, 3, 4, 5, 6]", Arrays.toString(arr1));
    }

    @Test
    public void sort2() {
        SortsUtils.sort(arr2);
        assertEquals("[1, 1, 1, 1]", Arrays.toString(arr2));
    }

    @Test
    public void sort3() {
        SortsUtils.sort(arr3);
        assertEquals("[1, 5, 9, 9, 9, 99]", Arrays.toString(arr3));
    }

    @Test
    public void sort4() {
        SortsUtils.sort(arr4);
        assertEquals("[]", Arrays.toString(arr4));
    }

    @Test
    public void sort5() {
        SortsUtils.sort(arr5);
        assertEquals("[1, 2, 3, 4, 5, 6]", Arrays.toString(arr5));
    }

    @Test
    public void sort6() {
        SortsUtils.sort(arr6);
        assertEquals("[-93, -2, 0, 5, 62, 102]", Arrays.toString(arr6));
    }

    @Test
    public void shake1() {
        SortsUtils.shake(arr1);
        assertEquals("[1, 2, 3, 4, 5, 6]", Arrays.toString(arr1));
    }

    @Test
    public void shake2() {
        SortsUtils.shake(arr2);
        assertEquals("[1, 1, 1, 1]", Arrays.toString(arr2));
    }

    @Test
    public void shake3() {
        SortsUtils.shake(arr3);
        assertEquals("[1, 5, 9, 9, 9, 99]", Arrays.toString(arr3));
    }

    @Test
    public void shake4() {
        SortsUtils.shake(arr4);
        assertEquals("[]", Arrays.toString(arr4));
    }

    @Test
    public void shake5() {
        SortsUtils.shake(arr5);
        assertEquals("[1, 2, 3, 4, 5, 6]", Arrays.toString(arr5));
    }

    @Test
    public void shake6() {
        SortsUtils.shake(arr6);
        assertEquals("[-93, -2, 0, 5, 62, 102]", Arrays.toString(arr6));
    }
}
