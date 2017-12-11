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
    public void formatToCurrencyZero() throws Exception {
        ConvertToCurrencyString convert = new ConvertToCurrencyString();
        log.info("Passing in zero bigdecimal: " + convert.formatToCurrency(new BigDecimal(0)));
    }

    /**
     * Format to currency 1.
     *
     * @throws Exception the exception
     */
    @Test
    public void formatToCurrency1() throws Exception {
        ConvertToCurrencyString convert = new ConvertToCurrencyString();
        log.info("Passing in zero double: " + convert.formatToCurrency(0.0));
    }

}