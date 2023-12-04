package home_work_6.search_engines;

import home_work_6.api.ISearchEngine;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class EngineCommonTest {

    // 1. "привет, как дела!" - тут три слова "привет", "как", "дела";

    @ParameterizedTest
    @MethodSource("engines")
    public void search1(ISearchEngine engine) {

        String text1 = "привет, как дела!";
        long result1 = engine.search(text1, "привет");
        long result2 = engine.search(text1, "как");
        long result3 = engine.search(text1, "дела");
        long result4 = engine.search(text1, "какдела");

        assertEquals(1, result1);
        assertEquals(1, result2);
        assertEquals(1, result3);
        assertEquals(0, result4);
    }

    // 2. "привет,какдела!" - тут два слова "привет", "какдела";

    @ParameterizedTest
    @MethodSource("engines")
    public void search2(ISearchEngine engine) {

        String text2 = "привет,какдела!";
        long result1 = engine.search(text2, "привет");
        long result2 = engine.search(text2, "какдела");
        long result3 = engine.search(text2, "дела");

        assertEquals(1, result1);
        assertEquals(1, result2);
        assertEquals(0, result3);
    }

    // 3. "привет;какдела!" - тут два слова "привет", "какдела";

    @ParameterizedTest
    @MethodSource("engines")
    public void search3(ISearchEngine engine) {

        String text3 = "привет;какдела!";
        long result1 = engine.search(text3, "привет");
        long result2 = engine.search(text3, "какдела");
        long result3 = engine.search(text3, "дела");

        assertEquals(1, result1);
        assertEquals(1, result2);
        assertEquals(0, result3);
    }

    // 4. "как дела!.Что делаешь?"- тут четыре слова "как", "дела", "Что",
    // "делаешь";

    @ParameterizedTest
    @MethodSource("engines")
    public void search4(ISearchEngine engine) {

        String text4 = "как дела!.Что делаешь?";
        long result1 = engine.search(text4, "как");
        long result2 = engine.search(text4, "дела");
        long result3 = engine.search(text4, "Что");
        long result4 = engine.search(text4, "делаешь");
        long result5 = engine.search(text4, "привет");

        assertEquals(1, result1);
        assertEquals(1, result2);
        assertEquals(1, result3);
        assertEquals(1, result4);
        assertEquals(0, result5);
    }

    // 5. "Привет-привет" - тут одно слово "Привет-привет";

    @ParameterizedTest
    @MethodSource("engines")
    public void search5(ISearchEngine engine) {

        String text5 = "Привет-привет";
        long result1 = engine.search(text5, "Привет-привет");
        long result2 = engine.search(text5, "привет");
        long result3 = engine.search(text5, "Привет");

        assertEquals(1, result1);
        assertEquals(0, result2);
        assertEquals(0, result3);
    }

    // 6. "Привет -привет" - тут два слова "Привет", "привет";

    @ParameterizedTest
    @MethodSource("engines")
    public void search6(ISearchEngine engine) {

        String text6 = "Привет -привет";
        long result1 = engine.search(text6, "Привет");
        long result2 = engine.search(text6, "привет");
        long result3 = engine.search(text6, "что");

        assertEquals(1, result1);
        assertEquals(1, result2);
        assertEquals(0, result3);
    }

    // 7. "4-х" - тут одно слово "4-х";

    @ParameterizedTest
    @MethodSource("engines")
    public void search7(ISearchEngine engine) {

        String text7 = "4-х";
        long result1 = engine.search(text7, "4-х");
        long result2 = engine.search(text7, "4");
        long result3 = engine.search(text7, "х");

        assertEquals(1, result1);
        assertEquals(0, result2);
        assertEquals(0, result3);
    }

    // 8. "один и 1" - тут три слова "один", "и", "1"

    @ParameterizedTest
    @MethodSource("engines")
    public void search8(ISearchEngine engine) {

        String text8 = "один и 1";
        long result1 = engine.search(text8, "один");
        long result2 = engine.search(text8, "и");
        long result3 = engine.search(text8, "1");
        long result4 = engine.search(text8, "Один");

        assertEquals(1, result1);
        assertEquals(1, result2);
        assertEquals(1, result3);
        assertEquals(0, result4);
    }

    // 9. "бабушка бабушке бабушку" - тут три слова "бабушка", "бабушке", "бабушку"

    @ParameterizedTest
    @MethodSource("engines")
    public void search9(ISearchEngine engine) {

        String text9 = "бабушка бабушке бабушку";
        long result1 = engine.search(text9, "бабушка");
        long result2 = engine.search(text9, "бабушке");
        long result3 = engine.search(text9, "бабушку");
        long result4 = engine.search(text9, "бабушкой");

        assertEquals(1, result1);
        assertEquals(1, result2);
        assertEquals(1, result3);
        assertEquals(0, result4);
    }

    @ParameterizedTest
    @MethodSource("engines")
    public void search10(ISearchEngine engine) {

        String text = "привет";
        long result = engine.search(text, "привет");

        assertEquals(1, result);
    }

    @ParameterizedTest
    @MethodSource("engines")
    public void search11(ISearchEngine engine) {

        String text = "привет-";
        long result = engine.search(text, "привет");

        assertEquals(1, result);
    }

    @ParameterizedTest
    @MethodSource("engines")
    public void search12(ISearchEngine engine) {

        String text = "привет--";
        long result = engine.search(text, "привет");

        assertEquals(1, result);
    }

    @ParameterizedTest
    @MethodSource("engines")
    public void search13(ISearchEngine engine) {

        String text = "-привет--";
        long result = engine.search(text, "привет");

        assertEquals(1, result);
    }

    @ParameterizedTest
    @MethodSource("engines")
    public void search14(ISearchEngine engine) {

        String text = "--привет--";
        long result = engine.search(text, "привет");

        assertEquals(1, result);
    }

    @ParameterizedTest
    @MethodSource("engines")
    public void search15(ISearchEngine engine) {

        String text = "--привет-привет--";
        long result = engine.search(text, "привет");

        assertEquals(0, result);
    }

    @ParameterizedTest
    @MethodSource("engines")
    public void search16(ISearchEngine engine) {

        String text = "--привет--привет--";
        long result = engine.search(text, "привет");

        assertEquals(0, result);
    }

    @ParameterizedTest
    @MethodSource("engines")
    public void search17(ISearchEngine engine) {

        String text = "--привет--.--привет--";
        long result = engine.search(text, "привет");

        assertEquals(2, result);
    }

    @ParameterizedTest
    @MethodSource("engines")
    public void search18(ISearchEngine engine) {

        String text = "--привет-- --привет--";
        long result = engine.search(text, "привет");

        assertEquals(2, result);
    }

    @ParameterizedTest
    @MethodSource("engines")
    public void search19(ISearchEngine engine) {

        String text = "привет,Привет,привет";
        long result = engine.search(text, "привет");

        assertEquals(2, result);
    }

    public static ISearchEngine[] engines() {

        ISearchEngine[] engines = new ISearchEngine[3];

        engines[0] = new EasySearch();
        engines[1] = new RegExSearch();
        engines[2] = new SearchEnginePunctuationNormalizer(engines[0]);

        return engines;
    }
}