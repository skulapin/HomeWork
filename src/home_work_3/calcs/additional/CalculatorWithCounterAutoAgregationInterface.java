package home_work_3.calcs.additional;

import home_work_3.calcs.api.ICalculator;

/* 11. Создать класс CalculatorWithCounterAutoAgregationInterface.
	11.1 Внутри класса нельзя создавать объекты (использовать new), можно пользоваться только тем что передал вам
	пользователь вашего класса.
	11.2 Все методы объявленные в данном классе НЕ статические (не имеют модификатор static).
	11.3 В данном классе должен быть только конструктор принимающий объект типа ICalculator
	11.4 Данный класс напрямую не умеет считать математику, он умеет делегировать расчёт математики калькулятору который
	передали в конструктор
	11.5 В классе должны присутствовать все методы объявленные в интерфейсе.
	11.6 В классе должен быть метод long getCountOperation() который должен возвращать количество использований данного
	калькулятора. При вызове данного метода счётчик учёта не увеличивается.
 */

/**
 * Содержит методы базовых математических операций (сложение, вычитание, умножение, деление, возведение числа в степень,
 * модуль числа, квадратный корень из числа) и автоматический счетчик количества использований математических операций.
 * Функционирует c объектами типа ICalculator
 */
public class CalculatorWithCounterAutoAgregationInterface {

	/**
	 * Ссылка на объект типа ICalculator
	 */
	ICalculator calc;

	/**
	 * Количество использований математических методов класса
	 */
	private long counter = 0;

	/**
	 * Конструктор класса
	 * @param calc Объект реализующий интерфейс ICalculator
	 */
	public CalculatorWithCounterAutoAgregationInterface(ICalculator calc) {

		this.calc = calc;
	}

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