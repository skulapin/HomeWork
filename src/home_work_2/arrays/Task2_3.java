package home_work_2.arrays;

/*  2.3* Выполнить задание 2.2 иным способом. Создать интерфейс IArraysOperation с методами из задания, каждый метод
    должен принимать массив с которым он будет работать. Написать 4 отдельных класса и реализовать данный интерфейс:
		2.3.1. DoWhileOperation - во всех методах можно использовать только do....while
		2.3.2. WhileOperation - во всех методах можно использовать только while
		2.3.3. ForOperation - во всех методах можно использовать только for
		2.3.4. ForEachOperation - во всех методах можно использовать только foreach
*/

import home_work_2.utils.ArraysUtils;

public class Task2_3 {

    public static void main(String[] args) {

        int[] array = ArraysUtils.arrayFromConsole();

        DoWhileOperation sortDoWhile = new DoWhileOperation();
        WhileOperation sortWhile = new WhileOperation();
        ForOperation sortForOperation = new ForOperation();
        ForEachOperation sortForEach = new ForEachOperation();

        System.out.println("Итерирование при помощи Do...While");
        sortDoWhile.printAllDoWhileOperation(array);

        System.out.println("Итерирование при помощи While");
        sortWhile.printAllWhileOperation(array);

        System.out.println("Итерирование при помощи For");
        sortForOperation.printAllForOperation(array);

        System.out.println("Итерирование при помощи ForEach");
        sortForEach.printAllForEachOperation(array);
    }
}