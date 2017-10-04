package edu.matc.persistence;

import edu.matc.entity.UserRole;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserRoleDao {
    private final Logger log = Logger.getLogger(this.getClass());


    /**
     * add a userRole
     *
     * @param userRole
     * @return the id of the inserted record
     */
    public int addUserRole(UserRole userRole) {
        int id = 0;

        Transaction transaction = null;
        Session session = null;

        try {
            session = SessionFactoryProvider.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            id = (int) session.save(userRole);
            transaction.commit();
        } catch (HibernateException hibernateException) {
            log.error("Error occurred attempting to add userRole: " + userRole, hibernateException);
            if (transaction != null) {
                try {
                    log.error("Error occurred, attempting to rollback transaction adding userRole: " + userRole);
                    transaction.rollback();
                } catch (HibernateException hibernateException2) {
                    log.error("Error occurred during rollback for user: " + userRole, hibernateException2);
                }
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return id;
    }
}
