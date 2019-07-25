package com.solvd.airport.dao;

import com.solvd.airport.entity.City;
import java.util.List;

public interface ICity {

    City getByID(Long id);

    List<City> getAll();

    void save(City value);

    void delete(Long id);

    void update(City value);

}
