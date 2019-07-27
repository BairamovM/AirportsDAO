package com.solvd.airport.dao;

import com.solvd.airport.entity.EmployeePosition;
import java.util.List;

public interface IEmployeePosition extends DAO <EmployeePosition> {

    EmployeePosition getByID(Long id);

    List<EmployeePosition> getAll();

    EmployeePosition save(EmployeePosition value);

    void delete(Long id);

    void update(EmployeePosition value);

}
