package edu.matc.controller;

import edu.matc.entity.BudgetMonth;
import edu.matc.entity.Users;
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
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Set;

@WebServlet(
        name = "addBudgetMonth",
        urlPatterns = {"/addBudgetMonth"}
)
public class AddBudgetMonth extends HttpServlet {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private final Logger log = Logger.getLogger(this.getClass());


    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        String budgetDate = request.getParameter("budgetDate");
        log.info("budgetDate = " + budgetDate);

        LocalDate localDate = LocalDate.parse(budgetDate, DATE_TIME_FORMATTER);
        LocalDateAttributeConverter converter = new LocalDateAttributeConverter();
        Date date = converter.convertToDatabaseColumn(localDate);



        UsersDao usersDao = new UsersDao();
        Users users = usersDao.getUserByUserName(request.getRemoteUser());

        users.getBudgetMonthsByAccountId().add(new BudgetMonth(date, users));

        usersDao.updateUser(users);


        request.getSession().setAttribute("createMessage", "successfully added " + budgetDate);

        request.setAttribute("user", users);

        Set<BudgetMonth> budgetMonths = users.getBudgetMonthsByAccountId();

        request.setAttribute("budgetMonths", budgetMonths);

        // Create the url
        String url = "/showBudgetDetails.jsp";

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
