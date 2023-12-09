package home_work_6;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import home_work_6.api.ISearchEngine;
import home_work_6.callable.WordSearchJob;
import home_work_6.search_engines.EasySearch;
import home_work_6.utils.FileUtils;

/*
 * 8. Написать новый класс с точкой входа. При запуске программы пользователь должен передать адрес папки, из которой мы
 * будет считывать текстовые файлы. После запуска пользователь указывает что он хочет найти в этих текстах. После каждого
 * ввода осуществляется поиск. Вводит пока не надоест. Поиск выполняется многопоточно. Один файл – одно задание для поиска.
 * Задания помещаются в ExecutorService. Результат всех его поисков должен накапливаться в файла result.txt в формате
 * «Имя файла – слово – количество». После заверщение обработки всех книг вывести записанные результаты в файла result.txt;
 */
public class WordFinderMultiThreadRunner {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        int booksListSize;
        String path;
        String bookText;
        String word;
        String resultFile = "result.txt";

        List<String> booksList;
        ISearchEngine searchEngine = new EasySearch();
        Scanner sc = new Scanner(System.in);
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        CountDownLatch latch;

        System.out.print("Введите адрес папки с книгами: ");

        while (true) {
            path = sc.next();
            //path = "D:\\Java\\IT-Academy\\Md-JC1-138-23\\Workspase_JC1\\Md-JC1-138-23\\HomeWork\\src\\home_work_6\\books\\";
            if (path.endsWith("\\")) {
                break;
            }
            System.out.print("Для корректной работы программы путь должен заканчиваться на \"\\\"\nВведите адрес папки с книгами: ");
        }

        booksList = FileUtils.getFilesList(path, ".txt");
        booksListSize = booksList.size();

        if (!booksList.isEmpty()) {
            while (true) {

                System.out.print("Вводите слова, которое хотите найти в книге. Для выхода из программы введите 'q'\n->");

                word = sc.next();
                latch = new CountDownLatch(booksListSize);
                List<Future<Long>> futures = new ArrayList<>();

                if ("q".equals(word)) {
                    System.out.println("Программа завершена!");
                    executorService.shutdown();
                    return;
                }

                for (String bookName : booksList) {
                    bookText = null;
                    try {
                        bookText = FileUtils.readFromFile(path + bookName, " ");
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    } finally {
                        futures.add(executorService.submit(new WordSearchJob(bookText, word, searchEngine, latch)));
                    }
                }

                latch.await();

                for (int i = 0; i < booksListSize; i++) {
                    try {
                        FileUtils.writeToFile(booksList.get(i) + " - " + word + " - " + futures.get(i).get(), resultFile);
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                }
                try {
                    System.out.println(FileUtils.readFromFile("result.txt", "\n"));
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        } else {
            System.out.println("В данной директории нет текстовых файлов. Программа завершена!");
        }
    }
}