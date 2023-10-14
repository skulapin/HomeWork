package home_work_3.calcs.additional;

import home_work_3.calcs.simple.CalculatorWithMathExtends;

/* 6. Создать класс CalculatorWithCounterAutoSuper.
	6.1 Все методы и поля объявленные в данном классе НЕ статические (не имеют модификатор static).
	6.2 Данный класс наследует класс CalculatorWithMathExtends.
	6.3 Данный класс переопределяет все методы полученные в результате наследования и в этих методах должен быть
	реализован механизм учёта их использования (учёт общий для всех методов класса), а вместо реализации математики при
	помощи ключевого слова super вызывает данный метод у родителя. Например вызвали метод plus(7, 3) который должен
	сложить два числа и вернуть результат сложения. Внутри метода plus() пишем реализацию учета, а после делаем вызов
	super.plus(7, 3). Использование super позволит вызвать реализацию из родительского класса.
	6.4 В классе должен быть метод long getCountOperation() который должен возвращать количество использований данного
	калькулятора. При вызове данного метода счётчик учёта не увеличивается.
 */

/**
 * Содержит методы базовых математических операций (сложение, вычитание, умножение, деление, возведение числа в степень,
 * модуль числа, квадратный корень из числа) и автоматический счетчик количества использований математических операций.
 */
public class CalculatorWithCounterAutoSuper extends CalculatorWithMathExtends {

	/**
	 * Количество использований математических методов класса
	 */
	private long counter = 0;

	/**
	 * Производит операцию сложение
	 *
	 * @param number1 Первое слагаемое
	 * @param number2 Второе слагаемое
	 * @return Результат сложения друх чисел
	 */
	public double add(double number1, double number2) {
		counter++;
		return super.add(number1, number2);
	}

	/**
	 * Производит операцию вычитание
	 *
	 * @param number1 Уменьшаемое
	 * @param number2 Вычитаемое
	 * @return Разность двух чисел
	 */
	public double subtract(double number1, double number2) {
		counter++;
		return super.subtract(number1, number2);
	}

	/**
	 * Производит операцию умножение
	 *
	 * @param number1 Первый множитель
	 * @param number2 Второй множитель
	 * @return Результат умножения двух чисел
	 */
	public double multiply(double number1, double number2) {
		counter++;
		return super.multiply(number1, number2);
	}

	/**
	 * Производит операцию деление
	 *
	 * @param number1 Делимое
	 * @param number2 Делитель
	 * @return Результат деления двух чисел (частное)
	 */
	public double divide(double number1, double number2) {
		counter++;
		return super.divide(number1, number2);
	}

	/**
	 * Производит операцию возведения числа в степень. Основание должно быть положительным числом.
	 *
	 * @param number1 Основание
	 * @param number2 Степень числа
	 * @return Результат операции возведения числа в степень
	 */
	public double pow(double number1, int number2) {
		counter++;
		return super.pow(number1, number2);
	}

	/**
	 * Приведение числа к абсолютному значению (модуль числа)
	 *
	 * @param number Приводимое к абсолютному значению число
	 * @return Абсолютное значение числа
	 */
	public double abs(double number) {
		counter++;
		return super.abs(number);
	}

	/**
	 * Операция нахождения квадратного корня числа
	 *
	 * @param number Неотрицательное вещественное число
	 * @return Квадратный корень из числа
	 */
	public double sqrt(double number) {
		counter++;
		return super.sqrt(number);
	}

	/**
	 * Возвращает число использования методов математических операций
	 *
	 * @return Количество использования методов математических операций
	 */
	public long getCountOperation() {
		return counter;
	}
}