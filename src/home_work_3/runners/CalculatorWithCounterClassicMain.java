package home_work_3.runners;

import home_work_3.calcs.additional.CalculatorWithCounterClassic;

/* 	5.5 Создать класс CalculatorWithCounterClassicMain в котором будет точка входа (main метод). В main методе требуется
	создать экземпляр калькулятора и используя методы из данного экземпляра посчитать выражения из задания 1, при каждой
	математической операции самостоятельно вызывать метод incrementCountOperation() для увеличения счётчика. Вывести в
	консоль результат.
 */

public class CalculatorWithCounterClassicMain {

    public static void main(String[] args) {

        double result;
        CalculatorWithCounterClassic calc = new CalculatorWithCounterClassic();

        result = calc.add(4.1, calc.add(calc.multiply(15, 7), calc.pow(calc.divide(28, 5), 2))); //Результат равен 140.46

        calc.incrementCountOperation();
        calc.incrementCountOperation();
        calc.incrementCountOperation();
        calc.incrementCountOperation();
        calc.incrementCountOperation();

        System.out.println("Результат равен " + result);
        System.out.println("Количество операций равно " + calc.getCountOperation());
    }
}