package edu.matc.controller;

import edu.matc.entity.BudgetMonth;
import edu.matc.entity.BudgetedItem;
import edu.matc.persistence.AbstractDao;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Deletes the BudgetedItem for the id passed in the request parameters.
 */
@WebServlet(
        name = "deleteBudgetedItem",
        urlPatterns = {"/deleteBudgetedItem"}
)
public class DeleteBudgetItem extends HttpServlet {

    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * Deletes the BudgetedItem for the id passed in the request parameters.
     *
     * @param request the request
     * @param response the response
     * @throws ServletException
     * @throws IOException
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String b_budgetedId = request.getParameter("b_budgetedId");

        log.info("b_budgetedId = " + b_budgetedId);

        int budgetId = 0;

        try {
            AbstractDao<BudgetedItem> budgetedItemAbstractDao = new AbstractDao<>(BudgetedItem.class);
            BudgetedItem budgetedItem = budgetedItemAbstractDao.get(Integer.valueOf(b_budgetedId));
            budgetId = budgetedItem.getCategory().getBudgetMonth().getBudgetMonthId();
            budgetedItemAbstractDao.delete(budgetedItem);

            log.info("Deleted Budgeted Item with Id: " + b_budgetedId + " for Budget Month Id: " + budgetId);
        } catch (Exception e) {
            log.error("Error occurred deleting budgeted item id " + b_budgetedId, e);
        }

        AbstractDao<BudgetMonth> dao = new AbstractDao<>(BudgetMonth.class);
        BudgetMonth budget = dao.get(budgetId);

        log.info("Budget Month: " + budget);
        log.info("budgetId: " + budgetId);

        request.setAttribute("budget", budget);

        HttpSession session = request.getSession();

        session.setAttribute("budgetId", budgetId);

        // Create the url
        String url = "getBudgetDetails";

        response.sendRedirect(url);
    }
}
