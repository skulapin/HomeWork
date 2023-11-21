package home_work_5.utils;

import java.util.Collection;
import java.util.Iterator;

/**
 * Утилита для итерирования коллекций
 */
public class IteratorUtils {

    /**
     * Производит итерацию коллекции при помощи iterator
     *
     * @param <T>        Тип коллекции
     * @param collection Коллекция
     */
    public static <T> void iterateWithIterator(Collection<T> collection) {

        Iterator<T> iterator = collection.iterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
    }

    /**
     * Производит итерацию коллекции при помощи цикла For
     *
     * @param <T>        Тип коллекции
     * @param collection Коллекция
     */
    public static <T> void iterateWithCycleFor(Collection<T> collection) {

        for (int i = 0; i < collection.size(); i++) {

        }
    }
}