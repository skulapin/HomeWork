package home_work_2.arrays;

/**
 * Содержит методы выводящие в консоль элементы массива типа int при помощи While
 */
public class WhileOperation implements IArraysOperation {

    @Override
    public String printAllElements(int[] arr) {
        int i = 0;
        StringBuilder builder = new StringBuilder();
        while (i < arr.length) {
            if (builder.isEmpty()) {
                builder.append(arr[i]);
            } else {
                builder.append(" ").append(arr[i]);
            }
            i++;
        }
        return builder.toString();
    }

    @Override
    public String printSecondElements(int[] arr) {
        int i = 1;
        StringBuilder builder = new StringBuilder();
        while (i < arr.length) {
            if (builder.isEmpty()) {
                builder.append(arr[i]);
            } else {
                builder.append(" ").append(arr[i]);
            }
            i += 2;
        }
        return builder.toString();
    }

    @Override
    public String printAllElementsInReverse(int[] arr) {
        int i = arr.length - 1;
        StringBuilder builder = new StringBuilder();
        while (i >= 0) {
            if (builder.isEmpty()) {
                builder.append(arr[i]);
            } else {
                builder.append(" ").append(arr[i]);
            }
            i--;
        }
        return builder.toString();
    }

    /**
     * Выводит на печать работу всех методов данного класса
     *
     * @param arr Массив целочисленных переменных типа int
     */
    public void printAllWhileOperation(int[] arr) {
        System.out.println(printAllElements(arr));
        System.out.println(printSecondElements(arr));
        System.out.println(printAllElementsInReverse(arr));
    }
}