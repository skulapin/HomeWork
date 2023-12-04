package home_work_6.search_engines;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import home_work_6.api.ISearchEngine;
/*
 * 4.2* Написать класс RegExSearch реализующий интерфейс ISearchEngine. Реализовать поиск при помощи класса Matcher.
 * Данный класс ищет слова с учётом регистра.
 */

/**
 * Класс-поисковик выражения в тексте. Использует для поиска класс Matcher
 */
public class RegExSearch implements ISearchEngine {

    private boolean caseIgnore = false;

    /**
     * Устанавливает значение caseIgnore = true для осуществления следующей работы метода search без учета регистра
     * текста и слова
     * Note: На длинных строках работает КАТАСТРОФИЧЕСКИ медленно!!!
     */
    protected void searchWithCaseIgnore() {
        this.caseIgnore = true;
    }

    @Override
    public long search(String text, String word) {

        Pattern p;
        long counter = 0;

        // Использовать для поиска слов в объемных текстах. Регулярка ниже работает КАТАСТРОФИЧЕСКИ медленно!
        //String regexStr = "\\b" + word + "\\b";

        String regexStr =
                        "(" +
                        "(?<=[^-\\w]-+)" +    // не буква + любое количество тире
                        "|" +
                        "(?<=\\s-{1,})" +   // пробел + любое количество тире
                        "|" +
                        "(?<=^-{1,})" +     // начало строки + любое количество тире
                        "|" +
                        "(?<=\\s)" +        // пробел
                        "|" +
                        "(?<![\\w-])" +     // не буква и не тире
                        ")" +
                        word +
                        "(" +
                        "(?=-+[^-\\w])" +     // любое количество тире + не буква
                        "|" +
                        "(?=-{1,}\\s)" +    // любое количество тире + пробел
                        "|" +
                        "(?=-{1,}$)" +      // любое количество тире + конец строки
                        "| " +
                        "(?=\\s) " +        // пробел
                        "|" +
                        "(?![\\w-])" +      //не буква и не тире
                        ")";

        if (this.caseIgnore) {
            p = Pattern.compile(regexStr, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CHARACTER_CLASS);
        } else {
            p = Pattern.compile(regexStr, Pattern.UNICODE_CHARACTER_CLASS);
        }

        Matcher m = p.matcher(text);

        while (m.find()) {
            counter++;
        }
        caseIgnore = false;
        return counter;
    }
}