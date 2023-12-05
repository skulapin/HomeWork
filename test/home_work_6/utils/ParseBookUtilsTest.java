package home_work_6.utils;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParseBookUtilsTest {

    private String text = "Привет, как.дела?! Что\nнового!";
    private List<String> list = new ArrayList<>();

    {
        list.add("Привет");
        list.add("как");
        list.add("дела");
        list.add("Что");
        list.add("нового");
    }

    @Test
    public void splitStringToList1() {

        String[] splitters = {",", " ", "\\.", "\\?", "\n", "!" };
        assertEquals(list, ParseBookUtils.splitStringToList(text, splitters));
    }

    @Test
    public void splitStringToList2() {

        list = new ArrayList<>();
        text = "";

        String[] splitters = {",", " ", "\\.", "\\?", "\n", "\\!"};

        assertEquals(list, ParseBookUtils.splitStringToList(text, splitters));
    }

    @Test
    public void deleteWordsFromList1() {
        ParseBookUtils.deleteWordsFromList(list, new String[]{"как", "Что"});
        assertEquals("[Привет, дела, нового]", list.toString());
    }

    @Test
    public void deleteWordsFromList2() {
        ParseBookUtils.deleteWordsFromList(list, new String[]{"кАк", "что"});
        assertEquals("[Привет, как, дела, Что, нового]", list.toString());
    }

    @Test
    public void deleteWordsFromList3() {
        ParseBookUtils.deleteWordsFromList(list, new String[]{""});
        assertEquals("[Привет, как, дела, Что, нового]", list.toString());
    }

    @Test
    public void deleteFirstCharacter1() {
        ParseBookUtils.deleteFirstCharacter(list, new char[]{'п', 'к', 'ч', 'о'});
        assertEquals("[Привет, ак, дела, Что, нового]", list.toString());
    }

    @Test
    public void deleteFirstCharacter2() {
        ParseBookUtils.deleteFirstCharacter(list, new char[]{});
        assertEquals("[Привет, как, дела, Что, нового]", list.toString());
    }

    @Test
    public void deleteLastCharacter1() {

        ParseBookUtils.deleteLastCharacter(list, new char[]{'п', 'к', 'ч', 'о'});
        assertEquals("[Привет, ка, дела, Чт, новог]", list.toString());
    }

    @Test
    public void deleteLastCharacter2() {
        ParseBookUtils.deleteLastCharacter(list, new char[]{});
        assertEquals("[Привет, как, дела, Что, нового]", list.toString());
    }

    @Test
    public void checkAndSplitByDots1() {

        list = new ArrayList<>();
        list.add("Привет");
        list.add("ка.к.");
        list.add(".у");
        list.add("те.бя");
        list.add("де..ла");
        list.add("...что");
        list.add("нового...");

        ParseBookUtils.checkAndSplitByDots(list);
        assertEquals("[Привет, ка, те, де..ла, ...что, нового..., к., у, бя]", list.toString());
    }

    @Test
    public void checkAndSplitByDots2() {

        list = new ArrayList<>();
        ParseBookUtils.checkAndSplitByDots(list);
        assertEquals("[]", list.toString());
    }
}