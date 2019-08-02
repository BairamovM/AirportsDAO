package com.solvd.airport.dao;

import com.solvd.airport.entity.AllFlight;
import java.util.List;

public interface IAllFlight extends DAO <AllFlight> {

    AllFlight getByID(Long id);

    AllFlight getAll();

    AllFlight save(AllFlight value);

    void delete(Long id);

    void update(AllFlight value);

}
