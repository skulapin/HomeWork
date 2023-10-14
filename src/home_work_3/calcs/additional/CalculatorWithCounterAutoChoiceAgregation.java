package home_work_3.calcs.additional;

import home_work_3.calcs.simple.*;

/* 9. Создать класс CalculatorWithCounterAutoChoiceAgregation.
	9.1 Все методы объявленные в данных классах НЕ статические (не имеют модификатор static).
	9.2 В данном классе должны быть следующие варианты конструктора:
		9.2.1 Принимающий объект типа CalculatorWithOperator
		9.2.2 Принимающий объект типа CalculatorWithMathCopy
		9.2.3 Принимающий объект типа CalculatorWithMathExtends
	9.4 Данные класс также не умеет напрямую считать математику, они умеют делегировать расчёт математики калькулятору
	который передали в конструктор.
	9.5 В классах должны присутствовать математические методы:
		9.5.1 4 базовых математических метода (деление, умножение, вычитание, сложение).
		9.5.2 3 метода (Возведение в целую степень дробного положительного числа, Модуль числа, Корень из числа).
	9.6 В классе должен быть метод long getCountOperation() который должен возвращать количество использований данного
	калькулятора. При вызове данного метода счётчик учёта не увеличивается.
 */

/**
 * Содержит методы базовых математических операций (сложение, вычитание, умножение, деление, возведение числа в степень,
 * модуль числа, квадратный корень из числа) и автоматический счетчик количества использований математических операций.
 * Функционирует только с объектами типов CalculatorWithOperator, CalculatorWithMathCopy и CalculatorWithMathExtends
 */
public class CalculatorWithCounterAutoChoiceAgregation {

	/**
	 * Ссылка на объект типа CalculatorWithOperator
	 */
	private CalculatorWithOperator calc1;

	/**
	 * Ссылка на объект типа CalculatorWithMathCopy
	 */
	private CalculatorWithMathCopy calc2;

	/**
	 * Ссылка на объект типа CalculatorWithMathExtends
	 */
	private CalculatorWithMathExtends calc3;

	/**
	 * Количество использований математических методов класса
	 */
	private long counter = 0;

	/**
	 * Конструктор класса
	 * @param calc Объект калькулятора CalculatorWithOperator
	 */
	public CalculatorWithCounterAutoChoiceAgregation(CalculatorWithOperator calc) {
		calc1 = calc;
	}

	/**
	 * Конструктор класса
	 * @param calc Объект калькулятора CalculatorWithMathCopy
	 */
	public CalculatorWithCounterAutoChoiceAgregation(CalculatorWithMathCopy calc) {
		calc2 = calc;
	}

	/**
	 * Конструктор класса
	 * @param calc Объект калькулятора CalculatorWithMathExtends
	 */
	public CalculatorWithCounterAutoChoiceAgregation(CalculatorWithMathExtends calc) {
		calc3 = calc;
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
		if (calc1 != null) {
			return calc1.add(number1, number2);
		} else if (calc2 != null) {
			return calc2.add(number1, number2);
		} else {
			return calc3.add(number1, number2);
		}
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
		if (calc1 != null) {
			return calc1.subtract(number1, number2);
		} else if (calc2 != null) {
			return calc2.subtract(number1, number2);
		} else {
			return calc3.subtract(number1, number2);
		}
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
		if (calc1 != null) {
			return calc1.multiply(number1, number2);
		} else if (calc2 != null) {
			return calc2.multiply(number1, number2);
		} else {
			return calc3.multiply(number1, number2);
		}
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
		if (calc1 != null) {
			return calc1.divide(number1, number2);
		} else if (calc2 != null) {
			return calc2.divide(number1, number2);
		} else {
			return calc3.divide(number1, number2);
		}
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
		if (calc1 != null) {
			return calc1.pow(number1, number2);
		} else if (calc2 != null) {
			return calc2.pow(number1, number2);
		} else {
			return calc3.pow(number1, number2);
		}
	}

	/**
	 * Приведение числа к абсолютному значению (модуль числа)
	 *
	 * @param number Приводимое к абсолютному значению число
	 * @return Абсолютное значение числа
	 */
	public double abs(double number) {
		counter++;
		if (calc1 != null) {
			return calc1.abs(number);
		} else if (calc2 != null) {
			return calc2.abs(number);
		} else {
			return calc3.abs(number);
		}
	}

	/**
	 * Операция нахождения квадратного корня числа
	 *
	 * @param number Неотрицательное вещественное число
	 * @return Квадратный корень из числа
	 */
	public double sqrt(double number) {
		counter++;
		if (calc1 != null) {
			return calc1.sqrt(number);
		} else if (calc2 != null) {
			return calc2.sqrt(number);
		} else {
			return calc3.sqrt(number);
		}
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