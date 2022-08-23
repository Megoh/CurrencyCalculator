package pl.dominikwolowicz;

import java.math.BigDecimal;

public class Calculator {
    public static BigDecimal getAmount(BigDecimal amountInEur, BigDecimal exchangeRate) {
        return amountInEur.multiply(exchangeRate);
    }
}
