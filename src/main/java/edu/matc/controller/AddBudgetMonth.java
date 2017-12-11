package edu.matc.controller;

import edu.matc.entity.BudgetMonth;
import edu.matc.entity.Users;
import edu.matc.persistence.AbstractDao;
import edu.matc.util.ConvertToCurrencyString;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(
        name = "addBudgetMonth",
        urlPatterns = {"/addBudgetMonth"}
)
public class AddBudgetMonth extends HttpServlet {

    private final Logger log = Logger.getLogger(this.getClass());


    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String monthSelected = request.getParameter("monthSelected");
        log.info("monthSelected = " + monthSelected);
        String yearSelected = request.getParameter("yearSelected");
        log.info("yearSelected = " + yearSelected);

        AbstractDao<Users> usersAbstractDao = new AbstractDao<>(Users.class);
        Users users = usersAbstractDao.findByProperty("userName", request.getRemoteUser()).get(0);

        log.info("Remote User: " + request.getRemoteUser());
        log.info("User: " + users);

        BudgetMonth budgetMonth = new BudgetMonth(monthSelected, yearSelected, users);
        log.info("New BudgetMonth: " + budgetMonth);

        users.getBudgetMonths().add(budgetMonth);

        usersAbstractDao.update(users);

        Map<String, Object> propertyMap = new HashMap<String, Object>();

        propertyMap.put("budgetMonth", monthSelected);
        propertyMap.put("budgetYear", yearSelected);
        propertyMap.put("users", users);

        AbstractDao<BudgetMonth> budgetMonthAbstractDao = new AbstractDao<>(BudgetMonth.class);
        List<BudgetMonth> budget = budgetMonthAbstractDao.findByPropertyMap(propertyMap);

        log.info("Budget Month: " + budget);


        request.setAttribute("budget", budget.get(0));
        request.setAttribute("currencyFormat", new ConvertToCurrencyString());

        // Create the url
        String url = "/showBudgetDetails.jsp";

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
