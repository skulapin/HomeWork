package home_work_3;

import home_work_3.calcs.additional.CalculatorStringExpression;
import home_work_3.calcs.api.ICalculator;
import home_work_3.calcs.simple.CalculatorWithMathCopy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorStringExpressionTest {

    ICalculator calcEngine = new CalculatorWithMathCopy();
    ICalculator calc = new CalculatorStringExpression(calcEngine);

    @Test
    public void calculateResult2() {
        double result = ((CalculatorStringExpression) calc).returnValue("4.1 + 15 * 7 + (28 / 5) ^ 2");
        assertEquals(140.45999999999998, result);
    }

    @Test
    public void calculateResult3() {
        double result = ((CalculatorStringExpression) calc).returnValue("PI");
        assertEquals(Math.PI, result);
    }

    @Test
    public void calculateResult4() {
        double result = ((CalculatorStringExpression) calc).returnValue("E");
        assertEquals(Math.E, result);
    }

    @Test
    public void calculateResult5() {
        double result = ((CalculatorStringExpression) calc).returnValue("2+2*(2-|-2|)");
        assertEquals(2, result);
    }

    @Test
    public void calculateResult6() {
        assertThrows(Exception.class, () -> ((CalculatorStringExpression) calc).returnValue("1++1"));
    }
}