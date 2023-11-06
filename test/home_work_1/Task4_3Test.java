package home_work_1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task4_3Test {

    @Test
    public void getRemainder1() {
        int remainder = Task4_3.getRemainder(5, 8);
        assertEquals(5, remainder);
    }

    @Test
    public void getRemainder2() {
        int remainder = Task4_3.getRemainder(-5, 8);
        assertEquals(-5, remainder);
    }

    @Test
    public void getRemainder3() {
        int remainder = Task4_3.getRemainder(5, -8);
        assertEquals(5, remainder);
    }

    @Test
    public void getRemainder4() {
        int remainder = Task4_3.getRemainder(0, 8);
        assertEquals(0, remainder);
    }

    @Test
    public void getRemainder5() {
        int remainder = Task4_3.getRemainder(0, -8);
        assertEquals(0, remainder);
    }

    @Test
    public void getRemainder6() {
        int remainder = Task4_3.getRemainder(5, 0);
        assertEquals(0, remainder);
    }

    @Test
    public void getQuotient1() {
        double quotient = Task4_3.getQuotient(5, 8);
        assertEquals(0.625, quotient);
    }

    @Test
    public void getQuotient2() {
        double quotient = Task4_3.getQuotient(-5, 8);
        assertEquals(-0.625, quotient);
    }

    @Test
    public void getQuotient3() {
        double quotient = Task4_3.getQuotient(5, -8);
        assertEquals(-0.625, quotient);
    }

    @Test
    public void getQuotient4() {
        double quotient = Task4_3.getQuotient(0, 8);
        assertEquals(0, quotient);
    }

    @Test
    public void getQuotient5() {
        double quotient = Task4_3.getQuotient(0, -8);
        assertEquals(0, quotient);
    }

    @Test
    public void getQuotient6() {
        double quotient = Task4_3.getQuotient(5, 0);
        assertEquals(0, quotient);
    }
}
