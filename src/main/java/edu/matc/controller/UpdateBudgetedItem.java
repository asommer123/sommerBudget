package edu.matc.controller;

import edu.matc.entity.BudgetMonth;
import edu.matc.entity.BudgetedItem;
import edu.matc.persistence.AbstractDao;
import edu.matc.util.LocalDateAttributeConverter;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Updates the budgeted item for the information passed in the request parameters.
 */
@WebServlet(
        name = "updateBudgetedItem",
        urlPatterns = {"/updateBudgetedItem"}
)
public class UpdateBudgetedItem extends HttpServlet {

    private final Logger log = Logger.getLogger(this.getClass());
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    /**
     * Updates the budgeted item for the information passed in the request parameters.
     *
     * @param request the request
     * @param response the response
     * @throws ServletException
     * @throws IOException
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String b_categoryId = request.getParameter("b_categoryId");
        String b_subCategoryName = request.getParameter("b_subCategoryName");
        String b_budgetedId = request.getParameter("b_budgetedId");
        String b_budgetedAmount = request.getParameter("b_budgetedAmount");
        String b_dueDate = request.getParameter("b_dueDate");
        String b_envelopeAmount = request.getParameter("b_envelopeAmount");
        String b_note = request.getParameter("b_note");

        log.info("b_categoryId = " + b_categoryId);
        log.info("b_subCategoryName = " + b_subCategoryName);
        log.info("b_budgetedId = " + b_budgetedId);
        log.info("b_budgetedAmount = " + b_budgetedAmount);
        log.info("b_dueDate = " + b_dueDate);
        log.info("b_envelopeAmount = " + b_envelopeAmount);
        log.info("b_note = " + b_note);

        int budgetId = 0;

        try {
            AbstractDao<BudgetedItem> budgetedItemAbstractDao = new AbstractDao<>(BudgetedItem.class);
            BudgetedItem budgetedItem = budgetedItemAbstractDao.get(Integer.valueOf(b_budgetedId));

            LocalDateAttributeConverter converter = new LocalDateAttributeConverter();

            budgetedItem.setSubCategoryName(b_subCategoryName);
            budgetedItem.setBudgetedAmount(new BigDecimal(b_budgetedAmount));

            if (b_envelopeAmount == null || b_envelopeAmount.isEmpty()) {
                budgetedItem.setEnvelopeAmount(null);
            } else {
                budgetedItem.setEnvelopeAmount(new BigDecimal(b_envelopeAmount));
            }

            if (b_dueDate == null || b_dueDate.isEmpty()) {
                budgetedItem.setDueDate(null);
            } else {
                budgetedItem.setDueDate(converter.convertToDatabaseColumn(LocalDate.parse(b_dueDate, DATE_TIME_FORMATTER)));
            }

            if (b_note.isEmpty()) {
                budgetedItem.setNote(null);
            } else {
                budgetedItem.setNote(b_note);
            }

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

        HttpSession session = request.getSession();
        session.setAttribute("budgetId", budgetId);

        String url = "getBudgetDetails";
        response.sendRedirect(url);
    }
}
