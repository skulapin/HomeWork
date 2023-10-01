package home_work_2.loops;

import home_work_2.utils.InputCheckerUtils;

/*  1. Циклы. Для преобразования строки в число можно использовать http://proglang.su/java/numbers-parseint, если хотите
    можете добавить проверки на корректность ввода данных. Число положительное, максимум long:
    1.1. Перемножить числа от 1 до числа (включительно) введенного через аргумент к исполняемой программе. Есть нюанс с
    переполнением, можно добавить проверки и сообщения пользователю.
    Пример: Ввели 5, должно получиться в консоли: 1 * 2 * 3 * 4 * 5 = ответ
	1.1.1. Используя только цикл
	1.1.2.* Используя рекурсию
*/

public class Task1_1_2 {

    public static void main(String[] args) {

        boolean correctInput = InputCheckerUtils.isArgumentPositiveLong(args);

        if (correctInput) {

            long result = 1;
            long argument = Integer.parseInt(args[0]);

            for (long i = argument; i >= 1; i--) {

                result *= i;

                if (i == 1) {
                    System.out.println("Факториал числа " + argument + " равен " + result);
                    break;
                }

                if (Long.MAX_VALUE / (i - 1) < result) {
                    System.out.println("Произошло переполнение переменной");
                    break;
                }
            }
        } else {
            System.out.println("Неверный аргумент к программе");
        }
    }
}