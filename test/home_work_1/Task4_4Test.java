package home_work_1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task4_4Test {

    @Test
    public void bytesToKilobytes1() {
        double data = Task4_4.bytesToKilobytes(1536);
        assertEquals(1.5, data);
    }

    @Test
    public void bytesToKilobytes2() {
        double data = Task4_4.bytesToKilobytes(-1536);
        assertEquals(-1, data);
    }

    @Test
    public void bytesToKilobytes3() {
        double data = Task4_4.bytesToKilobytes(0);
        assertEquals(0, data);
    }

    @Test
    public void kilobytesToBytes1() {
        int data = Task4_4.kilobytesToBytes(2);
        assertEquals(2048, data);
    }

    @Test
    public void kilobytesToBytes2() {
        int data = Task4_4.kilobytesToBytes(-2);
        assertEquals(-1, data);
    }

    @Test
    public void kilobytesToBytes3() {
        int data = Task4_4.kilobytesToBytes(0);
        assertEquals(0, data);
    }
}