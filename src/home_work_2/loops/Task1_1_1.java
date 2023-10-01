package home_work_2.loops;

import home_work_2.utils.InputCheckerUtils;

/*  1. Циклы. Для преобразования строки в число можно использовать http://proglang.su/java/numbers-parseint, если хотите
    можете добавить проверки на корректность ввода данных. Число положительное, максимум long:
    1.1. Перемножить числа от 1 до числа (включительно) введенного через аргумент к исполняемой программе. Есть нюанс с
    переполнением, можно добавить проверки и сообщения пользователю.
        Пример: Ввели 5, должно получиться в консоли: 1 * 2 * 3 * 4 * 5 = ответ
    	1.1.1. Используя только цикл
*/

public class Task1_1_1 {

    public static void main(String[] args) {

        boolean correctInput = InputCheckerUtils.isArgumentPositiveLong(args);

        if (correctInput) {

            long result = 1;
            long argument = Long.parseLong(args[0]);

            for (int i = 1; i <= argument; i++) {

                result *= i;

                if (i == argument) {
                    System.out.println("Факториал числа " + argument + " равен " + result);
                    break;
                }

                if (Long.MAX_VALUE / (i + 1) < result) {
                    System.out.println("Произошло переполнение переменной");
                    break;
                }
            }
        } else {
            System.out.println("Неверный аргумент к программе");
        }
    }
}