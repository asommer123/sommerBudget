package edu.matc.entity;

import edu.matc.persistence.AbstractDao;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class BudgetMonthTest {
    private final Logger log = Logger.getLogger(this.getClass());

    private AbstractDao<BudgetMonth> budgetMonthAbstractDao;

    @Before
    public void setup() {
        budgetMonthAbstractDao = new AbstractDao<>(BudgetMonth.class);
    }
    @Test
    public void calculateBudgetedTotalZero() throws Exception {
        BudgetMonth budgetMonth = budgetMonthAbstractDao.get(2);

        BigDecimal total = budgetMonth.calculateBudgetedTotal();

        log.info("Total: " + total);

    }

    @Test
    public void calculateIncomeTotal() throws Exception {
    }

    @Test
    public void calculateRemaining() throws Exception {
    }

}