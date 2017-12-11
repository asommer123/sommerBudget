package edu.matc.controller;

import edu.matc.entity.BudgetMonth;
import edu.matc.persistence.AbstractDao;
import edu.matc.util.ConvertToCurrencyString;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(
        name = "getBudgetDetails",
        urlPatterns = {"/getBudgetDetails"}
)
public class GetBudgetDetails extends HttpServlet {

    private final Logger log = Logger.getLogger(this.getClass());
    private final static String DELETEBUDGET = "deleteBudget";


    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String budgetId = request.getParameter("budgetId");

        if (budgetId == null) {
            HttpSession session = request.getSession();
            budgetId = session.getAttribute("budgetId").toString();
        }

        log.info("budgetId = " + budgetId);

        AbstractDao<BudgetMonth> dao = new AbstractDao<>(BudgetMonth.class);
        BudgetMonth budget = dao.get(Integer.valueOf(budgetId));

        log.info("Budget Month: " + budget);

        if (DELETEBUDGET.equals(request.getParameter("submit"))) {
            dao.delete(budget);

            String url = "searchBudgetMonths";
            response.sendRedirect(url);
        } else {
            request.setAttribute("budget", budget);
            request.setAttribute("currencyFormat", new ConvertToCurrencyString());

            String url = "/showBudgetDetails.jsp";

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
            dispatcher.forward(request, response);
        }
    }
}
