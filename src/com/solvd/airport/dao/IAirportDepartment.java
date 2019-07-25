package com.solvd.airport.dao;

import com.solvd.airport.entity.AirportDepartment;
import java.util.List;

public interface IAirportDepartment {

    AirportDepartment getByID(Long id);

    List<AirportDepartment> getAll();

    void save(AirportDepartment value);

    void delete(Long id);

    void update(AirportDepartment value);

}
