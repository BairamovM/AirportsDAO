package com.solvd.airport.dao;

import com.solvd.airport.entity.Nationality;
import java.util.List;

public interface INationality extends DAO <Nationality> {

    Nationality getByID(Long id);

    Nationality getAll();

    Nationality save(Nationality value);

    void delete(Long id);

    void update(Nationality value);

}
