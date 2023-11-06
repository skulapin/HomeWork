package home_work_2.arrays;

/**
 * Содержит методы выводящие в консоль элементы массива типа int при помощи Do...While
 */
public class DoWhileOperation implements IArraysOperation {

    @Override
    public String printAllElements(int[] arr) {

        if (arr.length == 0) {
            return "";
        }
        int i = 0;
        StringBuilder builder = new StringBuilder();
        do {
            if (builder.isEmpty()) {
                builder.append(arr[i]);
            } else {
                builder.append(" ").append(arr[i]);
            }
            i++;
        } while (i < arr.length);
        return builder.toString();
    }

    @Override
    public String printSecondElements(int[] arr) {

        if (arr.length == 0) {
            return "";
        }
        int i = 1;
        StringBuilder builder = new StringBuilder();
        do {
            if (builder.isEmpty()) {
                builder.append(arr[i]);
            } else {
                builder.append(" ").append(arr[i]);
            }
            i += 2;
        } while (i < arr.length);
        return builder.toString();
    }

    @Override
    public String printAllElementsInReverse(int[] arr) {

        if (arr.length == 0) {
            return "";
        }
        int i = arr.length - 1;
        StringBuilder builder = new StringBuilder();
        do {
            if (builder.isEmpty()) {
                builder.append(arr[i]);
            } else {
                builder.append(" ").append(arr[i]);
            }
            i--;
        } while (i >= 0);
        return builder.toString();
    }

    /**
     * Выводит на печать работу всех методов данного класса
     *
     * @param arr Массив целочисленных переменных типа int
     */
    public void printAllDoWhileOperation(int[] arr) {
        System.out.println(printAllElements(arr));
        System.out.println(printSecondElements(arr));
        System.out.println(printAllElementsInReverse(arr));
    }
}