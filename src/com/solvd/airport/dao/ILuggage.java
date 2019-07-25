package com.solvd.airport.dao;

import com.solvd.airport.entity.Luggage;
import java.util.List;

public interface ILuggage {

    Luggage getByID(Long id);

    List<Luggage> getAll();

    void save(Luggage value);

    void delete(Long id);

    void update(Luggage value);

}
