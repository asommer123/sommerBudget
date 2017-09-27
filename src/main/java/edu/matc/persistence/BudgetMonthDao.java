package edu.matc.persistence;

import edu.matc.entity.BudgetMonth;
import edu.matc.entity.User;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class BudgetMonthDao {
    private final Logger log = Logger.getLogger(this.getClass());


    public List<BudgetMonth> getBudgetsForUser(User user) {
        List<BudgetMonth> budgetMonths = new ArrayList<BudgetMonth>();
        Session session = null;

        try {
            session = SessionFactoryProvider.getSessionFactory().openSession();
            budgetMonths = session.createCriteria(User.class).list();
        } catch (HibernateException hibernateException) {
            log.error("Error getting all users", hibernateException);
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return budgetMonths;
    }

}
