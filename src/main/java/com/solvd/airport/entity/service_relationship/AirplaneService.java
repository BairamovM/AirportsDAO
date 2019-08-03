package com.solvd.airport.entity.service_relationship;

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
    private TeamService teamService;

    private List <SeatFlight> seatFlightServiceList;
    private DepartureService departureService;

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

    public TeamService getTeamService() {
        return teamService;
    }

    public void setTeamService(TeamService teamService) {
        this.teamService = teamService;
    }

    public List<SeatFlight> getSeatFlightServiceList() {
        return seatFlightServiceList;
    }

    public void setSeatFlightServiceList(List<SeatFlight> seatFlightServiceList) {
        this.seatFlightServiceList = seatFlightServiceList;
    }

    public DepartureService getDepartureService() {
        return departureService;
    }

    public void setDepartureService(DepartureService departureService) {
        this.departureService = departureService;
    }
}
