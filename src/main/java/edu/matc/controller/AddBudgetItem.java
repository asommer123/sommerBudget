package edu.matc.controller;

import edu.matc.entity.BudgetedItem;
import edu.matc.entity.Category;
import edu.matc.persistence.AbstractDao;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;

@WebServlet(
        name = "addBudgetedItem",
        urlPatterns = {"/addBudgetedItem"}
)
public class AddBudgetItem extends HttpServlet {

    private final Logger log = Logger.getLogger(this.getClass());

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        String categoryId = request.getParameter("b_categoryId");
        String subCategory = request.getParameter("b_subCategoryName");
        String note = request.getParameter("b_note");
        String budgetedAmount = request.getParameter("b_budgetedAmount");
        String dueDate = request.getParameter("b_dueDate");
        String envelopeAmount = request.getParameter("b_envelopeAmount");

        log.info("categoryId = " + categoryId);
        log.info("subCategory = " + subCategory);
        log.info("budgetedId = " + note);
        log.info("budgetedAmount = " + budgetedAmount);
        log.info("dueDate = " + dueDate);
        log.info("envelopeAmount = " + envelopeAmount);

        if (note.isEmpty()) {
            note = null;
        }
        String budgetIdString = request.getParameter("b_budgetId");
        log.info("budgetIdString: " + budgetIdString);

        int budgetId = 0;

        try {
            AbstractDao<Category> categoryAbstractDao = new AbstractDao<>(Category.class);
            Category category = categoryAbstractDao.get(Integer.valueOf(categoryId));
            budgetId = category.getBudgetMonth().getBudgetMonthId();
            log.info("budgetId: " + budgetId);

            BigDecimal budgetedAmountBigDecimal = new BigDecimal(budgetedAmount);
            log.info("budgetedAmountBigDecimal: " + budgetedAmountBigDecimal);

            BudgetedItem budgetedItem = new BudgetedItem();
            //BudgetedItem budgetedItem = new BudgetedItem(subCategory, budgetedAmountBigDecimal, dueDate, note, categoryId);

            budgetedItem.setCategory(category);
            budgetedItem.setSubCategoryName(subCategory);
            budgetedItem.setBudgetedAmount(budgetedAmountBigDecimal);
            budgetedItem.setNote(note);

            category.getBudgetedItems().add(budgetedItem);

            categoryAbstractDao.update(category);
        } catch (Exception e) {
            log.error("Error occurred adding new budgeted item", e);
        }

        HttpSession session = request.getSession();
        session.setAttribute("budgetId", budgetId);

        // Create the url
        String url = "getBudgetDetails";

        //redirect
        response.sendRedirect(url);
    }
}
