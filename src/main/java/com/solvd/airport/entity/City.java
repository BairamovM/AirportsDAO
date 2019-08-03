package com.solvd.airport.entity;

import org.apache.log4j.Logger;

import java.util.List;

public class City {

    private static final Logger logEntity = Logger.getLogger(City.class);

    private Long id;
    private String nameCity;
    private Long country;

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

    public String getNameCity() {
        return nameCity;
    }

    public void setNameCity(String nameCity) {

        try {
            if (nameCity == null) {
                logEntity.error("Value nameCity NULL error = " + nameCity);
                throw new EntityException("Value nameCity NULL error = " + nameCity);
            } else if (nameCity != null) {
                this.nameCity = nameCity;
            }
        } catch (EntityException e) {
            logEntity.error("Value nameCity NULL error = " + nameCity);
        }
    }

    public Long getCountry() {
        return country;
    }

    public void setCountry(Long country) {
        this.country = country;
    }
}
