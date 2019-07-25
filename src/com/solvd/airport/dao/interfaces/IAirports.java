package com.solvd.airport.dao.interfaces;

import com.solvd.airport.dao.entity.Airports;
import java.util.List;

public interface IAirports {

    Airports getByID(Long id);

    List<Airports> getAll();

    void save(Airports value);

    void delete(Long id);

    void update(Airports value);

}
