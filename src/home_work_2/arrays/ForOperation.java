package home_work_2.arrays;

/**
 * Содержит методы выводящие в консоль элементы массива типа int при помощи For
 */
public class ForOperation implements IArraysOperation {
    /**
     * Выводит все элементы массива в консоль
     *
     * @param arr Массив целочисленных переменных типа int
     */
    @Override
    public void printAllElements(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    /**
     * Выводит каждый второй элемент массива в консоль
     *
     * @param arr Массив целочисленных переменных типа int
     */
    @Override
    public void printSecondElements(int[] arr) {
        for (int i = 1; i < arr.length; i += 2) {
            System.out.print(arr[i] + " ");
        }
    }

    /**
     * Выводит все элементы массива в консоль в обратном порядке
     *
     * @param arr Массив целочисленных переменных типа int
     */
    @Override
    public void printAllElementsInReverse(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
    }

    /**
     * Вызывает все методы печати данного класса
     *
     * @param arr Массив целочисленных переменных типа int
     */
    public void printAllForOperation(int[] arr) {
        printAllElements(arr);
        System.out.println();
        printSecondElements(arr);
        System.out.println();
        printAllElementsInReverse(arr);
        System.out.println();
    }
}