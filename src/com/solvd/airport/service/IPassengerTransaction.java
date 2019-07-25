package com.solvd.airport.service;

import com.solvd.airport.entity.Passengers;
import com.solvd.airport.entity.SeatsFlight;

public interface IPassengerTransaction {

    void bookPlace(Passengers value1, SeatsFlight value2);

}
