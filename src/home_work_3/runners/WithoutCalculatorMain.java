package home_work_3.runners;

/* 1. Создать класс WithoutCalculatorMain в котором необходимо посчитать следующие выражения: 
	1.1 4.1 + 15 * 7 + (28 / 5) ^ 2. Вывести сохранённый результат в консоль. Внимание, знак "^" обозначает возведение
	в степень.
	*/

public class WithoutCalculatorMain {

    public static void main(String[] args) {

        double result;

        result = 4.1 + 15 * 7 + Math.pow((double) 28 / 5, 2); //Результат равен 140.46

        System.out.println("Результат равен " + result);
    }
}