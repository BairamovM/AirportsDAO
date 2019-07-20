package com.solvd.javalab.dao.daoClasses;

import java.util.List;

public interface DAO <T> {

    T get(Long id);

    List<T> getAll();

    void save(T t);

    void delete(Long id);

    void update(T t);


}
