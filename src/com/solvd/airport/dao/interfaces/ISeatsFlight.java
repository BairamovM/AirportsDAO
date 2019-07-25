package com.solvd.airport.dao.interfaces;

import com.solvd.airport.dao.entity.SeatsFlight;
import java.util.List;

public interface ISeatsFlight {

    SeatsFlight getByID(Long id);

    List<SeatsFlight> getAll();

    void save(SeatsFlight value);

    void delete(Long id);

    void update(SeatsFlight value);

}
