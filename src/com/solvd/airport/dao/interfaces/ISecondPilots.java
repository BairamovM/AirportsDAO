package com.solvd.airport.dao.interfaces;

import com.solvd.airport.dao.entity.SecondPilots;
import java.util.List;

public interface ISecondPilots {

    SecondPilots getByID(Long id);

    List<SecondPilots> getAll();

    void save(SecondPilots value);

    void delete(Long id);

    void update(SecondPilots value);

}
