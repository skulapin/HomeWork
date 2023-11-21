package home_work_5.utils;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/**
 * Утилита для генерации строк
 */
public class GenerateStringUtils {

    private static List<Character> rusLetters;
    private static List<Character> engLetters;

    /**
     * Генерирует строку из символов таблицы ASCII заданной длины
     *
     * @param length Длина строки
     * @return Строка из символов таблицы ASCII
     */
    public static String getRandomString(int length) {

        StringBuilder builder = new StringBuilder();

        for (int i = 1; i <= length; i++) {
            builder.append((char) (Math.random() * 127 + 1));
        }
        return builder.toString();
    }

    /**
     * Генерирует строку из букв русского алфавита заданной длины
     *
     * @param length Длина строки
     * @return Строка из букв русского алфавита
     */
    public static String getRandomStringFromRusLetters(int length) {

        StringBuilder builder = new StringBuilder();

        if (rusLetters == null) {

            rusLetters = new ArrayList<Character>();

            // символ Ё (1025)
            addCharactersToList(rusLetters, 1025, 1025);
            // символы а-я, А-Я (1040-1103)
            addCharactersToList(rusLetters, 1040, 1103);
            // символ ё (1105)
            addCharactersToList(rusLetters, 1105, 1105);
        }

        for (int i = 1; i <= length; i++) {
            builder.append(rusLetters.get((int) (Math.random() * rusLetters.size())));
        }
        return builder.toString();
    }

    /**
     * Генерирует строку из букв английского алфавита заданной длины
     *
     * @param length Длина строки
     * @return Строка из букв английского алфавита
     */
    public static String getRandomStringFromEngLetters(int length) {

        StringBuilder builder = new StringBuilder();

        if (engLetters == null) {

            engLetters = new ArrayList<Character>();

            // символы A-Z (65-90)
            addCharactersToList(engLetters, 65, 90);
            // символы a-z (97-122)
            addCharactersToList(engLetters, 97, 122);

        }

        for (int i = 1; i <= length; i++) {
            builder.append(engLetters.get((int) (Math.random() * engLetters.size())));
        }
        return builder.toString();
    }

    /**
     * Возвращает случайную строку из переданного массива строк
     *
     * @param names Массив строк
     * @return Случайная строка из массива
     */
    public static String getRandomStringFromArray(String[] names) {

        int name = (int) (Math.random() * names.length);
        return names[name];
    }

    /**
     * Возвращает случайную строку из содержимого переданного файла. Содержимое
     * файла должно разделяться через перенос строки (\n)
     *
     * @param fileName Название файла
     * @return Случайная строка из файла
     * @throws IOException Ошибка IOException
     */
    public static String getRandomStringFromFile(String fileName) throws IOException {

        StringBuilder builder = new StringBuilder();
        int reader;
        String[] names;

        Reader input = new FileReader(fileName);

        while ((reader = input.read()) != -1) {
            builder.append((char) reader);
        }

        input.close();

        names = builder.toString().split("\\r?\\n");

        return getRandomStringFromArray(names);
    }

    /**
     * Добавляет в переданную коллекцию символы заданного диапазона
     *
     * @param collection Коллекция для заполнения
     * @param from       Начало диапазона
     * @param to         Конец диапазона
     */
    private static void addCharactersToList(List<Character> collection, int from, int to) {
        for (int i = from; i <= to; i++) {
            collection.add((char) i);
        }
    }
}