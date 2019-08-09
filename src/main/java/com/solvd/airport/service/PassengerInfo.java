package com.solvd.airport.service;

import com.solvd.airport.entity.Passenger;


import com.solvd.airport.dao.ILuggage;
import com.solvd.airport.dao.ISeatFlight;
import com.solvd.airport.dao.INationality;
import com.solvd.airport.dao.IPassenger;
import com.solvd.airport.dao.jdbc.LuggageDAO;
import com.solvd.airport.dao.jdbc.SeatFlightDAO;
import com.solvd.airport.dao.jdbc.NationalityDAO;
import com.solvd.airport.dao.jdbc.PassengerDAO;

public class PassengerInfo {

    private ILuggage luggageDAO = new LuggageDAO();
    private ISeatFlight seatFlightDAO = new SeatFlightDAO();
    private INationality nationalityDAO = new NationalityDAO();
    private IPassenger passengerDAO = new PassengerDAO();

    public Passenger addPassenger (Passenger passengerService, Long passengerId) {

        passengerService.setNationality(nationalityDAO.getByID(passengerId));
        return passengerDAO.save(passengerService);
    }

    public Passenger getPassenger (Long id) {

        Passenger passenger = passengerDAO.getByID(id);
        //passenger.setLuggageServiceList(luggageDAO.getAllId(id));
        //passenger.setSeatFlightService(seatFlightDAO.getByID(id));

        return passenger;
    }

}
