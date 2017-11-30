package edu.matc.controller;

import edu.matc.entity.BudgetMonth;
import edu.matc.entity.Users;
import edu.matc.persistence.AbstractDao;
import edu.matc.persistence.UsersDao;
import edu.matc.util.LocalDateAttributeConverter;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@WebServlet(
        name = "getBudgetDetails",
        urlPatterns = {"/getBudgetDetails"}
)
public class GetBudgetDetails extends HttpServlet {

    private final Logger log = Logger.getLogger(this.getClass());


    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {



        String budgetId = request.getParameter("budgetId");
        log.info("budgetId = " + budgetId);

        AbstractDao<BudgetMonth> dao = new AbstractDao<>(BudgetMonth.class);
        BudgetMonth budgetMonth = dao.get(Integer.valueOf(budgetId));

        log.info("Budget Month: " + budgetMonth);


        request.setAttribute("budgetMonth", budgetMonth);


        // Create the url
        String url = "/showBudgetDetails.jsp";

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
