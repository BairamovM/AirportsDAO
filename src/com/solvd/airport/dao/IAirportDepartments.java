package com.solvd.airport.dao;

import com.solvd.airport.entity.AirportDepartments;
import java.util.List;

public interface IAirportDepartments {

    AirportDepartments getByID(Long id);

    List<AirportDepartments> getAll();

    void save(AirportDepartments value);

    void delete(Long id);

    void update(AirportDepartments value);

}
