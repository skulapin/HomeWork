package home_work_1;

import java.util.Scanner;

/*  Разбираемся с операторами ветвления. Каждую задачу в отдельном классе. Пояснения по задачам сотреть в презентации и
    на сайте по ссылке в презентации.

	4.4 Перевести байты в килобайты или наоборот
    Перевести число, введенное пользователем, в байты или килобайты в зависимости от его выбора
 */

public class Task4_4 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int data;
        double result;
        String choice;

        System.out.print("Для перевода байт в килобайты введите \"yes\", для перевода килобайтов в байты " +
                "нажмите \"no\".\nВведите Ваш выбор:");

        choice = sc.nextLine();

        if (choice.equals("yes")) {

            System.out.print("Введите количество байт:");

            while (true) {
                while (!sc.hasNextInt()) {
                    sc.nextLine();
                    System.out.print("Неверный ввод, повторите попытку: ");
                }
                data = sc.nextInt();
                if (data >= 0) {
                    break;
                } else {
                    System.out.print("Память не может быть отрицательным числом, повторите попытку: ");
                }
            }
            result = (double) data / 1024;
            System.out.println(data + " байт равняется " + result + " килобайт");
        } else if (choice.equals("no")) {

            System.out.print("Введите количество килобайт:");

            while (true) {
                while (!sc.hasNextInt()) {
                    sc.nextLine();
                    System.out.print("Неверный ввод, повторите попытку: ");
                }
                data = sc.nextInt();
                if (data >= 0) {
                    break;
                } else {
                    System.out.print("Память не может быть отрицательным числом, повторите попытку: ");
                }
            }
            result = data * 1024;
            System.out.println(data + " килобайт равняется " + result + " байт");
        } else {
            System.out.println("Введено неверное значение. Перезапустите программу!");
        }
    }
}
