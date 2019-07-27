package com.solvd.airport.dao;

import com.solvd.airport.entity.Team;
import java.util.List;

public interface ITeam extends DAO <Team> {

    Team getByID(Long id);

    List<Team> getAll();

    Team save(Team value);

    void delete(Long id);

    void update(Team value);

}
