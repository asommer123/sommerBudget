package edu.matc.persistence;

import edu.matc.entity.*;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * The type Abstract dao test.
 */
public class AbstractDaoTest {

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
        List<Users> users = usersAbstractDao.getAll();
        assertTrue(users.size() > 0);
    }

    /**
     * Update test.
     *
     * @throws Exception the exception
     */
    @Test
    public void updateTest() throws Exception {
        Users user = usersAbstractDao.get(1);

        BudgetMonth budgetMonth = new BudgetMonth("December", "2017", user);

        user.getBudgetMonths().add(budgetMonth);

        usersAbstractDao.update(user);


        Users updatedUser = usersAbstractDao.get(1);

        assertTrue(user.getBudgetMonths().size() == updatedUser.getBudgetMonths().size());
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

        assertTrue("testAccount".equals(usersList.get(0).getUserName()));
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

        assertTrue(budgetMonth.size() > 0);
        assertTrue(budgetMonth.get(0).getBudgetMonth().equals("November"));
        assertTrue(budgetMonth.get(0).getBudgetYear().equals("2017"));
    }


    /**
     * Delete test.
     *
     * @throws Exception the exception
     */
    @Test
    public void deleteTest() throws Exception {
        Users user = usersAbstractDao.get(3);
        usersAbstractDao.delete(user);

        Users user2 = usersAbstractDao.get(3);

        assertTrue(user2 == null);
    }

}