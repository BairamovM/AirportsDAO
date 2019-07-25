package com.solvd.airport.dao;

import com.solvd.airport.entity.EmployeeSalary;
import java.util.List;

public interface IEmployeeSalary {

    EmployeeSalary getByID(Long id);

    List<EmployeeSalary> getAll();

    void save(EmployeeSalary value);

    void delete(Long id);

    void update(EmployeeSalary value);

}
