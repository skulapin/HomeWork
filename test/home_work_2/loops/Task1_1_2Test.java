package home_work_2.loops;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task1_1_2Test {

    Task1_1_2 task = new Task1_1_2();

    @Test
    public void getFactorial1() {
        String factorial = task.getFactorial(0);
        assertEquals("0! = 1", factorial);
    }

    @Test
    public void getFactorial2() {
        String factorial = task.getFactorial(1);
        assertEquals("1 = 1", factorial);
    }

    @Test
    public void getFactorial3() {
        String factorial = task.getFactorial(5);
        assertEquals("1 * 2 * 3 * 4 * 5 = 120", factorial);
    }

    @Test
    public void getFactorial4() {
        String factorial = task.getFactorial(20);
        assertEquals("1 * 2 * 3 * 4 * 5 * 6 * 7 * 8 * 9 * 10 * 11 * 12 * 13 * 14 * 15 * 16 * 17 * 18 * 19 * 20 " +
                "= 2432902008176640000", factorial);
    }

    @Test
    public void getFactorial5() {
        String factorial = task.getFactorial(21);
        assertEquals("Произошло переполнение переменной", factorial);
    }

    @Test
    public void getFactorial6() {
        String factorial = task.getFactorial(-5);
        assertEquals("Введено отрицательное число", factorial);
    }
}