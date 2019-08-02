package com.solvd.airport.dao;

import com.solvd.airport.entity.ChiefPilot;
import java.util.List;

public interface IChiefPilot extends DAO <ChiefPilot> {

    ChiefPilot getByID(Long id);

    ChiefPilot getAll();

    ChiefPilot save(ChiefPilot value);

    void delete(Long id);

    void update(ChiefPilot value);

}
