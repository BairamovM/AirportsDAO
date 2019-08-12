package com.solvd.airport.entity;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import org.apache.log4j.Logger;

public class Country {

    private static final Logger logEntity = Logger.getLogger(Country.class);

    private Integer id;
    private String nameCountry;

    @JsonGetter ("id")
    public Integer getId() {
        return id;
    }

    @JsonSetter ("id")
    public void setId(Integer id) {

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

    @JsonGetter ("nameCountry")
    public String getNameCountry() {
        return nameCountry;
    }

    @JsonSetter ("nameCountry")
    public void setNameCountry(String nameCountry) {

        try {
            if (nameCountry == null) {
                logEntity.error("Value nameCountry NULL error = " + nameCountry);
                throw new EntityException("Value nameCountry NULL error = " + nameCountry);
            } else if (nameCountry != null) {
                this.nameCountry = nameCountry;
            }
        } catch (EntityException e) {
            logEntity.error("Value nameCountry NULL error = " + nameCountry);
        }
    }


    @Override
    public String toString() {
        return "Country { " + "\n" +
                "id = " + id + "\n" +
                "nameCountry = " + nameCountry + '\'' + "\n" +
                '}' +
                "\n";
    }
}
