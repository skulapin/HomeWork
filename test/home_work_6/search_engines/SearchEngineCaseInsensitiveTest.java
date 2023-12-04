package home_work_6.search_engines;

import home_work_6.api.ISearchEngine;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchEngineCaseInsensitiveTest {


    @ParameterizedTest
    @MethodSource("engines")
    public void search1(ISearchEngine engine) {

        String text5 = "Привет-привет";
        long result1 = engine.search(text5, "Привет-пРивет");
        long result2 = engine.search(text5, "привет");
        long result3 = engine.search(text5, "Привет");

        assertEquals(1, result1);
        assertEquals(0, result2);
        assertEquals(0, result3);
    }

    @ParameterizedTest
    @MethodSource("engines")
    public void search2(ISearchEngine engine) {

        String text6 = "Привет -привет";
        long result1 = engine.search(text6, "Привет");
        long result2 = engine.search(text6, "привет");
        long result3 = engine.search(text6, "пРивет");

        assertEquals(2, result1);
        assertEquals(2, result2);
        assertEquals(2, result3);
    }

    @ParameterizedTest
    @MethodSource("engines")
    public void search3(ISearchEngine engine) {

        String text = "привет,При/вет!привет.пРивет?прИвет*пРивеТ";
        long result = engine.search(text, "прИвет");

        assertEquals(5, result);
    }
    public static ISearchEngine[] engines() {

        ISearchEngine[] engines = new ISearchEngine[2];

        engines[0] = new SearchEngineCaseInsensitive(new EasySearch());
        engines[1] = new SearchEngineCaseInsensitive(new RegExSearch());

        return engines;
    }
}
