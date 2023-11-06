package home_work_1;

/*7.* Создать СТАТИЧЕСКИЙ метод createPhoneNumber рядом с методом main, данный метод будет принимает один параметр и
будет возвращать строку в отформатированном виде. В метод будет передаваться массив из 10 цифр (от 0 до 9). Данные
цифры должны быть помещены в строку формата: (XXX) XXX-XXXX. Например передан массив: {1,2,3,4,5,6,7,8,9,0},
возвращаемый результат: (123) 456-7890. (Взято с https://www.codewars.com/kata/525f50e3b73515a6db000b83/train/java).
В задании нельзя использовать колекции, стрима.
 */
public class Task7 {

    public static void main(String[] args) {

        int[] numbers = new int[10];
        String phoneNumber;

        for (int i = 0; i <= 9; i++) {
            numbers[i] = (int) (Math.random() * 10);
        }

        phoneNumber = createPhoneNumber(numbers);
        System.out.println(phoneNumber);

    }

    /**
     * Принимает массив цифр и преобразовывает в строку формата (XXX) XXX-XXXX
     *
     * @param a Массив чисел
     * @return Строка формата (XXX) XXX-XXXX. При некорректром вводе (отрицательные
     * числа, числа не являющиеся цифрами, массив состоит не из 10 элементов) возвращает null
     */
    public static String createPhoneNumber(int[] a) {

        StringBuffer buffer = new StringBuffer();

        if (a.length != 10) {
            return null;
        }

        for (int i = 0; i < a.length; i++) {
            if (a[i] < 0 || a[i] > 9) {
                return null;
            }
        }

        for (int i = 0; i < a.length; i++) {
            if (i == 0) {
                buffer.append("(").append(a[i]);
            }
            if ((i > 0 && i < 3) || (i > 3 && i < 6) || i > 6) {
                buffer.append(a[i]);
            } else if (i == 3) {
                buffer.append(") ").append(a[i]);
            } else if (i == 6) {
                buffer.append("-").append(a[i]);
            }
        }
        return buffer.toString();
    }
}