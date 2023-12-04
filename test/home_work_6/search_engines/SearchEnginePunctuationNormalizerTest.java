package home_work_6.search_engines;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchEnginePunctuationNormalizerTest {

    private final SearchEnginePunctuationNormalizer engine = new SearchEnginePunctuationNormalizer(new EasySearch());

    @Test
    public void search1() {

        String text = "hel,llo  \n  .   wor!ld?";

        text = engine.deleteSymbols(text, new String[]{"\n", ",", "\\.", "!"}, "");
        text = engine.deleteSymbols(text, new String[]{" +"}, " ");
        text = engine.deleteSymbols(text, new String[]{"l{3}"}, "ll");
        text = engine.deleteSymbols(text, new String[]{"h"}, "H");
        text = engine.deleteSymbols(text, new String[]{"\\?"}, "!");

        assertEquals("Hello world!", text);
    }

    @Test
    public void search2() {

        String text = "При%вет, к?ак %дел?а?, Чт\nо де[лаешь?";
        text = engine.deleteSymbols(text, new String[]{"\n", "%", "(?<=[кл])\\?", "(?<=[//?])," , "\\["}, "");

        assertEquals("Привет, как дела? Что делаешь?", text);
    }
}