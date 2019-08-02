package com.solvd.airport.dao;

import com.solvd.airport.entity.ChiefPilot;
import java.util.List;

public interface IChiefPilot extends DAO <ChiefPilot> {

    ChiefPilot getByID(Long id);

    List<ChiefPilot> getAll();

    List<ChiefPilot> save(List<ChiefPilot> value);

    void delete(Long id);

    void update(List <ChiefPilot> value);

}
