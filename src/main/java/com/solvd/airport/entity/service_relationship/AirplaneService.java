package com.solvd.airport.entity.service_relationship;

import com.solvd.airport.entity.Departure;
import com.solvd.airport.entity.SeatFlight;
import com.solvd.airport.entity.Team;
import org.apache.log4j.Logger;

import java.util.List;

public class AirplaneService {

    private static final Logger logEntity = Logger.getLogger(AirplaneService.class);

    private Long id;
    private String type;
    private Long numberSeets;
    private Long rangeFlight;
    private Long carryingCapacity;
    private Team team;

    private List <SeatFlight> seatFlightList;
    private Departure departure;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getNumberSeets() {
        return numberSeets;
    }

    public void setNumberSeets(Long numberSeets) {
        this.numberSeets = numberSeets;
    }

    public Long getRangeFlight() {
        return rangeFlight;
    }

    public void setRangeFlight(Long rangeFlight) {
        this.rangeFlight = rangeFlight;
    }

    public Long getCarryingCapacity() {
        return carryingCapacity;
    }

    public void setCarryingCapacity(Long carryingCapacity) {
        this.carryingCapacity = carryingCapacity;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public List<SeatFlight> getSeatFlightList() {
        return seatFlightList;
    }

    public void setSeatFlightList(List<SeatFlight> seatFlightList) {
        this.seatFlightList = seatFlightList;
    }

    public Departure getDeparture() {
        return departure;
    }

    public void setDeparture(Departure departure) {
        this.departure = departure;
    }
}
