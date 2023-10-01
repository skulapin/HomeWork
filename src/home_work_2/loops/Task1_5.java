package home_work_2.loops;

import java.util.Scanner;

/*  1.5. Задачи в презентации. На сайте есть пояснения по каждой из этих задач. Все задачи в одном классе, в отдельных
        методах.
    	1.5.1. Найти наибольшую цифру натурального числа
    	С клавиатуры вводится натуральное число. Найти его наибольшую цифру. Например, введено число 764580. Наибольшая
    	цифра в нем 8.
    	1.5.2. Вероятность четных случайных чисел
    	Проверить корректность работы генератора псевдослучайных чисел языка программирования с помощью оценки
    	вероятности выпадения четных чисел на выборке не меньше 1000 случайный чисел.
    	1.5.3. Посчитать четные и нечетные цифры числа
    	Посчитать четные и нечетные цифры введенного натурального числа. Например, если введено число 34560, то у него
    	3 четные цифры (4,6 и 0) и 2 нечетные (3 и 5)
    	1.5.4. Ряд Фибоначчи
        Вывести на экран столько элементов ряда Фибоначчи, сколько указал пользователь. Например, если на ввод поступило
        число 6, то вывод должен содержать шесть первых чисел ряда Фибоначчи: 1 2 3 5 8 13.
    	1.5.5. Вывести ряд чисел в диапазоне с шагом
    	Вывести на экран ряд натуральных чисел от минимума до максимума с шагом. Например, если минимум 10, максимум 35,
    	шаг 5, то вывод должен быть таким: 10 15 20 25 30 35. Минимум, максимум и шаг указываются пользователем
    	(считываются с клавиатуры).
    	1.5.6. Переворот числа
    	Сформировать из введенного числа обратное по порядку входящих в него цифр и вывести на экран. Например, если
    	введено число 3486, то надо вывести число 6843.

    	https://gospodaretsva.com/category/cycles
    	*/

public class Task1_5 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int taskNumber;

        System.out.print("Введите номер задачи от 1 до 6: ");

        if (sc.hasNextInt()) {

            taskNumber = sc.nextInt();

            switch (taskNumber) {

                case (1):

                    int numberTask1;
                    int resultTask1;

                    System.out.print("Введите натуральное число: ");

                    if (sc.hasNextInt()) {

                        numberTask1 = sc.nextInt();
                        resultTask1 = task1(numberTask1);

                        System.out.println("Максимальная цифра в числе " + numberTask1 + " равняется " + resultTask1);
                    } else {
                        sc.nextLine();
                        System.out.println("Введено не число");
                    }
                    break;

                case (2):

                    int numberTask2;
                    double resultTask2;

                    System.out.print("Введите число выборки: ");

                    if (sc.hasNextInt()) {

                        numberTask2 = sc.nextInt();
                        if (numberTask2 > 0) {
                            resultTask2 = task2(numberTask2);

                            System.out.println(
                                    "При выборке в " + numberTask2 + " процент четных чисел равен " + resultTask2 + "%");
                        } else {
                            System.out.println("Введено не положительное число");
                        }
                    } else {
                        sc.nextLine();
                        System.out.println("Введено не число");
                    }

                    break;
                case (3):

                    int numberTask3;
                    int[] resultTask3;

                    System.out.print("Введите натуральное число: ");

                    if (sc.hasNextInt()) {

                        numberTask3 = sc.nextInt();
                        resultTask3 = task3(numberTask3);

                        System.out.println("В числе " + numberTask3 + " количество четных чисел равно " + resultTask3[0]
                                + " , количество нечетных чисел равно " + resultTask3[1]);
                    } else {
                        sc.nextLine();
                        System.out.println("Введено не число");
                    }
                    break;

                case (4):

                    int numberTask4;
                    String resultTask4;

                    System.out.print("Введите порядок числа Фибоначчи: ");

                    if (sc.hasNextInt()) {

                        numberTask4 = sc.nextInt();

                        if (numberTask4 > 0) {

                            resultTask4 = task4(numberTask4);

                            System.out.println("Число Фибоначчи " + numberTask4 + "-го порядка: " + resultTask4);
                        } else {
                            System.out.println("Введено не положительное число");
                        }
                    } else {
                        sc.nextLine();
                        System.out.println("Введено не число");
                    }
                    break;

                case (5):

                    int minValue;
                    int maxValue;
                    int incrementNumber;
                    String resultTask5;

                    System.out.print("Введите минимальное значение: ");

                    if (sc.hasNextInt()) {
                        minValue = sc.nextInt();

                        System.out.print("Введите максимальное значение: ");

                        if (sc.hasNextInt()) {

                            maxValue = sc.nextInt();

                            if (minValue <= maxValue) {

                                System.out.print("Введите шаг: ");

                                if (sc.hasNextInt()) {
                                    incrementNumber = sc.nextInt();

                                    if (incrementNumber > 0) {

                                        resultTask5 = task5(minValue, maxValue, incrementNumber);
                                        System.out.println("Последовательность от числа " + minValue + " до числа "
                                                + maxValue + " с шагом " + incrementNumber + ": " + resultTask5);
                                    } else {
                                        System.out.println("Шаг должен быть положительным числом!");
                                    }
                                } else {
                                    sc.nextLine();
                                    System.out.println("Введено не число");
                                }
                            } else {
                                System.out.println("Минимальная граница больше максимально!");
                            }
                        } else {
                            sc.nextLine();
                            System.out.println("Введено не число");
                        }
                    } else {
                        sc.nextLine();
                        System.out.println("Введено не число");
                    }

                    break;

                case (6):

                    int numberTask6;
                    int resultTask6;

                    System.out.print("Введите число, которое необходимо перевернуть: ");

                    if (sc.hasNextInt()) {
                        numberTask6 = sc.nextInt();

                        resultTask6 = task6(numberTask6);

                        System.out.println("Число " + numberTask6 + " в перевернутом виде: " + resultTask6);
                    } else {
                        sc.nextLine();
                        System.out.println("Введено не число");
                    }
                    break;
                default:
                    System.out.println("Введено неверное значение!");
            }
        } else {
            System.out.println("Введено не целочисленное число");
        }
    }

    /**
     * Находит наибольшую цифру натурального числа
     * @param number Число в котором производится поиск наибольшей цифры
     * @return Переменная типа int со значением наибольшей цифры в числе
     */
    public static int task1(int number) {

        int maxNumber = 0;
        int variable;

        number = Math.abs(number);

        while (number > 0) {

            variable = number % 10;

            if (variable > maxNumber) {
                maxNumber = variable;
            }
            number /= 10;
        }
        return maxNumber;
    }

    /**
     * Проверяет вероятность получения четных случайных чисел при определенной выборке
     * @param number Размер выборки
     * @return Переменная типа double с процентом четных чисел
     */
    public static double task2(int number) {

        int counter = 0;

        for (int i = 1; i <= number; i++) {
            if ((int) (Math.random() * 100) % 2 == 0) {
                counter++;
            }
        }
        return (double) counter / number * 100;
    }

    /**
     * Считает четные и нечетные цифры числа
     * @param number Число, в котором производится подсчет четных и нечетных чисел
     * @return Массив типа из 2 элементов int[]. В 0 ячейке количество четных чисел, в 1 ячейке количество нечетных чисел
     */
    public static int[] task3(int number) {

        int[] oddAndEvenNumbers = new int[2];
        int variable;

        if (number == 0) {
            oddAndEvenNumbers[0] = 1;
            return oddAndEvenNumbers;
        }

        if (number < 0) {
            number = Math.abs(number);
        }

        while (number > 0) {

            variable = number % 10;
            number /= 10;

            if (variable % 2 == 0) {
                oddAndEvenNumbers[0]++;
            } else {
                oddAndEvenNumbers[1]++;
            }
        }
        return oddAndEvenNumbers;
    }

    /**
     * Рассчитывает ряд Фибоначчи
     * @param number Порядок числа Фибоначчи
     * @return Переменная типа String с рядом Фибоначчи заданного порядка
     */
    public static String task4(int number) {

        int firstNumber = 0;
        int secondNumber = 1;
        int temp;
        String result = "";

        for (int i = 1; i <= number; i++) {

            temp = firstNumber;
            firstNumber = secondNumber;
            secondNumber += temp;
            result += secondNumber + " ";
        }
        return result;
    }

    /**
     * Определяет ряд натуральных чисел от минимума до максимума с определенным шагом
     * @param min Минимальная граница
     * @param max Максимальная граница
     * @param incremet Шаг выборки
     * @return Переменную типа String с рядом натуральных чисел
     */
    public static String task5(int min, int max, int incremet) {

        String result = "";

        while (min <= max) {
            result += min + " ";
            min += incremet;
        }
        return result;
    }

    /**
     * Формирует из числа обратное по порядку входящих в него цифр
     * @param number Число из готорого формируется обратное число
     * @return Переменная типа int с обратным числом
     */
    public static int task6(int number) {

        int result = 0;
        boolean isNegativeNumber = false;

        if (number < 0) {
            isNegativeNumber = true;
            number = Math.abs(number);
        }

        while (number > 0) {
            result = result * 10 + number % 10;
            number /= 10;
        }

        if (isNegativeNumber) {
            return -result;
        }
        return result;
    }
}