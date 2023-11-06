package home_work_1;

import java.util.Scanner;

/*  Разбираемся с операторами ветвления. Каждую задачу в отдельном классе. Пояснения по задачам сотреть в презентации и
на сайте по ссылке в презентации.
4.6 Определить високосный год или нет
Определить, является ли год, который ввел пользователь, високосным или невисокосным.
*/

public class Task4_6 {

    public static void main(String[] args) {

        short year;

        Scanner sc = new Scanner(System.in);

        System.out.print("Введите год: ");

        while (!sc.hasNextShort()) {
            sc.nextLine();
            System.out.print("Неверный ввод, повторите попытку: ");
        }

        year = sc.nextShort();

        if (isLeapYear(year)) {
            System.out.println(year + " является високосным годом.");
        } else {
            System.out.println(year + " не является високосным годом.");
        }
    }

    /**
     * Определяет является ли год високосным
     *
     * @param year Год
     * @return true - год является високосным, false - год не является високосным
     */
    public static boolean isLeapYear(short year) {
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return true;
            }
        } else {
            return false;
        }
    }
}