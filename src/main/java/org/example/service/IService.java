package org.example.service;

import java.util.List;

public interface IService<T> {

    T getById(long id);

    List<T> getAll();

    boolean save(T t);

    boolean update(T t);

    boolean delete(T t);

}

