package home_work_2.loops;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task1_3Test {

    private final Task1_3 task = new Task1_3();

    @Test
    public void getPow1() {
        String result = task.getPow(18, 5);
        assertEquals("18.0 ^ 5 = 1889568.0", result);
    }

    @Test
    public void getPow2() {
        String result = task.getPow(7.5, 2);
        assertEquals("7.5 ^ 2 = 56.25", result);
    }

    @Test
    public void getPow3() {
        String result = task.getPow(-18, 5);
        assertEquals("-18.0 ^ 5 = -1889568.0", result);
    }

    @Test
    public void getPow4() {
        String result = task.getPow(-7.5, 2);
        assertEquals("-7.5 ^ 2 = 56.25", result);
    }

    @Test
    public void getPow5() {
        String result = task.getPow(0, 2);
        assertEquals("0.0 ^ 2 = 0.0", result);
    }

    @Test
    public void getPow6() {
        String result = task.getPow(18, -5);
        assertEquals("Cтепень должна быть положительная", result);
    }
}