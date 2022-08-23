package pl.dominikwolowicz;

import java.math.BigDecimal;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        BigDecimal amountInEur = BigDecimal.valueOf(22.08);

        FileCurrencyParser fileCurrencyParser = new FileCurrencyParser();
        BigDecimal currencyRate = fileCurrencyParser.getCurrencyRate("PLN");

        BigDecimal amount = Calculator.getAmount(amountInEur, currencyRate);

        Logger logger = Logger.getLogger(Main.class.getName());
        logger.info("Amount after exchange rate equals: " + amount);
    }
}