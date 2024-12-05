package project.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import project.entity.Status;
import project.entity.Tag;

import java.util.List;

public class TagRepository implements IRepository<Tag> {

    private final static Logger log = LogManager.getLogger(TagRepository.class);


    @Override
    public Tag findById(long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){

            return session.get(Tag.class,id);

        }catch (Exception e){
            log.error(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Tag> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){

            return session.createQuery("from Tag", Tag.class).list();

        }catch (Exception e){
            log.error("Error finding all Tags: " + e.getMessage());
            return null;
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
