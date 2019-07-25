package com.solvd.airport.entity;

import org.apache.log4j.Logger;

public class Cities {

    private static final Logger logEntity = Logger.getLogger(Cities.class);

    private Long id;
    private String nameCity;
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
