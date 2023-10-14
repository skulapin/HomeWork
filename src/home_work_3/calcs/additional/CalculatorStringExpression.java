package home_work_3.calcs.additional;

import java.util.ArrayList;
import java.util.List;

import home_work_3.calcs.api.ICalculator;

/* 14**. Написать класс CalculatorStringExpression. Данное задание направлено на изучение паттера Адаптер.
	14.0 О адаптерах можно прочитать по ссылкам:
		14.0.1 https://refactoring.guru/ru/design-patterns/adapter
		14.0.2 https://www.wikiwand.com/ru/%D0%90%D0%B4%D0%B0%D0%BF%D1%82%D0%B5%D1%80_(%D1%88%D0%B0%D0%B1%D0%BB%D0%BE%D0%BD_%D0%BF%D1%80%D0%BE%D0%B5%D0%BA%D1%82%D0%B8%D1%80%D0%BE%D0%B2%D0%B0%D0%BD%D0%B8%D1%8F)
	14.1 реализующий разбор (парсинг) СТРОКИ с математическим выражением:
	14.2 Класс должен понимать операторы: + - \ * ^ || 
	14.3 Класс должен понимать ( )
	14.4 Класс должен строго учитывать приоритеты в данном выражении
	14.5 Класс должен уметь парсить в строке константные значение: PI, E (Экспонента)
	14.6 Класс должен контролировать что в строке могут быть только допустие символы (числа, операторы, скобки, константы)
	14.7 Класс должен контролировать чтобы выражение было валидным (2 + 2 - хорошо, 2 + - плохо)
	*/

/**
 * Класс осуществляет разбор строки с математическим выражением методом рекурсивного спуска. Основа парсера честно
 * подбрита с просторов интернета, исходный код функционировал только с операторами + - / * и знаками приоритета ().
 * Доработан функционал для возможности работы с дробными числами, константами PI и E, операторами ^ || и унарным
 * оператором -. При необходимости парсер легко расширяем для работы с функциями sin(), cos(),min(), max() итп.
 * Исходный код шаблона: https://github.com/Arhiser/java_tutorials/blob/master/src/ru/arhiser/parser/Main.java
 * Видеообзор работы исходного кода: https://www.youtube.com/watch?v=iLnNqqom5KY
 * Видеообзор по дальнейшему расширению функционала класса: https://www.youtube.com/watch?v=ARTnW-unrAQ
 *
 * @author s.kulapin
 */
public class CalculatorStringExpression implements ICalculator {

    /**
     * ссылка на объект типа ICalculator
     */
    private ICalculator calc;

    /**
     * Конструктор класса CalculatorStringExpression
     *
     * @param calc Объект типа ICalculator
     */
    public CalculatorStringExpression(ICalculator calc) {
        this.calc = calc;
    }

    /**
     * Рассчитывает значение переданного математического выражения
     *
     * @param expressionText Математическое выражение
     * @return Результат переданного математического выражения
     */
    public double returnValue(String expressionText) {

        List<Lexeme> lexemes = lexAnalyze(expressionText);
        LexemeBuffer lexemeBuffer = new LexemeBuffer(lexemes);
        return expr(lexemeBuffer);
    }

    /**
     * ENUM набор типов лексем
     *
     * @author s.kulapin
     */
    public enum LexemeType {
        LEFT_BRACKET, RIGHT_BRACKET, OP_PLUS, OP_MINUS, OP_MUL, OP_DIV, NUMBER, EOF, MODULE, POW;
    }

    /**
     * Метод лексического анализа математического выражения
     *
     * @param expText Строка с математическим выражением
     * @return Коллекция лексем разобранного математического выражения
     */
    public static List<Lexeme> lexAnalyze(String expText) {
        ArrayList<Lexeme> lexemes = new ArrayList<>();
        int pos = 0;
        int textLength = expText.length();
        while (pos < textLength) {
            char c = expText.charAt(pos);
            switch (c) {
                case '(':
                    lexemes.add(new Lexeme(LexemeType.LEFT_BRACKET, c));
                    pos++;
                    continue;
                case ')':
                    lexemes.add(new Lexeme(LexemeType.RIGHT_BRACKET, c));
                    pos++;
                    continue;
                case '+':
                    lexemes.add(new Lexeme(LexemeType.OP_PLUS, c));
                    pos++;
                    continue;
                case '-':
                    lexemes.add(new Lexeme(LexemeType.OP_MINUS, c));
                    pos++;
                    continue;
                case '*':
                    lexemes.add(new Lexeme(LexemeType.OP_MUL, c));
                    pos++;
                    continue;
                case '/':
                    lexemes.add(new Lexeme(LexemeType.OP_DIV, c));
                    pos++;
                    continue;
                case '|':
                    lexemes.add(new Lexeme(LexemeType.MODULE, c));
                    pos++;
                    continue;
                case '^':
                    lexemes.add(new Lexeme(LexemeType.POW, c));
                    pos++;
                    continue;
                default:
                    if (Character.isDigit(c) || c == '.' || c == 'P' || c == 'I' || c == 'E') {
                        StringBuilder sb = new StringBuilder();
                        do {
                            sb.append(c);
                            pos++;
                            if (pos >= expText.length()) {
                                break;
                            }
                            c = expText.charAt(pos);
                        } while (Character.isDigit(c) || c == '.' || c == 'P' || c == 'I' || c == 'E');
                        lexemes.add(new Lexeme(LexemeType.NUMBER, sb.toString()));
                    } else {
                        if (c != ' ') {
                            throw new RuntimeException("Unexpected character: " + c);
                        }
                        pos++;
                    }
            }
        }
        lexemes.add(new Lexeme(LexemeType.EOF, ""));
        return lexemes;
    }

    /**
     * Проверка на пустое выражение
     *
     * @param lexemes Набор лексем
     * @return Возвращает 0 при переданной пустой строке. В противном случае
     * запускает процесс синтаксического анализа математического выражения
     */
    public double expr(LexemeBuffer lexemes) {
        Lexeme lexeme = lexemes.next();
        if (lexeme.type == LexemeType.EOF) {
            return 0;
        } else {
            lexemes.back();
            return plusminus(lexemes);
        }
    }

    /**
     * Обработка подвыражений сложения и вычитания
     *
     * @param lexemes Набор лексем
     * @return Значение вычисленного подвыражения
     */
    public double plusminus(LexemeBuffer lexemes) {
        double value = multdiv(lexemes);
        while (true) {
            Lexeme lexeme = lexemes.next();
            switch (lexeme.type) {
                case OP_PLUS:
                    value = add(value, multdiv(lexemes));
                    break;
                case OP_MINUS:
                    value = subtract(value, multdiv(lexemes));
                    break;
                case MODULE:
                    lexemes.back();
                    return value;
                case EOF:
                case RIGHT_BRACKET:
                    lexemes.back();
                    return value;
                default:
                    throw new RuntimeException("Unexpected token: " + lexeme.value + " at position: " + lexemes.getPos());
            }
        }
    }

    /**
     * Обработка подвыражений умножения, деления и возведения в степень
     *
     * @param lexemes Набор лексем
     * @return Значение вычисленного подвыражения
     */
    public double multdiv(LexemeBuffer lexemes) {
        double value = factor(lexemes);
        while (true) {
            Lexeme lexeme = lexemes.next();
            switch (lexeme.type) {
                case OP_MUL:
                    value = multiply(value, factor(lexemes));
                    break;
                case OP_DIV:
                    value = divide(value, factor(lexemes));
                    break;
                case POW:
                    value = pow(value, (int) factor(lexemes));
                    break;
                case EOF:
                case RIGHT_BRACKET:
                case OP_PLUS:
                case OP_MINUS:
                case MODULE:
                    lexemes.back();
                    return value;
                default:
                    throw new RuntimeException("Unexpected token: " + lexeme.value + " at position: " + lexemes.getPos());
            }
        }
    }

    /**
     * Обработка числа, выражения в скобках или модуле
     *
     * @param lexemes Набор лексем
     * @return Значение вычисленного подвыражения
     */
    public double factor(LexemeBuffer lexemes) {
        Lexeme lexeme = lexemes.next();
        switch (lexeme.type) {
            case OP_MINUS:
                double value = factor(lexemes);
                return -value;
            case NUMBER:
                switch (lexeme.value) {
                    case "E":
                        return Math.E;
                    case "PI":
                        return Math.PI;
                    default:
                        return Double.parseDouble(lexeme.value);
                }
            case LEFT_BRACKET:
                value = plusminus(lexemes);
                lexeme = lexemes.next();
                if (lexeme.type != LexemeType.RIGHT_BRACKET) {
                    throw new RuntimeException("Unexpected token: " + lexeme.value + " at position: " + lexemes.getPos());
                }
                return value;
            case MODULE:
                value = plusminus(lexemes);
                lexeme = lexemes.next();
                if (lexeme.type != LexemeType.MODULE) {
                    throw new RuntimeException("Unexpected token: " + lexeme.value + " at position: " + lexemes.getPos());
                }
                return abs(value);
            default:
                throw new RuntimeException("Unexpected token: " + lexeme.value + " at position: " + lexemes.getPos());
        }
    }

    /**
     * Производит операцию сложение
     *
     * @param number1 Первое слагаемое
     * @param number2 Второе слагаемое
     * @return Результат сложения друх чисел
     */
    @Override
    public double add(double number1, double number2) {
        return calc.add(number1, number2);
    }

    /**
     * Производит операцию вычитание
     *
     * @param number1 Уменьшаемое
     * @param number2 Вычитаемое
     * @return Разность двух чисел
     */
    @Override
    public double subtract(double number1, double number2) {
        return calc.subtract(number1, number2);
    }

    /**
     * Производит операцию умножение
     *
     * @param number1 Первый множитель
     * @param number2 Второй множитель
     * @return Результат умножения двух чисел
     */
    @Override
    public double multiply(double number1, double number2) {
        return calc.multiply(number1, number2);
    }

    /**
     * Производит операцию деление
     *
     * @param number1 Делимое
     * @param number2 Делитель
     * @return Результат деления двух чисел (частное)
     */
    @Override
    public double divide(double number1, double number2) {
        return calc.divide(number1, number2);
    }

    /**
     * Производит операцию возведения числа в степень. Основание должно быть положительным числом.
     *
     * @param number1 Основание
     * @param number2 Степень числа
     * @return Результат операции возведения числа в степень
     */
    @Override
    public double pow(double number1, int number2) {
        return calc.pow(number1, number2);
    }

    /**
     * Приведение числа к абсолютному значению (модуль числа)
     *
     * @param number Приводимое к абсолютному значению число
     * @return Абсолютное значение числа
     */
    @Override
    public double abs(double number) {
        return calc.abs(number);
    }

    /**
     * Операция нахождения квадратного корня числа
     *
     * @param number Неотрицательное вещественное число
     * @return Квадратный корень из числа
     */
    @Override
    public double sqrt(double number) {
        return calc.sqrt(number);
    }

    /**
     * Вспомогательный класс для представления отдельно взятой лексемы
     *
     * @author s.kulapin
     */
    public static class Lexeme {

        /**
         * Тип лексемы
         */
        LexemeType type;

        /**
         * Значение лексемы в текстовом формате
         */
        String value;

        /**
         * Конструктор класса Lexeme
         *
         * @param type  Тип лексемы
         * @param value Значение лексемы типа String
         */
        public Lexeme(LexemeType type, String value) {
            this.type = type;
            this.value = value;
        }

        /**
         * Конструктор класса Lexeme
         *
         * @param type  Тип лексемы
         * @param value Значение лексемы типа Character
         */
        public Lexeme(LexemeType type, Character value) {
            this.type = type;
            this.value = value.toString();
        }
    }

    /**
     * Вспомогательный класс аккумулирующий всю информацию по проходу коллекции
     * лексем
     *
     * @author s.kulapin
     */
    public static class LexemeBuffer {

        /**
         * Указатель на ячейку коллекции
         */
        private int pos;

        /**
         * Коллекция лексем
         */
        public List<Lexeme> lexemes;

        /**
         * Конструктор класса LexemeBuffer
         *
         * @param lexemes Коллекция лексем
         */
        public LexemeBuffer(List<Lexeme> lexemes) {
            this.lexemes = lexemes;
        }

        /**
         * Возвращает лексему и передвигает указатель на 1 ячейку вправо
         *
         * @return Лексама, над который находится указатель
         */
        public Lexeme next() {
            return lexemes.get(pos++);
        }

        /**
         * Передвигает указатель на 1 ячейку влево
         */
        public void back() {
            pos--;
        }

        /**
         * Возвращает номер ячейки над которой установлен указатель
         *
         * @return Номер ячейки
         */
        public int getPos() {
            return pos;
        }
    }
}