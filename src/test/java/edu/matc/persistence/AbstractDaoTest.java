package edu.matc.persistence;

import edu.matc.entity.*;
import org.apache.log4j.Logger;
import org.hibernate.criterion.MatchMode;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * The type Abstract dao test.
 */
public class AbstractDaoTest {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private final Logger log = Logger.getLogger(this.getClass());
    private AbstractDao<Users> usersAbstractDao;
    private AbstractDao<BudgetMonth> budgetMonthAbstractDao;
    private AbstractDao<Category> categoryAbstractDao;
    private AbstractDao<BudgetedItem> budgetedItemAbstractDao;

    /**
     * Sets .
     */
    @Before
    public void setup() {
        usersAbstractDao = new AbstractDao(Users.class);
        budgetMonthAbstractDao = new AbstractDao<>(BudgetMonth.class);
        categoryAbstractDao = new AbstractDao<>(Category.class);
        budgetedItemAbstractDao = new AbstractDao<>(BudgetedItem.class);
    }

    /**
     * Create test.
     *
     * @throws Exception the exception
     */
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

    /**
     * Create test budget month.
     *
     * @throws Exception the exception
     */
    @Test
    public void createTestBudgetMonth() throws Exception {
        Users user = usersAbstractDao.get(2);

        BudgetMonth budgetMonth = new BudgetMonth("August", "2017", user);

        int budgetId = budgetMonthAbstractDao.create(budgetMonth);

        log.info("budgetId: " + budgetId);

        assertTrue(budgetMonthAbstractDao.get(budgetId).equals(budgetMonth));
    }


    /**
     * Gets test.
     *
     * @throws Exception the exception
     */
    @Test
    public void getTest() throws Exception {
        Users user = usersAbstractDao.get(1);

        Set<BudgetMonth> budgetMonthes = user.getBudgetMonths();

        for (BudgetMonth budgetMonth: budgetMonthes) {
            log.info("BudgetMonth: " + budgetMonth);
        }

        assertTrue(user.getAccountId() == 1);



    }

    /**
     * Gets all test.
     *
     * @throws Exception the exception
     */
    @Test
    public void getAllTest() throws Exception {
    }

    /**
     * Update test.
     *
     * @throws Exception the exception
     */
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

    /**
     * Find by property test.
     *
     * @throws Exception the exception
     */
    @Test
    public void findByPropertyTest() throws Exception {
        List<Users> usersList = usersAbstractDao.findByProperty("userName", "testAccount");
        log.info("Users: " + usersList);
    }

    /**
     * Find by property match test.
     *
     * @throws Exception the exception
     */
    @Test
    public void findByPropertyMatchTest() throws Exception {
        List<Users> usersList = usersAbstractDao.findByProperty("userName", "testAccount", MatchMode.EXACT);
        log.info("Users: " + usersList);
    }

    /**
     * Find by property map test.
     *
     * @throws Exception the exception
     */
    @Test
    public void findByPropertyMapTest() throws Exception {
        Map<String, Object> propertyMap = new HashMap<String, Object>();
        Users users = usersAbstractDao.get(1);

        propertyMap.put("budgetMonth", "November");
        propertyMap.put("budgetYear", "2017");
        propertyMap.put("users", users);

        List<BudgetMonth> budgetMonth = budgetMonthAbstractDao.findByPropertyMap(propertyMap);

        log.info("BudgetMonth: " + budgetMonth);

    }


    /**
     * Test calc total.
     *
     * @throws Exception the exception
     */
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

    /**
     * Delete test.
     *
     * @throws Exception the exception
     */
    @Test
    public void deleteTest() throws Exception {
    }


    /**
     * Add new budget month test.
     *
     * @throws Exception the exception
     */
    @Test
    public void addNewBudgetMonthTest() throws Exception {

        String monthSelected = "January";
        String yearSelected = "1234";

        AbstractDao<Users> usersAbstractDao1 = new AbstractDao<>(Users.class);
        Users users = usersAbstractDao1.findByProperty("userName", "testAccount").get(0);

        log.info("User: " + users);

        BudgetMonth budgetMonth = new BudgetMonth(monthSelected, yearSelected, users);
        log.info("New BudgetMonth: " + budgetMonth);

        users.getBudgetMonths().add(budgetMonth);

        usersAbstractDao1.update(users);


        Map<String, Object> propertyMap = new HashMap<String, Object>();

        propertyMap.put("budgetMonth", monthSelected);
        propertyMap.put("budgetYear", yearSelected);
        propertyMap.put("users", users);

        AbstractDao<BudgetMonth> budgetMonthAbstractDao = new AbstractDao<>(BudgetMonth.class);
        List<BudgetMonth> budget = budgetMonthAbstractDao.findByPropertyMap(propertyMap);

        log.info("Budget Month: " + budget);
    }


    /**
     * Update test budgeted item.
     *
     * @throws Exception the exception
     */
    @Test
    public void updateTestBudgetedItem() throws Exception {

        String number = null;

        BigDecimal amount = new BigDecimal("1234.56");
        log.info("Amount: " + amount);

        BigDecimal amount2 = new BigDecimal(number);
        log.info("Amount2: " + amount2);


        BudgetedItem budgetedItem = budgetedItemAbstractDao.get(1);

        budgetedItem.setBudgetedAmount(new BigDecimal("1234.56"));

        budgetedItemAbstractDao.update(budgetedItem);

        BudgetedItem updatedBudgetedItem = budgetedItemAbstractDao.get(1);

    }
}