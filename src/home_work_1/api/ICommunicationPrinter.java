package home_work_1.api;

public interface ICommunicationPrinter {

    /**
     * Возвращает приветствие в зависимости от введенного имени
     *
     * @param name Имя
     * @return Строка с приветствием пользователя
     */
    String welcome(String name);
}