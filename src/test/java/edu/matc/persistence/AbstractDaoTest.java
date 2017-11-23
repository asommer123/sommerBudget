package edu.matc.persistence;

import edu.matc.entity.BudgetMonth;
import edu.matc.entity.UserRole;
import edu.matc.entity.Users;
import edu.matc.util.LocalDateAttributeConverter;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Set;

import static org.junit.Assert.*;

public class AbstractDaoTest {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private final Logger log = Logger.getLogger(this.getClass());
    AbstractDao<Users> usersAbstractDao;
    AbstractDao<BudgetMonth> budgetMonthAbstractDao;

    @Before
    public void setup() {
        usersAbstractDao = new AbstractDao(Users.class);
        budgetMonthAbstractDao = new AbstractDao<>(BudgetMonth.class);
    }

    @Test
    public void createTest() throws Exception {
        Users user = new Users();

        user.setUserName("newAcct10");
        user.setUserPass("test");
        user.setEmailAddress("newUser@test.com");
        user.setFirstName("TestName");
        user.setLastName("LastName");

        UserRole userRole = new UserRole();
        userRole.setRollName("tester");
        userRole.setUsersByAccountId(user);
        user.getUserRoleByUserName().add(userRole);


        //LocalDate localDate = LocalDate.parse(dateString, DATE_TIME_FORMATTER);
        LocalDate localDate = LocalDate.now();
        LocalDateAttributeConverter converter = new LocalDateAttributeConverter();
        Date date = converter.convertToDatabaseColumn(localDate);
        log.info("Date: " + date);
        log.info("LocalDate: " + localDate);



        BudgetMonth budgetMonth = new BudgetMonth();

        budgetMonth.setBudgetDate(date);
        budgetMonth.setUsersByAccountId(user);
        user.getBudgetMonthsByAccountId().add(budgetMonth);

        int userId = usersAbstractDao.create(user);

        assertTrue(usersAbstractDao.get(userId).equals(user));
    }

    @Test
    public void createTestBudgetMonth() throws Exception {
        Users user = usersAbstractDao.get(8);

        LocalDate localDate = LocalDate.parse("2017-10-01", DATE_TIME_FORMATTER);
        //LocalDate localDate = LocalDate.now();
        LocalDateAttributeConverter converter = new LocalDateAttributeConverter();
        Date date = converter.convertToDatabaseColumn(localDate);
        log.info("Date: " + date);
        log.info("LocalDate: " + localDate);



        BudgetMonth budgetMonth = new BudgetMonth();

        budgetMonth.setBudgetDate(date);
        budgetMonth.setUsersByAccountId(user);


        int budgetId = budgetMonthAbstractDao.create(budgetMonth);

        log.info("budgetId: " + budgetId);

        assertTrue(budgetMonthAbstractDao.get(budgetId).equals(budgetMonth));
    }




    @Test
    public void getTest() throws Exception {
        Users user = usersAbstractDao.get(1);

        Set<BudgetMonth> budgetMonthes = user.getBudgetMonthsByAccountId();

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
    }

    @Test
    public void deleteTest() throws Exception {
    }

}