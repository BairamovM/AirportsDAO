package com.solvd.airport.dao.entity;

import org.apache.log4j.Logger;

public class AllFlights {

    private static final Logger logEntity = Logger.getLogger(AllFlights.class);

    private Long id;
    private Double numberFlight;
    private Long idDepartureAirport;
    private Long idAirportArrival;
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

    public Long getIdDepartureAirport() {
        return idDepartureAirport;
    }

    public void setIdDepartureAirport(Long idDepartureAirport) {

        try {
            if (idDepartureAirport <= 0) {
                logEntity.error("Value idDepartureAirport error = " + idDepartureAirport);
                throw new EntityException("Value idDepartureAirport error = " + idDepartureAirport);
            } else if (idDepartureAirport >= 1) {
                this.idDepartureAirport = idDepartureAirport;
            }
        } catch (EntityException e) {
            logEntity.error("Value idDepartureAirport error = " + idDepartureAirport);
        }
    }

    public Long getIdAirportArrival() {
        return idAirportArrival;
    }

    public void setIdAirportArrival(Long idAirportArrival) {

        try {
            if (idAirportArrival <= 0) {
                logEntity.error("Value idAirportArrival error = " + idAirportArrival);
                throw new EntityException("Value idAirportArrival error = " + idAirportArrival);
            } else if (idAirportArrival >= 1) {
                this.idAirportArrival = idAirportArrival;
            }
        } catch (EntityException e) {
            logEntity.error("Value idAirportArrival error = " + idAirportArrival);
        }
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
