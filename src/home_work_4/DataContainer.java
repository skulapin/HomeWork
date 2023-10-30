package home_work_4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

/**
 * Задание:
 * 1. Создать класс DataContainer у которого есть один дженерик (обобщение). Например литерал T. Данный класс как раз и
 * будет решать задачу поставленную перед нами: хранить неограниченное количество передаваемых объектов обобщённого типа.
 * 2. Внутри DataContainer должно быть поле T[] data, внутренний массив, которое предназначено для хранения передаваемых
 * объектов. Да, именно T[] а не Object[]. Если использовать Object[] то это будет опасно и постоянно придётся делать
 * приведеление типов. Поле обязательно не static и private
 * 3. Из-за особенностей дженериков в данном классе обязательно будет присутствовать один конструктор DataContainer(T[]).
 * Есть и другие способы, но в рамках обучения они будут сложными и с ними мы разбираться будем слишком сложно.
 * 4. В данном классе должен быть метод int add(T item) который добавляет данные во внутреннее поле data и возвращает
 * номер позиции в которую были вставлены данные, начиная с 0.
 * 4.1 Если поле data не переполнено то данные нужно добавлять в первую позицию (ячейку) после последней заполненной
 * позиции (ячейки).
 * 4.1.1 Пример: data = [1, 2, 3, null, null, null]. Вызвали add(777). Должно получиться data = [1, 2, 3, 777, null, null].
 * Метод add вернёт число 3.
 * 4.1.2 Пример: data = [1, 2, 3, null, null, null]. Вызвали add(null). Должно получиться data = [1, 2, 3, null, null, null].
 * Метод add вернёт число -1. -1 будет индикатором того что данный элемент в наш контейнер вставлять нельзя.
 * 4.1.3 Пример: data = [1, null, 3, null, null, null]. Вызвали add(777). Должно получиться data = [1, 777, 3, null, null, null].
 * Метод add вернёт число 1.
 * 4.2 В случае если поле data переполнено, нужно придумать механизм который будет расширять пространство для новых
 * элементов. Тут вам поможет Arrays.copyOf.
 * 4.2.1 Пример: data = [1, 2, 3]. Вызвали add(777). Должно получиться data = [1, 2, 3, 777]. Метод add вернёт число 3.
 * 4.2.2 Пример: data = []. Вызвали add(777). Должно получиться data = [777]. Метод add вернёт число 0.
 * 5. В данном классе должен быть метод T get(int index). Данный метод получает из DataContainer'а, из поля data,
 * предварительно сохранённый объект который мы передали на предыдущем шаге через метод add.
 * 5.1 Пример: data = []. Вызвали add(9999). Получили data = [9999]. Метод add вернул число 0. Вызываем get(0).
 * Метод get возвращает 9999
 * 5.2 Пример: data = [9999]. Вызываем get(1). Метод get возвращает null
 * 6. В данном классе должен быть метод T[] getItems(). Данный метод возвращает массив из поля data.
 * 7. Добавить метод boolean delete(int index) который будет удалять элемент из нашего поля data по индексу.
 * 7.1 Метод возвращает true если у нас получилось удалить данные.
 * 7.1.1 Пример data = [1, 2, 3, 777]. Вызывают delete(3). Должно получиться data = [1, 2, 3]. Метод delete вернёт true
 * 7.2 Метод возвращает false если нет такого индекса.
 * 7.2.1 Пример data = [1, 2, 3, 777]. Вызывают delete(9). Должно получиться data = [1, 2, 3, 777]. Метод delete вернёт false
 * 7.3. Освободившуюся ячейку в поеле data необходимо удалить полностью. Пустых элементов не должно быть.
 * 7.3.1 Пример data = [1, 2, 3, 777]. Вызывают delete(2). Должно получиться data = [1, 2, 777]. Метод delete вернёт true
 * 8. Добавить метод boolean delete(T item) который будет удалять элемент из нашего поля data.
 * 8.1 Метод возвращает false если передают null.
 * 8.1.1 Пример data = [1, 2, 3, 777]. Вызывают delete(null). Метод delete вернёт false a data = [1, 2, 3, 777]
 * 8.1.2 Пример data = [1, 2, 3, 777, null]. Вызывают delete(null). Метод delete вернёт false a data = [1, 2, 3, 777, null]
 * 8.2 Метод возвращает true если у нас получилось удалить данные.
 * 8.2.1 Пример data = [1, 2, 3, 777]. Вызывают delete(777). Должно получиться data = [1, 2, 3]. Метод delete вернёт true
 * 8.3 Метод возвращает false если нет такого элемента.
 * 8.3.1 Пример data = [1, 2, 3, 777]. Вызывают delete(111). Должно получиться data = [1, 2, 3, 777]. Метод delete вернёт false
 * 8.4 Освободившуюся ячейку необходимо удалить полностью. Пустых элементов не должно быть.
 * 8.4.1 Пример data = [1, 2, 3, 777, 3]. Вызывают delete(3). Должно получиться data = [1, 2, 777, 3]. Метод delete вернёт true
 * 9. Добавить НЕ СТАТИЧЕСКИЙ метод void sort(Comparator<.......> comparator). Данный метод занимается сортировкой данных
 * записанных в поле data используя реализацию сравнения из ПЕРЕДАННОГО объекта comparator. Классом Arrays пользоваться
 * запрещено. Интефейс Comparator обязательно должен быть реализован отдельным классом. Для каждого типа данных и
 * сравнений программист создаёт отдельную реализацию интерфейса Comparator.
 * 9.1 Пример data = [3, 1, 3, 777]. Вызывают sort(....) передавая компаратор чисел. Должно получиться data = [1, 3, 3, 777]
 * 9.2 Пример data = ["i", "hello", "1", "Как домашка"]. Вызывают sort(....) передавая компаратор строк по длинне.
 * Должно получиться data = ["i", "1", "hello", "Как домашка"]
 * 10. Переопределить метод toString() в классе и выводить содержимое data без ячеек в которых хранится null.
 * 10.1 Пример data = [1, 2, 3, 777, 3]. Вызывают toString() у созданного DataContainer. Возвращается строка [1, 2, 3, 777, 3]
 * 10.2 Пример data = [1, 2, 3, null]. Вызывают toString() у созданного DataContainer. Возвращается строка [1, 2, 3]
 * 10.3 Пример data = []. Вызывают toString() у созданного DataContainer. Возвращается строка []
 * 11.* В DataContainer добавить СТАТИЧЕСКИЙ метод void sort(DataContainer<.............> container) с дженериком extends
 * Comparable. Данный метод будет сортировать элементы в ПЕРЕДАННОМ объекте DataContainer используя реализацию сравнения
 * вызываемый у хранимых объектов. Для этого надо сделать дженерик метод.
 * 12.* В DataContainer добавить СТАТИЧЕСКИЙ метод void sort(DataContainer<.............> container, Comparator<.......> comparator)
 * который будет принимать объект DataContainer и реализацию интерфейса Comparator. Данный метод будет сортировать
 * элементы в ПЕРЕДАННОМ объекте DataContainer используя реализацию сравнения из ПЕРЕДАННОГО объекта интерфейса Comparator.
 * 13.** Реализовать в DataContainer интерфейс Iterable
 */

/**
 * Класс может сохранять в себе почти любое количество данных обобщённого типа (GENERIC)
 *
 * @param <T> Тип хранимых данных
 * @author s.kulapin
 */
public class DataContainer<T> implements Iterable<T> {

    /**
     * Массив в котором хранятся данные
     */
    private T[] data;

    /**
     * Конструктор класса
     *
     * @param data Массив данных неопределенного типа
     */
    public DataContainer(T[] data) {
        this.data = data;
    }

    /**
     * Добавляет данные во внутреннее поле класса и возвращает номер ячейки массива, куда были помещены данные
     *
     * @param item Переданные данные
     * @return Номер позиции
     */
    public int add(T item) {

        if (item == null) {
            return -1;
        }

        for (int i = 0; i < data.length; i++) {
            if (data[i] == null) {
                data[i] = item;
                return i;
            }
        }
        data = Arrays.copyOf(data, data.length + 1);
        data[data.length - 1] = item;
        return data.length - 1;
    }

    /**
     * Возвращает данные из массива по номеру ячейки
     *
     * @param index Номер ячейки, откуда взять данные
     * @return Данные из массива
     */
    public T get(int index) {

        if (index >= data.length || index < 0) {
            return null;
        }
        return data[index];
    }

    /**
     * Возвращает массив данных
     *
     * @return Массив данных
     */
    public T[] getItems() {
        return this.data;
    }

    /**
     * Удаляет элемент из массива по переданному индексу ячейки и удаляет пустую ячейку из массива при успешном поиске
     * подходящей ячейки. Возвращает true/false в зависимости от успешности произведенного действия
     *
     * @param index Номер ячейки
     * @return true - Удаление прошло успешно, false - осуществить удаление не получилось
     */
    public boolean delete(int index) {

        if (index >= data.length || index < 0) {
            return false;
        }

        T[] temp = Arrays.copyOf(data, data.length - 1);

        for (int i = 0, j = 0; i < data.length; i++, j++) {

            if (i == index) {
                j--;
                continue;
            }

            temp[j] = data[i];
        }
        data = temp;
        return true;
    }

    /**
     * Ищет и удаляет элемент из массива по переданному значению данных и удаляет пустую ячейку из массива при успешном
     * поиске подходящей ячейки. Возвращает true/false в зависимости от успешности произведенного действия
     *
     * @param item Данные которые необходимо удалить
     * @return True - удаление прошло успешно, false - осуществить удаление не получилось
     */
    public boolean delete(T item) {

        if (item == null || data.length == 0) {
            return false;
        }

        boolean itemFound = false;

        T[] temp = Arrays.copyOf(data, data.length - 1);

        for (int i = 0, j = 0; i < data.length; i++, j++) {
            if (data[i] != null && data[i].equals(item) && !itemFound) {
                itemFound = true;
                j--;
                continue;
            }
            // исключаем вызов несуществующей ячейки в массиве temp на последней итерации
            // при отсутствии совпадений
            if (i == data.length - 1 && !itemFound) {
                return false;
            }
            temp[j] = data[i];
        }

        if (itemFound) {
            data = temp;
            return true;
        }
        return false;
    }

    /**
     * Сортирует хранимые данные используя реализацию сравнения из переданного объекта компаратора.
     *
     * @param comparator Реализация объекта компаратора
     */
    public void sort(Comparator<T> comparator) {

        for (int i = 0; i < data.length - 1; i++) {

            int comparatorResult = comparator.compare(data[i], data[i + 1]);

            if (comparatorResult == 1) {

                T temp;

                temp = data[i];
                data[i] = data[i + 1];
                data[i + 1] = temp;
                i = 0;
            }
        }
    }

    /**
     * Переопределенный метод toString. Возвращает строковое значение хранящихся элементов
     */
    @Override
    public String toString() {

        StringBuilder result = new StringBuilder();
        boolean firstElementAdded = false;

        result.append("[");

        for (int i = 0; i < data.length; i++) {

            if (data[i] != null) {
                if (firstElementAdded) {
                    result.append(", ");
                }
                result.append(data[i]);
                firstElementAdded = true;
            }
        }
        result.append("]");

        return result.toString();
    }

    /**
     * Сортирует хранимые данные используя реализацию сравнения вызываемый у хранимых объектов
     *
     * @param <T>       Тип хранимых данных
     * @param container Объект с данными
     */
    public static <T extends Comparable<? super T>> void sort(DataContainer<T> container) {

        int length = container.getItems().length;
        T[] tempArray = Arrays.copyOf(container.getItems(), length);

        for (int i = 0; i < length - 1; i++) {

            if (tempArray[i + 1] != null) {
                int comparatorResult = tempArray[i].compareTo(tempArray[i + 1]);

                if (comparatorResult == 1) {

                    T temp;
                    temp = tempArray[i];
                    tempArray[i] = tempArray[i + 1];
                    tempArray[i + 1] = temp;
                    i = 0;
                }
            }
        }

        for (int i = 0; i < length; i++) {
            container.delete(0);
        }

        for (int i = 0; i < length; i++) {
            if (tempArray[i] != null) {
                container.add(tempArray[i]);
            }
        }
    }

    /**
     * Соритирует хранимые данные в переданном объекте используя реализацию сравнения из переданного объекта интерфейса
     * Comparator
     *
     * @param <T>        Тип хранимых данных
     * @param container  Объект с данными
     * @param comparator Реализация объекта компаратора
     */
    public static <T> void sort(DataContainer<T> container, Comparator<T> comparator) {
        container.sort(comparator);
    }

    /**
     * Переопределенный метод iterator. Возвращает объект типа DataContainerIterator
     */
    @Override
    public Iterator<T> iterator() {

        return new DataContainerIterator();
    }

    /**
     * Реализация класса имплементирующего интерфейс Iterator
     *
     * @author s.kulapin
     */
    class DataContainerIterator implements Iterator<T> {

        /**
         * Номер позиции итерации
         */
        int current;

        /**
         * Переопределенный метод hasNext интерфейса Iterator. Возвращает true/false в зависимости от нахождения поля
         * класса current внутри диапазона ячеек массива
         */
        @Override
        public boolean hasNext() {
            return current < data.length;
        }

        /**
         * Переопределеннй метод next интерфейса Iterator. Возвращает значение ячейки массива
         */
        @Override
        public T next() {

            return data[current++];
        }
    }
}