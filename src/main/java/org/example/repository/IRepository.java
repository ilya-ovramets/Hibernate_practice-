package org.example.repository;

import java.util.List;

public interface IRepository<T> {

    T findById(long id);

    List<T> findAll();

    void save(T t);

    void update(T t);

    void delete(long id);
}
