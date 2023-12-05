package home_work_6.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import home_work_6.comparator.KeyStringComparator;
import home_work_6.comparator.ValueIntegerComparator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CollectionUtilsTest {

    private List<String> list = new ArrayList<>();
    private Map<String, Integer> map = new HashMap<>();

    {
        list.add("Привет");
        list.add("как");
        list.add("дела");
        list.add("Привет");
        list.add("Привет");

        map.put("Привет", 3);
        map.put("как", 1);
        map.put("дела", 1);
    }

    @Test
    public void listToMap1() {
        assertEquals(map, CollectionUtils.listToMap(list));
    }

    @Test
    public void listToMap2() {

        list = new ArrayList<>();
        map = new HashMap<>();

        assertEquals(map, CollectionUtils.listToMap(list));
    }

    @Test
    public void getFirstElementsFromList1() {

        List<Entry<String, Integer>> listEntry = new ArrayList<>();
        listEntry.addAll(map.entrySet());
        listEntry.sort(new ValueIntegerComparator().reversed().thenComparing(new KeyStringComparator().reversed()));

        assertEquals("Привет - 3 раз\nкак - 1 раз\nдела - 1 раз", CollectionUtils.getFirstElementsFromList(listEntry, 3));
    }

    @Test
    public void getFirstElementsFromList2() {

        List<Entry<String, Integer>> listEntry = new ArrayList<>();
        map = new HashMap<>();
        listEntry.addAll(map.entrySet());

        assertEquals("", CollectionUtils.getFirstElementsFromList(listEntry, 0));
    }

    @Test
    public void getStringRepresentation1() {

        assertEquals("Привет\nкак\nдела\nПривет\nПривет", CollectionUtils.getStringRepresentation(list));
    }

    @Test
    public void getStringRepresentation2() {
        list = new ArrayList<>();
        assertEquals("", CollectionUtils.getStringRepresentation(list));
    }
}