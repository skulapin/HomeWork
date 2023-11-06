package home_work_2.loops;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task1_4Test {

    Task1_4 task = new Task1_4();

    @Test
    public void answerToString1() {
        String result = task.answerToString(3);
        assertEquals("Значение переменной до переполнения 1162261467\nЗначение переменной после переполнения " +
                "-808182895", result);
    }

    @Test
    public void answerToStrin2() {
        String result = task.answerToString(188);
        assertEquals("Значение переменной до переполнения 1249198336\nЗначение переменной после переполнения " +
                "-1373914112", result);
    }

    @Test
    public void answerToString3() {
        String result = task.answerToString(-19);
        assertEquals("Значение переменной до переполнения -893871739\nЗначение переменной после переполнения " +
                "-196306143", result);
    }

    @Test
    public void answerToString4() {
        String result = task.answerToString(50);
        assertEquals("Значение переменной до переполнения 312500000\nЗначение переменной после переполнения " +
                "-1554869184", result);
    }

    @Test
    public void answerToString5() {
        String result = task.answerToString(-1);
        assertEquals("Поберегите компьютер!", result);
    }

    @Test
    public void answerToString6() {
        String result = task.answerToString(0);
        assertEquals("Поберегите компьютер!", result);
    }

    @Test
    public void answerToString7() {
        String result = task.answerToString(1);
        assertEquals("Поберегите компьютер!", result);
    }
}