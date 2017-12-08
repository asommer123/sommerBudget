package edu.matc.controller;

import edu.matc.entity.UserRole;
import edu.matc.entity.Users;
import edu.matc.persistence.AbstractDao;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "createNewUser",
        urlPatterns = {"/createNewUser"}
)
public class CreateNewUser extends HttpServlet {

    private final Logger log = Logger.getLogger(this.getClass());

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        String userName = request.getParameter("userName");
        String userPassword = request.getParameter("userPassword");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String emailAddress = request.getParameter("emailAddress");

        log.info("userName = " + userName);
        log.info("userPassword = " + userPassword);
        log.info("firstName = " + firstName);
        log.info("lastName = " + lastName);
        log.info("emailAddress = " + emailAddress);

        Users user = new Users(userName, userPassword, firstName, lastName, emailAddress);
        UserRole userRole = new UserRole("registeredUser", user);

        user.getUserRole().add(userRole);

        log.info("User: " + user);

        AbstractDao<Users> usersAbstractDao = new AbstractDao<>(Users.class);

        usersAbstractDao.create(user);

        request.login(userName, userPassword);

        //UsersDao usersDao = new UsersDao();
        //Users users = usersDao.getUserByUserName(request.getRemoteUser());


        String url = "searchBudgetMonths";

        response.sendRedirect(url);
    }
}
