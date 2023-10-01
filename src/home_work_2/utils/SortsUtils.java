package home_work_2.utils;

/* 4.1. Создать класс SortsUtils. В этом классе не должно быть main метода. В этом классе написать следующие методы:
		4.1.1. Написать метод public static void sort(int[] arr). Данный метод будет сортировать переданный ему массив
		при помощи алгоритма пузырьковая сортировка. Описание алгоритма: https://prog-cpp.ru/sort-bubble/
		4.1.2. Написать метод public static void shake(int[] arr). Данный метод будет сортировать переданный ему массив
		при помощи алгоритма шейкерная сортировка. Описание алгоритма: https://prog-cpp.ru/sort-shaker/
 */

/**
 * Содержит методы производящие сортировку элементов массива типа int
 */
public class SortsUtils {
    /**
     * Сортирует массив при помощи алгоритма пузырьковой сортировки
     * @param arr Массив элементов типа int
     */
    public static void sort(int[] arr) {

        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {

                    int temp;

                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    /**
     * Сортирует массив при помощи алгоритма шейкерной сортировки
     * @param arr Массив элементов типа int
     */
    public static void shake(int[] arr) {

        int leftPosition = 0;
        int rightPosition = arr.length - 1;
        boolean hasSorted = true;

        while (leftPosition < rightPosition && hasSorted) {

            hasSorted = false;
            for (int i = leftPosition; i < rightPosition; i++) {
                if (arr[i] > arr[i + 1]) {

                    int temp;

                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    hasSorted = true;
                }
            }

            if (!hasSorted) {
                break;
            }

            rightPosition--;

            for (int i = rightPosition; i > leftPosition; i--) {
                if (arr[i] < arr[i - 1]) {

                    int temp;

                    temp = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = temp;
                    hasSorted = true;
                }
            }
            leftPosition++;
        }
    }
}