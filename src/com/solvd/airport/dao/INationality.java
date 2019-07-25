package com.solvd.airport.dao;

import com.solvd.airport.entity.Nationality;
import java.util.List;

public interface INationality {

    Nationality getByID(Long id);

    List<Nationality> getAll();

    void save(Nationality value);

    void delete(Long id);

    void update(Nationality value);

}
