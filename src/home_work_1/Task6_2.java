package home_work_1;

import java.util.Objects;
import java.util.Scanner;

/*6. Запросить у пользователя через консоль его имя. В данном задании у вас должно получиться 3 класса.
	Что в итоге надо сделать (общее условие):
		1. Если имя будет равно имени "Вася" тогда в консоль должно вывести сообщение "Привет!" на одной строке, а на
		второй "Я тебя так долго ждал".
		2. Если имя будет равно имени "Анастасия" тогда в консоль должно вывести сообщение "Я тебя так долго ждал".
		3. В случае если это будет другое имя то вывести сообщение "Добрый день, а вы кто?".
	Как это сделать:
		6.2 Написать в отдельном классе main метод и в нём код который будет выполнять общее условие при помощи if else if
	ВНИМАНИЕ! В примерах c if для сравнения имён использовать код вида Objects.equals("Имя1", "Имя2").
 */

public class Task6_2 {
    public static void main(String[] args) {

        String name;
        Scanner sc = new Scanner(System.in);

        System.out.print("Введите ваше имя: ");
        name = sc.nextLine();

        if (Objects.equals(name, "Вася")) {
            System.out.println("Привет!");
            System.out.println("Я тебя так долго ждал");
        } else if (Objects.equals(name, "Анастасия")) {
            System.out.println("Я тебя так долго ждал");
        } else {
            System.out.println("Добрый день, а вы кто?");
        }
    }
}

