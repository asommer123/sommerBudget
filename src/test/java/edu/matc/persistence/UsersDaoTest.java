package edu.matc.persistence;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ocbc.api.Response;
import com.ocbc.api.Results;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import edu.matc.entity.UserRole;
import edu.matc.entity.Users;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import static org.junit.Assert.*;

public class UsersDaoTest {
    private final Logger log = Logger.getLogger(this.getClass());

    UsersDao dao;

    @Before
    public void setup() {
        dao = new UsersDao();
    }

    @Test
    public void getAllUsers() throws Exception {
        List<Users> users = dao.getAllUsers();
        assertTrue(users.size() > 0);
    }

    @Test
    public void getUser() throws Exception {
        Users user = dao.getUser(1);
        assertTrue(user.getAccountId() == 1);
    }

    @Test
    public void getUserByUserNameTest() throws Exception {
        Users users = dao.getUserByUserName("testAccount");
        log.info(users.toString());
        assertTrue(users.getUserName().equals("testAccount"));
    }

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

    @Test
    public void deleteUser() throws Exception {
        Users user = dao.getUser(3);
        dao.deleteUser(user.getAccountId());
        List<Users> usersList = dao.getAllUsers();
        Users user2 = dao.getUser(3);

        assertTrue(user2 == null);
    }

    @Test
    public void updateUser() throws Exception {
        Users users = dao.getUser(1);
        users.setEmailAddress("myEmail@test.edu");
        dao.updateUser(users);

        Users users1 = dao.getUser(1);

        assertTrue(users.equals(users1));
    }


    @Test
    public void apiTest() throws Exception {

        //curl -X GET --header "Accept: application/json"
        // --header "Authorization: Bearer c3c34e2d512dfded5c252469d4fdc747"
        // "https://api.ocbc.com:8243/Home_Loan/1.0?currentAge1=30&totalMonthlyIncome1=5000&totalMonthlyDebt1=200&outstandingLoans1=0&repaymentPeriod=30"

        URL url = new URL("https://api.ocbc.com:8243/Home_Loan/1.0?currentAge1=30&totalMonthlyIncome1=5000&totalMonthlyDebt1=200&outstandingLoans1=0&repaymentPeriod=30");
        String encoding = Base64.encode ("c3c34e2d512dfded5c252469d4fdc747".getBytes());
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty  ("Accept", "application/json");
        connection.setRequestProperty  ("Authorization", "Bearer c3c34e2d512dfded5c252469d4fdc747");
        int responseCode = connection.getResponseCode();

        if (responseCode != 200) {
            log.error("Error encounted while calling API. Response code = " + responseCode
                    + ". Response message = " + connection.getResponseMessage());
        }

        InputStream content = (InputStream)connection.getInputStream();

        BufferedReader in = new BufferedReader (new InputStreamReader(content));
        String jsonResponse="";
        String line;
        while ((line = in.readLine()) != null) {
            jsonResponse = jsonResponse + line;
        }
        log.info("Response: " + jsonResponse);
        ObjectMapper mapper = new ObjectMapper();
        Response response = mapper.readValue(jsonResponse, Response.class);

        log.info(response.toString());
        Results results = response.getResults();
        log.info(results.toString());




    }


/*
    public GameResponse gameApiCall () throws IOException {

        URL url = new URL("https://api.mysportsfeeds.com/v1.1/pull/" + sport
                + "/current/full_game_schedule.json");
        String encoding = Base64.encode ("madentjava2017:greatlakes".getBytes());
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setDoOutput(true);
        connection.setRequestProperty  ("Authorization", "Basic " + encoding);
        responseCode = connection.getResponseCode();

        if (responseCode != 200) {
            log.error("Error encounted while calling My Sports Feed API. Response code = " + responseCode
                    + ". Response message = " + connection.getResponseMessage());
            return null;
        }

        InputStream content = (InputStream)connection.getInputStream();

        BufferedReader in = new BufferedReader (new InputStreamReader(content));
        String jsonResponse="";
        String line;
        while ((line = in.readLine()) != null) {
            jsonResponse = jsonResponse + line;
        }
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(jsonResponse,GameResponse.class);
    }*/

}