package com.solvd.airport.dao;

import com.solvd.airport.entity.Teams;
import java.util.List;

public interface ITeams {

    Teams getByID(Long id);

    List<Teams> getAll();

    void save(Teams value);

    void delete(Long id);

    void update(Teams value);

}
