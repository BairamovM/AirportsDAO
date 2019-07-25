package com.solvd.airport.dao;

import com.solvd.airport.entity.ChiefPilots;
import java.util.List;

public interface IChiefPilots {

    ChiefPilots getByID(Long id);

    List<ChiefPilots> getAll();

    void save(ChiefPilots value);

    void delete(Long id);

    void update(ChiefPilots value);

}
