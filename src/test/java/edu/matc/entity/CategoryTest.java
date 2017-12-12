package edu.matc.entity;

import edu.matc.persistence.AbstractDao;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class CategoryTest {
    private final Logger log = Logger.getLogger(this.getClass());

    private AbstractDao<Category> categoryAbstractDao;

    /**
     * Create category abstract dao.
     */
    @Before
    public void setup() {
        categoryAbstractDao = new AbstractDao<>(Category.class);
    }

    /**
     * Calculate category total zero.
     *
     * @throws Exception the exception
     */
    @Test
    public void calculateTotalTest() throws Exception {
        Category category = categoryAbstractDao.get(2);

        BigDecimal total = category.calculateTotal();

        assertTrue(total.compareTo(BigDecimal.valueOf(215.00)) == 0);
    }

}