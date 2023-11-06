package home_work_1;

import java.util.Scanner;

/*  Разбираемся с операторами ветвления. Каждую задачу в отдельном классе. Пояснения по задачам сотреть в презентации и
    на сайте по ссылке в презентации.
	4.1 Определить нечётное число.
	Из двух случайных чисел, одно из которых четное, а другое нечетное, определить и вывести на экран нечетное число
 */

public class Task4_1 {

    public static void main(String[] args) {

        int number1;
        int number2;
        Scanner sc = new Scanner(System.in);

        System.out.print("Введите первое число: ");

        while (!sc.hasNextInt()) {
            sc.nextLine();
            System.out.print("Неверный ввод, повторите попытку: ");
        }

        number1 = sc.nextInt();

        if (Math.abs(number1 % 2) == 0) {
            while (true) {
                System.out.print("Введите нечетное число: ");
                while (!sc.hasNextInt()) {
                    sc.nextLine();
                    System.out.print("Введите нечетное число: ");
                }
                number2 = sc.nextInt();
                if (Math.abs(number2 % 2) == 1) {
                    break;
                }
            }
        } else {
            while (true) {
                System.out.print("Введите четное число: ");
                while (!sc.hasNextInt()) {
                    sc.nextLine();
                    System.out.print("Введите четное число: ");
                }
                number2 = sc.nextInt();
                if (Math.abs(number2 % 2) == 0) {
                    break;
                }
            }
        }

        System.out.println("Нечетное число - " + getOddNumber(number1, number2));
    }

    /**
     * Среди двух чисел находит нечетное число
     *
     * @param num1 Первое число
     * @param num2 Второе число
     * @return Возвращает нечетное число.
     * При некорректных входных параметрах (два четных, либо два нечетных числа) возвращает 0
     */
    public static int getOddNumber(int num1, int num2) {

        if ((num1 % 2 == 0 && num2 % 2 == 0) || (num1 % 2 == 1 && num2 % 2 == 1)) {
            return 0;
        }

        if (Math.abs(num1 % 2) == 1) {
            return num1;
        }
        return num2;
    }
}