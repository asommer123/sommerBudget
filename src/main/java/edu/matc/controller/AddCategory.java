package edu.matc.controller;

import edu.matc.entity.BudgetMonth;
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

/**
 * Creates a new Category based on the information passed in the request parameters.
 */
@WebServlet(
        name = "addCategory",
        urlPatterns = {"/addCategory"}
)
public class AddCategory extends HttpServlet {

    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * Creates a new Category based on the information passed in the request parameters.
     *
     * @param request the request
     * @param response the response
     * @throws ServletException
     * @throws IOException
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        String budgetIdString = request.getParameter("b_budgetId");
        String categoryName = request.getParameter("b_categoryName");

        log.info("budgetId = " + budgetIdString);
        log.info("categoryName = " + categoryName);

        int budgetId = 0;

        AbstractDao<BudgetMonth> budgetMonthAbstractDao = new AbstractDao<>(BudgetMonth.class);

        try {
            budgetId = Integer.valueOf(budgetIdString);

            BudgetMonth budgetMonth = budgetMonthAbstractDao.get(budgetId);

            budgetMonth.getCategories().add(new Category(categoryName, budgetMonth));

            budgetMonthAbstractDao.update(budgetMonth);
        } catch (Exception e) {
            log.error("Error occurred adding new category", e);
        }

        HttpSession session = request.getSession();
        session.setAttribute("budgetId", budgetId);

        // Create the url
        String url = "getBudgetDetails";

        //redirect
        response.sendRedirect(url);
    }
}
