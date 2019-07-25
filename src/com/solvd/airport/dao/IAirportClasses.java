package com.solvd.airport.dao;

import com.solvd.airport.entity.AirportClasses;
import java.util.List;

public interface IAirportClasses {

    AirportClasses getByID(Long id);

    List<AirportClasses> getAll();

    void save(AirportClasses value);

    void delete(Long id);

    void update(AirportClasses value);

}
