package home_work_2.arrays;

/**
 * Содержит методы выводящие в консоль элементы массива типа int при помощи Do...While
 */
public class DoWhileOperation implements IArraysOperation {
    /**
     * Выводит все элементы массива в консоль.
     *
     * @param arr Массив целочисленных переменных типа int
     */
    @Override
    public void printAllElements(int[] arr) {
        int i = 0;
        do {
            System.out.print(arr[i] + " ");
            i++;
        } while (i < arr.length);
    }

    /**
     * Выводит каждый второй элемент массива в консоль
     *
     * @param arr Массив целочисленных переменных типа int
     */
    @Override
    public void printSecondElements(int[] arr) {
        int i = 1;
        do {
            System.out.print(arr[i] + " ");
            i += 2;
        } while (i < arr.length);
    }

    /**
     * Выводит все элементы массива в консоль в обратном порядке
     *
     * @param arr Массив целочисленных переменных типа int
     */
    @Override
    public void printAllElementsInReverse(int[] arr) {
        int i = arr.length - 1;
        do {
            System.out.print(arr[i] + " ");
            i--;
        } while (i >= 0);
    }

    /**
     * Вызывает все методы печати данного класса
     *
     * @param arr Массив целочисленных переменных типа int
     */
    public void printAllDoWhileOperation(int[] arr) {
        printAllElements(arr);
        System.out.println();
        printSecondElements(arr);
        System.out.println();
        printAllElementsInReverse(arr);
        System.out.println();
    }
}