package home_work_1;

import home_work_1.api.ICommunicationPrinter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task6_3Test {

    private final ICommunicationPrinter task6 = new Task6_3();

    @Test
    public void welcome1() {
        String answer = task6.welcome("Вася");
        assertEquals("Привет!\nЯ тебя так долго ждал", answer);
    }

    @Test
    public void welcome2() {
        String answer = task6.welcome("Анастасия");
        assertEquals("Я тебя так долго ждал", answer);
    }

    @Test
    public void welcome3() {
        String answer = task6.welcome("Сергей");
        assertEquals("Добрый день, а вы кто?", answer);
    }
}