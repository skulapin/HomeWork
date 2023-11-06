package home_work_2.loops;

/*  1.6. Вывести таблицу умножения в консоль. В консоли должно получиться также как и на картинке (динозаврика рисовать
    не надо): https://www.dropbox.com/s/ibakfuppvy2w32g/multiplication_table.jpeg?dl=0
 */

public class Task1_6 {

    /**
     * Собирает в строковую переменную таблицу умножения
     *
     * @return Таблица умножения
     */
    public String multiplicationTable() {

        int number;
        StringBuilder builder = new StringBuilder();

        for (int i = 1; i <= 10; i++) {
            if (i != 1) {
                builder.append("\n");
            }
            System.out.println();
            for (int j = 2; j <= 5; j++) {
                number = i * j;
                builder.append(returnFormula(i, j, number));
            }
        }

        builder.append("\n");

        for (int i = 0; i < 53; i++) {
            builder.append("-");

        }

        for (int i = 1; i <= 10; i++) {
            builder.append("\n");

            for (int j = 6; j <= 9; j++) {
                number = i * j;
                builder.append(returnFormula(i, j, number));
            }
        }
        return builder.toString();
    }


    /**
     * Собирает строку с выражением умножения двух чисел
     *
     * @param i      Второй множитель
     * @param j      Первый множитель
     * @param number Результат умножения
     * @return Переменная типа String с выражением перемножения двух чисел
     */
    public static String returnFormula(int i, int j, int number) {

        String result = j + " x ";

        if (i < 10) {
            result += " " + i + " = ";
        } else {
            result += i + " = ";
        }

        if (number < 10) {
            result += " " + number;
        } else {
            result += number;
        }

        if (j != 5 && j != 9) {
            result += " | ";
        }
        return result;
    }
}