package home_work_1;

import java.util.Scanner;

/*  Разбираемся с операторами ветвления. Каждую задачу в отдельном классе. Пояснения по задачам сотреть в презентации и
    на сайте по ссылке в презентации.

	4.5 Буква или иной символ
	Вводится целое число, обозначающее код символа по таблице ASCII. Определить, это код английской буквы или какой-либо
	иной символ.
 */

public class Task4_5 {

    public static void main(String[] args) {

        byte number;
        Scanner sc = new Scanner(System.in);

        System.out.print("Введите число в диапазоне от 0 до 127:");

        while(true) {
            while (!sc.hasNextByte()) {
                sc.nextLine();
                System.out.print("Неверный ввод, повторите попытку: ");
            }
            number = sc.nextByte();
            if (number >= 0){
                break;
            }else{
                System.out.print("Число должно быть положительным, повторите попытку: ");
            }
        }

        if ((number >= 65 && number <= 90) || (number >= 97 && number <= 122)) {
            System.out.println("Введено число обозначающее код английской буквы " + (char) number);
        } else {
            System.out.println("Введенное число не является кодом английской буквы");
        }
    }
}
