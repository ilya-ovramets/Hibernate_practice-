package org.example.repository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.example.entity.Task;

import java.util.List;
import java.util.Optional;

public class TaskRepository implements IRepository<Task> {

    private final static Logger log = LogManager.getLogger(TaskRepository.class);


    @Override
    public Optional<Task> findById(long id) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()){

            return Optional.ofNullable(session.get(Task.class,id));

        }catch (Exception e){
            log.error(e.getMessage());
            return Optional.empty();
        }

    }

    @Override
    public List<Task> findAll() {

        try(Session session = HibernateUtil.getSessionFactory().openSession()){

            return session.createQuery("from Task", Task.class).list();

        }catch (Exception e){
            log.error("Error finding all Tasks: " + e.getMessage());
            return List.of();
        }

    }

    @Override
    public void save(Task task) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(task);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            log.error("Error saving Task: " + e.getMessage(), e);
        }
    }

    @Override
    public void update(Task task) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.merge(task);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            log.error("Error updating Task: " + e.getMessage(), e);
        }

    }

    @Override
    public void delete(long id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Task task = session.get(Task.class, id);
            if (task != null) {
                session.remove(task);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            log.error("Error deleting Task: " + e.getMessage(), e);
        }
    }
}
