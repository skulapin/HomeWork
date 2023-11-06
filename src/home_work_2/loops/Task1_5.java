package home_work_2.loops;

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

    /**
     * Находит наибольшую цифру натурального числа
     *
     * @param number Число в котором производится поиск наибольшей цифры
     * @return Переменная типа int со значением наибольшей цифры в числе
     */
    public int task1(int number) {

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
     *
     * @param number Размер выборки
     * @return Переменная типа double с процентом четных чисел. При некорретных входных параметрах
     * (отрицательное число или ноль) возвращает -1
     */
    public double task2(int number) {

        if (number <= 0) {
            return -1;
        }

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
     *
     * @param number Число, в котором производится подсчет четных и нечетных чисел
     * @return Массив типа из 2 элементов int[]. В 0 ячейке количество четных чисел, в 1 ячейке количество нечетных чисел
     */
    public int[] task3(int number) {

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
     *
     * @param number Порядок числа Фибоначчи
     * @return Переменная типа String с рядом Фибоначчи заданного порядка
     */
    public String task4(int number) {

        if (number <= 0) {
            return "Введено не положительное число";
        }

        int firstNumber = 0;
        int secondNumber = 1;
        int temp;

        StringBuilder builder = new StringBuilder();

        for (int i = 1; i <= number; i++) {

            temp = firstNumber;
            firstNumber = secondNumber;
            secondNumber += temp;
            builder.append(secondNumber);
            if (i != number) {
                builder.append(" ");
            }
        }
        return builder.toString();
    }

    /**
     * Определяет ряд натуральных чисел от минимума до максимума с определенным шагом
     *
     * @param min       Минимальная граница
     * @param max       Максимальная граница
     * @param increment Шаг выборки
     * @return Переменную типа String с рядом натуральных чисел. При некорректных входных параметрах выводится оповещение.
     */
    public String task5(int min, int max, int increment) {

        if (min > max || increment <= 0) {
            return "Введены некорректные данные";
        }

        StringBuilder builder = new StringBuilder();

        while (min <= max) {
            builder.append(min);
            if (min != max) {
                builder.append(" ");
            }
            min += increment;
        }
        return builder.toString();
    }

    /**
     * Формирует из числа обратное по порядку входящих в него цифр
     *
     * @param number Число из готорого формируется обратное число
     * @return Переменная типа int с обратным числом
     */
    public int task6(int number) {

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