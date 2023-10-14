package home_work_3.calcs.simple;

import home_work_3.calcs.api.ICalculator;

/* 2. Создать класс CalculatorWithOperator.
	2.1 Все методы объявленные в данном классе НЕ статические (не имеют модификатор static).
	2.2 В классе должны присутствовать математические методы:
		2.2.1 4 базовых математических метода (деление, умножение, вычитание, сложение) каждый из этих методов должен
		принимать два параметра (определитесь с их типами) и должны возвращать результат (определиться с возвращаемым
		типом результата) при помощи ключевого слово return.
		2.2.2 3 метода (Возведение в целую степень дробного положительного числа, Модуль числа, Квадратный корень из
		числа).
	2.3 В методах можно использовать любые арифметические операторы.
	2.4 Использование библиотеки Math ЗАПРЕЩЕНО! (кроме извлечения корня). Если у Вас плохо с математикой, то для
	реализации метода "Квадратный корень из числа" можно воспользоваться библиотекой Math.
 */

/**
 * Содержит методы базовых математических операций (сложение, вычитание, умножение, деление, возведение числа в степень,
 * модуль числа, квадратный корень из числа)
 */
public class CalculatorWithOperator implements ICalculator {

    /**
     * Производит операцию сложение
     *
     * @param number1 Первое слагаемое
     * @param number2 Второе слагаемое
     * @return Результат сложения друх чисел
     */
    public double add(double number1, double number2) {
        return number1 + number2;
    }

    /**
     * Производит операцию вычитание
     *
     * @param number1 Уменьшаемое
     * @param number2 Вычитаемое
     * @return Разность двух чисел
     */
    public double subtract(double number1, double number2) {
        return number1 - number2;
    }

    /**
     * Производит операцию умножение
     *
     * @param number1 Первый множитель
     * @param number2 Второй множитель
     * @return Результат умножения двух чисел
     */
    public double multiply(double number1, double number2) {
        return number1 * number2;
    }

    /**
     * Производит операцию деление
     *
     * @param number1 Делимое
     * @param number2 Делитель
     * @return Результат деления двух чисел (частное)
     */
    public double divide(double number1, double number2) {
        return number1 / number2;
    }

    /**
     * Производит операцию возведения числа в степень. Основание должно быть положительным числом.
     *
     * @param number1 Основание
     * @param number2 Степень числа
     * @return Результат операции возведения числа в степень
     */
    public double pow(double number1, int number2) {

        double result = 1;

        if (number2 >= 1) {
            for (int i = 1; i <= number2; i++) {
                result *= number1;
            }
            return result;
        } else if (number2 < 0) {
            number2 *= -1;
            for (int i = 1; i <= number2; i++) {
                result *= number1;
            }
            return 1 / result;
        } else {
            return 1;
        }
    }

    /**
     * Приведение числа к абсолютному значению (модуль числа)
     *
     * @param number Приводимое к абсолютному значению число
     * @return Абсолютное значение числа
     */
    public double abs(double number) {

        if (number < 0) {
            return number * -1;
        }
        return number;
    }

    /**
     * Операция нахождения квадратного корня числа
     *
     * @param number Неотрицательное вещественное число
     * @return Квадратный корень из числа
     */
    public double sqrt(double number) {
        return Math.sqrt(number);
    }
}