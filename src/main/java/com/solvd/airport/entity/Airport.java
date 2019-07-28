package com.solvd.airport.entity;

import org.apache.log4j.Logger;

import java.util.List;

public class Airport {

    private static final Logger logEntity = Logger.getLogger(Airport.class);

    private Long id;
    private String nameAirport;
    private List <AirportClass> airportClass;
    private List <Country> country;

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

    public String getNameAirport() {
        return nameAirport;
    }

    public void setNameAirport(String nameAirport) {

        try {
            if (nameAirport == null) {
                logEntity.error("Value nameAirport NULL error = " + nameAirport);
                throw new EntityException("Value nameAirport NULL error = " + nameAirport);
            } else if (nameAirport != null) {
                this.nameAirport = nameAirport;
            }
        } catch (EntityException e) {
            logEntity.error("Value nameAirport NULL error = " + nameAirport);
        }
    }

    public List <AirportClass> getAirportClass() {
        return airportClass;
    }

    public void setAirportClass(List <AirportClass> airportClass) {
        this.airportClass = airportClass;
    }

    public List <Country> getCountry() {
        return country;
    }

    public void setCountry(List <Country> country) {
        this.country = country;
    }
}
