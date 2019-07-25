package com.solvd.airport.dao.interfaces;

import com.solvd.airport.dao.entity.EmployeeSalaries;
import java.util.List;

public interface IEmployeeSalaries {

    EmployeeSalaries getByID(Long id);

    List<EmployeeSalaries> getAll();

    void save(EmployeeSalaries value);

    void delete(Long id);

    void update(EmployeeSalaries value);

}
