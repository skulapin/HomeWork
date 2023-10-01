package home_work_2.arrays;

/*  2.3* Выполнить задание 2.2 иным способом. Создать интерфейс IArraysOperation с методами из задания, каждый метод
    должен принимать массив с которым он будет работать. Написать 4 отдельных класса и реализовать данный интерфейс:
		2.3.1. DoWhileOperation - во всех методах можно использовать только do....while
		2.3.2. WhileOperation - во всех методах можно использовать только while
		2.3.3. ForOperation - во всех методах можно использовать только for
		2.3.4. ForEachOperation - во всех методах можно использовать только foreach
 */

public interface IArraysOperation {
    /**
     * Выводит все элементы массива в консоль
     * @param arr Массив целочисленных переменных типа int
     */
    abstract void printAllElements(int arr[]);

    /**
     * Выводит в консоль каждый второй элемент целочисленного массива типа int
     * @param arr Массив целочисленных переменных типа int
     */
    abstract void printSecondElements(int arr[]);

    /**
     * Выводит в консоль все переменные целочисленного массива типа int в обратном порядке
     * @param arr Массив целочисленных переменных типа int
     */
    abstract void printAllElementsInReverse(int arr[]);
}

