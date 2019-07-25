package com.solvd.airport.dao;

import com.solvd.airport.entity.EmployeePosition;
import java.util.List;

public interface IEmployeePosition {

    EmployeePosition getByID(Long id);

    List<EmployeePosition> getAll();

    void save(EmployeePosition value);

    void delete(Long id);

    void update(EmployeePosition value);

}
