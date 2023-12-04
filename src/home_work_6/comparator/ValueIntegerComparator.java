package home_work_6.comparator;

import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Компаратор для сравнения количества ключей
 */
public class ValueIntegerComparator implements Comparator<Map.Entry<String, Integer>> {

	@Override
	public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
		return o1.getValue() - o2.getValue();
	}
}