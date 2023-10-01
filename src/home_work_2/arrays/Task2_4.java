package home_work_2.arrays;

import home_work_2.utils.ArraysUtils;
import java.util.*;

/*  2.4 Задачи в презентации. На сайте есть пояснения по каждой из этих задач. Все задачи в одном классе, в отдельных
    методах. Для получения массивов вызывать ранее созданный метод arrayRandom (ArraysUtils.arrayRandom(50, 100))
		2.4.1. Сумма четных положительных элементов массива
		В массиве, содержащем положительные и отрицательные целые числа, вычислить сумму четных положительных элементов.
		2.4.2. Максимальный из элементов массива с четными индексами
		В массиве найти максимальный элемент с четным индексом.
		Другая формулировка задачи: среди элементов массива с четными индексами, найти тот, который имеет максимальное
		значение.
		2.4.3. Элементы массива, которые меньше среднего арифметического
		Найти в массиве те элементы, значение которых меньше среднего арифметического, взятого от всех элементов массива.
		2.4.4. Найти два наименьших (минимальных) элемента массива
		В одномерном массиве целых чисел определить два наименьших элемента. Они могут быть как равны между собой (оба
		являться минимальными), так и различаться.
		2.4.5. Сжать массив, удалив элементы, принадлежащие интервалу
		Сжать массив, удалив из него все элементы, величина которых находится в интервале [а, b]. Освободившиеся в конце
		массива элементы заполнить нулями.
		2.4.6. Сумма цифр массива
		Найти сумму всех цифр целочисленного массива. Например, если дан массив [12, 104, 81], то сумма всех его цифр
		будет равна 1 + 2 + 1 + 0 + 4 + 8 + 1 = 17.

		https://gospodaretsva.com/category/array
*/

public class Task2_4 {

    public static void main(String[] args) {

        int taskNumber;
        int[] array;

        Scanner sc = new Scanner(System.in);

        System.out.print("Введите номер задачи от 1 до 6: ");

        if (sc.hasNextInt()) {
            taskNumber = sc.nextInt();

            array = ArraysUtils.arrayRandom(50, 100);

            switch (taskNumber) {

                case (1):

                    int resultTask1 = task1(array);
                    System.out.println("Сумма положительных четных элементов в массиве равняется " + resultTask1);
                    break;
                case (2):

                    int resultTask2 = task2(array);
                    System.out.println("Максимальное число в массиве с четным индексом равняется  " + resultTask2);
                    break;
                case (3):

                    String resultTask3 = task3(array);
                    System.out.println("Элементы, значение которых меньше среднего арифметического всех элементов массива:");
                    System.out.println(resultTask3);
                    break;

                case (4):

                    int[] resultTask4 = task4(array);
                    System.out.println("Минимальные числа в массиве " + resultTask4[0] + " и " + resultTask4[1]);
                    break;

                case (5):
                    int minBound;
                    int maxBound;

                    System.out.println("Введите диапазон чисел который необходимо удалить из массива.");
                    System.out.print("Введите нижнюю границу: ");

                    while (!sc.hasNextInt()) {
                        sc.nextLine();
                        System.out.print("Неверный ввод, повторите попытку: ");
                    }
                    minBound = sc.nextInt();

                    System.out.print("Введите верхнюю границу: ");

                    while (true) {
                        while (!sc.hasNextInt()) {
                            sc.nextLine();
                            System.out.print("Неверный ввод, повторите попытку: ");
                        }
                        maxBound = sc.nextInt();
                        if (maxBound >= minBound) {
                            break;
                        } else {
                            System.out.print("Верхняя граница должна быть не меньше нижней. Повторите попытку: ");
                        }
                    }

                    task5(minBound, maxBound, array);

                    System.out.println(Arrays.toString(array));
                    break;

                case (6):

                    int resultTask6 = task6(array);
                    System.out.println("Сумма всех цифр целочисленного массива равна " + resultTask6);
                    break;

                default:
                    System.out.println("Введено неверное значение!");
            }
        } else {
            System.out.println("Введено неверное значение");
        }

    }

    /**
     * Вычисляет сумму четных положительных элементов массива типа int
     * @param array Массив элементов типа int
     * @return Сумма четных положительных элементов массива типа int
     */
    public static int task1(int[] array) {

        int result = 0;

        for (int i : array) {
            if (i % 2 == 0 && i > 0) {
                result += i;
            }
        }
        return result;
    }

    /**
     * Находит в массиве максимальный элемент с четным индексом
     * @param array Массив переменных типа int
     * @return Максимальный элемент в массиве с четным индексом
     */
    public static int task2(int[] array) {

        int maxValue = array[0];

        for (int i = 2; i < array.length; i = i + 2) {

            if (array[i] > maxValue) {
                maxValue = array[i];
            }
        }
        return maxValue;
    }

    /**
     * Находит в массиве элементы, значение которых меньше среднего арифметического всех элементов массива
     * @param array Массив переменных типа int
     * @return Переменную типа String с элементами массива, значение которых меньше среднего арифметического всех
     * элементов массива
     */
    public static String task3(int[] array) {

        int sum = 0;
        double average;
        String result = "";

        for (int i : array) {
            sum += i;
        }

        average = (double) sum / array.length;

        for (int i : array) {
            if (i < average) {
                result += i + " ";
            }
        }
        return result;
    }

    /**
     * Находит два наименьших элемента массива
     * @param array Массив переменных типа int
     * @return Массив из 2 ячеек с наименьшими элементами переданного в метод массива
     */
    public static int[] task4(int[] array) {

        int[] minimumNumbers = new int[2];


        minimumNumbers[0] = array[0];
        minimumNumbers[1] = array[1];

        for (int i = 2; i < array.length; i++) {

            if (array[i] < minimumNumbers[0] || array[i] < minimumNumbers[1]) {
                if (minimumNumbers[0] > minimumNumbers[1]) {
                    minimumNumbers[0] = array[i];
                } else {
                    minimumNumbers[1] = array[i];
                }
            }
        }
        return minimumNumbers;
    }

    /**
     * Сжимает массив, удаляя элементы величина которых находится в заданном интервале
     * @param min Минимальная граница интервала
     * @param max Максимальная граница интервала
     * @param array Массив переменных типа int который необходимо сжать
     */
    public static void task5(int min, int max, int[] array) {

        for (int i = 0; i < array.length; i++) {
            if (array[i] >= min && array[i] <= max) {
                array[i] = 0;
            }
        }
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] == 0) {
                for (int j = i + 1; j < array.length; j++) {
                    if (array[j] != 0) {
                        array[i] = array[j];
                        array[j] = 0;
                        break;
                    }
                }
            }
        }
    }

    /**
     * Находит сумму всех цифр целочисленного массива
     * @param array Массив переменных типа int
     * @return Сумма всех цифр целочисленного массива
     */
    public static int task6(int[] array) {

        int result = 0;

        for (int i : array) {
            if (i < 0) {
                i = Math.abs(i);
            }
            while (i > 0) {
                result += i % 10;
                i /= 10;
            }
        }
        return result;
    }
}