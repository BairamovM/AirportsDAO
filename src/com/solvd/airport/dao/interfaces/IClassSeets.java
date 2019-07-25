package com.solvd.airport.dao.interfaces;

import com.solvd.airport.dao.entity.ClassSeets;
import java.util.List;

public interface IClassSeets {

    ClassSeets getByID(Long id);

    List<ClassSeets> getAll();

    void save(ClassSeets value);

    void delete(Long id);

    void update(ClassSeets value);

}
