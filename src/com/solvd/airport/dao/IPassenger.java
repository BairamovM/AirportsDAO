package com.solvd.airport.dao;

import com.solvd.airport.entity.Passenger;
import java.util.List;

public interface IPassenger extends DAO <Passenger> {

    Passenger getByID(Long id);

    List<Passenger> getAll();

    void save(Passenger value);

    void delete(Long id);

    void update(Passenger value);

}
