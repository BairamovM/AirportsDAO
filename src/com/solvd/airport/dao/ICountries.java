package com.solvd.airport.dao;

import com.solvd.airport.entity.Countries;
import java.util.List;

public interface ICountries {

    Countries getByID(Long id);

    List<Countries> getAll();

    void save(Countries value);

    void delete(Long id);

    void update(Countries value);

}
