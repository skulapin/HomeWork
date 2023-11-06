package home_work_1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task5Test {

    @Test
    public void sleepIn1(){
        boolean answer = Task5.sleepIn(false , false);
        assertEquals(true, answer);
    }

    @Test
    public void sleepIn2(){
        boolean answer = Task5.sleepIn(true , false);
        assertEquals(false, answer);
    }

    @Test
    public void sleepIn3(){
        boolean answer = Task5.sleepIn(true , true);
        assertEquals(true, answer);
    }
}