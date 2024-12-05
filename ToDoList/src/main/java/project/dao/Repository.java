package project.dao;

import java.util.List;

public interface Repository<T> {

    T findById(long id);

    List<T> findAll();

    void save(T t);

    void update(T t);

    void delete(long id);
}
