package com.solvd.airport.dao;

import com.solvd.airport.entity.ClassSeets;
import java.util.List;

public interface IClassSeets {

    ClassSeets getByID(Long id);

    List<ClassSeets> getAll();

    void save(ClassSeets value);

    void delete(Long id);

    void update(ClassSeets value);

}
