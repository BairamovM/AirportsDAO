package com.solvd.airport.entity;

import org.apache.log4j.Logger;

public class AllFlight {

    private static final Logger logEntity = Logger.getLogger(AllFlight.class);

    private Long id;
    private Double numberFlight;
    private Airport idDepartureAirport;
    private Airport idAirportArrival;
    private Long flightTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {

        try {
            if (id <= 0) {
                logEntity.error("Value id error = " + id);
                throw new EntityException("Value id error = " + id);
            } else if (id >= 1) {
                this.id = id;
            }
        } catch (EntityException e) {
            logEntity.error("Value id error = " + id);
        }
    }

    public Double getNumberFlight() {
        return numberFlight;
    }

    public void setNumberFlight(Double numberFlight) {

        try {
            if (numberFlight <= 0) {
                logEntity.error("Value numberFlight error = " + numberFlight);
                throw new EntityException("Value numberFlight error = " + numberFlight);
            } else if (numberFlight >= 1) {
                this.numberFlight = numberFlight;
            }
        } catch (EntityException e) {
            logEntity.error("Value numberFlight error = " + numberFlight);
        }
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

        try {
            if (flightTime <= 0) {
                logEntity.error("Value flightTime error = " + flightTime);
                throw new EntityException("Value flightTime error = " + flightTime);
            } else if (flightTime >= 1) {
                this.flightTime = flightTime;
            }
        } catch (EntityException e) {
            logEntity.error("Value flightTime error = " + flightTime);
        }
    }
}
