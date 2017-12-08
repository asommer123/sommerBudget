package edu.matc.controller;

import edu.matc.entity.BudgetMonth;
import edu.matc.entity.Users;
import edu.matc.persistence.AbstractDao;
import edu.matc.persistence.UsersDao;
import edu.matc.util.ConvertToCurrencyString;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(
        name = "addBudgetMonth",
        urlPatterns = {"/addBudgetMonth"}
)
public class AddBudgetMonth extends HttpServlet {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private final Logger log = Logger.getLogger(this.getClass());


    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        String monthSelected = request.getParameter("monthSelected");
        log.info("monthSelected = " + monthSelected);
        String yearSelected = request.getParameter("yearSelected");
        log.info("yearSelected = " + yearSelected);



        UsersDao usersDao = new UsersDao();
        Users users = usersDao.getUserByUserName(request.getRemoteUser());

        log.info("Remote User: " + request.getRemoteUser());

        users.getBudgetMonths().add(new BudgetMonth(monthSelected, yearSelected, users));

        usersDao.updateUser(users);


        Map<String, Object> propertyMap = new HashMap<String, Object>();

        propertyMap.put("budgetMonth", monthSelected);
        propertyMap.put("budgetYear", yearSelected);

        AbstractDao<BudgetMonth> budgetMonthAbstractDao = new AbstractDao<>(BudgetMonth.class);
        BudgetMonth budget = budgetMonthAbstractDao.findByPropertyMap(propertyMap).get(0);

        log.info("Budget Month: " + budget);


        request.setAttribute("budget", budget);
        request.setAttribute("currencyFormat", new ConvertToCurrencyString());

        // Create the url
        String url = "/showBudgetDetails.jsp";

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
