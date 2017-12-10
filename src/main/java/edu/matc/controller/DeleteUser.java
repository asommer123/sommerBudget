package edu.matc.controller;

import edu.matc.entity.BudgetMonth;
import edu.matc.entity.BudgetedItem;
import edu.matc.entity.Users;
import edu.matc.persistence.AbstractDao;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(
        name = "deleteUser",
        urlPatterns = {"/deleteUser"}
)
public class DeleteUser extends HttpServlet {

    private final Logger log = Logger.getLogger(this.getClass());

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accountId = request.getParameter("m_accountId");
        log.info("accountId = " + accountId);

        HttpSession session = request.getSession();

        try {
            AbstractDao<Users> usersAbstractDao = new AbstractDao<>(Users.class);
            Users user = usersAbstractDao.get(Integer.valueOf(accountId));

            usersAbstractDao.delete(user);

            log.info("Deleted User: " + user);

            session.setAttribute("message", "Successfully removed user with account id: " + accountId);
        } catch (Exception e) {
            session.setAttribute("message", "Error occurred while deleting user with account id: " + accountId);
            log.error("Error occurred deleting user with id " + accountId, e);
        }

        // Create the url
        String url = "searchUser";

        response.sendRedirect(url);
    }
}
