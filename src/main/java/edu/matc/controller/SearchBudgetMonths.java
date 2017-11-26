package edu.matc.controller;

import edu.matc.entity.BudgetMonth;
import edu.matc.entity.Users;
import edu.matc.persistence.AbstractDao;
import edu.matc.persistence.UsersDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@WebServlet(
        name = "searchBudgetMonths",
        urlPatterns = {"/searchBudgetMonths"}
)
public class SearchBudgetMonths extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UsersDao usersDao = new UsersDao();

        String url = "/showBudgetMonths.jsp";
        request.setAttribute("title", "My Budgets");
        HttpSession session = request.getSession();

        //session.removeAttribute("newUser");
        //session.removeAttribute("newUserName");
        session.setAttribute("loggedIn", true);


        Users user = usersDao.getUserByUserName(request.getRemoteUser()).get(0);
        request.setAttribute("user", user);

        Set<BudgetMonth> budgetMonths = user.getBudgetMonthsByAccountId();

        request.setAttribute("budgetMonths", budgetMonths);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}


