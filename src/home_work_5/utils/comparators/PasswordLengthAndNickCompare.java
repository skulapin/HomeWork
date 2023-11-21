package home_work_5.utils.comparators;

import java.util.Comparator;

import home_work_5.dto_classes.Person;

/**
 * Comparator для сортировки объектов типа Person в порядке увеличения длины
 * пароля пользователей. При одинаковой длине пароля сортирует коллекцию по
 * псевдонимам пользователей в алфавитном порядке
 */
public class PasswordLengthAndNickCompare implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {

        if (o2 == null) {
            return -1;
        }

        if (o1 == null) {
            return 1;
        }

        int passwordLengthCompare = new PasswordLengthCompare().compare(o1, o2);

        if (passwordLengthCompare != 0) {
            return passwordLengthCompare;
        }
        return o1.getNick().compareTo(o2.getNick());
    }
}