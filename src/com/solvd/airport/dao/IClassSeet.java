package com.solvd.airport.dao;

import com.solvd.airport.entity.ClassSeet;
import java.util.List;

public interface IClassSeet {

    ClassSeet getByID(Long id);

    List<ClassSeet> getAll();

    void save(ClassSeet value);

    void delete(Long id);

    void update(ClassSeet value);

}
