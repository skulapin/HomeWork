package home_work_3.runners;

import home_work_3.calcs.additional.*;
import home_work_3.calcs.api.ICalculator;
import home_work_3.calcs.simple.CalculatorWithMathExtends;

/* 13.5 Создать класс CalculatorDecoratorMain в котором будет точка входа (main метод). Cоздать переменную типа
	ICalculator calc записав в неё новый экземпляр класса CalculatorWithCounterAutoDecorator которому в конструктор был
	передан новый экземпляр класса CalculatorWithMemoryDecorator которому в конструтор был передан новый экземпляр класса
	CalculatorWithMathExtends. Используя созданную переменную посчитать выражения из задания 1. Вывести в консоль.
	13.6 Вывести количество использований калькулятора.
	13.7** Получить перечисленные далее сведения требуется из калькулятора который вам вернёт метод getCalculator().
	Данный пункт вам очень поможет выполнить оператор instanceof который нужно использовать в main.
		13.7.1 Выполнить метод сохранения последнего расчёта и вывести сохранённое значение.
		13.7.2 Изменить calc путём изменения создаваемого экземпляра на CalculatorWithCounterClassic. Сделать выводы в
		комментариях зачем нужен instanceof
 */

public class CalculatorDecoratorMain {

    public static void main(String[] args) {

        //13.5
        ICalculator calc = new CalculatorWithCounterAutoDecorator(
                new CalculatorWithMemoryDecorator(new CalculatorWithMathExtends()));

        double result;

        result = calc.add(4.1, calc.add(calc.multiply(15, 7), calc.pow(calc.divide(28, 5), 2)));

        System.out.println("Результат равен " + result); //Результат равен 140.46

        //13.6
        if (calc instanceof CalculatorWithCounterAutoDecorator) {

            System.out.println("Количество операций равно " + ((CalculatorWithCounterAutoDecorator) calc).getCountOperation());
            System.out.println();

            //13.7.1
            if (((CalculatorWithCounterAutoDecorator) calc).getCalculator() instanceof CalculatorWithMemoryDecorator) {

                CalculatorWithMemoryDecorator calc2 = (CalculatorWithMemoryDecorator) ((CalculatorWithCounterAutoDecorator) calc)
                        .getCalculator();

                calc2.save();

                System.out.println("Сохраненный результат равен " + calc2.load());
            }
        }

        /* 13.7.2
        Оператор instanceof проверяет наличие связи наследования между двумя операндами и служит для защиты от
        неправильного приведения типов. В нашем случае CalculatorWithCounterClassic не реализует интерфейс ICalculator и
        никакой связи с классом CalculatorWithMemoryDecorator не имеет. Попытка приведения к данному типу и вызов метода
        getCalculator() вызовет ошибку выполнения программы.
         */

        calc = new CalculatorWithCounterClassic();

        if (calc instanceof CalculatorWithMemoryDecorator) {

            System.out.println("Возможно осуществить приведение типа к переменной к классу CalculatorWithMemoryDecorator");
        } else {
            System.out.println("Невозможно осуществить приведение типа к переменной к классу CalculatorWithMemoryDecorator");
        }
    }
}