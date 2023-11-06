package home_work_2.loops;

/*  1.2. Все цифры из числа введенного через аргумент к исполняемой программе перемножить между собой и вывести ход
    вычислений в консоль. Пользователь обязан ввести целое число. Если ввели не целое то выдать сообщение о том что
    пользователь ввёл некорректные данные.
		1.2.1 Пример: Ввели 181232375, должно получиться в консоли: 1 * 8 * 1 * 2 * 3 * 2 * 3 * 7 * 5 = 10 080
		1.2.2 Пример: Ввели 99.2, должно получиться в консоли: Введено не целое число
		1.2.3 Пример: Ввели Привет, должно получиться в консоли: Введено не число
*/

public class Task1_2 {

    /**
     * Возвращает строку с расписанным перемножением всех цифр числа и конечным результатом.
     *
     * @param argument Строка с числом
     * @return Строка с расписанным перемножением всех цифр числа и конечным результатом.
     * При некорректных входных параметрах выводит сообщения:
     * "Введено не целое число" -  при дробном числе
     * "Введено не число" - при введеннном ни целом, ни дробном числе
     */
    public String multiplyNumbers(String argument) {

        boolean isDouble = false;
        boolean isString = false;
        boolean isNegativeNumber = false;

        int dotCounter = 0;
        int result = 1;

        StringBuilder builder = new StringBuilder();

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

        if ((argument.charAt(0) == '0' && argument.length() > 1 && argument.charAt(1) != '.') || argument.charAt(0) == '.'
                || argument.charAt(argument.length() - 1) == '.') {
            isString = true;
        }

        if (isString) {
            return "Введено не число";
        } else if (isDouble) {
            return "Введено не целое число";
        } else {

            // Собираем полученный результат в строку. Если число отрицательное - итерацию
            // производим со 2 символа.

            int j = 0;

            if (isNegativeNumber) {
                j++;
            }
            for (int i = j; i < argument.length(); i++) {

                builder.append(argument.charAt(i));

                if (!(i == argument.length() - 1)) {
                    builder.append(" * ");

                }
                result *= Character.getNumericValue(argument.charAt(i));
            }

            builder.append(" = ").append(result);

            return builder.toString();
        }
    }
}