package home_work_2.arrays;

import home_work_2.utils.ArraysUtils;

/* 2.2 Создать класс ArraysIteration. В этом классе написать перебор (итерирование) массива при помощи do....while,
    while, for, foreach. Вызывая ранее созданный метод arrayFromConsole (ArraysUtils.arrayFromConsole()) получить массив.
    Все задачи в одном классе, в отдельных методах, в каждом методе используется 4 разных цикла. Должно получиться 3 метода:
		2.2.1. Вывести все элементы в консоль.
		2.2.2. Вывести каждый второй элемент массива в консоль.
		2.2.3. Вывести все элементы массива в консоль в обратном порядке.
*/

public class ArraysIteration {

    public static void main(String[] args) {

        int[] array = ArraysUtils.arrayFromConsole();

        printAllElements(array);
        System.out.println();
        printSecondElements(array);
        System.out.println();
        printAllElementsInReverse(array);
    }

    /**
     * Выводит в консоль все переменные целочисленного массива типа int
     *
     * @param arr Массив целочисленных переменных типа int
     */
    public static void printAllElements(int arr[]) {
        int i = 0;
        do {
            System.out.print(arr[i] + " ");
            i++;
        } while (i < arr.length);

        System.out.println();
        i = 0;

        while (i < arr.length) {
            System.out.print(arr[i] + " ");
            i++;
        }

        System.out.println();

        for (i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();

        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();
    }

    /**
     * Выводит в консоль каждый второй элемент целочисленного массива типа int
     *
     * @param arr Массив целочисленных переменных типа int
     */
    public static void printSecondElements(int arr[]) {

        int i = 1;
        do {
            System.out.print(arr[i] + " ");
            i += 2;
        } while (i < arr.length);

        System.out.println();
        i = 1;

        while (i < arr.length) {
            System.out.print(arr[i] + " ");
            i += 2;
        }

        System.out.println();

        for (i = 1; i < arr.length; i += 2) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();

        i = 0;
        for (int j : arr) {
            if (i % 2 == 1) {
                System.out.print(j + " ");
            }
            i++;
        }
        System.out.println();
    }

    /**
     * Выводит в консоль все переменные целочисленного массива типа int в обратном порядке
     *
     * @param arr Массив целочисленных переменных типа int
     */
    public static void printAllElementsInReverse(int arr[]) {

        int i = arr.length - 1;

        do {
            System.out.print(arr[i] + " ");
            i--;
        } while (i >= 0);

        System.out.println();
        i = arr.length - 1;

        while (i >= 0) {
            System.out.print(arr[i] + " ");
            i--;
        }

        System.out.println();

        for (i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();

        int[] varArray = new int[arr.length];
        i = arr.length - 1;

        for (int j : arr) {
            varArray[i] = j;
            i--;
        }

        for (int j : varArray) {
            System.out.print(j + " ");
        }
    }
}