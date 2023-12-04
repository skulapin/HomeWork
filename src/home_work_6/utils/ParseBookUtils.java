package home_work_6.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Утилита для разборки текстового документа на слова
 */
public class ParseBookUtils {

    /**
     * Разбирает переданную строку на коллекцию слов. Разбивка строки происходит по переданному массиву разделителей.
     *
     * @param book      Строка которую необходимо разобрать на слова
     * @param splitters Массив разделителей по которым разбираем переданную строку
     * @return Коллекция слов
     */
    public static List<String> splitStringToList(String book, String[] splitters) {

        int listSize;
        int counter;
        int index;
        boolean needAdditionalCheck = false;
        String word;
        String[] newWords;
        List<String> list = new ArrayList<>();

        list.add(book);

        listSize = list.size();

        for (int i = 0; i < listSize; i++) {

            word = list.get(i);

            if (Objects.equals(word, "")) {
                list.remove(i);
                listSize--;
                i--;
                continue;
            }

            for (String splitter : splitters) {

                if (Objects.equals(splitter, "\\.") || Objects.equals(splitter, "\\?")
                        || Objects.equals(splitter, "\\)") || Objects.equals(splitter, "\\(")
                        || Objects.equals(splitter, "\\*")) {
                    needAdditionalCheck = true;
                }

                if (word.contains(splitter) || needAdditionalCheck) {
                    needAdditionalCheck = false;

                    newWords = word.split(splitter);

                    if (newWords.length == 0) {
                        list.remove(i);
                        listSize--;
                        i--;
                        break;
                    }

                    list.remove(i);

                    index = i;

                    word = null;
                    counter = 0;

                    for (int k = 0; k < newWords.length; k++) {

                        if (Objects.equals(newWords[k], "")) {
                            counter++;
                            continue;
                        }

                        if (word == null) {
                            word = newWords[k];
                        }

                        list.add(index, newWords[k]);
                        index++;
                    }
                    listSize += newWords.length - 1 - counter;
                }
            }
        }
        return list;
    }

    /**
     * Удаляет из коллекции строки, совпадающие со строками в переданном массиве строк
     *
     * @param list  Коллекция из которой необходимо удалить элементы
     * @param words Массив строк, которые необходимо удалить из коллекции
     */
    public static void deleteWordsFromList(List<String> list, String[] words) {

        int listSize = list.size();

        for (int i = 0; i < listSize; i++) {
            for (int j = 0; j < words.length; j++) {
                if (Objects.equals(list.get(i), words[j])) {
                    list.remove(i);
                    listSize--;
                    i--;
                    break;
                }
            }
        }
    }

    /**
     * Редактирует переданную коллекцию строк. При совпадении символа в 0 индексе строки из коллекции с любым символом
     * из переданного массива символов значение строки перезаписывается, удаляя первый символ в строке
     *
     * @param list       Коллекция строк для редактирования
     * @param characters Символы которые необходимо удалить в 0 индексе переданной коллекции строк
     */
    public static void deleteFirstCharacter(List<String> list, char[] characters) {

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < characters.length; j++) {
                String temp = list.get(i);
                if (temp.charAt(0) == characters[j]) {
                    list.set(i, temp.substring(1));
                    i--;
                    break;
                }
            }
        }
    }

    /**
     * Редактирует переданную коллекцию строк. При совпадении символа с последним символом строки из коллекции с любым
     * символом из переданного массива символов значение строки перезаписывается, удаляя последний символ в строке
     *
     * @param list       Коллекция строк для редактирования
     * @param characters Символы которые необходимо удалить в последнем символе
     *                   строки из переданной коллекции строк
     */
    public static void deleteLastCharacter(List<String> list, char[] characters) {

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < characters.length; j++) {
                String temp = list.get(i);
                int length = temp.length();
                if (temp.charAt(length - 1) == characters[j]) {
                    list.set(i, temp.substring(0, length - 1));
                    i--;
                    break;
                }
            }
        }
    }

    /**
     * Разбивает строки из переданной коллекции по разведителю "dot" (точка) при условии, что это не многоточие в
     * составе строки.
     * Например, слова Ку...зьмич, Про...ли, ж...а из книги "Война и мир" разбиты не будут
     *
     * @param list Коллекция для редактирования
     */
    public static void checkAndSplitByDots(List<String> list) {

        int size = list.size();
        int index;

        for (int i = 0; i < size; i++) {

            String word = list.get(i);
            if ((index = word.indexOf('.')) != -1 && list.get(i).charAt(index + 1) != '.') {

                list.remove(i);
                list.add(i, word.substring(0, index));
                list.add(word.substring(index + 1));
                size++;
            }
        }
    }
}