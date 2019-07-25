package com.solvd.airport.dao.interfaces;

import com.solvd.airport.dao.entity.AirportEmployees;
import java.util.List;

public interface IAirportEmployees {

    AirportEmployees getByID(Long id);

    List<AirportEmployees> getAll();

    void save(AirportEmployees value);

    void delete(Long id);

    void update(AirportEmployees value);

}
