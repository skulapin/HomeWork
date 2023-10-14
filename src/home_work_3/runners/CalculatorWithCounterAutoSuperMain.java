package home_work_3.runners;

import home_work_3.calcs.additional.CalculatorWithCounterAutoSuper;

/* 	6.5 Создать класс CalculatorWithCounterAutoSuperMain в котором будет точка входа (main метод). В main методе
	требуется создать экземпляр калькулятора и используя методы из данного экземпляра посчитать выражения из задания 1.
	Вывести в консоль результаты посчитанных выражений и результат метода getCountOperation().
 */

public class CalculatorWithCounterAutoSuperMain {

	public static void main(String[] args) {

		double result;
		CalculatorWithCounterAutoSuper calc = new CalculatorWithCounterAutoSuper();

		result = calc.add(4.1, calc.add(calc.multiply(15, 7), calc.pow(calc.divide(28, 5), 2))); //Результат равен 140.46

		System.out.println("Результат равен " + result);
		System.out.println("Количество операций равно " + calc.getCountOperation());

	}
}