package project.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import project.entity.Task;

import java.util.List;

public class TaskRepository implements Repository<Task> {

    @PersistenceContext
    EntityManager entityManager;


    @Override
    public Task findById(long id) {
        return entityManager.find(Task.class,id);
    }

    @Override
    public List<Task> findAll() {
        return entityManager.createQuery("Select * from tasks").getResultList();
    }

    @Override
    public void save(Task task) {
        entityManager.persist(task);

    }

    @Override
    public void update(Task task) {
        entityManager.merge(task);

    }

    @Override
    public void delete(long id) {
        Task task = findById(id);
        if(task != null){
            entityManager.remove(task);
        }

    }
}
