package com.solvd.airport.dao;

import com.solvd.airport.entity.ChiefPilot;
import java.util.List;

public interface IChiefPilot {

    ChiefPilot getByID(Long id);

    List<ChiefPilot> getAll();

    void save(ChiefPilot value);

    void delete(Long id);

    void update(ChiefPilot value);

}
