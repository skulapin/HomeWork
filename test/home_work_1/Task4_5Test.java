package home_work_1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Task4_5Test {

    @Test
    public void isEnglishLetter1() {
        boolean letter = Task4_5.isEnglishLetter(-60);
        assertFalse(letter);
    }

    @Test
    public void isEnglishLetter2() {
        boolean letter = Task4_5.isEnglishLetter(0);
        assertFalse(letter);
    }

    @Test
    public void isEnglishLetter3() {
        boolean letter = Task4_5.isEnglishLetter(60);
        assertFalse(letter);
    }

    @Test
    public void isEnglishLetter4() {
        boolean letter = Task4_5.isEnglishLetter(65);
        assertTrue(letter);
    }

    @Test
    public void isEnglishLetter5() {
        boolean letter = Task4_5.isEnglishLetter(70);
        assertTrue(letter);
    }

    @Test
    public void isEnglishLetter6() {
        boolean letter = Task4_5.isEnglishLetter(90);
        assertTrue(letter);
    }

    @Test
    public void isEnglishLetter7() {
        boolean letter = Task4_5.isEnglishLetter(95);
        assertFalse(letter);
    }

    @Test
    public void isEnglishLetter8() {
        boolean letter = Task4_5.isEnglishLetter(97);
        assertTrue(letter);
    }

    @Test
    public void isEnglishLetter9() {
        boolean letter = Task4_5.isEnglishLetter(110);
        assertTrue(letter);
    }

    @Test
    public void isEnglishLetter10() {
        boolean letter = Task4_5.isEnglishLetter(122);
        assertTrue(letter);
    }

    @Test
    public void isEnglishLetter11() {
        boolean letter = Task4_5.isEnglishLetter(130);
        assertFalse(letter);
    }
}