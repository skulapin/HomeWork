package home_work_6.search_engines;

import home_work_6.api.ISearchEngine;

/*
 * 4.4* Написать декоратор для ISearchEngine который будет позволять искать данные без учёта регистра.
		Более подробное описание задачи, для понимания чего я хочу:  Тут можно пойти на хитрость, данный класс может
		* просто приводить весь текст и передаваемое слово к нижнему регистру но тут возникает вопрос как данный класс
		* может помочь для RegExSearch. Класс RegExSearch в своей реализации использует регулярные выражения и в случае
		* с регулярными выражениями есть возможность указать свойство CASE_INSENSITIVE для выражение и оно и так станет
		* не чувствительно к регистру. Для того чтобы тут что-то оптимизировать можно воспользоваться оператором
		* instanceof и вычислить таки какого класса нам передали объект ISearchEngine. Данная практика является
		* нежелательной но при этом в некоторых случаях очень эффективной.
 */

/**
 * Класс-поисковик выражения в тексте. Использует для поиска реализацию поисковика вложенного интерфейса ISearchEngine.
 * Осуществляет поиск строки в тексте без учета регистра
 */
public class SearchEngineCaseInsensitive implements ISearchEngine {

    private ISearchEngine engine;

    public SearchEngineCaseInsensitive(ISearchEngine engine) {
        this.engine = engine;
    }

    /**
     * Осуществляет поиск строки в тексте без учета регистра
     */
    @Override
    public long search(String text, String word) {

        if (this.engine instanceof RegExSearch) {
            ((RegExSearch) engine).searchWithCaseIgnore();
        } else {
            text = text.toLowerCase();
            word = word.toLowerCase();
        }
        return this.engine.search(text, word);
    }
}