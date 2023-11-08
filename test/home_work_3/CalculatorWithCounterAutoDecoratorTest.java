package home_work_3;

import home_work_3.calcs.additional.CalculatorWithCounterAutoDecorator;
import home_work_3.calcs.api.ICalculator;
import home_work_3.calcs.simple.CalculatorWithMathCopy;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CalculatorWithCounterAutoDecoratorTest {

    ICalculator calcEngine = new CalculatorWithMathCopy();
    ICalculator calc = new CalculatorWithCounterAutoDecorator(calcEngine);

    @Test
    public void calculateResult() {
        double result = calc.add(4.1, calc.add(calc.multiply(15, 7), calc.pow(calc.divide(28, 5), 2)));
        long counter = ((CalculatorWithCounterAutoDecorator) calc).getCountOperation();
        assertEquals(140.45999999999998, result);
        assertEquals(5, counter);
    }

    @Test
    public void getCountOperation() {
        long counter = ((CalculatorWithCounterAutoDecorator) calc).getCountOperation();
        assertEquals(0, counter);
    }

    @Test
    public void getCalculator() {
        boolean calculator = Objects.equals(calcEngine, ((CalculatorWithCounterAutoDecorator) calc).getCalculator());
        assertTrue(calculator);
    }
}