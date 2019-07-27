package com.solvd.airport.dao;

import java.util.List;

public interface DAO <T> {

    T getByID(Long id);

    List<T> getAll();

    T save(T t);

    void delete(Long id);

    void update(T t);


}
