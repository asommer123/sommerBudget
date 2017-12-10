package edu.matc.persistence;



import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by
 * Modeled after: https://rodrigouchoa.wordpress.com/2014/09/26/generic-dao-example/
 * and https://github.com/MadJavaEntFall2017/FatBikeTrailReports/blob/master/src/main/java/com/paulawaite/fbtr/persistence/AbstractDao.java
 *
 */
public class AbstractDao<T> {

    private Class<T> type;
    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * Instantiates a new Abstract dao.
     *
     * @param type the entity type, for example User, Trail, etc.
     */
    public AbstractDao(Class<T> type) {
        this.type = type;
    }

    /**
     * Adds the object to the database.
     *
     * @param object the entity to create
     * @return the id of the newly added record
     */
    public int create(T object) {

        Transaction transaction = null;
        Integer id = null;
        Session session = null;
        try {
            session = getSession();
            transaction = session.beginTransaction();
            id = (Integer) session.save(object);
            transaction.commit();
            log.debug("Created " + object.getClass().getName() + " with id " +
                    "of: " + id);
        } catch (HibernateException e) {
            if (transaction != null) {
                try {
                    log.error("Error saving  " + object, e);
                    transaction.rollback();
                } catch (HibernateException he2) {
                    log.error("Error rolling back save of " + object, e);
                }
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return id;
    }

    /**
     * Gets the entity with the id passed in.
     *
     * @param id the id of the entity to be read and returned
     * @return the entity
     */
    @SuppressWarnings("unchecked")
    public T get(int id) {

        Session session = getSession();
        T t = null;
        try {
            t = (T) session.get(type, id);
        } catch (HibernateException e) {
            log.error("Error getting " + type + " with id " + id, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return t;
    }

    /**
     * Gets all entities of the given type.
     *
     * @return all the entities
     */
    @SuppressWarnings("unchecked")
    public List<T> getAll() {

        Session session = getSession();
        ArrayList<T> list = null;
        try {
            list = (ArrayList<T>)getSession().createCriteria(type).list();
        } catch (HibernateException e) {
            log.error("Error getting list of " + type, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return list;

    }

    /**
     * Update the entity
     *
     * @param object the entity to be updated
     */
    public void update(T object) {
        Session session = getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            // merge resolved this issue:
            // https://blog.tallan.com/2008/09/18/hibernate-merge-vs-saveorupdate/
            //session.merge(object);
            session.saveOrUpdate(object);
            transaction.commit();
            log.debug("Updated " + object.getClass().getName() + ": " + object);
        } catch (HibernateException e) {
            if (transaction != null) {
                try {
                    log.error("Error updating  " + object, e);
                    transaction.rollback();
                } catch (HibernateException he2) {
                    log.error("Error rolling back update of " +object, e);
                }
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    /**
     * Delete the entity.
     *
     * @param object the entity to be deleted
     */
    public void delete(T object) {
        Session session = getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(object);
            transaction.commit();
            log.debug("Deleted " + object.getClass().getName() + ": " + object);
        } catch (HibernateException e) {
            if (transaction != null) {
                try {
                    log.error("Error deleting  " + object, e);
                    transaction.rollback();
                } catch (HibernateException he2) {
                    log.error("Error rolling back delete of " + object, e);
                }
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }


    /**
     * Finds entities by one of its properties.
     * Usage to return all users with lastName of "Smith": findByProperty("lastName", "smith");
     *
     * @param propertyName the property name.
     * @param value        the value by which to find.
     * @return list of entities
     */
    @SuppressWarnings("unchecked")
    public List<T> findByProperty(String propertyName, Object value) {
        //return getSession().createCriteria(type).add(Restrictions.eq(propertyName, value)).list();
        Session session = null;
        ArrayList<T> list = null;

        try {
            session = getSession();
            list = (ArrayList<T>)session.createCriteria(type).add(Restrictions.eq(propertyName, value)).list();
        } catch (HibernateException e) {
            log.error("Error getting list of " + type + " for " + propertyName + value, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return list;
    }


    @SuppressWarnings("unchecked")
    public List<T> findByPropertyMap(Map<String, Object> propertyMap) {

        //List<T> list = getSession().createCriteria(type).add(Restrictions.allEq(propertyMap)).list();
        Session session = null;
        ArrayList<T> list = null;

        try {
            session = getSession();
            list = (ArrayList<T>)session.createCriteria(type).add(Restrictions.allEq(propertyMap)).list();
        } catch (HibernateException e) {
            log.error("Error getting list of " + type + " for properyMap " + propertyMap, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return list;
    }

    /**
     * Finds entities by a String property specifying a MatchMode. This search
     * is case insensitive.
     *
     * @param propertyName the property name.
     * @param value        the value to check against.
     * @param matchMode    the match mode: EXACT, START, END, ANYWHERE.
     * @return list of entities matching the criteria
     */
    @SuppressWarnings("unchecked")
    public List<T> findByProperty(String propertyName, String value, MatchMode matchMode){
        if (matchMode != null){
            return getSession().createCriteria(type).add(Restrictions.ilike(propertyName, value, matchMode)).list();
        }else{
            return getSession().createCriteria(type).add(Restrictions.ilike(propertyName, value, MatchMode.EXACT)).list();
        }
    }

    /**
     * Finds all objects of a class by the specified order.
     *
     * @param order           the order: ASC or DESC.
     * @param propertiesOrder the properties on which to apply the ordering.
     * @return list
     */
    @SuppressWarnings("unchecked")
    public List<T> findAll(String order, String... propertiesOrder) {
        Criteria criteria = getSession().createCriteria(type);

        for (String propertyOrder : propertiesOrder) {
            if (propertyOrder.equals("ASC")) {// TODO should create enum for ASC, DESC
                criteria.addOrder(org.hibernate.criterion.Order.asc(propertyOrder));
            } else {
                criteria.addOrder(org.hibernate.criterion.Order.desc(propertyOrder));
            }
        }

        return criteria.list();
    }

    /**
     * Returnes an open session from the SessionFactory
     * @return session
     */
    private Session getSession() {
        return SessionFactoryProvider.getSessionFactory().openSession();

    }
}
