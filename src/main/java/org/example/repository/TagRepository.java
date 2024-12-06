package org.example.repository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.example.entity.Tag;

import java.util.List;
import java.util.Optional;

public class TagRepository implements IRepository<Tag> {

    private final static Logger log = LogManager.getLogger(TagRepository.class);


    @Override
    public Optional<Tag> findById(long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){

            return Optional.ofNullable(session.get(Tag.class,id));

        }catch (Exception e){
            log.error(e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public List<Tag> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){

            return session.createQuery("from Tag", Tag.class).list();

        }catch (Exception e){
            log.error("Error finding all Tags: " + e.getMessage());
            return List.of();
        }
    }

    @Override
    public void save(Tag tag) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(tag);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            log.error("Error saving Tag: " + e.getMessage(), e);
        }
    }

    @Override
    public void update(Tag tag) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.merge(tag);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            log.error("Error updating Tag: " + e.getMessage(), e);
        }
    }

    @Override
    public void delete(long id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Tag tag = session.get(Tag.class, id);
            if (tag != null) {
                session.remove(tag);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            log.error("Error deleting Tag: " + e.getMessage(), e);
        }
    }
}
