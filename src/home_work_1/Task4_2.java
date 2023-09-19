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
        int c;

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
            c = sc.nextInt();
            if (c != number1 && c != number2) {
                break;
            } else {
                System.out.print("Введено ранее введенное число, повторите попытку: ");
            }
        }

        if ((number1 > number2 && number1 < c) || (number1 > c && number1 < number2)) {
            System.out.println("Среди чисел " + number1 + ", " + number2 + " и " + c + " число " + number1 +
                    " является средним числом");
        } else if ((number2 > number1 && number2 < c) || (number2 > c && number2 < number1)) {
            System.out.println("Среди чисел " + number1 + ", " + number2 + " и " + c + " число " + number2 +
                    " является средним числом");
        } else {
            System.out.println("Среди чисел " + number1 + ", " + number2 + " и " + c + " число " + c +
                    " является средним числом");
        }
    }
}
