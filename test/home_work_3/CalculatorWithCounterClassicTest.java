package home_work_3;

import home_work_3.calcs.additional.CalculatorWithCounterClassic;
import home_work_3.calcs.api.ICalculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorWithCounterClassicTest {

    ICalculator calc = new CalculatorWithCounterClassic();

    @Test
    public void calculateResult() {
        double result = calc.add(4.1, calc.add(calc.multiply(15, 7), calc.pow(calc.divide(28, 5), 2)));
        long counter = ((CalculatorWithCounterClassic) calc).getCountOperation();
        assertEquals(140.45999999999998, result);
        assertEquals(0, counter);
    }

    @Test
    public void getCountOperation1() {
        ((CalculatorWithCounterClassic) calc).incrementCountOperation();
        long counter = ((CalculatorWithCounterClassic) calc).getCountOperation();
        assertEquals(1, counter);
    }

    @Test
    public void getCountOperation2() {
        ((CalculatorWithCounterClassic) calc).incrementCountOperation();
        ((CalculatorWithCounterClassic) calc).incrementCountOperation();
        ((CalculatorWithCounterClassic) calc).incrementCountOperation();
        long counter = ((CalculatorWithCounterClassic) calc).getCountOperation();
        assertEquals(3, counter);
    }
}