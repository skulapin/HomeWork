package home_work_3.calcs.additional;

import home_work_3.calcs.api.ICalculator;

/* 13*. Создать класс CalculatorWithCounterAutoDecorator и CalculatorWithMemoryDecorator
	13.1 Отличие от предыдущих CalculatorWithCounterAutoAgregationInterface и CalculatorWithMemory в том что данные
	классы будут реализовывать интерфейс ICalculator.
	13.2 Данный подход позволяет назвать данный классы "Декораторами". Декоратор - это популярный паттерн который
	позволяет комбинировать и дополнять новыми возможностями объекты (в нашем случае калькуляторы) не меняя код в их
	классе. Тем самым мы приходим к тому что мы не наследуем классы для их расширения и не привязываемся к реализации
	конкретного калькулятора. Советую начать гуглить слово "паттерн".
	13.3 О декораторах можно прочитать по ссылкам:
		13.3.1 https://refactoring.guru/ru/design-patterns/decorator
		13.3.2 https://www.wikiwand.com/ru/%D0%94%D0%B5%D0%BA%D0%BE%D1%80%D0%B0%D1%82%D0%BE%D1%80_
		(%D1%88%D0%B0%D0%B1%D0%BB%D0%BE%D0%BD_%D0%BF%D1%80%D0%BE%D0%B5%D0%BA%D1%82%D0%B8%D1%80%D0%BE%D0%B2%D0%B0%D0%BD%D0%B8%D1%8F)
	13.4 Добавить в эти классы метод ICalculator getCalculator() который будут возвращать вложенный в них калькулятор.
 */

/**
 * Содержит методы базовых математических операций (сложение, вычитание, умножение, деление, возведение числа в степень,
 * модуль числа, квадратный корень из числа) и автоматический счетчик количества использований математических операций.
 * Функционирует c объектами типа ICalculator
 */
public class CalculatorWithCounterAutoDecorator implements ICalculator {

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
     *
     * @param calc Объект реализующий интерфейс ICalculator
     */
    public CalculatorWithCounterAutoDecorator(ICalculator calc) {

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
     * Возвращает число использования математических операций
     *
     * @return Количество использования математических операций
     */
    public long getCountOperation() {
        return counter;
    }

    /**
     * Возвращает объект калькулятора
     *
     * @return Объект калькулятора типа ICalculator
     */
    public ICalculator getCalculator() {
        return calc;
    }
}