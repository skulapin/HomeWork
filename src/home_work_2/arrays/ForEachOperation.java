package home_work_2.arrays;

/**
 * Содержит методы выводящие в консоль элементы массива типа int при помощи ForEach
 */
public class ForEachOperation implements IArraysOperation {

    @Override
    public String printAllElements(int[] arr) {
        StringBuilder builder = new StringBuilder();
        for (int j : arr) {
            if (builder.isEmpty()) {
                builder.append(j);
            } else {
                builder.append(" ").append(j);
            }
        }
        return builder.toString();
    }

    @Override
    public String printSecondElements(int[] arr) {
        int i = 0;
        StringBuilder builder = new StringBuilder();
        for (int j : arr) {
            if (i % 2 == 1) {
                if (builder.isEmpty()) {
                    builder.append(j);
                } else {
                    builder.append(" ").append(j);
                }
            }
            i++;
        }
        return builder.toString();
    }

    @Override
    public String printAllElementsInReverse(int[] arr) {

        int[] varArray = new int[arr.length];
        int i = arr.length - 1;
        StringBuilder builder = new StringBuilder();
        for (int j : arr) {
            varArray[i] = j;
            i--;
        }
        for (int j : varArray) {
            if (builder.isEmpty()) {
                builder.append(j);
            } else {
                builder.append(" ").append(j);
            }
        }
        return builder.toString();
    }

    /**
     * Выводит на печать работу всех методов данного класса
     *
     * @param arr Массив целочисленных переменных типа int
     */
    public void printAllForEachOperation(int[] arr) {
        System.out.println(printAllElements(arr));
        System.out.println(printSecondElements(arr));
        System.out.println(printAllElementsInReverse(arr));
    }
}
