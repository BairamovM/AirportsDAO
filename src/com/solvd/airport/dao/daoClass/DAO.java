package com.solvd.airport.dao.daoClass;

import java.util.List;

public interface DAO <T> {

    T getByID(Long id);

    List<T> getAll();

    void save(T t);

    void delete(Long id);

    void update(T t);


}
