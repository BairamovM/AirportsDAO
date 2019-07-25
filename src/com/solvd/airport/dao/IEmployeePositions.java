package com.solvd.airport.dao;

import com.solvd.airport.entity.EmployeePositions;
import java.util.List;

public interface IEmployeePositions {

    EmployeePositions getByID(Long id);

    List<EmployeePositions> getAll();

    void save(EmployeePositions value);

    void delete(Long id);

    void update(EmployeePositions value);

}
