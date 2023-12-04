package home_work_6.search_engines;

import home_work_6.api.ISearchEngine;

/*
 * 4.3* Написать декоратор SearchEnginePunctuationNormalizer для ISearchEngine который будет удалять нежелательные
 * символы. Любые знаки препинания, лишние пробелы и например переводы строк.
 */

/**
 * Класс-поисковик выражения в тексте. Использует для поиска реализацию поисковика вложенного интерфейса ISearchEngine.
 * Имеет дополнительный инструмент для удаления из текста нежелательных символов
 */
public class SearchEnginePunctuationNormalizer implements ISearchEngine {

    private final ISearchEngine engine;

    public SearchEnginePunctuationNormalizer(ISearchEngine engine) {
        this.engine = engine;
    }

    @Override
    public long search(String text, String word) {
        return this.engine.search(text, word);
    }

    /**
     * Осуществляет удаление, либо замену нежелательных символов в переданном тексте
     *
     * @param text      Текст для редактирования
     * @param replace   Массив строк, которые необходимо отредактировать в тексте
     * @param replaceBy Строка которой необходимо откорректировать указанные места.
     *                  Для удаления символа передается пустая строка ""
     * @return Отредактированный текст
     */
    public String deleteSymbols(String text, String[] replace, String replaceBy) {

        for (int i = 0; i < replace.length; i++) {
            text = text.replaceAll(replace[i], replaceBy);
        }
        return text;
    }
}
