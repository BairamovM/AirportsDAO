package com.solvd.airport.entity;

import org.apache.log4j.Logger;

public class Airports {

    private static final Logger logEntity = Logger.getLogger(Airports.class);

    private Long id;
    private String nameAirport;
    private Long AirportClasses_id;
    private Long Countries_id;

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

    public Long getAirportClasses_id() {
        return AirportClasses_id;
    }

    public void setAirportClasses_id(Long airportClasses_id) {

        try {
            if (airportClasses_id <= 0) {
                logEntity.error("Value airportClasses_id error = " + airportClasses_id);
                throw new EntityException("Value airportClasses_id error = " + airportClasses_id);
            } else if (airportClasses_id >= 1) {
                this.AirportClasses_id = airportClasses_id;
            }
        } catch (EntityException e) {
            logEntity.error("Value airportClasses_id error = " + airportClasses_id);
        }
    }

    public Long getCountries_id() {
        return Countries_id;
    }

    public void setCountries_id(Long countries_id) {

        try {
            if (countries_id <= 0) {
                logEntity.error("Value countries_id error = " + countries_id);
                throw new EntityException("Value countries_id error = " + countries_id);
            } else if (countries_id >= 1) {
                this.Countries_id = countries_id;
            }
        } catch (EntityException e) {
            logEntity.error("Value countries_id error = " + countries_id);
        }
    }
}
