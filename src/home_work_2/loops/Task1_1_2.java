package home_work_2.loops;

import home_work_2.utils.InputCheckerUtils;

/*  1. Циклы. Для преобразования строки в число можно использовать http://proglang.su/java/numbers-parseint, если хотите
    можете добавить проверки на корректность ввода данных. Число положительное, максимум long:
    1.1. Перемножить числа от 1 до числа (включительно) введенного через аргумент к исполняемой программе. Есть нюанс с
    переполнением, можно добавить проверки и сообщения пользователю.
    Пример: Ввели 5, должно получиться в консоли: 1 * 2 * 3 * 4 * 5 = ответ
	1.1.1. Используя только цикл
	1.1.2.* Используя рекурсию
*/

public class Task1_1_2 {

    /**
     * Формирует строку с выражением получения факториала заданного числа
     *
     * @param argument Число до которого перемножаем
     * @return Строковый результат перемножения факториала. При переполнении переменной, либо вводе отрицательного числа
     * выдает соответствующее предупреждение
     */
    public String getFactorial(int argument) {

        long result;
        StringBuilder builder = new StringBuilder();

        if (argument < 0) {
            return "Введено отрицательное число";
        }

        if (argument == 0) {
            return "0! = 1";
        }

        result = getFactorialValue(argument);

        if (result == 0) {
            return "Произошло переполнение переменной";
        }

        for (int i = 1; i <= argument; i++) {

            builder.append(i);
            if (i != argument) {
                builder.append(" * ");
            }
        }
        builder.append(" = ").append(result);
        return builder.toString();
    }

    /**
     * Возвращает факториал заданного числа
     *
     * @param argument Число до которого перемножаем
     * @return Факториал натурального числа. При переполнении переменной возвращает ноль
     */
    private long getFactorialValue(int argument) {

        long result = 1;

        if (argument == 1 || argument == 0) {
            return result;
        }

        long temp = getFactorialValue(argument - 1);

        if (temp > Long.MAX_VALUE / argument) {
            return 0;
        }
        result = argument * temp;
        return result;
    }
}