package com.solvd.airport.dao;

import com.solvd.airport.entity.Luggage;
import java.util.List;

public interface ILuggage extends DAO <Luggage> {

    Luggage getByID(Long id);

    Luggage getAll();

    Luggage save(Luggage value);

    void delete(Long id);

    void update(Luggage value);

}
