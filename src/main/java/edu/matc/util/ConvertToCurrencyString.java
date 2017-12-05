package edu.matc.util;

import java.math.BigDecimal;
import java.text.NumberFormat;

public class ConvertToCurrencyString {

    public String formatToCurrency(Double amount) {
        return NumberFormat.getCurrencyInstance().format(amount);
    }

    public String formatToCurrency(BigDecimal amount) {
        return NumberFormat.getCurrencyInstance().format(amount);
    }
}
