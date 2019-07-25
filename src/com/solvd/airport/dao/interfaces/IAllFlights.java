package com.solvd.airport.dao.interfaces;

import com.solvd.airport.dao.entity.AllFlights;
import java.util.List;

public interface IAllFlights {

    AllFlights getByID(Long id);

    List<AllFlights> getAll();

    void save(AllFlights value);

    void delete(Long id);

    void update(AllFlights value);

}
