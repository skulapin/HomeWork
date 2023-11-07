package home_work_4;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class DataContainerTest {

    private DataContainer<Integer> containerInteger = new DataContainer<>(new Integer[]{1, null, 3, null});
    private final DataContainer<String> containerString = new DataContainer<>(new String[]{"i", "hello", "1", "Как домашка"});

    @Test
    public void add() {
        assertEquals(1, containerInteger.add(777));
        assertEquals(3, containerInteger.add(4));
        assertEquals(-1, containerInteger.add(null));
    }

    @Test
    public void get() {
        assertEquals(1, containerInteger.get(0));
        assertNull(containerInteger.get(1));
        assertEquals(3, containerInteger.get(2));
        assertNull(containerInteger.get(10));
    }

    @Test
    public void getItems() {
        assertEquals("[1, null, 3, null]", Arrays.toString(containerInteger.getItems()));
    }

    @Test
    public void delete() {
        assertFalse(containerInteger.delete(null));
        assertEquals(4, containerInteger.getItems().length);
        assertTrue(containerInteger.delete(3));
        assertEquals(3, containerInteger.getItems().length);
        assertFalse(containerInteger.delete(-3));
        assertEquals(3, containerInteger.getItems().length);
    }

    @Test
    public void sort1() {
        containerInteger = new DataContainer<>(new Integer[]{3, 1, 3, 777});
        containerInteger.sort(new IntegerCompare());
        assertEquals("[1, 3, 3, 777]", Arrays.toString(containerInteger.getItems()));

        containerString.sort(new StringCompare());
        assertEquals("[i, 1, hello, Как домашка]", Arrays.toString(containerString.getItems()));
    }

    @Test
    public void toStringTest() {
        assertEquals("[1, 3]", containerInteger.toString());
        containerInteger = new DataContainer<>(new Integer[0]);
        assertEquals("[]", containerInteger.toString());
    }

    @Test
    public void sort2() {
        containerInteger = new DataContainer<>(new Integer[]{3, 1, 3, 777});
        DataContainer.sort(containerInteger);
        assertEquals("[1, 3, 3, 777]", Arrays.toString(containerInteger.getItems()));

        DataContainer.sort(containerString);
        assertEquals("[hello, i, 1, Как домашка]", Arrays.toString(containerString.getItems()));
    }

    @Test
    public void sort3() {
        containerInteger = new DataContainer<>(new Integer[]{3, 1, 3, 777});
        DataContainer.sort(containerInteger, new IntegerCompare());
        assertEquals("[1, 3, 3, 777]", Arrays.toString(containerInteger.getItems()));

        DataContainer.sort(containerString, new StringCompare());
        assertEquals("[i, 1, hello, Как домашка]", Arrays.toString(containerString.getItems()));
    }

    @Test
    public void forEach() {
        containerInteger = new DataContainer<>(new Integer[]{3, 1, 3, 777});
        StringBuilder builder = new StringBuilder();

        for (int i : containerInteger.getItems()) {
            if (!builder.isEmpty()) {
                builder.append(" ");
            }
            builder.append(i);
        }
        assertEquals("3 1 3 777", builder.toString());
    }
}