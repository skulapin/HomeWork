package home_work_3.calcs.simple;

import home_work_3.calcs.api.ICalculator;

/* 4. Создать класс CalculatorWithMathExtends.
	4.1 Все методы объявленные в данном классе НЕ статические (не имеют модификатор static).
	4.2 Данный класс должен наследовать класс CalculatorWithOperator.
	4.3 Условия:
		4.3.1 4 базовых математических метода (деление, умножение, вычитание, сложение) НЕ ДОЛЖНЫ быть объявлены напрямую
		в классе, а должны быть унаследованы от родительского класса (4.2).
		4.3.2 3 метода (Возведение в целую степень дробного положительного числа, Модуль числа, Корень из числа). Данные
		методы должны ПЕРЕОПРЕДЕЛЯТЬ методы родительского класса (4.2) и должны содержать в своём теле вызов библиотеки
		Math и возврат полученного результата.
 */

/**
 * Содержит методы базовых математических операций (сложение, вычитание, умножение, деление, возведение числа в степень,
 * модуль числа, квадратный корень из числа)
 */
public class CalculatorWithMathExtends extends CalculatorWithOperator implements ICalculator {

    /**
     * Производит операцию возведения числа в степень. Основание должно быть положительным числом.
     *
     * @param number1 Основание
     * @param number2 Степень числа
     * @return Результат операции возведения числа в степень. Если основание равно 0 и степень отрицательная -
     * возвращает ноль.
     */
    public double pow(double number1, int number2) {
        if (number1 == 0 && number2 < 0) {
            return 0;
        }
        return Math.pow(number1, number2);
    }

    /**
     * Приведение числа к абсолютному значению (модуль числа)
     *
     * @param number Приводимое к абсолютному значению число
     * @return Абсолютное значение числа
     */
    public double abs(double number) {
        return Math.abs(number);
    }

    /**
     * Операция нахождения квадратного корня числа
     *
     * @param number Неотрицательное вещественное число
     * @return Квадратный корень из числа. При переданном в метод отрицательном числе возвращает -1
     */
    public double sqrt(double number) {
        if (number < 0){
            return -1;
        }
        return Math.sqrt(number);
    }
}