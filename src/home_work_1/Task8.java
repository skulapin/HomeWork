package home_work_1;

import java.util.Scanner;

/*8.** Создать СТАТИЧЕСКИЙ метод String toBinaryString(byte number) и возвращает двоичное представление числа. В методе
можно использовать только обычную математику которая описана в теории. Если число отрицательное то вернуть
дополнительный код. Теория https://planetcalc.ru/747. Пример:
	8.1 Вводим: 42.  Возвращает: 00101010
	8.2 Вводим: 15.  Возвращает: 00001111
	8.3 Вводим: -42. Возвращает: 11010110
	8.4 Вводим: -15. Возвращает: 11110001
 */

public class Task8 {

    public static void main(String[] args) {

        byte inputNumber;
        String binaryBumber;

        Scanner sc = new Scanner(System.in);

        System.out.print("Введите число от -128 до 127: ");

        while (!sc.hasNextByte()) {
            sc.nextLine();
            System.out.print("Неверный ввод, повторите попытку: ");
        }

        inputNumber = sc.nextByte();

        binaryBumber = toBinaryString(inputNumber);

        System.out.println("Число " + inputNumber + " в двоичной системе счисления равняется " + binaryBumber);

    }

    public static String toBinaryString(byte number) {

        String result;
        int binaryBit = 64;

        if (number >= 0) {
            result = "0";
            for (int i = 1; i < 8; i++) {
                if (number / binaryBit == 1) {
                    result += 1;
                    number -= binaryBit;
                } else {
                    result += 0;
                }
                binaryBit /= 2;
            }
        } else {

            int[] binaryNumber = new int[8];
            number = (byte) Math.abs(number);

            // переводим модуль отрицательного числа в двоичную систему

            for (int i = 1; i < binaryNumber.length; i++) {
                if (number / binaryBit == 1) {
                    binaryNumber[i] = 1;
                    number -= binaryBit;
                } else {
                    binaryNumber[i] = 0;
                }
                binaryBit /= 2;
            }

            // Реверсируем 0 и 1 в массиве

            for (int i = 0; i < binaryNumber.length; i++) {
                if (binaryNumber[i] == 0) {
                    binaryNumber[i] = 1;
                } else {
                    binaryNumber[i] = 0;
                }
            }

            //переводим двоичное число в десятичное с добавлением единицы

            number = 1;
            binaryBit = 64;
            for (int i = 1; i < binaryNumber.length; i++) {

                number += binaryNumber[i] * binaryBit;
                binaryBit /= 2;
            }

            // переводим десятичное число в двоичное c заполнением старшего бита единицей

            result = "1";
            binaryBit = 64;
            for (int i = 1; i < 8; i++) {
                if (number / binaryBit == 1) {
                    result += 1;
                    number -= binaryBit;
                } else {
                    result += 0;
                }
                binaryBit /= 2;
            }
        }
        return result;
    }
}