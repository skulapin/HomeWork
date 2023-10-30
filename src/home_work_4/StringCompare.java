package home_work_4;

import java.util.Comparator;

/**
 * Comparator для сортировки объектов типа String в порядке возрастания длины строки
 *
 * @author s.kulapin
 */
public class StringCompare implements Comparator<String> {

    /**
     * Возвращает 1, -1 или 0
     * 1 - o1 > o2 || o1 == null
     * -1 - o1.length < o2.length
     * 0 - o2 = null || o1.length == o2.length
     */
    @Override
    public int compare(String o1, String o2) {

        if (o2 == null) {
            return 0;
        }

        if (o1 == null || o1.length() > o2.length()) {
            return 1;
        } else if (o1.length() < o2.length()) {
            return -1;
        }
        return 0;
    }
}