package home_work_4;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCompareTest {

    private final Comparator<String> comparator = new StringCompare();

    @Test
    public void compare1() {
        assertEquals(1, comparator.compare("Hello", "Hi"));
    }

    @Test
    public void compare2() {
        assertEquals(-1, comparator.compare("Hi", "Hello"));
    }

    @Test
    public void compare3() {
        assertEquals(0, comparator.compare("Hi", "Hi"));
    }

    @Test
    public void compare4() {
        assertEquals(1, comparator.compare(null, "Hi"));
    }

    @Test
    public void compare5() {
        assertEquals(0, comparator.compare("Hi", null));
    }

    @Test
    public void compare6() {
        assertEquals(0, comparator.compare(null, null));
    }
}