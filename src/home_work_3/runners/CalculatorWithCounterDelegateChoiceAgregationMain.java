package home_work_3.runners;

import home_work_3.calcs.additional.*;
import home_work_3.calcs.simple.*;

/* 9.7 Создать класс CalculatorWithCounterDelegateChoiceAgregationMain в котором будет точка входа (main метод). В main
	методе требуется:
		9.7.1 Создать экземпляр калькулятора используя конструктор принимающий CalculatorWithOperator и используя методы
		из данного экземпляра посчитать выражения из задания 1. Вывести в консоль результаты посчитанных выражений и
		результат метода getCountOperation().
		9.7.2 Создать экземпляр калькулятора используя конструктор принимающий CalculatorWithMathCopy и используя методы
		из данного экземпляра посчитать выражения из задания 1. Вывести в консоль результаты посчитанных выражений и
		результат метода getCountOperation().
		9.7.3 Создать экземпляр калькулятора используя конструктор принимающий CalculatorWithMathExtends и используя
		методы из данного экземпляра посчитать выражения из задания 1. Вывести в консоль результаты посчитанных выражений
		и результат метода getCountOperation().
 */

public class CalculatorWithCounterDelegateChoiceAgregationMain {

    public static void main(String[] args) {

        CalculatorWithCounterAutoChoiceAgregation calc1 = new CalculatorWithCounterAutoChoiceAgregation(
                new CalculatorWithOperator());
        CalculatorWithCounterAutoChoiceAgregation calc2 = new CalculatorWithCounterAutoChoiceAgregation(
                new CalculatorWithMathCopy());
        CalculatorWithCounterAutoChoiceAgregation calc3 = new CalculatorWithCounterAutoChoiceAgregation(
                new CalculatorWithMathExtends());

        double result;
        result = calc1.add(4.1, calc1.add(calc1.multiply(15, 7), calc1.pow(calc1.divide(28, 5), 2))); //Результат равен 140.46

        System.out.println("Результат CalculatorWithOperator равен " + result);
        System.out.println("Количество операций CalculatorWithOperator равно " + calc1.getCountOperation());

        result = calc2.add(4.1, calc2.add(calc2.multiply(15, 7), calc2.pow(calc2.divide(28, 5), 2))); //Результат равен 140.46

        System.out.println("Результат CalculatorWithMathCopy равен " + result);
        System.out.println("Количество операций CalculatorWithMathCopy равно " + calc2.getCountOperation());

        result = calc3.add(4.1, calc3.add(calc3.multiply(15, 7), calc3.pow(calc3.divide(28, 5), 2))); //Результат равен 140.46

        System.out.println("Результат CalculatorWithMathExtends равен " + result);
        System.out.println("Количество операций CalculatorWithMathExtends равно " + calc3.getCountOperation());
    }
}