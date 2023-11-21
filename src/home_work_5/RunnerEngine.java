package home_work_5;

import java.util.Collection;
import java.util.List;
import java.util.function.Supplier;

import home_work_5.dto_classes.Animal;
import home_work_5.dto_classes.Person;
import home_work_5.utils.IteratorUtils;
import home_work_5.utils.CollectionUtils;
import home_work_5.utils.comparators.AgeAndNickCompare;
import home_work_5.utils.comparators.AgeCompare;
import home_work_5.utils.comparators.PasswordLengthAndNickCompare;
import home_work_5.utils.comparators.PasswordLengthCompare;

/**
 * Класс для проведения операций согласно ДЗ_5
 */
public class RunnerEngine {

    /**
     * Прогоняет программу по проведению операций над переданной коллекцией. Заполнение коллекции, сортировка
     * итерирование, удаление элементов
     *
     * @param <T>        Дженерик коллекции
     * @param collection Коллекция
     * @param quantity   Количество элементов для добавления в коллекцию
     * @param supplier   Supplier для создания объектов типа T
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    public static <T> void run(Collection<T> collection, int quantity, Supplier<T> supplier) {

        long timeBefore;
        long timeAfter;
        T t = supplier.get();

        // Заполнение коллекции
        timeBefore = System.currentTimeMillis();
        CollectionUtils.fillCollection(collection, quantity, supplier);
        timeAfter = System.currentTimeMillis();

        System.out.println(getInformation("Заполнение коллекции",
                collection.getClass().getSimpleName(), quantity, timeAfter - timeBefore));

        // В Set может добавиться меньше элементов
        quantity = collection.size();

        // Сортировки коллекций List
        if (collection instanceof List) {

            if (t instanceof Person) {
                ((List) collection).sort(new PasswordLengthCompare());
                ((List) collection).sort(new PasswordLengthAndNickCompare());
            } else if (t instanceof Animal) {
                ((List) collection).sort(new AgeCompare());
                ((List) collection).sort(new AgeAndNickCompare());
            }
            CollectionUtils.sortCollection((List) collection);
        }

        // Итерирование коллекции итератором
        timeBefore = System.currentTimeMillis();
        IteratorUtils.iterateWithIterator(collection);
        timeAfter = System.currentTimeMillis();

        System.out.println(getInformation("Итерирование итератором коллекции",
                collection.getClass().getSimpleName(), quantity, timeAfter - timeBefore));

        // Итерирование коллекции циклом For
        timeBefore = System.currentTimeMillis();
        IteratorUtils.iterateWithCycleFor(collection);
        timeAfter = System.currentTimeMillis();

        System.out.println(getInformation("Итерирование циклом For коллекции",
                collection.getClass().getSimpleName(), quantity, timeAfter - timeBefore));

        // Удаление всех элементов коллекции
        timeBefore = System.currentTimeMillis();
        CollectionUtils.deleteAllElementsWithIterator(collection);
        timeAfter = System.currentTimeMillis();

        System.out.println(getInformation("Удаление при помощи итератора всех элементов коллекции",
                collection.getClass().getSimpleName(), quantity, timeAfter - timeBefore));

        System.out.println();

    }

    /**
     * Возвращает строку с описанием проведенной операции и затраченному времени
     *
     * @param operation      Название операции
     * @param collectionType Тип переданной коллекции
     * @param quantity       Количество элементов в коллекции
     * @param time           Затраченное время на проведение операции
     * @return Описание проведенной операции
     */
    private static String getInformation(String operation, String collectionType, int quantity, long time) {
        return "Операция: " + operation + " " + collectionType + " количеством элементов " + quantity + ". Заняла "
                + time + "мс";
    }
}