package com.solvd.airport.entity;

import org.apache.log4j.Logger;

public class Departure {

    private static final Logger logEntity = Logger.getLogger(Departure.class);

    private Long id;
    private String departureDate;
    private Long airplane;
    private Long allFlight;

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

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {

        try {
            if (departureDate == null) {
                logEntity.error("Value departureDate NULL error = " + departureDate);
                throw new EntityException("Value departureDate NULL error = " + departureDate);
            } else if (departureDate != null) {
                this.departureDate = departureDate;
            }
        } catch (EntityException e) {
            logEntity.error("Value nameCountry NULL error = " + departureDate);
        }
    }

    public Long getAirplane() {
        return airplane;
    }

    public void setAirplane(Long airplane) {
        this.airplane = airplane;
    }

    public Long getAllFlight() {
        return allFlight;
    }

    public void setAllFlight(Long allFlight) {
        this.allFlight = allFlight;
    }
}
