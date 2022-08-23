package pl.dominikwolowicz;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

import static pl.dominikwolowicz.Calculator.getAmount;

public class CalculatorTests {
    @Test
    public void testDecimalPointMultiplication() {
        assertEquals(BigDecimal.valueOf(104.90208), getAmount(BigDecimal.valueOf(22.08), BigDecimal.valueOf(4.7510)));
    }

    @Test
    public void testZeroByZeroMultiplication() {
        assertEquals(BigDecimal.valueOf(0), getAmount(BigDecimal.valueOf(0), BigDecimal.valueOf(0)));
    }
}
