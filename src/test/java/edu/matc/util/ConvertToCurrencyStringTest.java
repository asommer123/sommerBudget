package edu.matc.util;

import org.apache.log4j.Logger;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * The type Convert to currency string test.
 */
public class ConvertToCurrencyStringTest {
    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * Format to currency zero.
     *
     * @throws Exception the exception
     */
    @Test
    public void formatToCurrencyBigDecimalZero() throws Exception {
        ConvertToCurrencyString convert = new ConvertToCurrencyString();
        log.info("Passing in zero bigdecimal: " + convert.formatToCurrency(new BigDecimal(0)));
        assertTrue("$0.00".equals(convert.formatToCurrency(new BigDecimal(0))));
    }

    /**
     * Format to currency big decimal non-zero.
     *
     * @throws Exception the exception
     */
    @Test
    public void formatToCurrencyBigDecimalNonZero() throws Exception {
        ConvertToCurrencyString convert = new ConvertToCurrencyString();
        log.info("Passing in non-zero bigdecimal: " + convert.formatToCurrency(new BigDecimal(12345678.9)));
        assertTrue("$12,345,678.90".equals(convert.formatToCurrency(new BigDecimal(12345678.9))));
    }

    /**
     * Format to currency double zero.
     *
     * @throws Exception the exception
     */
    @Test
    public void formatToCurrencyDoubleZero() throws Exception {
        ConvertToCurrencyString convert = new ConvertToCurrencyString();
        log.info("Passing in zero double: " + convert.formatToCurrency(0.0));
        assertTrue("$0.00".equals(convert.formatToCurrency(0.0)));
    }

    /**
     * Format to currency double non-zero.
     *
     * @throws Exception the exception
     */
    @Test
    public void formatToCurrencyDoubleNonZero() throws Exception {
        ConvertToCurrencyString convert = new ConvertToCurrencyString();
        log.info("Passing in non-zero double: " + convert.formatToCurrency(0.0));
        assertTrue("$12,345,678.90".equals(convert.formatToCurrency(12345678.9)));
    }

}