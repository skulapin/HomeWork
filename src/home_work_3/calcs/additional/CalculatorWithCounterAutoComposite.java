package home_work_3.calcs.additional;

import home_work_3.calcs.simple.CalculatorWithMathCopy;

/* 7. Создать класс CalculatorWithCounterAutoComposite.
	7.1 Все методы и поля объявленные в данном классе НЕ статические (не имеют модификатор static).
	7.2 Внутри класса мы должны создавать поле хранящее объект класса калькулятор. Для примера можно использовать любой
	тип калькулятора. Я возьму для примера CalculatorWithMathCopy
	7.3 Инициализировать данное поле созданным (использовать new) внутри данного класса объектом калькулятора.
	7.4 Данный класс напрямую не умеют считать математику, он умеют делегировать расчёт математики калькулятору который
	сохранён в его поле.
	7.5 В классах должны присутствовать математические методы:
		7.5.1 4 базовых математических метода (деление, умножение, вычитание, сложение).
		7.5.2 3 метода (Возведение в целую степень дробного положительного числа, Модуль числа, Корень из числа).
	7.6 В классе должен быть метод long getCountOperation() который должен возвращать количество использований данного
	калькулятора. При вызове данного метода счётчик учёта не увеличивается.
 */

/**
 * Содержит методы базовых математических операций (сложение, вычитание, умножение, деление, возведение числа в степень,
 * модуль числа, квадратный корень из числа) и автоматический счетчик количества использований математических операций.
 */
public class CalculatorWithCounterAutoComposite {

	/**
	 * Объект типа CalculatorWithMathCopy
	 */
	private CalculatorWithMathCopy calc = new CalculatorWithMathCopy();

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
		return calc.add(number1, number2);
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
		return calc.subtract(number1, number2);
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
		return calc.multiply(number1, number2);
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
		return calc.divide(number1, number2);
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
		return calc.pow(number1, number2);
	}

	/**
	 * Приведение числа к абсолютному значению (модуль числа)
	 *
	 * @param number Приводимое к абсолютному значению число
	 * @return Абсолютное значение числа
	 */
	public double abs(double number) {
		counter++;
		return calc.abs(number);
	}

	/**
	 * Операция нахождения квадратного корня числа
	 *
	 * @param number Неотрицательное вещественное число
	 * @return Квадратный корень из числа
	 */
	public double sqrt(double number) {
		counter++;
		return calc.sqrt(number);
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