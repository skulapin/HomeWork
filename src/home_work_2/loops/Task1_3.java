package home_work_2.loops;

import java.util.Scanner;

/*  1.3. Возведение в степень. Через консоль пользователь вводит два числа. Первое число это число которое мы будем
    возводить, Второе число это степень в которую возводят первое число. Степень - только положительная и целая.
    Возводимое число - может быть отрицательным и оно будет дробным. Math использовать нельзя.
		1.3.1 Пример: Ввели 18 и 5, должно получиться в консоли: 18.0 ^ 5 = 1 889 568.0
		1.3.2 Пример: Ввели 7.5 и 2, должно получиться в консоли: 7.5 ^ 2 = 56.25
*/

public class Task1_3 {

    public static void main(String[] args) {

        double degreeBase;
        int exponent;
        double result = 1;

        Scanner sc = new Scanner(System.in);

        System.out.print("Введите основание степени: ");

        while (!sc.hasNextDouble()) {

            sc.nextLine();
            System.out.print("Неверный ввод, повторите попытку: ");
        }

        degreeBase = sc.nextDouble();

        System.out.print("Введите показатель степени: ");

        while (true) {
            while (!sc.hasNextInt()) {

                sc.nextLine();
                System.out.print("Неверный ввод, повторите попытку: ");
            }

            exponent = sc.nextInt();

            if (exponent >= 1) {
                break;
            } else {
                System.out.print("Неверный ввод, повторите попытку: ");
            }
        }

        for (int i = 1; i <= exponent; i++) {
            result *= degreeBase;
        }
        System.out.println(degreeBase + " ^ " + exponent + " = " + result);
    }
}