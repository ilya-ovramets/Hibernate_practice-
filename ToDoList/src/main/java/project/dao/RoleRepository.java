package project.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import project.entity.Role;

import java.util.List;

public class RoleRepository implements Repository<Role>
{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Role findById(long id) {
        return entityManager.find(Role.class,id);
    }

    @Override
    public List<Role> findAll() {
        return entityManager.createQuery("Select * from role", Role.class).getResultList();
    }

    @Override
    public void save(Role role) {
        entityManager.persist(role);
    }

    @Override
    public void update(Role role) {
        entityManager.merge(role);

    }

    @Override
    public void delete(long id) {
        Role role = findById(id);
        if(role != null){
            entityManager.remove(role);
        }



    }
}
