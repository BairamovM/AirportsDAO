package com.solvd.airport.dao;

import com.solvd.airport.entity.service_relationship.Passenger;
import java.util.List;

public interface IPassenger extends DAO <Passenger> {

    Passenger getByID(Long id);

    Passenger getAll();

    Passenger save(Passenger value);

    void delete(Long id);

    void update(Passenger value);

}
