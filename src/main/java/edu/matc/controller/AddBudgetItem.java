package edu.matc.controller;

import edu.matc.entity.BudgetedItem;
import edu.matc.entity.Category;
import edu.matc.persistence.AbstractDao;
import edu.matc.util.LocalDateAttributeConverter;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet(
        name = "addBudgetedItem",
        urlPatterns = {"/addBudgetedItem"}
)
public class AddBudgetItem extends HttpServlet {

    private final Logger log = Logger.getLogger(this.getClass());
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

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

        String budgetIdString = request.getParameter("b_budgetId");
        log.info("budgetIdString: " + budgetIdString);

        int budgetId = 0;

        try {
            AbstractDao<Category> categoryAbstractDao = new AbstractDao<>(Category.class);
            Category category = categoryAbstractDao.get(Integer.valueOf(categoryId));
            budgetId = category.getBudgetMonth().getBudgetMonthId();
            log.info("budgetId: " + budgetId);

            BudgetedItem budgetedItem = new BudgetedItem();

            LocalDateAttributeConverter converter = new LocalDateAttributeConverter();

            budgetedItem.setCategory(category);
            budgetedItem.setSubCategoryName(subCategory);
            budgetedItem.setBudgetedAmount(new BigDecimal(budgetedAmount));

            if (envelopeAmount == null || envelopeAmount.isEmpty()) {
                budgetedItem.setEnvelopeAmount(null);
            } else {
                budgetedItem.setEnvelopeAmount(new BigDecimal(envelopeAmount));
            }

            if (dueDate == null || dueDate.isEmpty()) {
                budgetedItem.setDueDate(null);
            } else {
                budgetedItem.setDueDate(converter.convertToDatabaseColumn(LocalDate.parse(dueDate, DATE_TIME_FORMATTER)));
            }

            if (note.isEmpty()) {
                budgetedItem.setNote(null);
            } else {
                budgetedItem.setNote(note);
            }

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
