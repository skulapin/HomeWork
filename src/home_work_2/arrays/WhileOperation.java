package home_work_2.arrays;

/**
 * Содержит методы выводящие в консоль элементы массива типа int при помощи While
 */
public class WhileOperation implements IArraysOperation {
    /**
     * Выводит все элементы массива в консоль
     *
     * @param arr Массив целочисленных переменных типа int
     */
    @Override
    public void printAllElements(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            System.out.print(arr[i] + " ");
            i++;
        }
    }

    /**
     * Выводит каждый второй элемент массива в консоль
     *
     * @param arr Массив целочисленных переменных типа int
     */
    @Override
    public void printSecondElements(int[] arr) {
        int i = 1;
        while (i < arr.length) {
            System.out.print(arr[i] + " ");
            i += 2;
        }
    }

    /**
     * Выводит все элементы массива в консоль в обратном порядке
     *
     * @param arr Массив целочисленных переменных типа int
     */
    @Override
    public void printAllElementsInReverse(int[] arr) {
        int i = arr.length - 1;
        while (i >= 0) {
            System.out.print(arr[i] + " ");
            i--;
        }
    }

    /**
     * Вызывает все методы печати данного класса
     *
     * @param arr Массив целочисленных переменных типа int
     */
    public void printAllWhileOperation(int[] arr) {
        printAllElements(arr);
        System.out.println();
        printSecondElements(arr);
        System.out.println();
        printAllElementsInReverse(arr);
        System.out.println();
    }
}