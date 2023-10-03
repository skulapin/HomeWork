package home_work_2.loops;

/*  1.6. Вывести таблицу умножения в консоль. В консоли должно получиться также как и на картинке (динозаврика рисовать
    не надо): https://www.dropbox.com/s/ibakfuppvy2w32g/multiplication_table.jpeg?dl=0
 */

public class Task1_6 {

    public static void main(String[] args) {

        int number;

        for (int i = 1; i <= 10; i++) {
            System.out.println();
            for (int j = 2; j <= 5; j++) {
                number = i * j;
                System.out.print(returnFormula(i, j, number));
            }
        }

        System.out.println();

        for (int i = 0; i < 53; i++) {
            System.out.print("-");
        }

        for (int i = 1; i <= 10; i++) {
            System.out.println();
            for (int j = 6; j <= 9; j++) {
                number = i * j;
                System.out.print(returnFormula(i, j, number));
            }
        }
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