package home_work_6.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

import home_work_6.api.ISearchEngine;

/**
 * Определяет чисто повторений слова в тексте
 */
public class WordSearchJob implements Callable<Long> {

    private final String bookText;
    private final String word;
    private final ISearchEngine engine;
    private final CountDownLatch latch;

    public WordSearchJob(String bookText, String word, ISearchEngine engine, CountDownLatch latch) {

        this.bookText = bookText;
        this.word = word;
        this.engine = engine;
        this.latch = latch;
    }

    /**
     * Находит и возвращает число повторений слова в тексте
     */
    @Override
    public Long call() {
        latch.countDown();
        return engine.search(bookText, word);
    }
}