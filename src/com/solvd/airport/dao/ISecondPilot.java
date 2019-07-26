package com.solvd.airport.dao;

import com.solvd.airport.entity.SecondPilot;
import java.util.List;

public interface ISecondPilot extends DAO <SecondPilot> {

    SecondPilot getByID(Long id);

    List<SecondPilot> getAll();

    SecondPilot save(SecondPilot value);

    void delete(Long id);

    void update(SecondPilot value);

}
