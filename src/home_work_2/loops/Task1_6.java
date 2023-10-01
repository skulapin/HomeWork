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
                System.out.print(j + " x " + i + " = " + number + "    ");
            }
        }

        for (int i = 1; i <= 10; i++) {
            System.out.println();
            for (int j = 6; j <= 10; j++) {
                number = i * j;
                System.out.print(j + " x " + i + " = " + number + "    ");
            }
        }
    }
}