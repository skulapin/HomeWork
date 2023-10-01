package home_work_2.arrays;

import home_work_2.utils.ArraysUtils;

/*  2.1.1.1. Пример в отдельном классе с main. int[] container = arrayFromConsole(). Результат: В методе arrayFromConsole
    будет запрошена информация у пользователя, пользователь вводит размер (3) и его элементы по порядку {4, 17, 32}.
    Соответсвенно будет создан массив размером 3 с элементами {4, 17, 32} и сохранён в переменную container.
 */

public class Task2_1_1_1 {

    public static void main(String[] args) {

        int[] container = ArraysUtils.arrayFromConsole();

        for (int i : container) {
            System.out.print(i + " ");
        }
    }
}
