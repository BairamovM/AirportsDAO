package com.solvd.airport.service;

import com.solvd.airport.dao.INationality;
import com.solvd.airport.dao.IPassenger;
import com.solvd.airport.dao.jdbc.NationalityDAO;
import com.solvd.airport.dao.jdbc.PassengerDAO;
import com.solvd.airport.entity.Passenger;

public class PassengerService {

    private IPassenger passengerDAO = new PassengerDAO();
    private INationality nationalityDAO = new NationalityDAO();

    public Passenger getPassenger(Long id) {

        Passenger passenger = new Passenger();
        passenger = passengerDAO.getByID(id);
        passenger.setNationality(nationalityDAO.getByID(passenger.getNationality().getId()));

        return passenger;
    }

    public Passenger save(Passenger passenger) {
        return passengerDAO.save(passenger);
    }

    public void rewritePassengerData(Passenger passenger) {
        passengerDAO.update(passenger);
    }
}
