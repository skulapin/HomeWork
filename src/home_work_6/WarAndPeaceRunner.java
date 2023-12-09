package home_work_6;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

import home_work_6.api.ISearchEngine;
import home_work_6.comparator.KeyStringComparator;
import home_work_6.comparator.ValueIntegerComparator;
import home_work_6.search_engines.EasySearch;
import home_work_6.search_engines.RegExSearch;
import home_work_6.search_engines.SearchEngineCaseInsensitive;
import home_work_6.search_engines.SearchEngineCaseNormalizer;
import home_work_6.search_engines.SearchEnginePunctuationNormalizer;
import home_work_6.utils.CollectionUtils;
import home_work_6.utils.FileUtils;
import home_work_6.utils.ParseBookUtils;

/*
Задача на умение работать с: строками, Set, Map, регулярные выражения*, работа с файлами**.
В задаче запрещено использовать stream

Падежи, склонения, форма слова, опечатки, переносы и прочие проблемы текста - не ваша проблема! Вообще не думайте над
тем как исправить текст, думайте над правилами разбиения текста на слова.
Отдельно стоящие знаки препинания, пробелы и переводы строк - это не слова. Регистр в словах имеет значение.

На основании вопросов от студентов рассмотрим некоторые варианты текстов с вариантами разбиения на слова:
	1. "привет, как дела!" - тут три слова "привет", "как", "дела";
	2. "привет,какдела!" - тут два слова "привет", "какдела";
	3. "привет;какдела!" - тут два слова "привет", "какдела";
	4. "как дела!.Что делаешь?"- тут четыре слова "как", "дела", "Что", "делаешь";
	5. "Привет-привет" - тут одно слово "Привет-привет";
	6. "Привет -привет" - тут два слова "Привет", "привет";
	7. "4-х" - тут одно слово "4-х";
	8. "один и 1" - тут три слова "один", "и", "1"
	9. "бабушка бабушке бабушку" - тут три слова "бабушка", "бабушке", "бабушку"

Совет по выполнению данного ДЗ. Сначала воспользоваться "простым" правилом разбиения на слова. Например ориентируюсь по
пробелам. Выполнить подсчёт слов, отсортировать их и проверить что в целом всё остальное работает. А потом уже заниматься
усложнением правила разбиения в соответсвии с примерами написанными выше. Так вы более грамотно распределите своё время
на выполнение данного задания.

Война и мир:
1. Скачать книгу "Война и мир" https://www.dropbox.com/s/8mstiwnx9o9btw4/%D0%B2%D0%BE%D0%B9%D0%BD%D0%B0%20%D0%B8%20%D0%BC%D0%B8%D1%80_%D0%BA%D0%BD%D0%B8%D0%B3%D0%B0.txt?dl=0
на компьютер
2. Работа с коллекциями:
	2.1 Найти в тексте все использованные слова и поместить их в коллекцию Set.
		Более подробное описание задачи, для понимания чего я хочу: Для решения данной задачи необходимо прочитать
		текстовый файл и поместить текст из данного текстового файла в строку. Далее данную строку необходимо обработать
		таким образом чтобы из неё можно было бы считывать слова. Далее каждое полученное слово поместить в Set. Благодаря
		возможностям Set'ов в итоге мы получим коллекцию содержащую набор слов который был использован при написании
		данного текста. В конце выводим в консоль количество использованных слов.
	2.2 Найти в тексте топ N (настраиваемое значение) слов и вывести количество этих слов используя Map и List.
	Отсортировать по количеству. Распечатать в консоль.
		Пример: Война - 200 раз, Мир - 100 раз и так далее. Знаки препинания, пробелы и переводы строк - это не слова.
		Более подробное описание задачи, для понимания чего я хочу: Для решения данной задачи необходимо прочитать
		текстовый файл  и поместить текст из данного текстового файла в строку.  Далее данную строку необходимо
		обработать таким образом чтобы из неё можно было бы считывать слова. Далее каждое полученное слово поместить
		как ключ в Map, а количество повторений в тексте ставить как значение. Для того чтобы это работало вам
		необходимо постоянно проверять наличие ключа в Map, и если нужный нам ключ уже присутсвует в нашей коллекции то
		мы должны увеличить уже имеющееся значение в коллекции на еденицу. После наполнения данной коллекции мы получим
		набор слов и их количество в тексте. Далее нам нужно придумать как отсортировать получившуюся коллекцию но к
		сожалению непосредственно эту коллекцию отсортировать не получится, придётся создавать для этого List и наполнять
		лист Entry из Map. В итоге из получившегося отсортированного набора данных вывести первые N записей.
3. Написать интерфейс ISearchEngine. Это будет интерфейс в котором будут методы:
	3.1 long search(String text, String word) - Метод возвращает информации о количестве раз которое встречается слово
	в тексте. Первый параметр текст в котором ищем, второй параметр что ищем в тексте.
4. Реализовать интерфейс ISearchEngine:
	4.1 Написать класс EasySearch. Реализовать поиск используя метод indexOf из класса String. В данной реализации
	запрещено использовать регулярные выражения в любом виде, для любых задач. Данный класс ищет слова с учётом регистра.
	4.2* Написать класс RegExSearch реализующий интерфейс ISearchEngine. Реализовать поиск при помощи класса Matcher.
	Данный класс ищет слова с учётом регистра.
	4.3* Написать декоратор SearchEnginePunctuationNormalizer для ISearchEngine который будет удалять нежелательные
	символы. Любые знаки препинания, лишние пробелы и например переводы строк.
	4.4* Написать декоратор для ISearchEngine который будет позволять искать данные без учёта регистра.
		Более подробное описание задачи, для понимания чего я хочу:  Тут можно пойти на хитрость, данный класс может
		просто приводить весь текст и передаваемое слово к нижнему регистру но тут возникает вопрос как данный класс
		может помочь для RegExSearch. Класс RegExSearch в своей реализации использует регулярные выражения и в случае с
		регулярными выражениями есть возможность указать свойство CASE_INSENSITIVE для выражение и оно и так станет не
		чувствительно к регистру. Для того чтобы тут что-то оптимизировать можно воспользоваться оператором instanceof и
		вычислить таки какого класса нам передали объект ISearchEngine. Данная практика является нежелательной но при
		этом в некоторых случаях очень эффективной.
	4.5** Написать декоратор SearchEngineCaseNormalizer для ISearchEngine который будет приводит все слова к единому
	падежу. Что позволит учитывать их как одинаковые слова. Например после работы данного класса текст "бабушка бабушке
	бабушку" уже будет выдавать: "бабушка - 3". Падеж можно настроить при помощи конструктора.
5. Используя реализации интерфейса ISearchEngine вывести информацию как часто встречаются слова "война", "и" (как союз),
   "мир".
	5.1 Как есть.
	5.2* Вне зависимости от регистра.

Далее задания выполнять только после прохождения темы "Работа с файлами"
7. Написать новый класс с точкой входа. При запуске программы пользователь должен передать адрес папки, из которой мы
    будет считывать текстовые файлы. Наполнить данную директорию книгами, 100 книг мнинимум. При запуске пользователю в
    консоль выдать список txt файлов и предложить выбрать файл, с которым мы будем работать. Пользователь, выбрав файл
    вводит то, что он хочет найти в этом файле. После каждого ввода осуществляется поиск. Вводит пока не надоест.
    Пользователь может вернуться к выбору файла. Результат всех его поисков должен накапливаться в файла result.txt в
    формате «Имя файла – слово – количество». Тестируем.
 */

public class WarAndPeaceRunner {

    public static void main(String[] args) {

        char[] charToDelete = {'.', '-', '<'};
        String book = null;
        String bookName = "Война и мир_книга.txt";
        String word1 = "война";
        String word2 = "и";
        String word3 = "мир";
        String[] splitters = {"\n", " ", ",", "\\)", "\\(", "\\?", "!", ";", ":", "\\*", "\"", "--"};
        String[] wordsToDelete = {"--", "-", ".", "..", "...", "="};

        List<String> wordsList;
        Set<String> wordsSet;
        Map<String, Integer> wordsMap;
        List<Entry<String, Integer>> wordsNumberList = new ArrayList<>();

        ISearchEngine engine1 = new EasySearch();
        ISearchEngine engine2 = new RegExSearch();
        ISearchEngine engine3 = new SearchEnginePunctuationNormalizer(engine1);
        ISearchEngine engine4 = new SearchEngineCaseInsensitive(engine3);
        ISearchEngine engine5 = new SearchEngineCaseNormalizer(engine1);

        try {
            book = FileUtils.readFromFile(bookName, " ");
        } catch (IOException e) {
            System.out.println("Произошла ошибка: " + e);
        }

        wordsList = ParseBookUtils.splitStringToList(book, splitters);
        ParseBookUtils.deleteWordsFromList(wordsList, wordsToDelete);
        ParseBookUtils.deleteFirstCharacter(wordsList, charToDelete);
        ParseBookUtils.deleteLastCharacter(wordsList, charToDelete);
        ParseBookUtils.checkAndSplitByDots(wordsList);

        wordsSet = new TreeSet<>(wordsList);

        wordsMap = CollectionUtils.listToMap(wordsList);

        wordsNumberList.addAll(wordsMap.entrySet());
        wordsNumberList.sort(new ValueIntegerComparator().reversed().thenComparing(new KeyStringComparator()));

        System.out.println("Cлова в сете содержащие символы, за исключением '-' :");
        for (String s : wordsSet) {
            for (int i = 0; i < s.length(); i++) {
                if (!Character.isAlphabetic(s.charAt(i)) && !Character.isDigit(s.charAt(i)) && s.charAt(i) != '-') {
                    System.out.println(s);
                    break;
                }
            }
        }

        System.out.println("Количество символов в книге " + book.length());
        System.out.println("Длина листа " + wordsList.size());
        System.out.println("Длина сета " + wordsSet.size());
        System.out.println("Длина мапы " + wordsMap.size());

        System.out.println(CollectionUtils.getFirstElementsFromList(wordsNumberList, 20));

        System.out.println("Слово \"" + word1 + "\" встречается " + wordsMap.get(word1) + " раз в мапе");
        System.out.println("Слово \"" + word2 + "\" встречается " + wordsMap.get(word2) + " раз в мапе");
        System.out.println("Слово \"" + word3 + "\" встречается " + wordsMap.get(word3) + " раз в мапе");
        System.out.println();

        System.out.println(getWordNumber(engine1, book, word1));
        System.out.println(getWordNumber(engine2, book, word1));
        System.out.println(getWordNumber(engine3, book, word1));
        System.out.println(getWordNumber(engine4, book, word1));
        System.out.println(getWordNumber(engine5, book, word1));
        System.out.println();
        System.out.println(getWordNumber(engine1, book, word2));
        System.out.println(getWordNumber(engine2, book, word2));
        System.out.println(getWordNumber(engine3, book, word2));
        System.out.println(getWordNumber(engine4, book, word2));
        System.out.println(getWordNumber(engine5, book, word2));
        System.out.println();
        System.out.println(getWordNumber(engine1, book, word3));
        System.out.println(getWordNumber(engine2, book, word3));
        System.out.println(getWordNumber(engine3, book, word3));
        System.out.println(getWordNumber(engine4, book, word3));
        System.out.println(getWordNumber(engine5, book, word3));
    }

    private static String getWordNumber(ISearchEngine engine, String text, String word) {

        StringBuilder builder = new StringBuilder();

        builder.append("Слово \"" + word + "\" встречается " + engine.search(text, word) + " раз при поиске классом "
                + engine.getClass().getSimpleName());

        if (engine instanceof SearchEngineCaseInsensitive) {
            builder.append(" вне зависимости от регистра");
        }
        if (engine instanceof SearchEngineCaseNormalizer) {
            builder.append(" вне зависимости от падежа");
        }
        return builder.toString();
    }
}