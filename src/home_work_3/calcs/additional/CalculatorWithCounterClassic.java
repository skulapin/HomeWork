package home_work_3.calcs.additional;

import home_work_3.calcs.simple.CalculatorWithMathExtends;

/* 5. Создать класс CalculatorWithCounterClassic.
	5.1 Все методы объявленные в данном классе НЕ статические (не имеют модификатор static).
	5.2 Данный класс должен наследовать класс CalculatorWithMathExtends.
	5.3 В классе должен быть метод void incrementCountOperation() который должен увеличивать внутренний счётчик (поле)
	в калькуляторе.
	5.4 В классе должен быть метод long getCountOperation() который должен возвращать количество использований данного
	калькулятора (поле).
 */

/**
 * Содержит методы базовых математических операций (сложение, вычитание, умножение, деление, возведение числа в степень,
 * модуль числа, квадратный корень из числа) и счетчик количества использований математических операций.
 */
public class CalculatorWithCounterClassic extends CalculatorWithMathExtends {

    /**
     * Количество использований математических методов класса
     */
    private long counter = 0;

    /**
     * Инкрементирует значение счетчика
     */
    public void incrementCountOperation() {
        counter++;
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