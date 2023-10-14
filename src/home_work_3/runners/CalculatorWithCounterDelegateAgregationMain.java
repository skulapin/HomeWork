package home_work_3.runners;

import home_work_3.calcs.additional.CalculatorWithCounterAutoAgregation;
import home_work_3.calcs.simple.CalculatorWithMathCopy;

/* 	8.7 Создать класс CalculatorWithCounterDelegateAgregationMain в котором будет точка входа (main метод). В main методе
	требуется создать экземпляр калькулятора и используя методы из данного экземпляра посчитать выражения из задания 1.
	Вывести в консоль результаты посчитанных выражений и результат метода getCountOperation().
 */

public class CalculatorWithCounterDelegateAgregationMain {

    public static void main(String[] args) {

        CalculatorWithCounterAutoAgregation calc = new CalculatorWithCounterAutoAgregation(new CalculatorWithMathCopy());

        double result;
        result = calc.add(4.1, calc.add(calc.multiply(15, 7), calc.pow(calc.divide(28, 5), 2))); //Результат равен 140.46

        System.out.println("Результат равен " + result);
        System.out.println("Количество операций равно " + calc.getCountOperation());
    }
}