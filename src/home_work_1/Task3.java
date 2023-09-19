package home_work_1;

/* 3. Изучить библиотеку (класс) Math из jdk. (https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html). Отразить
эксперименты в сданной домашней работе. Материалов в интернете очень много
 */

public class Task3 {
    public static void main(String[] args) {

        //Вычислить значение выражения по формуле b + sqrt(b^2 + 4ac) / 2a - a^3 * c + b^-2

        double a = 2.4;
        double b = -3.5;
        double c = 1.1;
        double result;

        result = b + Math.sqrt(Math.pow(b, 2) + 4 * a * c) / (2 * a) - Math.pow(a, 3) * c + Math.pow(b, -2);

        System.out.println("Результат равен " + result);
        System.out.println("");

        // Вычислить длину окружности и площадь круга одного и того же заданного радиуса R.

        double radius = 4.3;
        double perimeter;
        double square;

        perimeter = 2 * Math.PI * radius;
        square = Math.PI * Math.pow(radius, 2);

        System.out.println("Длина окружности равна " + perimeter);
        System.out.println("Площадь круга равна " + square);
    }
}
