package edu.matc.util;

import java.math.BigDecimal;
import java.text.NumberFormat;

/**
 * The type Convert to currency string.
 */
public class ConvertToCurrencyString {

    /**
     * Format to currency string where input is a Double.
     *
     * @param amount the amount
     * @return the string
     */
    public String formatToCurrency(Double amount) {
        return NumberFormat.getCurrencyInstance().format(amount);
    }

    /**
     * Format to currency string where input is a BigDecimal.
     *
     * @param amount the amount
     * @return the string
     */
    public String formatToCurrency(BigDecimal amount) {
        return NumberFormat.getCurrencyInstance().format(amount);
    }
}
