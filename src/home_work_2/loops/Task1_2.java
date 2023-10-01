package home_work_2.loops;

/*  1.2. Все цифры из числа введенного через аргумент к исполняемой программе перемножить между собой и вывести ход
    вычислений в консоль. Пользователь обязан ввести целое число. Если ввели не целое то выдать сообщение о том что
    пользователь ввёл некорректные данные.
		1.2.1 Пример: Ввели 181232375, должно получиться в консоли: 1 * 8 * 1 * 2 * 3 * 2 * 3 * 7 * 5 = 10 080
		1.2.2 Пример: Ввели 99.2, должно получиться в консоли: Введено не целое число
		1.2.3 Пример: Ввели Привет, должно получиться в консоли: Введено не число
*/

public class Task1_2 {

    public static void main(String[] args) {

        if (args.length == 1) {

            String argument = args[0];

            boolean isDouble = false;
            boolean isString = false;
            boolean isNegativeNumber = false;

            int dotCounter = 0;
            int result = 1;

            String toConsole = "";

            // Проверяем потенциальное число на отрицательность

            if (argument.charAt(0) == '-') {
                isNegativeNumber = true;
            }

            // Проверяем наличие недопустимых символов в строке для числа

            for (int i = 0; i < argument.length(); i++) {

                if (!Character.isDigit(argument.charAt(i))) {

                    if (argument.charAt(i) == '.') {
                        isDouble = true;
                        dotCounter++;

                        if (dotCounter > 1) {
                            isString = true;
                            break;
                        }
                    } else {
                        if (i != 0 || !isNegativeNumber) {
                            isString = true;
                            break;
                        }
                    }
                }
            }

            // Проверяем частные ситуации в первом и последнем символе строки

            if (argument.charAt(0) == '0' || argument.charAt(0) == '.'
                    || argument.charAt(argument.length() - 1) == '.') {
                isString = true;
            }

            if (isString == true) {
                System.out.println("Введено не число");
            } else if (isDouble == true) {
                System.out.println("Введено не целое число");
            } else {

                // Собираем полученный результат в строку. Если число отрицательное - итерацию
                // производим со 2 символа.

                int j = 0;

                if (isNegativeNumber) {
                    j++;
                }
                for (int i = j; i < argument.length(); i++) {

                    toConsole += argument.charAt(i);

                    if (!(i == argument.length() - 1)) {
                        toConsole += " * ";
                    }
                    result *= Character.getNumericValue(argument.charAt(i));
                }

                toConsole += " = " + result;
                System.out.println(toConsole);
            }
        } else {
            System.out.println("Неверный аргумент к программе");
        }
    }
}