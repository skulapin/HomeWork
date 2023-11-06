package home_work_4;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class IntegerCompareTest {

    Comparator<Integer> comparator = new IntegerCompare();

    @Test
    public void compare1() {
        assertEquals(1, comparator.compare(1, 0));
    }

    @Test
    public void compare2() {
        assertEquals(-1, comparator.compare(0, 1));
    }

    @Test
    public void compare3() {
        assertEquals(0, comparator.compare(0, 0));
    }

    @Test
    public void compare4() {
        assertEquals(1, comparator.compare(null, 0));
    }

    @Test
    public void compare5() {
        assertEquals(0, comparator.compare(0, null));
    }

    @Test
    public void compare6() {
        assertEquals(0, comparator.compare(null, null));
    }
}