package com.solvd.airport.dao;

import com.solvd.airport.entity.EmployeeSalaries;
import java.util.List;

public interface IEmployeeSalaries {

    EmployeeSalaries getByID(Long id);

    List<EmployeeSalaries> getAll();

    void save(EmployeeSalaries value);

    void delete(Long id);

    void update(EmployeeSalaries value);

}
