package org.example.repository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.example.entity.Status;

import java.util.List;

public class StatusRepository implements IRepository<Status> {

    private final static Logger log = LogManager.getLogger(StatusRepository.class);

    @Override
    public Status findById(long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){

            return session.get(Status.class,id);

        }catch (Exception e){
            log.error(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Status> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){

            return session.createQuery("from Status", Status.class).list();

        }catch (Exception e){
            log.error("Error finding all Statuses: " + e.getMessage());
            return null;
        }
    }

    @Override
    public void save(Status status) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(status);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            log.error("Error saving Status: " + e.getMessage(), e);
        }
    }

    @Override
    public void update(Status status) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.merge(status);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            log.error("Error updating Status: " + e.getMessage(), e);
        }
    }

    @Override
    public void delete(long id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Status status = session.get(Status.class, id);
            if (status != null) {
                session.remove(status);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            log.error("Error deleting Status: " + e.getMessage(), e);
        }
    }
}
