package home_work_2.arrays;

/**
 * Содержит методы выводящие в консоль элементы массива типа int при помощи ForEach
 */
public class ForEachOperation implements IArraysOperation {
    /**
     * Выводит все элементы массива в консоль
     *
     * @param arr Массив целочисленных переменных типа int
     */
    @Override
    public void printAllElements(int[] arr) {
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }

    /**
     * Выводит каждый второй элемент массива в консоль
     *
     * @param arr Массив целочисленных переменных типа int
     */
    @Override
    public void printSecondElements(int[] arr) {
        int i = 0;
        for (int j : arr) {
            if (i % 2 == 1) {
                System.out.print(j + " ");
            }
            i++;
        }
    }

    /**
     * Выводит все элементы массива в консоль в обратном порядке
     *
     * @param arr Массив целочисленных переменных типа int
     */
    @Override
    public void printAllElementsInReverse(int[] arr) {

        int[] varArray = new int[arr.length];
        int i = arr.length - 1;
        for (int j : arr) {
            varArray[i] = j;
            i--;
        }
        for (int j : varArray) {
            System.out.print(j + " ");
        }
    }

    /**
     * Вызывает все методы печати данного класса
     *
     * @param arr Массив целочисленных переменных типа int
     */
    public void printAllForEachOperation(int[] arr) {
        printAllElements(arr);
        System.out.println();
        printSecondElements(arr);
        System.out.println();
        printAllElementsInReverse(arr);
        System.out.println();
    }
}
