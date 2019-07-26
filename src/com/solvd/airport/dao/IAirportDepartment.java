package com.solvd.airport.dao;

import com.solvd.airport.entity.AirportDepartment;
import java.util.List;

public interface IAirportDepartment extends DAO <AirportDepartment> {

    AirportDepartment getByID(Long id);

    List<AirportDepartment> getAll();

    AirportDepartment save(AirportDepartment value);

    void delete(Long id);

    void update(AirportDepartment value);

}
