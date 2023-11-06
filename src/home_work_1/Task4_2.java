package home_work_1;

import java.util.Scanner;

/*  Разбираемся с операторами ветвления. Каждую задачу в отдельном классе. Пояснения по задачам сотреть в презентации и
    на сайте по ссылке в презентации.

	4.2 Среди трёх чисел найти среднее
	Вводятся три разных числа. Найти, какое из них является средним (больше одного, но меньше другого)
 */

public class Task4_2 {
    public static void main(String[] args) {

        int number1;
        int number2;
        int number3;

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
            if (number2 != number1) {
                break;
            } else {
                System.out.print("Введено ранее введенное число, повторите попытку: ");
            }
        }

        System.out.print("Введите третье число:");

        while (true) {
            while (!sc.hasNextInt()) {
                sc.nextLine();
                System.out.print("Неверный ввод, повторите попытку: ");
            }
            number3 = sc.nextInt();
            if (number3 != number1 && number3 != number2) {
                break;
            } else {
                System.out.print("Введено ранее введенное число, повторите попытку: ");
            }
        }

        System.out.println("Среди чисел " + number1 + ", " + number2 + " и " + number3 + " число "
                + getMiddleNumber(number1, number2, number3) + " является средним числом");

    }

    /**
     * Среди трех чисел находит среднее
     *
     * @param num1 Первое число
     * @param num2 Второе число
     * @param num3 Третье число
     * @return Возвращает среднее по значению число.
     * При некорретных входных параметрах (два или более чисел равны) возвращает 2147483647
     */
    public static int getMiddleNumber(int num1, int num2, int num3) {

        if (num1 == num2 || num1 == num3 || num2 == num3) {
            return Integer.MAX_VALUE;
        }

        if ((num1 > num2 && num1 < num3) || (num1 > num3 && num1 < num2)) {
            return num1;
        } else if ((num2 > num1 && num2 < num3) || (num2 > num3 && num2 < num1)) {
            return num2;
        }
        return num3;
    }
}