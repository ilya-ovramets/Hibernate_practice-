package project.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import project.entity.User;

import java.util.List;

public class UserRepository implements Repository<User> {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public User findById(long id) {
        return entityManager.find(User.class,id);
    }

    @Override
    public List<User> findAll() {
        return entityManager.createQuery("Select * from users").getResultList();
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);

    }

    @Override
    public void update(User user) {
        entityManager.merge(user);

    }

    @Override
    public void delete(long id) {
        User user = findById(id);
        if(user != null){
            entityManager.remove(user);
        }

    }
}
