package home_work_3.calcs.additional;

import home_work_3.calcs.api.ICalculator;

/* 12*. Создать CalculatorWithMemory используя аналогичные принципы построения класса
CalculatorWithCounterAutoAgregationInterface.
	12.1 Данный калькулятор предназначен для того чтобы расширить возможности калькулятора и обеспечить его дополнительной
	функцией памяти. В принципе работает как калькулятор из реальной жизни.
	12.2 Все методы объявленные в данном классе НЕ статические (не имеют модификатор static).
	12.3 В данном классе должен быть только конструктор принимающий объект типа ICalculator
	12.4 Данный класс напрямую не умеет считать математику, он умеет делегировать расчёт математики калькулятору который
	передали в конструктор
	12.5 В классе должны присутствовать математические методы:
		12.5.1 4 базовых математических метода (деление, умножение, вычитание, сложение).
		12.5.2 3 метода (Возведение в целую степень дробного положительного числа, Модуль числа, Корень из числа).
	12.6 Функция памяти работает через методы:
		12.6.1 Записать в память результат выполнения последнего вызванного метода. У данного метода не должно быть
		параметров. Данный метод вызывается непосредтвенно пользователем, а не автоматический. Пример void save();
		12.6.2 Получить из памяти записанное значение. При получении записи из памяти память стирается, при записи нового
		значения память перезаписывается. Данный метод вызывается непосредтвенно пользователем, а не автоматический.
		Пример double load();
	12.7 В этом калькуляторе НЕТ ФУНКЦИИ ПОДСЧЁТА количества использований
 */

/**
 * Содержит методы базовых математических операций (сложение, вычитание, умножение, деление, возведение числа в степень,
 * модуль числа, квадратный корень из числа), метод сохранения и выгрузки результата.
 * Функционирует c объектами типа ICalculator
 */
public class CalculatorWithMemory {

    /**
     * Ссылка на объект типа CalculatorWithOperator
     */
    ICalculator calc;

    /**
     * Переменная хранящая результат использования последнего математического метода
     */
    private double tempNumber;

    /**
     * Переменная хранящая сохраненный пользователем результат математического метода
     */
    private double memoryNumber;

    /**
     * Конструктор класса
     *
     * @param calc Объект реализующий интерфейс ICalculator
     */
    public CalculatorWithMemory(ICalculator calc) {

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

        tempNumber = calc.add(number1, number2);
        return tempNumber;
    }

    /**
     * Производит операцию вычитание
     *
     * @param number1 Уменьшаемое
     * @param number2 Вычитаемое
     * @return Разность двух чисел
     */
    public double subtract(double number1, double number2) {
        tempNumber = calc.subtract(number1, number2);
        return tempNumber;
    }

    /**
     * Производит операцию умножение
     *
     * @param number1 Первый множитель
     * @param number2 Второй множитель
     * @return Результат умножения двух чисел
     */
    public double multiply(double number1, double number2) {
        tempNumber = calc.multiply(number1, number2);
        return tempNumber;
    }

    /**
     * Производит операцию деление
     *
     * @param number1 Делимое
     * @param number2 Делитель
     * @return Результат деления двух чисел (частное)
     */
    public double divide(double number1, double number2) {
        tempNumber = calc.divide(number1, number2);
        return tempNumber;
    }

    /**
     * Производит операцию возведения числа в степень. Основание должно быть положительным числом.
     *
     * @param number1 Основание
     * @param number2 Степень числа
     * @return Результат операции возведения числа в степень
     */
    public double pow(double number1, int number2) {
        tempNumber = calc.pow(number1, number2);
        return tempNumber;
    }

    /**
     * Приведение числа к абсолютному значению (модуль числа)
     *
     * @param number Приводимое к абсолютному значению число
     * @return Абсолютное значение числа
     */
    public double abs(double number) {
        tempNumber = calc.abs(number);
        return tempNumber;
    }

    /**
     * Операция нахождения квадратного корня числа
     *
     * @param number Неотрицательное вещественное число
     * @return Квадратный корень из числа
     */
    public double sqrt(double number) {
        tempNumber = calc.sqrt(number);
        return tempNumber;
    }

    /**
     * Сохраняет/перезаписывает результат использования последнего метода математических операций
     */
    public void save() {
        memoryNumber = tempNumber;
    }

    /**
     * Возвращает значение сохраненного результата использования метода математических операций. Значение из памяти стирается
     *
     * @return Сохраненный результат использования метода
     */
    public double load() {
        double number = memoryNumber;
        memoryNumber = 0;
        return number;
    }
}