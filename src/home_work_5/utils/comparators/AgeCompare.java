package home_work_5.utils.comparators;

import java.util.Comparator;

import home_work_5.dto_classes.Animal;

/**
 * Comparator для сортировки объектов типа Animal в порядке увеличения возраста
 */
public class AgeCompare implements Comparator<Animal> {

    @Override
    public int compare(Animal o1, Animal o2) {

        if (o2 == null) {
            return -1;
        }
        if (o1 == null) {
            return 1;
        }
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}