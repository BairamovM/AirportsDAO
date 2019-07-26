package com.solvd.airport.service;


import com.solvd.airport.dao.*;
import com.solvd.airport.dao.jdbc.*;
import com.solvd.airport.entity.SeatFlight;

public class SeatsFlightServise {

    private IPassenger passengerDAO = new PassengerDAO();
    private IAirplane numberSeetDAO = new AirplaneDAO();
    private IAirplane airplaneDAO = new AirplaneDAO();
    private IClassSeet classSeetDAO = new ClassSeetDAO();
    private ISeatFlight seatFlightDAO = new SeatFlightDAO();

    public SeatFlight seeInfoPassengerFlight (Long id) {

        SeatFlight seatFlight = new SeatFlight();
        seatFlight = seatFlightDAO.getByID(id);
        seatFlight.setAirplane(airplaneDAO.getByID(seatFlight.getId()));
        seatFlight.setPassenger(passengerDAO.getByID(seatFlight.getId()));
        seatFlight.setClassSeet(classSeetDAO.getByID(seatFlight.getId()));
        seatFlight.setAirplane(numberSeetDAO.getByID(seatFlight.getId()));

        return seatFlight;

    }

    public SeatFlight bookPlaceForPassenger (SeatFlight seatFlight) {

        return seatFlightDAO.save(seatFlight);

    }

    public void removePassengerFromList (Long id) {

        seatFlightDAO.delete(id);
    }

}
