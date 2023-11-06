package home_work_2.loops;

import java.util.Scanner;

/*  1.3. Возведение в степень. Через консоль пользователь вводит два числа. Первое число это число которое мы будем
    возводить, Второе число это степень в которую возводят первое число. Степень - только положительная и целая.
    Возводимое число - может быть отрицательным и оно будет дробным. Math использовать нельзя.
		1.3.1 Пример: Ввели 18 и 5, должно получиться в консоли: 18.0 ^ 5 = 1 889 568.0
		1.3.2 Пример: Ввели 7.5 и 2, должно получиться в консоли: 7.5 ^ 2 = 56.25
*/

public class Task1_3 {

    /**
     * Возводит число в заданную степень и формирует строку с заданным выражением
     *
     * @param degreeBase Основание
     * @param exponent   Степень
     * @return Строка с выражением возведения числа в степень. При вводе отрицательной степени выводится соответствующее
     * предупреждение
     */
    public String getPow(double degreeBase, int exponent) {

        if (exponent < 0) {
            return "Cтепень должна быть положительная";
        }

        double result = 1;

        for (int i = 1; i <= exponent; i++) {
            result *= degreeBase;
        }
        return degreeBase + " ^ " + exponent + " = " + result;
    }
}