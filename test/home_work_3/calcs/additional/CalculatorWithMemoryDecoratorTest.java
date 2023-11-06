package home_work_3.calcs.additional;

import home_work_3.calcs.api.ICalculator;
import home_work_3.calcs.simple.CalculatorWithMathCopy;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorWithMemoryDecoratorTest {

    ICalculator calcEngine = new CalculatorWithMathCopy();
    ICalculator calc = new CalculatorWithMemoryDecorator(calcEngine);

    @Test
    public void calculateResult() {
        double result = calc.add(4.1, calc.add(calc.multiply(15, 7), calc.pow(calc.divide(28, 5), 2)));
        assertEquals(140.45999999999998, result);
    }

    @Test
    public void getCalculator() {
        boolean calculator = Objects.equals(calcEngine, ((CalculatorWithMemoryDecorator) calc).getCalculator());
        assertEquals(true, calculator);
    }

    @Test
    public void saveAndLoad1() {
        calc.add(4.1, calc.add(calc.multiply(15, 7), calc.pow(calc.divide(28, 5), 2)));
        ((CalculatorWithMemoryDecorator) calc).save();
        double result = ((CalculatorWithMemoryDecorator) calc).load();
        assertEquals(140.45999999999998, result);
    }

    @Test
    public void saveAndLoad2() {
        calc.add(1, 2);
        ((CalculatorWithMemoryDecorator) calc).save();
        double result = ((CalculatorWithMemoryDecorator) calc).load();
        assertEquals(3, result);
        result = ((CalculatorWithMemoryDecorator) calc).load();
        assertEquals(0, result);
    }

    @Test
    public void load1() {
        double result = ((CalculatorWithMemoryDecorator) calc).load();
        assertEquals(0, result);
    }

    @Test
    public void load2() {
        calc.add(1, 2);
        double result = ((CalculatorWithMemoryDecorator) calc).load();
        assertEquals(0, result);
    }

    @Test
    public void add1() {
        double result = calc.add(2.5, 3.0);
        assertEquals(5.5, result);
    }

    @Test
    public void add2() {
        double result = calc.add(-2.5, 3.0);
        assertEquals(0.5, result);
    }

    @Test

    public void add3() {
        double result = calc.add(2.5, -3.0);
        assertEquals(-0.5, result);
    }

    @Test
    public void add4() {
        double result = calc.add(-2.5, -3.0);
        assertEquals(-5.5, result);
    }

    @Test
    public void add5() {
        double result = calc.add(0, 0);
        assertEquals(0.0, result);
    }

    @Test
    public void subtract1() {
        double result = calc.subtract(2.5, 3.0);
        assertEquals(-0.5, result);
    }

    @Test
    public void subtract2() {
        double result = calc.subtract(-2.5, 3.0);
        assertEquals(-5.5, result);
    }

    @Test

    public void subtract3() {
        double result = calc.subtract(2.5, -3.0);
        assertEquals(5.5, result);
    }

    @Test
    public void subtract4() {
        double result = calc.subtract(-2.5, -3.0);
        assertEquals(0.5, result);
    }

    @Test
    public void subtract5() {
        double result = calc.subtract(-0, 0);
        assertEquals(0.0, result);
    }

    @Test
    public void multiply1() {
        double result = calc.multiply(2.5, 3.0);
        assertEquals(7.5, result);
    }

    @Test
    public void multiply2() {
        double result = calc.multiply(-2.5, 3.0);
        assertEquals(-7.5, result);
    }

    @Test

    public void multiply3() {
        double result = calc.multiply(2.5, -3.0);
        assertEquals(-7.5, result);
    }

    @Test
    public void multiply4() {
        double result = calc.multiply(-2.5, -3.0);
        assertEquals(7.5, result);
    }

    @Test
    public void multiply5() {
        double result = calc.multiply(2, 0);
        assertEquals(0.0, result);
    }

    @Test
    public void multiply6() {
        double result = calc.multiply(0, -2);
        assertEquals(0.0, result);
    }

    @Test
    public void divide1() {
        double result = calc.divide(2.5, 2.0);
        assertEquals(1.25, result);
    }

    @Test
    public void divide2() {
        double result = calc.divide(-2.5, 2.0);
        assertEquals(-1.25, result);
    }

    @Test

    public void divide3() {
        double result = calc.divide(2.5, -2.0);
        assertEquals(-1.25, result);
    }

    @Test
    public void divide4() {
        double result = calc.divide(-2.5, -2.0);
        assertEquals(1.25, result);
    }

    @Test
    public void divide5() {
        double result = calc.divide(2, 0);
        assertEquals(0, result);
    }

    @Test
    public void divide6() {
        double result = calc.divide(0, -2);
        assertEquals(0.0, result);
    }

    @Test
    public void pow1() {
        double result = calc.pow(2.5, 2);
        assertEquals(6.25, result);
    }

    @Test
    public void pow2() {
        double result = calc.pow(-2.5, 2);
        assertEquals(6.25, result);
    }

    @Test

    public void pow3() {
        double result = calc.pow(2.5, -2);
        assertEquals(0.16, result);
    }

    @Test
    public void pow4() {
        double result = calc.pow(-2.5, -2);
        assertEquals(0.16, result);
    }

    @Test
    public void pow5() {
        double result = calc.pow(2, 0);
        assertEquals(1, result);
    }

    @Test
    public void abs1() {
        double result = calc.abs(2.5);
        assertEquals(2.5, result);
    }

    @Test
    public void abs2() {
        double result = calc.abs(-2.5);
        assertEquals(2.5, result);
    }

    @Test
    public void abs3() {
        double result = calc.abs(0);
        assertEquals(0, result);
    }

    @Test
    public void sqrt1() {
        double result = calc.sqrt(6.25);
        assertEquals(2.5, result);
    }

    @Test
    public void sqrt2() {
        double result = calc.sqrt(-6.25);
        assertEquals(-1, result);
    }

    @Test
    public void sqrt3() {
        double result = calc.sqrt(0);
        assertEquals(0, result);
    }
}
