package edu.matc.controller;

import edu.matc.entity.BudgetMonth;
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
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Set;

@WebServlet(
        name = "searchBudgetMonths",
        urlPatterns = {"/searchBudgetMonths"}
)
public class SearchBudgetMonths extends HttpServlet {

    private final Logger log = Logger.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        AbstractDao<Users> usersAbstractDao = new AbstractDao<>(Users.class);
        Users user = usersAbstractDao.findByProperty("userName", request.getRemoteUser()).get(0);

        if (userAdmin(user)) {
            session.setAttribute("adminLoggedIn", true);
        } else {
            session.setAttribute("regularLoggedIn", true);
        }

        Set<BudgetMonth> budgetMonths = user.getBudgetMonths();

        log.info("BudgetMonths: " + budgetMonths);

        request.setAttribute("budgetMonths", budgetMonths);

        String url = "/showBudgetMonths.jsp";

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

    private boolean userAdmin(Users user) {
        for (UserRole userRole : user.getUserRole()) {
            if (userRole.getRoleName().equals("administrator")) {
                return true;
            }
        }

        return false;
    }
}


