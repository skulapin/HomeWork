package home_work_1;

import java.util.Scanner;

/*  Разбираемся с операторами ветвления. Каждую задачу в отдельном классе. Пояснения по задачам сотреть в презентации и
    на сайте по ссылке в презентации.

	4.3 Проверка делимости одного числа на другое
	Вводятся два целых числа. Проверить делится ли первое на второе. Вывести на экран сообщение об этом, а также остаток
	(если он есть) и частное (в любом случае).
 */

public class Task4_3 {
    public static void main(String[] args) {

        int number1;
        int number2;

        int remainder;

        Scanner sc = new Scanner(System.in);

        System.out.print("Введите первое число:");

        while (!sc.hasNextInt()) {
            sc.nextLine();
            System.out.print("Неверный ввод, повторите попытку: ");
        }

        number1 = sc.nextInt();

        System.out.print("Введите второе число:");

        while (true) {
            while (!sc.hasNextInt()) {
                sc.nextLine();
                System.out.print("Неверный ввод, повторите попытку: ");
            }
            number2 = sc.nextInt();
            if (number2 != 0) {
                break;
            } else {
                System.out.print("На ноль делить нельзя, повторите попытку: ");
            }
        }

        remainder = getRemainder(number1, number2);

        if (remainder == 0) {
            System.out.print("Число " + number1 + " делится на " + number2 + " без остаткa. ");
        } else {
            System.out.print("Число " + number1 + " не делится на " + number2 + " без остатка. Остаток от деления равен "
                    + remainder + ". ");
        }
        System.out.println("Частное деления " + number1 + " на " + number2 + " равняется " + getQuotient(number1, number2));
    }

    /**
     * Находит остаток от деления двух чисел
     *
     * @param num1 Делимое
     * @param num2 Делитель
     * @return Возвращает остаток от деления. При делителе равном 0 возвращает 0
     */
    public static int getRemainder(int num1, int num2) {
        if (num2 == 0) {
            return 0;
        }
        return num1 % num2;
    }

    /**
     * Находит частное от деления двух чисел
     *
     * @param num1 Делимое
     * @param num2 Делитель
     * @return Возвращает частное от деления.
     * При делителе равном 0 возвращает 0
     */
    public static double getQuotient(int num1, int num2) {
        if (num1 == 0 || num2 == 0) {
            return 0;
        }
        return (double) num1 / num2;
    }
}