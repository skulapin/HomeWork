package home_work_3.runners;

import home_work_3.calcs.simple.CalculatorWithMathCopy;

/* 	3.3 Создать класс CalculatorWithMathCopyMain в котором будет точка входа (main метод). В main методе требуется
	создать экземпляр калькулятора и используя методы из данного экземпляра посчитать выражения из задания 1. Вывести
	в консоль результат.
 */

public class CalculatorWithMathCopyMain {

    public static void main(String[] args) {

        double result;
        CalculatorWithMathCopy calc = new CalculatorWithMathCopy();

        result = calc.add(4.1, calc.add(calc.multiply(15, 7), calc.pow(calc.divide(28, 5), 2))); // Результат равен 140.46

        System.out.println("Результат равен " + result);
    }
}