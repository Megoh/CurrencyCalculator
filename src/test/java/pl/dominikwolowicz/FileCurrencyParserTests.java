package pl.dominikwolowicz;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class FileCurrencyParserTests {
    @Test
    public void testNullCurrencyException() {
        FileCurrencyParser fileCurrencyParser = new FileCurrencyParser();
        assertThrows(NullPointerException.class, () -> fileCurrencyParser.getCurrencyRate(null));
    }

    @Test
    public void testExistentPlnCurrency() {
        FileCurrencyParser fileCurrencyParser = new FileCurrencyParser();
        assertEquals(BigDecimal.valueOf(4.7510).setScale(4, RoundingMode.DOWN), fileCurrencyParser.getCurrencyRate("PLN"));
    }
}
