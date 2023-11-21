package home_work_5.utils.comparators;

import java.util.Comparator;

import home_work_5.dto_classes.Person;

/**
 * Comparator для сортировки объектов типа Person в порядке увеличения длины пароля пользователей
 */
public class PasswordLengthCompare implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {

        if (o2 == null) {
            return -1;
        }
        if (o1 == null) {
            return 1;
        }

        int o1Length = o1.getPassword().length();
        int o2Length = o2.getPassword().length();

        if (o1Length > o2Length) {
            return 1;
        } else if (o1Length < o2Length) {
            return -1;
        }
        return 0;
    }
}