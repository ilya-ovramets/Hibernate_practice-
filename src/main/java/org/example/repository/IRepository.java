package org.example.repository;

import java.util.List;
import java.util.Optional;

public interface IRepository<T> {

    Optional<T> findById(long id);

    List<T> findAll();

    void save(T t);

    void update(T t);

    void delete(long id);
}
