package home_work_1;

import java.util.Scanner;

/*  Разбираемся с операторами ветвления. Каждую задачу в отдельном классе. Пояснения по задачам сотреть в презентации и
    на сайте по ссылке в презентации.

	4.4 Перевести байты в килобайты или наоборот
    Перевести число, введенное пользователем, в байты или килобайты в зависимости от его выбора
 */

public class Task4_4 {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int data;

        String choice;

        System.out.print("Для перевода байт в килобайты введите \"yes\", для перевода килобайтов в байты "
                + "нажмите \"no\".\nВведите Ваш выбор:");

        choice = sc.nextLine();

        if (choice.equals("yes")) {

            System.out.print("Введите количество байт:");

            data = getDataNumber();

            System.out.println(data + " байт равняется " + bytesToKilobytes(data) + " килобайт");
        } else if (choice.equals("no")) {

            System.out.print("Введите количество килобайт:");

            data = getDataNumber();

            System.out.println(data + " килобайт равняется " + kilobytesToBytes(data) + " байт");
        } else {
            System.out.println("Введено неверное значение. Перезапустите программу!");
        }
    }

    /**
     * Переводит байты в килобайты
     *
     * @param data Число байт
     * @return Возвращает величину преобразованную в килобайты.
     * При введенном отрицательном числе возвращает -1
     */
    public static double bytesToKilobytes(int data) {
        if (data < 0) {
            return -1;
        }
        return data / 1024.0;
    }

    /**
     * Переводит килобайты в байты
     *
     * @param data Число килобайт
     * @return Возвращает величину преобразованную в байты.
     * При введенном отрицательном числе возвращает -1
     */
    public static int kilobytesToBytes(int data) {
        if (data < 0) {
            return -1;
        }
        return data * 1024;
    }

    /**
     * Запрашивает у пользователя числовой объем памяти
     *
     * @return Число равняющееся объему памяти
     */
    private static int getDataNumber() {

        int data;

        while (true) {
            while (!sc.hasNextInt()) {
                sc.nextLine();
                System.out.print("Неверный ввод, повторите попытку: ");
            }
            data = sc.nextInt();
            if (data >= 0) {
                return data;
            } else {
                System.out.print("Память не может быть отрицательным числом, повторите попытку: ");
            }
        }
    }
}