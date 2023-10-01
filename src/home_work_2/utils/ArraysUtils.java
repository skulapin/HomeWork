package home_work_2.utils;

import java.util.*;

/*  2.1. Создать класс ArraysUtils. В этом классе не должно быть main метода. В этом классе написать следующие методы:
		2.1.1. Написать метод public static int[] arrayFromConsole(). Данный метод размер массива и каждый его элемент
		запрашивает у пользователя через консоль.
			2.1.1.1. Пример в отдельном классе с main. int[] container = arrayFromConsole(). Результат: В методе
			arrayFromConsole будет запрошена информация у пользователя, пользователь вводит размер (3) и его элементы
			по порядку {4, 17, 32}. Соответсвенно будет создан массив размером 3 с элементами {4, 17, 32} и сохранён
			в переменную container.
		2.1.2. Написать метод public static int[] arrayRandom(int size, int maxValueExclusion). Данный метод принимает
		два аргумента. Первый (size) указывает размер массива который мы хотим получить. Второй (maxValueExclusion)
		указывает до какого числа генерировать рандомные числа.
			2.1.2.1. Пример в отдельном классе с main. int[] container = arrayRandom(5, 100). Результат: В методе
			arrayRandom будет создан массив размером 5 с числами от 0 до 99 (использовать класс Random) и сохранён в
			переменную container.
			*/
/**
 * Содержит методы помогающие инициализировать и заполнить целочисленный массив переменными типа int
 */
public class ArraysUtils {
    /**
     * Создает целочисленный массив, размер и элементы которого запрашиваются у пользователя через консоль
     * @return Массив целочисленных переменных типа int
     */
    public static int[] arrayFromConsole() {

        int[] array;
        int arraySize;

        Scanner sc = new Scanner(System.in);

        System.out.print("Введите размерность массива: ");

        while (true) {
            while (!sc.hasNextInt()) {
                sc.nextLine();
                System.out.print("Неверный ввод, повторите попытку!");
            }

            arraySize = sc.nextInt();

            if (arraySize >= 0) {
                break;
            } else {
                System.out.print("Размер массива не может быть отрицательным! Повторите попытку: ");
            }
        }

        array = new int[arraySize];

        for (int i = 0; i < array.length; i++) {

            System.out.print("Введите " + i + " элемент массива: ");

            while (!sc.hasNextInt()) {
                sc.nextLine();
                System.out.println("Неверный ввод, повторите попытку!");
            }
            array[i] = sc.nextInt();
        }
        return array;
    }

    /**
     * Создает целочисленный массив переменных типа int, сгенерированных случайным образом
     * @param size Размер массива
     * @param maxValueExclusion Число, от нуля до которого заполнять ячейки массива
     * @return Массив целочисленных переменных типа int
     */
    public static int[] arrayRandom(int size, int maxValueExclusion) {

        int[] array = new int[size];
        Random rand = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(maxValueExclusion);
        }
        return array;
    }
}