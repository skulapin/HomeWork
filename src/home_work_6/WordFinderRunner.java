package home_work_6;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import home_work_6.api.ISearchEngine;
import home_work_6.search_engines.EasySearch;
import home_work_6.utils.CollectionUtils;
import home_work_6.utils.FileUtils;

/*
 *Далее задания выполнять только после прохождения темы "Работа с файлами"
7. Написать новый класс с точкой входа. При запуске программы пользователь должен передать адрес папки, из которой мы
* будет считывать текстовые файлы. Наполнить данную директорию книгами, 100 книг мнинимум. При запуске пользователю в
* консоль выдать список txt файлов и предложить выбрать файл, с которым мы будем работать. Пользователь, выбрав файл
* вводит то, что он хочет найти в этом файле. После каждого ввода осуществляется поиск. Вводит пока не надоест.
* Пользователь может вернуться к выбору файла. Результат всех его поисков должен накапливаться в файла result.txt в
* формате «Имя файла – слово – количество». Тестируем.
 */

public class WordFinderRunner {
    public static void main(String[] args) {

        long quantity;
        String path;
        String bookName;
        String bookText;
        String word;
        String resultFile = "result.txt";

        List<String> booksList;
        ISearchEngine searchEngine = new EasySearch();
        Scanner sc = new Scanner(System.in);

        System.out.print("Введите адрес папки с книгами: ");

        while (true) {
            path = sc.next();
            //path = "D:\\Java\\IT-Academy\\Md-JC1-138-23\\Workspase_JC1\\Md-JC1-138-23\\HomeWork\\src\\home_work_6\\books\\";
            if (path.endsWith("\\")) {
                break;
            }
            System.out.print("Для корректной работы программы путь должен заканчиваться на \"\\\""
                    + "\nВведите адрес папки с книгами: ");
        }

        booksList = FileUtils.getFilesList(path, ".txt");

        if (!booksList.isEmpty()) {
            while (true) {
                System.out.println("Список книг:\n" + CollectionUtils.getStringRepresentation(booksList));
                System.out.print("Выберите книгу из списка. Для выхода из программы введите 'q'\n->");

                while (true) {

                    bookName = sc.next();

                    if ("q".equals(bookName)) {
                        System.out.println("Программа завершена!");
                        return;
                    }
                    if (booksList.contains(bookName)) {
                        try {
                            bookText = FileUtils.readFromFile(path + bookName);
                            break;
                        } catch (IOException e) {
                            System.out.println(e);
                            System.out.println("Данной кники нет в папке, повторите ввод:");
                        }
                    }
                }

                System.out.print(
                        "Вводите слова, которое хотите найти в книге. Для возврата к выбору книг введите 'q'\n->");

                while (!"q".equals(word = sc.next())) {

                    quantity = searchEngine.search(bookText, word);

                    System.out.println(
                            "Слово \"" + word + "\" встречается в книге " + bookName + " " + quantity + " раз");

                    try {
                        if (FileUtils.writeToFile(bookName + " - " + word + " - " + quantity, resultFile)) {
                            System.out.println("Результат успешно записан в файл");
                        }
                    } catch (IOException e) {
                        System.out.println(e);
                    }
                    System.out.print("->");
                }
            }
        } else {
            System.out.println("В данной директории нет текстовых файлов. Программа завершена!");
        }
    }
}