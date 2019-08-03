package com.solvd.airport.entity.service_relationship;

import com.solvd.airport.entity.Airport;
import org.apache.log4j.Logger;

public class AllFlightService {

    private static final Logger logEntity = Logger.getLogger(AllFlightService.class);

    private Long id;
    private Double numberFlight;
    private Airport idDepartureAirport;
    private Airport idAirportArrival;
    private Long flightTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getNumberFlight() {
        return numberFlight;
    }

    public void setNumberFlight(Double numberFlight) {
        this.numberFlight = numberFlight;
    }

    public Airport getIdDepartureAirport() {
        return idDepartureAirport;
    }

    public void setIdDepartureAirport(Airport idDepartureAirport) {
        this.idDepartureAirport = idDepartureAirport;
    }

    public Airport getIdAirportArrival() {
        return idAirportArrival;
    }

    public void setIdAirportArrival(Airport idAirportArrival) {
        this.idAirportArrival = idAirportArrival;
    }

    public Long getFlightTime() {
        return flightTime;
    }

    public void setFlightTime(Long flightTime) {
        this.flightTime = flightTime;
    }
}
