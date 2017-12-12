package edu.matc.entity;

import edu.matc.persistence.AbstractDao;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * The type Budget month test.
 */
public class BudgetMonthTest {
    private final Logger log = Logger.getLogger(this.getClass());

    private AbstractDao<BudgetMonth> budgetMonthAbstractDao;

    /**
     * Creates budget month abstract dao.
     */
    @Before
    public void setup() {
        budgetMonthAbstractDao = new AbstractDao<>(BudgetMonth.class);
    }

    /**
     * Calculate budgeted total zero.
     *
     * @throws Exception the exception
     */
    @Test
    public void calculateBudgetedTotalZeroTest() throws Exception {
        BudgetMonth budgetMonth = budgetMonthAbstractDao.get(2);

        BigDecimal total = budgetMonth.calculateBudgetedTotal();

        assertTrue(total.equals(BigDecimal.valueOf(0)));
    }

    /**
     * Calculate budgeted total non-zero.
     *
     * @throws Exception the exception
     */
    @Test
    public void calculateBudgetedTotalNonZeroTest() throws Exception {
        BudgetMonth budgetMonth = budgetMonthAbstractDao.get(1);

        BigDecimal total = budgetMonth.calculateBudgetedTotal();

        log.info("total: " + total);

        assertTrue(total.compareTo(BigDecimal.valueOf(1158.94)) == 0);
    }

    /**
     * Calculate income total.
     *
     * @throws Exception the exception
     */
    @Test
    public void calculateIncomeTotal() throws Exception {
        BudgetMonth budgetMonth = budgetMonthAbstractDao.get(1);

        BigDecimal total = budgetMonth.calculateIncomeTotal();

        assertTrue(total.compareTo(BigDecimal.valueOf(2527.88)) == 0);
    }

    /**
     * Calculate remaining.
     *
     * @throws Exception the exception
     */
    @Test
    public void calculateRemaining() throws Exception {
        BudgetMonth budgetMonth = budgetMonthAbstractDao.get(1);

        BigDecimal total = budgetMonth.calculateRemaining();

        log.info("total: " + total);

        assertTrue(total.compareTo(BigDecimal.valueOf(1368.94)) == 0);
    }

}