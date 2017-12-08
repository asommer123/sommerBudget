package edu.matc.controller;

import edu.matc.entity.BudgetMonth;
import edu.matc.entity.Users;
import edu.matc.persistence.UsersDao;
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

        UsersDao usersDao = new UsersDao();


        request.setAttribute("title", "My Budgets");
        HttpSession session = request.getSession();

        //session.removeAttribute("newUser");
        //session.removeAttribute("newUserName");
        session.setAttribute("loggedIn", true);


        Users user = usersDao.getUserByUserName(request.getRemoteUser());
        request.setAttribute("user", user);

        Set<BudgetMonth> budgetMonths = user.getBudgetMonths();

        request.setAttribute("budgetMonths", budgetMonths);

        String url = "/showBudgetMonths.jsp";

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }


}


