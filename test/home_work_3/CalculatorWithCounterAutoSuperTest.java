package home_work_3;

import home_work_3.calcs.additional.CalculatorWithCounterAutoSuper;
import home_work_3.calcs.api.ICalculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorWithCounterAutoSuperTest {

    ICalculator calc = new CalculatorWithCounterAutoSuper();

    @Test
    public void calculateResult() {
        double result = calc.add(4.1, calc.add(calc.multiply(15, 7), calc.pow(calc.divide(28, 5), 2)));
        long counter = ((CalculatorWithCounterAutoSuper) calc).getCountOperation();
        assertEquals(140.45999999999998, result);
        assertEquals(5, counter);
    }

    @Test
    public void getCountOperation() {
        long counter = ((CalculatorWithCounterAutoSuper) calc).getCountOperation();
        assertEquals(0, counter);
    }
}