package com.solvd.airport.dao;

import java.util.List;

public interface DAO <T> {

    T getByID(Long id);

    List<T> getAll();

    List <T> save(List <T> t);

    void delete(Long id);

    void update(T t);


}
