package home_work_1;

import java.util.Objects;
import java.util.Scanner;

/*5.* Создать СТАТИЧЕСКИЙ метод sleepIn рядом с методом main. (Взято с https://codingbat.com/prob/p187868).
	5.1 Данный метод будет принима два параметра
	5.2 Будет отвечать на вопрос спать ли дальше (да/нет) (возвращать true либо false).
	5.3 Первый параметр boolean weekday обозначает рабочий день
	5.4 Второй параметр boolean vacation обозначает отпуск.
	5.5 Если у нас отпуск или не рабочий день то мы можем спать дальше
	5.6 На основании ответа от метода sleepIn вывести сообщение можем спать дальше или пора идти на работу
 */

public class Task5 {

    public static void main(String[] args) {

        String isWeekday;
        String isVacation;

        boolean weekday;
        boolean vacation;
        boolean answer;

        Scanner sc = new Scanner(System.in);

        System.out.print("Сегодня рабочий день? Введите \"yes\" или \"no\" ");

        while (true) {

            isWeekday = sc.nextLine();

            if (Objects.equals(isWeekday, "yes")) {
                weekday = true;
                break;
            } else if (Objects.equals(isWeekday, "no")) {
                weekday = false;
                break;
            } else {
                System.out.print("Неверный ввод, повторите попытку: ");
            }
        }

        System.out.print("Вы сейчас в отпуске? Введите \"yes\" или \"no\" ");

        while (true) {

            isVacation = sc.nextLine();

            if (Objects.equals(isVacation, "yes")) {
                vacation = true;
                break;
            } else if (Objects.equals(isVacation, "no")) {
                vacation = false;
                break;
            } else {
                System.out.print("Неверный ввод, повторите попытку: ");
            }
        }

        answer = sleepIn(weekday, vacation);

        if (answer){
            System.out.println("Можно спать дальше :)");
        }else{
            System.out.println("Пора идти на работу :(");
        }
    }

    public static boolean sleepIn(boolean weekday, boolean vacation) {

        if (!weekday || vacation) {
            return true;
        }
        return false;
    }
}
