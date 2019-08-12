package com.solvd.airport.entity;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import org.apache.log4j.Logger;

public class AirportClass {

    private static final Logger logEntity = Logger.getLogger(AirportClass.class);

    private Integer id;
    private Integer classType;

    @JsonSetter ("id")
    public void setId (Integer id) {

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

    @JsonGetter ("id")
    public Integer getId () {
        return id;
    }

    @JsonSetter ("classType")
    public void setClassType (Integer classType) {

        try {
            if (classType <= 0) {
                logEntity.error("Value classType error = " + classType);
                throw new EntityException("Value classType error = " + classType);
            } else if (classType >= 1 & classType <= 5) {
                this.classType = classType;
            }
        } catch (EntityException e) {
            logEntity.error("Value classType error = " + classType);
        }
    }

    @JsonGetter ("classType")
    public Integer getClassType () {
        return classType;
    }


    @Override
    public String toString() {
        return "AirportClass { " + "\n" +
                "id = " + id + "\n" +
                "classType = " + classType + "\n" +
                '}' +
                "\n";
    }
}
