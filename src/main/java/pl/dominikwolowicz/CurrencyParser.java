package pl.dominikwolowicz;

import java.math.BigDecimal;

public interface CurrencyParser {
    BigDecimal getCurrencyRate(String currency);
}
