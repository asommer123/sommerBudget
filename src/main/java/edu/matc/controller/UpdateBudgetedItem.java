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


        String categoryId = request.getParameter("categoryId");
        String subCategory = request.getParameter("subCategory");
        String budgetedId = request.getParameter("budgetedId");
        String budgetedAmount = request.getParameter("budgetedAmount");
        String dueDate = request.getParameter("dueDate");
        String envelopeAmount = request.getParameter("envelopeAmount");
        String note = request.getParameter("note");
        String dayOfMonthDue = request.getParameter("dayOfMonthDue");


        String b_note = request.getParameter("b_note");
        String b_budgetedId = request.getParameter("b_budgetedId");

        log.info("categoryId = " + categoryId);
        log.info("subCategory = " + subCategory);
        log.info("budgetedId = " + budgetedId);
        log.info("b_budgetedId = " + b_budgetedId);
        log.info("budgetedAmount = " + budgetedAmount);
        log.info("dueDate = " + dueDate);
        log.info("envelopeAmount = " + envelopeAmount);
        log.info("note = " + note);
        log.info("b_note = " + b_note);
        log.info("dayOfMonthDue = " + dayOfMonthDue);




        //String budgetId = request.getParameter("b_budgetId");
        //log.info("b_budgetId = " + budgetId);


        int budgetId = 0;


        try {
            AbstractDao<BudgetedItem> budgetedItemAbstractDao = new AbstractDao<>(BudgetedItem.class);
            BudgetedItem budgetedItem = budgetedItemAbstractDao.get(Integer.valueOf(b_budgetedId));

            //BigDecimal budgetedAmountBigDecimal = new BigDecimal(budgetedAmount);
            //log.info("budgetedAmountBigDecimal" + budgetedAmountBigDecimal);
            //budgetedItem.setBudgetedAmount(new BigDecimal(budgetedAmount));
            budgetedItem.setNote(b_note);

            budgetedItemAbstractDao.update(budgetedItem);
            budgetId = budgetedItem.getCategory().getBudgetMonth().getBudgetMonthId();
            log.info("Budget Month Id" + budgetedItem.getCategory().getBudgetMonth().getBudgetMonthId());
        } catch (Exception e) {
            log.error("Error occurred updating budgeted item", e);
        }




        AbstractDao<BudgetMonth> dao = new AbstractDao<>(BudgetMonth.class);
        BudgetMonth budget = dao.get(budgetId);

        log.info("Budget Month: " + budget);


        request.setAttribute("budget", budget);


        // Create the url
        String url = "/showBudgetDetails.jsp";

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
