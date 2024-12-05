package org.example.repository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.example.entity.Role;

import java.util.List;
import java.util.Optional;

public class RoleRepository implements IRepository<Role>
{
    private final static Logger log = LogManager.getLogger(RoleRepository.class);

    @Override
    public Optional<Role> findById(long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){

            return Optional.ofNullable(session.get(Role.class,id));

        }catch (Exception e){
            log.error(e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public List<Role> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Role", Role.class).list();
        } catch (Exception e) {
            log.error("Error finding all Roles: " + e.getMessage(), e);
            return List.of();
        }
    }

    @Override
    public void save(Role role) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(role);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            log.error("Error saving Role: " + e.getMessage(), e);
        }
    }

    @Override
    public void update(Role role) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.merge(role);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            log.error("Error updating Role: " + e.getMessage(), e);
        }

    }

    @Override
    public void delete(long id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Role role = session.get(Role.class, id);
            if (role != null) {
                session.remove(role);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            log.error("Error deleting Role: " + e.getMessage(), e);
        }
    }
}
