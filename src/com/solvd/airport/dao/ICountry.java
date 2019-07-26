package com.solvd.airport.dao;

import com.solvd.airport.entity.Country;
import java.util.List;

public interface ICountry extends DAO <Country> {

    Country getByID(Long id);

    List<Country> getAll();

    void save(Country value);

    void delete(Long id);

    void update(Country value);

}
