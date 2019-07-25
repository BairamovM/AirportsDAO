package com.solvd.airport.dao;

import com.solvd.airport.entity.Nationalities;
import java.util.List;

public interface INationalities {

    Nationalities getByID(Long id);

    List<Nationalities> getAll();

    void save(Nationalities value);

    void delete(Long id);

    void update(Nationalities value);

}
