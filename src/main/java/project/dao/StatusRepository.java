package project.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import project.entity.Status;

import java.util.List;

public class StatusRepository implements Repository<Status> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Status findById(long id) {
        return entityManager.find(Status.class,id);
    }

    @Override
    public List<Status> findAll() {
        return entityManager.createQuery("Select * from status").getResultList();
    }

    @Override
    public void save(Status status) {
        entityManager.persist(status);

    }

    @Override
    public void update(Status status) {
        entityManager.merge(status);

    }

    @Override
    public void delete(long id) {
        Status status = findById(id);

        if(status != null){
            entityManager.remove(status);
        }

    }
}
