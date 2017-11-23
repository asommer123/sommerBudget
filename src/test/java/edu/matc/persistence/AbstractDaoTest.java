package edu.matc.persistence;

import edu.matc.entity.BudgetMonth;
import edu.matc.entity.UserRole;
import edu.matc.entity.Users;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.sql.Date;

import static org.junit.Assert.*;

public class AbstractDaoTest {

    private final Logger log = Logger.getLogger(this.getClass());
    AbstractDao<Users> dao;

    @Before
    public void setup() {
        dao = new AbstractDao(Users.class);
    }

    @Test
    public void createTest() throws Exception {
        Users user = new Users();

        user.setUserName("newAcct9");
        user.setUserPass("test");
        user.setEmailAddress("newUser@test.com");
        user.setFirstName("TestName");
        user.setLastName("LastName");

        UserRole userRole = new UserRole();
        userRole.setRollName("tester");
        userRole.setUsersByAccountId(user);
        user.getUserRoleByUserName().add(userRole);


        Date date = new Date(1);
        log.info("Date:" + date);


        BudgetMonth budgetMonth = new BudgetMonth();

        budgetMonth.setBudgetDate(new Date(1));
        budgetMonth.setUsersByAccountId(user);
        user.getBudgetMonthsByAccountId().add(budgetMonth);

        int userId = dao.create(user);

        assertTrue(dao.get(userId).equals(user));
    }

    @Test
    public void getTest() throws Exception {
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