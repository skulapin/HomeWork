package home_work_6.search_engines;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchEngineCaseNormalizerTest {

    private final SearchEngineCaseNormalizer engine = new SearchEngineCaseNormalizer(new EasySearch());
    private final SearchEngineCaseNormalizer engineCaseNoralizer = new SearchEngineCaseNormalizer(new SearchEngineCaseInsensitive(new EasySearch()));

    //Например после работы данного класса текст "бабушка бабушка бабушку" уже будет выдавать: "бабушка - 3"

    @Test
    public void search1() {

        String text = "бабушка бабушку Бабушке бабушку бабушкой бабушке";
        long result1 = engine.search(text, "бабушка");
        long result2 = engine.search(text, "бабушке");
        long result3 = engine.search(text, "бабушку");
        long result4 = engineCaseNoralizer.search(text, "баБушка");
        long result5 = engineCaseNoralizer.search(text, "бабУшке");
        long result6 = engineCaseNoralizer.search(text, "бабуШку");

        assertEquals(5, result1);
        assertEquals(5, result2);
        assertEquals(5, result3);
        assertEquals(6, result4);
        assertEquals(6, result5);
        assertEquals(6, result6);
    }

    @Test
    public void search2() {

        String text = "Соль соли соли соЛей соли солям соль соли солью солями соли солЯх соленоид пересолил соленый " +
                "пересоленый солонка";
        long result1 = engine.search(text, "соль");
        long result2 = engineCaseNoralizer.search(text, "соль");

        assertEquals(9, result1);
        assertEquals(12, result2);
    }

    @Test
    public void search3() {

        String text = "Дворянин попросил дворецкого выйти из дворца во двор, чтобы посмотреть нет ли во дворе " +
                "дворовой собаки его дворника, который выпустил собаку по кличке дворф погулять в его дворе.";
        long result1 = engine.search(text, "двор");
        long result2 = engineCaseNoralizer.search(text, "Двор");

        assertEquals(3, result1);
        assertEquals(3, result2);
    }
}