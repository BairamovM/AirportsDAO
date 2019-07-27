package com.solvd.airport.dao;

import com.solvd.airport.entity.City;
import java.util.List;

public interface ICity extends DAO <City> {

    City getByID(Long id);

    List<City> getAll();

    City save(City value);

    void delete(Long id);

    void update(City value);

}
