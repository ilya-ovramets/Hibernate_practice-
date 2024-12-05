package project.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import project.entity.Tag;

import java.util.List;

public class TagRepository implements Repository<Tag> {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Tag findById(long id) {
        return entityManager.find(Tag.class,id);
    }

    @Override
    public List<Tag> findAll() {
        return entityManager.createQuery("Select * from tags").getResultList();
    }

    @Override
    public void save(Tag tag) {
        entityManager.persist(tag);
    }

    @Override
    public void update(Tag tag) {
        entityManager.merge(tag);
    }

    @Override
    public void delete(long id) {
        Tag tag = findById(id);
        if(tag!= null){
            entityManager.remove(tag);
        }

    }
}
