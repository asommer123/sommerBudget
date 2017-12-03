package edu.matc.controller;

import edu.matc.entity.BudgetMonth;
import edu.matc.entity.BudgetedItem;
import edu.matc.persistence.AbstractDao;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

@WebServlet(
        name = "updateBudgetedItem",
        urlPatterns = {"/updateBudgetedItem"}
)
public class UpdateBudgetedItem extends HttpServlet {

    private final Logger log = Logger.getLogger(this.getClass());

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        String category = request.getParameter("category");
        String subCategory = request.getParameter("subCategory");
        String budgetedId = request.getParameter("budgetedId");
        String budgetedAmount = request.getParameter("budgetedAmount");
        String dueDate = request.getParameter("dueDate");
        String envelopeAmount = request.getParameter("envelopeAmount");
        String note = request.getParameter("note");
        String dayOfMonthDue = request.getParameter("dayOfMonthDue");
        log.info("category = " + category);
        log.info("subCategory = " + subCategory);
        log.info("budgetedId = " + budgetedId);
        log.info("budgetedAmount = " + budgetedAmount);
        log.info("dueDate = " + dueDate);
        log.info("envelopeAmount = " + envelopeAmount);
        log.info("note = " + note);
        log.info("dayOfMonthDue = " + dayOfMonthDue);



        String budgetId = request.getParameter("budgetId");
        log.info("budgetId = " + budgetId);



        AbstractDao<BudgetedItem> budgetedItemAbstractDao = new AbstractDao<>(BudgetedItem.class);
        BudgetedItem budgetedItem = budgetedItemAbstractDao.get(Integer.valueOf(budgetedId));

        BigDecimal budgetedAmountBigDecimal = new BigDecimal(budgetedAmount);
        log.info("budgetedAmountBigDecimal" + budgetedAmountBigDecimal);
        budgetedItem.setBudgetedAmount(new BigDecimal(budgetedAmount));
        budgetedItem.setNote(note);

        budgetedItemAbstractDao.update(budgetedItem);


        AbstractDao<BudgetMonth> dao = new AbstractDao<>(BudgetMonth.class);
        BudgetMonth budget = dao.get(Integer.valueOf(budgetId));

        log.info("Budget Month: " + budget);


        request.setAttribute("budget", budget);


        // Create the url
        String url = "/showBudgetDetails.jsp";

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
