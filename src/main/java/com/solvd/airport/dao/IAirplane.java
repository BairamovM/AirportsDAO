package com.solvd.airport.dao;

import com.solvd.airport.entity.Airplane;
import java.util.List;

public interface IAirplane extends DAO <Airplane>{

    Airplane getByID(Long id);

    Airplane getAll();

    Airplane save(Airplane value);

    void delete(Long id);

    void update(Airplane value);

}
