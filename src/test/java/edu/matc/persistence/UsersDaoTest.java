package edu.matc.persistence;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ocbc.retirement.Response;
import com.ocbc.retirement.Results;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import edu.matc.entity.BudgetedItem;
import edu.matc.entity.Category;
import edu.matc.entity.UserRole;
import edu.matc.entity.Users;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.NumberFormat;
import java.util.List;

import static org.junit.Assert.*;

/**
 * The type Users dao test.
 */
public class UsersDaoTest {
    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * The Dao.
     */
    UsersDao dao;

    /**
     * Sets .
     */
    @Before
    public void setup() {
        dao = new UsersDao();
    }

    /**
     * Gets all users.
     *
     * @throws Exception the exception
     */
    @Test
    public void getAllUsers() throws Exception {
        List<Users> users = dao.getAllUsers();
        assertTrue(users.size() > 0);
    }

    /**
     * Gets user.
     *
     * @throws Exception the exception
     */
    @Test
    public void getUser() throws Exception {
        Users user = dao.getUser(1);
        assertTrue(user.getAccountId() == 1);
    }

    /**
     * Gets user by user name test.
     *
     * @throws Exception the exception
     */
    @Test
    public void getUserByUserNameTest() throws Exception {
        Users users = dao.getUserByUserName("testAccount");
        log.info(users.toString());
        assertTrue(users.getUserName().equals("testAccount"));
    }

    /**
     * Add user.
     *
     * @throws Exception the exception
     */
    @Test
    public void addUser() throws Exception {
        Users user = new Users();

        user.setUserName("newAcct6");
        user.setUserPass("test");
        user.setEmailAddress("newUser@test.com");
        user.setFirstName("TestName");
        user.setLastName("LastName");

        UserRole userRole = new UserRole();
        userRole.setRoleName("tester");
        userRole.setUsers(user);
        user.getUserRole().add(userRole);

        int userId = dao.addUser(user);

        assertTrue(dao.getUser(userId).equals(user));
    }

    /**
     * Delete user.
     *
     * @throws Exception the exception
     */
    @Test
    public void deleteUser() throws Exception {
        Users user = dao.getUser(3);
        dao.deleteUser(user.getAccountId());
        List<Users> usersList = dao.getAllUsers();
        Users user2 = dao.getUser(3);

        assertTrue(user2 == null);
    }

    /**
     * Update user.
     *
     * @throws Exception the exception
     */
    @Test
    public void updateUser() throws Exception {
        Users users = dao.getUser(1);
        users.setEmailAddress("myEmail@test.edu");
        dao.updateUser(users);

        Users users1 = dao.getUser(1);

        assertTrue(users.equals(users1));
    }






}