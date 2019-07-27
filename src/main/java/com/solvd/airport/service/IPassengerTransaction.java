package com.solvd.airport.service;

import com.solvd.airport.entity.Passenger;
import com.solvd.airport.entity.SeatFlight;

public interface IPassengerTransaction {

    void bookPlace(Passenger value1, SeatFlight value2);

}
