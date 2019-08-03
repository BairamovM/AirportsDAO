package com.solvd.airport.entity.service_relationship;

import com.solvd.airport.entity.Luggage;
import com.solvd.airport.entity.Nationality;
import com.solvd.airport.entity.SeatFlight;
import org.apache.log4j.Logger;

import java.util.List;

public class PassengerService {

    private static final Logger logEntity = Logger.getLogger(PassengerService.class);

    private Long id;
    private String firstName;
    private String lastName;
    private String dateBirth;
    private String gender;
    private Double passportSerialNumber;
    private Nationality nationality;

    private List <Luggage> luggageList;
    private SeatFlight seatFlightList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(String dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Double getPassportSerialNumber() {
        return passportSerialNumber;
    }

    public void setPassportSerialNumber(Double passportSerialNumber) {
        this.passportSerialNumber = passportSerialNumber;
    }

    public Nationality getNationality() {
        return nationality;
    }

    public void setNationality(Nationality nationality) {
        this.nationality = nationality;
    }

    public List<Luggage> getLuggageList() {
        return luggageList;
    }

    public void setLuggageList(List<Luggage> luggageList) {
        this.luggageList = luggageList;
    }

    public SeatFlight getSeatFlightList() {
        return seatFlightList;
    }

    public void setSeatFlightList(SeatFlight seatFlightList) {
        this.seatFlightList = seatFlightList;
    }
}
