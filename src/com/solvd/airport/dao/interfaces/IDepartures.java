package com.solvd.airport.dao.interfaces;

import com.solvd.airport.dao.entity.Departures;
import java.util.List;

public interface IDepartures {

    Departures getByID(Long id);

    List<Departures> getAll();

    void save(Departures value);

    void delete(Long id);

    void update(Departures value);

}
