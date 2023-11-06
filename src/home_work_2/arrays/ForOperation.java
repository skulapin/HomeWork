package home_work_2.arrays;

/**
 * Содержит методы выводящие в консоль элементы массива типа int при помощи For
 */
public class ForOperation implements IArraysOperation {

    @Override
    public String printAllElements(int[] arr) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (builder.isEmpty()) {
                builder.append(arr[i]);
            } else {
                builder.append(" ").append(arr[i]);
            }
        }
        return builder.toString();
    }

    @Override
    public String printSecondElements(int[] arr) {
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i < arr.length; i += 2) {
            if (builder.isEmpty()) {
                builder.append(arr[i]);
            } else {
                builder.append(" ").append(arr[i]);
            }
        }
        return builder.toString();
    }

    @Override
    public String printAllElementsInReverse(int[] arr) {
        StringBuilder builder = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (builder.isEmpty()) {
                builder.append(arr[i]);
            } else {
                builder.append(" ").append(arr[i]);
            }
        }
        return builder.toString();
    }

    /**
     * Выводит на печать работу всех методов данного класса
     *
     * @param arr Массив целочисленных переменных типа int
     */
    public void printAllForOperation(int[] arr) {
        System.out.println(printAllElements(arr));
        System.out.println(printSecondElements(arr));
        System.out.println(printAllElementsInReverse(arr));
    }
}