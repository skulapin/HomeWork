package home_work_5.utils.comparators;

import java.util.Comparator;

import home_work_5.dto_classes.Animal;

/**
 * Comparator для сортировки объектов типа Animal в порядке увеличения возраста.
 * При одинаковом возрасте сортирует коллекцию по кличкам в алфавитном порядке
 */
public class AgeAndNickCompare implements Comparator<Animal> {

    @Override
    public int compare(Animal o1, Animal o2) {

        if (o2 == null) {
            return -1;
        }

        if (o1 == null) {
            return 1;
        }

        int ageCompare = new AgeCompare().compare(o1, o2);

        if (ageCompare != 0) {
            return ageCompare;
        }
        return o1.getNick().compareTo(o2.getNick());
    }
}