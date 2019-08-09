package com.solvd.airport.dao;

import com.solvd.airport.entity.SeatFlight;
import java.util.List;

public interface ISeatFlight extends DAO <SeatFlight> {

    SeatFlight getByID(Long id);

    SeatFlight getAll();

    SeatFlight save(SeatFlight value);

    void delete(Long id);

    void update(SeatFlight value);

}
