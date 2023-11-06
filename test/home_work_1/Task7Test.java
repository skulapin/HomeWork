package home_work_1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task7Test {

    @Test
    public void createPhoneNumber1() {
        String result = Task7.createPhoneNumber(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0});
        assertEquals("(123) 456-7890", result);
    }

    @Test
    public void createPhoneNumber2() {
        String result = Task7.createPhoneNumber(new int[10]);
        assertEquals("(000) 000-0000", result);
    }

    @Test
    public void createPhoneNumber3() {
        String result = Task7.createPhoneNumber(new int[]{-1, 2, 3, 4, 5, 6, 7, 8, 9, 0});
        assertEquals(null, result);
    }

    @Test
    public void createPhoneNumber4() {
        String result = Task7.createPhoneNumber(new int[]{10, 2, 3, 4, 5, 6, 7, 8, 9, 0});
        assertEquals(null, result);
    }

    @Test
    public void createPhoneNumber5() {
        String result = Task7.createPhoneNumber(new int[9]);
        assertEquals(null, result);
    }

    @Test
    public void createPhoneNumber6() {
        String result = Task7.createPhoneNumber(new int[11]);
        assertEquals(null, result);
    }
}