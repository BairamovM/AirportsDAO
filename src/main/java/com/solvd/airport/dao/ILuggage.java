package com.solvd.airport.dao;

import com.solvd.airport.entity.service_relationship.Luggage;
import java.util.List;

public interface ILuggage extends DAO <Luggage> {

    Luggage getByID(Long id);

    Luggage getAll();

    List <Luggage> getAllId(Long id);

    Luggage save(Luggage value);

    void delete(Long id);

    void update(Luggage value);

}
