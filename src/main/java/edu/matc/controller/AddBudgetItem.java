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

@WebServlet(
        name = "addBudgetedItem",
        urlPatterns = {"/addBudgetedItem"}
)
public class AddBudgetItem extends HttpServlet {

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


        if (b_note.isEmpty()) {
            b_note = null;
        }





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
        log.info("budgetId: " + budgetId);


        request.setAttribute("budget", budget);
        //request.setAttribute("budgetId", budgetId);

        HttpSession session = request.getSession();

        session.setAttribute("budgetId", budgetId);



        // Create the url
        String url = "getBudgetDetails";

        //redirect
        response.sendRedirect(url);
    }
}
