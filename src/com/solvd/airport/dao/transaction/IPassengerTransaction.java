package com.solvd.airport.dao.transaction;

import com.solvd.airport.dao.entity.Passengers;
import com.solvd.airport.dao.entity.SeatsFlight;

public interface IPassengerTransaction {

    void bookPlace(Passengers value1, SeatsFlight value2);

}
