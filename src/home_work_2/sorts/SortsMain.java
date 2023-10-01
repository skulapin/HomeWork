package home_work_2.sorts;

import java.util.Arrays;
import home_work_2.utils.*;

/*  4.2. Создать класс SortsMain. Все проверки пишутся в main.
		4.2.1. После каждого теста в консоль вы должны распечатать сообщение формата "[Какой массив был до сортировки]
		-> [Каким стал массив после сортировки]". Для преобразования массива в текст можно использовать класс Arrays.
		4.2.2. Для тестов используем предварительно созданные массивы:
			4.2.2.1. new int[]{1,2,3,4,5,6}
			4.2.2.2. new int[]{1,1,1,1}
			4.2.2.3. new int[]{9,1,5,99,9,9}
			4.2.2.4. new int[]{}
			4.2.2.5. new int[]{6,5,4,3,2,1}
		4.2.2 После предварительных тестов пишем тест с рандомным заполнением массива. Вызывая ранее созданный метод
		arrayRandom (ArraysUtils.arrayRandom(50, 100)) получить массив. Отсортировать.
		4.2.3 После теста с рандомно заполненным массивом пишем тест с массивом полученным через консоль. Вызывая ранее
		созданный метод arrayFromConsole (ArraysUtils.arrayFromConsole()) получить массив. Отсортировать.
*/

public class SortsMain {

    public static void main(String[] args) {

        int[] array1 = new int[]{1, 2, 3, 4, 5, 6};
        int[] array2 = new int[]{1, 1, 1, 1};
        int[] array3 = new int[]{9, 1, 5, 99, 9, 9};
        int[] array4 = new int[]{};
        int[] array5 = new int[]{6, 5, 4, 3, 2, 1};
        int[] array6 = ArraysUtils.arrayRandom(50, 100);
        int[] array7 = ArraysUtils.arrayFromConsole();

        System.out.println("Сортировка предварительно созданных массивов пузырьковым способом:");
        System.out.println(sortArrayToString(array1));
        System.out.println(sortArrayToString(array2));
        System.out.println(sortArrayToString(array3));
        System.out.println(sortArrayToString(array4));
        System.out.println(sortArrayToString(array5));
        System.out.println();

        System.out.println("Сортировка предварительно созданных массивов шейкерным способом");
        System.out.println(shakeArrayToString(array1));
        System.out.println(shakeArrayToString(array2));
        System.out.println(shakeArrayToString(array3));
        System.out.println(shakeArrayToString(array4));
        System.out.println(shakeArrayToString(array5));
        System.out.println();

        System.out.println("Сортировка рандомно заполненного массива пузырьковым способом");
        System.out.println(sortArrayToString(array6));
        System.out.println();

        System.out.println("Сортировка рандомно заполненного массива шейкерным способом");
        System.out.println(shakeArrayToString(array6));
        System.out.println();

        System.out.println("Сортировка массива введенного с консоли пузырьковым способом");
        System.out.println(sortArrayToString(array7));
        System.out.println();

        System.out.println("Сортировка массива введенного с консоли шейкерным способом");
        System.out.println(shakeArrayToString(array7));
    }

    /**
     * Сортирует массив при помощи алгоритма пузырьковой сортировки
     * @param arr Массив элементов типа int
     * @return Переменная типа String c информацией [Какой массив был до сортировки] -> [Каким стал массив после сортировки]
     */
    public static String sortArrayToString(int[] arr) {

        String result = "";
        int[] tempArr = copyArray(arr);

        System.out.print(Arrays.toString(arr));
        SortsUtils.sort(arr);
        System.out.print(" -> " + Arrays.toString(arr));

        copyArray(arr, tempArr);

        return result;
    }

    /**
     * Сортирует массив при помощи алгоритма шейкерной сортировки
     * @param arr Массив элементов типа int
     * @return Переменная типа String c информацией [Какой массив был до сортировки] -> [Каким стал массив после сортировки]
     */
    public static String shakeArrayToString(int[] arr) {

        String result = "";
        int[] tempArr = copyArray(arr);

        System.out.print(Arrays.toString(arr));
        SortsUtils.shake(arr);
        System.out.print(" -> " + Arrays.toString(arr));

        copyArray(arr, tempArr);

        return result;
    }

    /**
     * Копирует массив переменных типа int
     * @param arr Массив элементов типа int
     * @return Скопированный массив элементов типа int
     */
    public static int[] copyArray(int[] arr) {

        int resultArray[] = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            resultArray[i] = arr[i];
        }
        return resultArray;
    }

    /**
     * Копирует массив переменных типа int
     * @param copyToArr Массив куда скопировать элементы
     * @param copyFromArr Массив откуда скопировать элементы
     */
    public static void copyArray(int[] copyToArr, int[] copyFromArr) {

        for (int i = 0; i < copyFromArr.length; i++) {
            copyToArr[i] = copyFromArr[i];
        }
    }
}