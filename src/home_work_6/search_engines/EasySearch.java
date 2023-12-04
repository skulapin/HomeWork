package home_work_6.search_engines;

import home_work_6.api.ISearchEngine;

/*
 * 4.1 Написать класс EasySearch. Реализовать поиск используя метод indexOf из класса String. В данной реализации
 * запрещено использовать регулярные выражения в любом виде, для любых задач. Данный класс ищет слова с учётом регистра.
 */

/**
 * Класс-поисковик выражения в тексте. Использует для поиска метод indexOf из класса String
 */
public class EasySearch implements ISearchEngine {

    @Override
    public long search(String text, String word) {

        long quantity = 0;
        int startIndex = 0;
        int length = word.length();
        char before;
        char after;
        boolean hasCorrectLeftChar;
        boolean hasCorrectRightChar;

        while ((startIndex = text.indexOf(word, startIndex)) != -1) {
            hasCorrectLeftChar = true;
            hasCorrectRightChar = true;

            if (startIndex == 0) {
                before = ' ';
            } else {
                before = text.charAt(startIndex - 1);

                if (before == '-') {

                    int tempStartIndex = startIndex - 2;

                    while (tempStartIndex >= 0) {
                        char tempChar = text.charAt(tempStartIndex);
                        if (tempChar == '-') {
                            if (tempStartIndex == 0) {
                                break;
                            }
                        } else {
                            hasCorrectLeftChar = !Character.isAlphabetic(tempChar) && !Character.isDigit(tempChar);
                            break;
                        }
                        tempStartIndex--;
                    }
                }
            }

            if (startIndex + length >= text.length()) {
                after = ' ';
            } else {

                after = text.charAt(startIndex + length);

                if (after == '-') {

                    int tempAfterIndex = startIndex + length + 1;

                    while (tempAfterIndex < text.length()) {

                        char tempChar = text.charAt(tempAfterIndex);

                        if (tempChar == '-') {
                            if (tempAfterIndex == text.length() - 1) {
                                break;
                            }
                        } else {
                            hasCorrectRightChar = !Character.isAlphabetic(tempChar) && !Character.isDigit(tempChar);
                            break;
                        }
                        tempAfterIndex++;
                    }
                }
            }
            if (!Character.isAlphabetic(before) && !Character.isDigit(before) && !Character.isAlphabetic(after) &&
                    !Character.isDigit(after) && hasCorrectLeftChar && hasCorrectRightChar) {
                quantity++;
            }
            startIndex++;
        }
        return quantity;
    }
}