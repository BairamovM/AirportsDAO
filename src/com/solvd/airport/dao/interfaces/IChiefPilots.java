package com.solvd.airport.dao.interfaces;

import com.solvd.airport.dao.entity.ChiefPilots;
import java.util.List;

public interface IChiefPilots {

    ChiefPilots getByID(Long id);

    List<ChiefPilots> getAll();

    void save(ChiefPilots value);

    void delete(Long id);

    void update(ChiefPilots value);

}
