package home_work_2.loops;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task1_2Test {

    Task1_2 task = new Task1_2();

    @Test
    public void multiplyNumbers1() {
        String result = task.multiplyNumbers("181232375");
        assertEquals("1 * 8 * 1 * 2 * 3 * 2 * 3 * 7 * 5 = 10080", result);
    }

    @Test
    public void multiplyNumbers2() {
        String result = task.multiplyNumbers("99.2");
        assertEquals("Введено не целое число", result);
    }

    @Test
    public void multiplyNumbers3() {
        String result = task.multiplyNumbers("Привет");
        assertEquals("Введено не число", result);
    }

    @Test
    public void multiplyNumbers4() {
        String result = task.multiplyNumbers("-181232375");
        assertEquals("1 * 8 * 1 * 2 * 3 * 2 * 3 * 7 * 5 = 10080", result);
    }

    @Test
    public void multiplyNumbers5() {
        String result = task.multiplyNumbers("0");
        assertEquals("0 = 0", result);
    }

    @Test
    public void multiplyNumbers6() {
        String result = task.multiplyNumbers("0.0");
        assertEquals("Введено не целое число", result);
    }

    @Test
    public void multiplyNumbers7() {
        String result = task.multiplyNumbers("0.2");
        assertEquals("Введено не целое число", result);
    }

    @Test
    public void multiplyNumbers8() {
        String result = task.multiplyNumbers("-99.2");
        assertEquals("Введено не целое число", result);
    }

    @Test
    public void multiplyNumbers9() {
        String result = task.multiplyNumbers(".2");
        assertEquals("Введено не число", result);
    }

    @Test
    public void multiplyNumbers10() {
        String result = task.multiplyNumbers("2.");
        assertEquals("Введено не число", result);
    }

    @Test
    public void multiplyNumbers11() {
        String result = task.multiplyNumbers("02");
        assertEquals("Введено не число", result);
    }

    @Test
    public void multiplyNumbers12() {
        String result = task.multiplyNumbers("2.2.2");
        assertEquals("Введено не число", result);
    }
}