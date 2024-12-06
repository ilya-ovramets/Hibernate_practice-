package org.example.repository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.example.entity.User;

import java.util.List;
import java.util.Optional;

public class UserRepository implements IRepository<User> {

    private final static Logger log = LogManager.getLogger(UserRepository.class);

    @Override
    public Optional<User> findById(long id) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()){

            return Optional.ofNullable(session.get(User.class,id));

        }catch (Exception e){
            log.error(e.getMessage());
            return Optional.empty();
        }

    }

    @Override
    public List<User> findAll() {

        try(Session session = HibernateUtil.getSessionFactory().openSession()){

            return session.createQuery("from User", User.class).list();

        }catch (Exception e){
            log.error("Error finding all Tags: " + e.getMessage());
            return List.of();
        }

    }

    @Override
    public void save(User user) {

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            log.error("Error saving User: " + e.getMessage(), e);
        }

    }

    @Override
    public void update(User user) {

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.merge(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            log.error("Error updating User: " + e.getMessage(), e);
        }

    }

    @Override
    public void delete(long id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            User user = session.get(User.class, id);
            if (user != null) {
                session.remove(user);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            log.error("Error deleting User: " + e.getMessage(), e);
        }

    }
}
