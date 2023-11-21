package home_work_5.utils;

import java.util.Collection;
import java.util.List;
import java.util.function.Supplier;
import java.util.Iterator;

/**
 * Утилита для работы с коллекциями. Заполнение, сортировка, удаление элементов
 */
public class CollectionUtils {

    /**
     * Заполняет коллекцию заданным количеством элементов
     *
     * @param <T>        Тип коллекции
     * @param collection Коллекция
     * @param quantity   Количество элементов
     * @param supplier   Supplier для создания объектов типа T
     */
    public static <T> void fillCollection(Collection<T> collection, int quantity, Supplier<T> supplier) {

        for (int i = 1; i <= quantity; i++) {
            collection.add(supplier.get());
        }
    }

    /**
     * Сортирует переданную коллекцию
     *
     * @param <T>        Тип коллекции
     * @param collection Коллекция
     */
    public static <T extends Comparable<T>> void sortCollection(List<T> collection) {

        for (int i = 0; i < collection.size() - 1; i++) {

            T temp = collection.get(i);

            if (temp.compareTo(collection.get(i + 1)) > 0) {

                collection.remove(i);
                collection.add(i + 1, temp);
                i = -1;
            }
        }
    }

    /**
     * Удаляет все элементы коллекции при помощи iterator
     *
     * @param <T>        Тип коллекции
     * @param collection Коллекция
     */
    public static <T> void deleteAllElementsWithIterator(Collection<T> collection) {

        Iterator<T> iterator = collection.iterator();

        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }
    }

    /**
     * Удаляет все элементы коллекции при помощи цикла For
     *
     * @param <T>        Тип коллекции
     * @param collection Коллекция
     */
    public static <T> void deleteWithCycleFor(Collection<T> collection) {

        Object[] arr = collection.toArray();

        for (Object o : arr) {
            collection.remove(o);
        }
    }

    /**
     * Удаляет все элементы коллекции при помощи метода clear() класса Collection
     *
     * @param <T>        Тип коллекции
     * @param collection Коллекция
     */
    public static <T> void deleteWithMethod(Collection<T> collection) {
        collection.clear();
    }
}