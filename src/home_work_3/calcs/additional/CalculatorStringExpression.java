package home_work_3.calcs.additional;

import java.util.ArrayList;
import java.util.List;

import home_work_3.calcs.api.ICalculator;

/* 14**. �������� ����� CalculatorStringExpression. ������ ������� ���������� �� �������� ������� �������.
	14.0 � ��������� ����� ��������� �� �������:
		14.0.1 https://refactoring.guru/ru/design-patterns/adapter
		14.0.2 https://www.wikiwand.com/ru/%D0%90%D0%B4%D0%B0%D0%BF%D1%82%D0%B5%D1%80_(%D1%88%D0%B0%D0%B1%D0%BB%D0%BE%D0%BD_%D0%BF%D1%80%D0%BE%D0%B5%D0%BA%D1%82%D0%B8%D1%80%D0%BE%D0%B2%D0%B0%D0%BD%D0%B8%D1%8F)
	14.1 ����������� ������ (�������) ������ � �������������� ����������:
	14.2 ����� ������ �������� ���������: + - \ * ^ || 
	14.3 ����� ������ �������� ( )
	14.4 ����� ������ ������ ��������� ���������� � ������ ���������
	14.5 ����� ������ ����� ������� � ������ ����������� ��������: PI, E (����������)
	14.6 ����� ������ �������������� ��� � ������ ����� ���� ������ �������� ������� (�����, ���������, ������, ���������)
	14.7 ����� ������ �������������� ����� ��������� ���� �������� (2 + 2 - ������, 2 + - �����)
	*/

/**
 * ����� ������������ ������ ������ � �������������� ���������� ������� ������������ ������. ������ ������� ������
 * �������� � ��������� ���������, �������� ��� �������������� ������ � ����������� + - / * � ������� ���������� ().
 * ��������� ���������� ��� ����������� ������ � �������� �������, ����������� PI � E, ����������� ^ || � �������
 * ���������� -. ��� ������������� ������ ����� ��������� ��� ������ � ��������� sin(), cos(),min(), max() ���.
 * �������� ��� �������: https://github.com/Arhiser/java_tutorials/blob/master/src/ru/arhiser/parser/Main.java
 * ���������� ������ ��������� ����: https://www.youtube.com/watch?v=iLnNqqom5KY
 * ���������� �� ����������� ���������� ����������� ������: https://www.youtube.com/watch?v=ARTnW-unrAQ
 *
 * @author s.kulapin
 */
public class CalculatorStringExpression implements ICalculator {

    /**
     * ������ �� ������ ���� ICalculator
     */
    private ICalculator calc;

    /**
     * ����������� ������ CalculatorStringExpression
     *
     * @param calc ������ ���� ICalculator
     */
    public CalculatorStringExpression(ICalculator calc) {
        this.calc = calc;
    }

    /**
     * ������������ �������� ����������� ��������������� ���������
     *
     * @param expressionText �������������� ���������
     * @return ��������� ����������� ��������������� ���������
     */
    public double returnValue(String expressionText) {

        List<Lexeme> lexemes = lexAnalyze(expressionText);
        LexemeBuffer lexemeBuffer = new LexemeBuffer(lexemes);
        return expr(lexemeBuffer);
    }

    /**
     * ENUM ����� ����� ������
     *
     * @author s.kulapin
     */
    public enum LexemeType {
        LEFT_BRACKET, RIGHT_BRACKET, OP_PLUS, OP_MINUS, OP_MUL, OP_DIV, NUMBER, EOF, MODULE, POW;
    }

    /**
     * ����� ������������ ������� ��������������� ���������
     *
     * @param expText ������ � �������������� ����������
     * @return ��������� ������ ������������ ��������������� ���������
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
     * �������� �� ������ ���������
     *
     * @param lexemes ����� ������
     * @return ���������� 0 ��� ���������� ������ ������. � ��������� ������
     * ��������� ������� ��������������� ������� ��������������� ���������
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
     * ��������� ������������ �������� � ���������
     *
     * @param lexemes ����� ������
     * @return �������� ������������ ������������
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
     * ��������� ������������ ���������, ������� � ���������� � �������
     *
     * @param lexemes ����� ������
     * @return �������� ������������ ������������
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
     * ��������� �����, ��������� � ������� ��� ������
     *
     * @param lexemes ����� ������
     * @return �������� ������������ ������������
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
     * ���������� �������� ��������
     *
     * @param number1 ������ ���������
     * @param number2 ������ ���������
     * @return ��������� �������� ���� �����
     */
    @Override
    public double add(double number1, double number2) {
        return calc.add(number1, number2);
    }

    /**
     * ���������� �������� ���������
     *
     * @param number1 �����������
     * @param number2 ����������
     * @return �������� ���� �����
     */
    @Override
    public double subtract(double number1, double number2) {
        return calc.subtract(number1, number2);
    }

    /**
     * ���������� �������� ���������
     *
     * @param number1 ������ ���������
     * @param number2 ������ ���������
     * @return ��������� ��������� ���� �����
     */
    @Override
    public double multiply(double number1, double number2) {
        return calc.multiply(number1, number2);
    }

    /**
     * ���������� �������� �������
     *
     * @param number1 �������
     * @param number2 ��������
     * @return ��������� ������� ���� ����� (�������)
     */
    @Override
    public double divide(double number1, double number2) {
        return calc.divide(number1, number2);
    }

    /**
     * ���������� �������� ���������� ����� � �������. ��������� ������ ���� ������������� ������.
     *
     * @param number1 ���������
     * @param number2 ������� �����
     * @return ��������� �������� ���������� ����� � �������
     */
    @Override
    public double pow(double number1, int number2) {
        return calc.pow(number1, number2);
    }

    /**
     * ���������� ����� � ����������� �������� (������ �����)
     *
     * @param number ���������� � ����������� �������� �����
     * @return ���������� �������� �����
     */
    @Override
    public double abs(double number) {
        return calc.abs(number);
    }

    /**
     * �������� ���������� ����������� ����� �����
     *
     * @param number ��������������� ������������ �����
     * @return ���������� ������ �� �����
     */
    @Override
    public double sqrt(double number) {
        return calc.sqrt(number);
    }

    /**
     * ��������������� ����� ��� ������������� �������� ������ �������
     *
     * @author s.kulapin
     */
    public static class Lexeme {

        /**
         * ��� �������
         */
        LexemeType type;

        /**
         * �������� ������� � ��������� �������
         */
        String value;

        /**
         * ����������� ������ Lexeme
         *
         * @param type  ��� �������
         * @param value �������� ������� ���� String
         */
        public Lexeme(LexemeType type, String value) {
            this.type = type;
            this.value = value;
        }

        /**
         * ����������� ������ Lexeme
         *
         * @param type  ��� �������
         * @param value �������� ������� ���� Character
         */
        public Lexeme(LexemeType type, Character value) {
            this.type = type;
            this.value = value.toString();
        }
    }

    /**
     * ��������������� ����� �������������� ��� ���������� �� ������� ���������
     * ������
     *
     * @author s.kulapin
     */
    public static class LexemeBuffer {

        /**
         * ��������� �� ������ ���������
         */
        private int pos;

        /**
         * ��������� ������
         */
        public List<Lexeme> lexemes;

        /**
         * ����������� ������ LexemeBuffer
         *
         * @param lexemes ��������� ������
         */
        public LexemeBuffer(List<Lexeme> lexemes) {
            this.lexemes = lexemes;
        }

        /**
         * ���������� ������� � ����������� ��������� �� 1 ������ ������
         *
         * @return �������, ��� ������� ��������� ���������
         */
        public Lexeme next() {
            return lexemes.get(pos++);
        }

        /**
         * ����������� ��������� �� 1 ������ �����
         */
        public void back() {
            pos--;
        }

        /**
         * ���������� ����� ������ ��� ������� ���������� ���������
         *
         * @return ����� ������
         */
        public int getPos() {
            return pos;
        }
    }
}