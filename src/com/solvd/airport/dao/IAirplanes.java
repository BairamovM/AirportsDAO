package com.solvd.airport.dao;

import com.solvd.airport.entity.Airplanes;
import java.util.List;

public interface IAirplanes {

    Airplanes getByID(Long id);

    List<Airplanes> getAll();

    void save(Airplanes value);

    void delete(Long id);

    void update(Airplanes value);

}
