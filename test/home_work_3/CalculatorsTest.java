package home_work_3;

import home_work_3.calcs.additional.*;
import home_work_3.calcs.api.ICalculator;
import home_work_3.calcs.simple.CalculatorWithMathCopy;
import home_work_3.calcs.simple.CalculatorWithMathExtends;
import home_work_3.calcs.simple.CalculatorWithOperator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorsTest {

    @ParameterizedTest
    @MethodSource("calculators")
    public void calculateResult(ICalculator calc) {
        double result = calc.add(4.1, calc.add(calc.multiply(15, 7), calc.pow(calc.divide(28, 5), 2)));
        assertEquals(140.45999999999998, result);
    }

    @ParameterizedTest
    @MethodSource("calculators")
    public void add1(ICalculator calc) {
        double result = calc.add(2.5, 3.0);
        assertEquals(5.5, result);
    }

    @ParameterizedTest
    @MethodSource("calculators")
    public void add2(ICalculator calc) {
        double result = calc.add(-2.5, 3.0);
        assertEquals(0.5, result);
    }

    @ParameterizedTest
    @MethodSource("calculators")
    public void add3(ICalculator calc) {
        double result = calc.add(2.5, -3.0);
        assertEquals(-0.5, result);
    }

    @ParameterizedTest
    @MethodSource("calculators")
    public void add4(ICalculator calc) {
        double result = calc.add(-2.5, -3.0);
        assertEquals(-5.5, result);
    }

    @ParameterizedTest
    @MethodSource("calculators")
    public void add5(ICalculator calc) {
        double result = calc.add(0, 0);
        assertEquals(0.0, result);
    }

    @ParameterizedTest
    @MethodSource("calculators")
    public void subtract1(ICalculator calc) {
        double result = calc.subtract(2.5, 3.0);
        assertEquals(-0.5, result);
    }

    @ParameterizedTest
    @MethodSource("calculators")
    public void subtract2(ICalculator calc) {
        double result = calc.subtract(-2.5, 3.0);
        assertEquals(-5.5, result);
    }

    @ParameterizedTest
    @MethodSource("calculators")
    public void subtract3(ICalculator calc) {
        double result = calc.subtract(2.5, -3.0);
        assertEquals(5.5, result);
    }

    @ParameterizedTest
    @MethodSource("calculators")
    public void subtract4(ICalculator calc) {
        double result = calc.subtract(-2.5, -3.0);
        assertEquals(0.5, result);
    }

    @ParameterizedTest
    @MethodSource("calculators")
    public void subtract5(ICalculator calc) {
        double result = calc.subtract(-0, 0);
        assertEquals(0.0, result);
    }

    @ParameterizedTest
    @MethodSource("calculators")
    public void multiply1(ICalculator calc) {
        double result = calc.multiply(2.5, 3.0);
        assertEquals(7.5, result);
    }

    @ParameterizedTest
    @MethodSource("calculators")
    public void multiply2(ICalculator calc) {
        double result = calc.multiply(-2.5, 3.0);
        assertEquals(-7.5, result);
    }

    @ParameterizedTest
    @MethodSource("calculators")
    public void multiply3(ICalculator calc) {
        double result = calc.multiply(2.5, -3.0);
        assertEquals(-7.5, result);
    }

    @ParameterizedTest
    @MethodSource("calculators")
    public void multiply4(ICalculator calc) {
        double result = calc.multiply(-2.5, -3.0);
        assertEquals(7.5, result);
    }

    @ParameterizedTest
    @MethodSource("calculators")
    public void multiply5(ICalculator calc) {
        double result = calc.multiply(2, 0);
        assertEquals(0.0, result);
    }

    @ParameterizedTest
    @MethodSource("calculators")
    public void multiply6(ICalculator calc) {
        double result = calc.multiply(0, -2);
        assertEquals(0.0, result);
    }

    @ParameterizedTest
    @MethodSource("calculators")
    public void divide1(ICalculator calc) {
        double result = calc.divide(2.5, 2.0);
        assertEquals(1.25, result);
    }

    @ParameterizedTest
    @MethodSource("calculators")
    public void divide2(ICalculator calc) {
        double result = calc.divide(-2.5, 2.0);
        assertEquals(-1.25, result);
    }

    @ParameterizedTest
    @MethodSource("calculators")
    public void divide3(ICalculator calc) {
        double result = calc.divide(2.5, -2.0);
        assertEquals(-1.25, result);
    }

    @ParameterizedTest
    @MethodSource("calculators")
    public void divide4(ICalculator calc) {
        double result = calc.divide(-2.5, -2.0);
        assertEquals(1.25, result);
    }

    @ParameterizedTest
    @MethodSource("calculators")
    public void divide5(ICalculator calc) {
        double result = calc.divide(2, 0);
        assertEquals(0, result);
    }

    @ParameterizedTest
    @MethodSource("calculators")
    public void divide6(ICalculator calc) {
        double result = calc.divide(0, -2);
        assertEquals(0.0, result);
    }

    @ParameterizedTest
    @MethodSource("calculators")
    public void pow1(ICalculator calc) {
        double result = calc.pow(2.5, 2);
        assertEquals(6.25, result);
    }

    @ParameterizedTest
    @MethodSource("calculators")
    public void pow2(ICalculator calc) {
        double result = calc.pow(-2.5, 2);
        assertEquals(6.25, result);
    }

    @ParameterizedTest
    @MethodSource("calculators")
    public void pow3(ICalculator calc) {
        double result = calc.pow(2.5, -2);
        assertEquals(0.16, result);
    }

    @ParameterizedTest
    @MethodSource("calculators")
    public void pow4(ICalculator calc) {
        double result = calc.pow(-2.5, -2);
        assertEquals(0.16, result);
    }

    @ParameterizedTest
    @MethodSource("calculators")
    public void pow5(ICalculator calc) {
        double result = calc.pow(2, 0);
        assertEquals(1, result);
    }

    @ParameterizedTest
    @MethodSource("calculators")
    public void abs1(ICalculator calc) {
        double result = calc.abs(2.5);
        assertEquals(2.5, result);
    }

    @ParameterizedTest
    @MethodSource("calculators")
    public void abs2(ICalculator calc) {
        double result = calc.abs(-2.5);
        assertEquals(2.5, result);
    }

    @ParameterizedTest
    @MethodSource("calculators")
    public void abs3(ICalculator calc) {
        double result = calc.abs(0);
        assertEquals(0, result);
    }

    @ParameterizedTest
    @MethodSource("calculators")
    public void sqrt1(ICalculator calc) {
        double result = calc.sqrt(6.25);
        assertEquals(2.5, result);
    }

    @ParameterizedTest
    @MethodSource("calculators")
    public void sqrt2(ICalculator calc) {
        double result = calc.sqrt(-6.25);
        assertEquals(-1, result);
    }

    @ParameterizedTest
    @MethodSource("calculators")
    public void sqrt3(ICalculator calc) {
        double result = calc.sqrt(0);
        assertEquals(0, result);
    }

    public static ICalculator[] calculators() {
        ICalculator[] calcs = new ICalculator[8];
        calcs[0] = new CalculatorWithMathCopy();
        calcs[1] = new CalculatorWithMathExtends();
        calcs[2] = new CalculatorWithOperator();
        calcs[3] = new CalculatorStringExpression(calcs[0]);
        calcs[4] = new CalculatorWithCounterAutoDecorator(calcs[0]);
        calcs[5] = new CalculatorWithCounterAutoSuper();
        calcs[6] = new CalculatorWithCounterClassic();
        calcs[7] = new CalculatorWithMemoryDecorator(calcs[0]);
        return calcs;
    }
}