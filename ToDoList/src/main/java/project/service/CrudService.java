package project.service;

import java.util.List;

public interface CrudService<T> {

    T getById(long id);

    List<T> getAll();

    boolean save(T t);

    boolean update(T t);

    boolean delete(T t);

}

