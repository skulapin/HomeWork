package home_work_2.loops;

import java.util.Scanner;

/*  1.4.* Умножать число long a = 1; пока не произойдёт переполнение. В конце в консоль вывести сообщение со значением
    до переполнения и после переполнения. Умножать на:
    	1.4.1. 3
    	1.4.2. 188
    	1.4.3. -19
    	1.4.4. Да и вообще на любое целочисленное
  */

public class Task1_4 {

    /**
     * Умножает число 1 типа long до тех пор, пока не произойдёт переполнение
     *
     * @param degree Число на которое умножаем
     * @return Переменная типа String со значением до переполнения и после переполнения.
     * При вводе -1, 0 или 1 выводится предупреждающее сообщение.
     */
    public String answerToString(int degree) {

        int result = 1;
        String toConsole = "";

        if (degree > 1) {
            while (true) {

                result *= degree;

                if (Integer.MAX_VALUE / degree < result) {

                    toConsole += "Значение переменной до переполнения " + result;
                    result *= degree;
                    toConsole += "\nЗначение переменной после переполнения " + result;
                    break;
                }
            }
        } else if (degree < -1) {
            while (true) {
                if (result > 0) {
                    if (Integer.MIN_VALUE / degree < result) {

                        toConsole += "Значение переменной до переполнения " + result;
                        result *= degree;
                        toConsole += "\nЗначение переменной после переполнения " + result;
                        break;
                    }
                    result *= degree;
                } else {
                    if (Integer.MAX_VALUE / degree > result) {

                        toConsole += "Значение переменной до переполнения " + result;
                        result *= degree;
                        toConsole += "\nЗначение переменной после переполнения " + result;
                        break;
                    }
                    result *= degree;
                }
            }
        } else {
            toConsole = "Поберегите компьютер!";
        }
        return toConsole;
    }
}