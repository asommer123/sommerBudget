package edu.matc.persistence;

import edu.matc.entity.*;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.*;

public class AbstractDaoTest {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private final Logger log = Logger.getLogger(this.getClass());
    private AbstractDao<Users> usersAbstractDao;
    private AbstractDao<BudgetMonth> budgetMonthAbstractDao;
    private AbstractDao<Category> categoryAbstractDao;

    @Before
    public void setup() {
        usersAbstractDao = new AbstractDao(Users.class);
        budgetMonthAbstractDao = new AbstractDao<>(BudgetMonth.class);
        categoryAbstractDao = new AbstractDao<>(Category.class);
    }

    @Test
    public void createTest() throws Exception {
        Users user = new Users();

        user.setUserName("newAcct11");
        user.setUserPass("test");
        user.setEmailAddress("newUser@test.com");
        user.setFirstName("TestName");
        user.setLastName("LastName");

        UserRole userRole = new UserRole();
        userRole.setRoleName("registeredUser");
        userRole.setUsers(user);
        user.getUserRole().add(userRole);

        BudgetMonth budgetMonth = new BudgetMonth();

        budgetMonth.setBudgetMonth("January");
        budgetMonth.setBudgetYear("2018");
        budgetMonth.setUsers(user);
        user.getBudgetMonths().add(budgetMonth);

        int userId = usersAbstractDao.create(user);

        assertTrue(usersAbstractDao.get(userId).equals(user));
    }

    @Test
    public void createTestBudgetMonth() throws Exception {
        Users user = usersAbstractDao.get(2);

        BudgetMonth budgetMonth = new BudgetMonth("August", "2017", user);

        int budgetId = budgetMonthAbstractDao.create(budgetMonth);

        log.info("budgetId: " + budgetId);

        assertTrue(budgetMonthAbstractDao.get(budgetId).equals(budgetMonth));
    }




    @Test
    public void getTest() throws Exception {
        Users user = usersAbstractDao.get(1);

        Set<BudgetMonth> budgetMonthes = user.getBudgetMonths();

        for (BudgetMonth budgetMonth: budgetMonthes) {
            log.info("BudgetMonth: " + budgetMonth);
        }

        assertTrue(user.getAccountId() == 1);



    }

    @Test
    public void getAllTest() throws Exception {
    }

    @Test
    public void updateTest() throws Exception {
        Users user = usersAbstractDao.get(1);

        BudgetMonth budgetMonth = new BudgetMonth("November", "2017", user);

        user.getBudgetMonths().add(budgetMonth);

        usersAbstractDao.update(user);


        Users updatedUser = usersAbstractDao.get(1);

        Set<BudgetMonth> budgetMonthes = updatedUser.getBudgetMonths();

        for (BudgetMonth budgetMonthUpdated: budgetMonthes) {
            log.info("BudgetMonth: " + budgetMonthUpdated);
        }

    }

    @Test
    public void findByPropertyMapTest() throws Exception {
        Map<String, Object> propertyMap = new HashMap<String, Object>();

        propertyMap.put("budgetMonth", "November");
        propertyMap.put("budgetYear", "2017");

        List<BudgetMonth> budgetMonth = budgetMonthAbstractDao.findByPropertyMap(propertyMap);

        log.info("BudgetMonth: " + budgetMonth);
    }



    @Test
    public void testCalcTotal() throws Exception {
        Category category = categoryAbstractDao.get(2);
        BigDecimal total = new BigDecimal(0);
        for (BudgetedItem budgetedItem : category.getBudgetedItems()) {
            total = total.add(budgetedItem.getBudgetedAmount());
            log.info("       Total: " + total);
            log.info("Budgeted Amt: " + budgetedItem.getBudgetedAmount());
        }
    }

    @Test
    public void deleteTest() throws Exception {
    }

}