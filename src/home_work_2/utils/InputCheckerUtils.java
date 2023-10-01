package home_work_2.utils;

/**
 * Содержит метод проверки переменной типо String на наличие целочисленной переменной
 */
public class InputCheckerUtils {
    /**
     * Проверяет содержимое переменной типа String на наличие положительной переменной типа long
     * @param arguments Переменная типа String с потенциально содержащимся целым числом
     * @return true - внутри String содержится положительная переменная типа long. false - внутри String не содержится
     * положительная переменная типа long
     */
    public static boolean isArgumentPositiveLong(String[] arguments) {

        if (arguments.length != 1) {
            return false;
        }
        try {
            long input = Long.parseLong(arguments[0]);
            if (input > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }
}