package home_work_3;

import home_work_3.calcs.additional.CalculatorWithMemoryDecorator;
import home_work_3.calcs.api.ICalculator;
import home_work_3.calcs.simple.CalculatorWithMathCopy;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CalculatorWithMemoryDecoratorTest {

    ICalculator calcEngine = new CalculatorWithMathCopy();
    ICalculator calc = new CalculatorWithMemoryDecorator(calcEngine);

    @Test
    public void getCalculator() {
        boolean calculator = Objects.equals(calcEngine, ((CalculatorWithMemoryDecorator) calc).getCalculator());
        assertTrue(calculator);
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
}