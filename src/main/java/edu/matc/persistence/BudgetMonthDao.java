package edu.matc.persistence;

import edu.matc.entity.BudgetMonth;
import edu.matc.entity.Users;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class BudgetMonthDao {
    private final Logger log = Logger.getLogger(this.getClass());


    public List<BudgetMonth> getBudgetsForUser(Users user) {
        List<BudgetMonth> budgetMonths = new ArrayList<BudgetMonth>();
        Session session = null;

        try {
            session = SessionFactoryProvider.getSessionFactory().openSession();
            budgetMonths = session.createCriteria(Users.class).list();
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
