package com.solvd.airport.entity;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.apache.log4j.Logger;

@XmlRootElement (name = "Airplane")
public class Airplane {

    private static final Logger logEntity = Logger.getLogger(Airplane.class);

    private Integer id;
    private String type;
    private Integer numberSeets;
    private Integer rangeFlight;
    private Integer carryingCapacity;
    private Team team;

    @XmlAttribute
    public void setId(Integer id) {
       this.id = id;
    }

    public Integer getId() {
        return id;
    }


    @XmlElement
    public void setType(String type) {

        try {
            if (type == null) {
                logEntity.error("Value type NULL error = " + type);
                throw new EntityException("Value type NULL error = " + type);
            } else if (type != null) {
                this.type = type;
            }
        } catch (EntityException e) {
            logEntity.error("Value type NULL error = " + type);
        }
    }

    public String getType() {
        return type;
    }

    @XmlElement
    public void setNumberSeets(Integer numberSeets) {


                this.numberSeets = numberSeets;

    }

    public Integer getNumberSeets() {
        return numberSeets;
    }

    @XmlElement
    public void setRangeFlight(Integer rangeFlight) {

        try {
            if (rangeFlight <= 0) {
                logEntity.error("Value rangeFlight error = " + rangeFlight);
                throw new EntityException("Value rangeFlight error = " + rangeFlight);
            } else if (rangeFlight >= 1) {
                this.rangeFlight = rangeFlight;
            }
        } catch (EntityException e) {
            logEntity.error("Value rangeFlight error = " + rangeFlight);
        }
    }

    public Integer getRangeFlight() {
        return rangeFlight;
    }

    @XmlElement
    public void setCarryingCapacity(Integer carryingCapacity) {

        try {
            if (carryingCapacity <= 0) {
                logEntity.error("Value carryingCapacity error = " + carryingCapacity);
                throw new EntityException("Value carryingCapacity error = " + carryingCapacity);
            } else if (carryingCapacity >= 1) {
                this.carryingCapacity = carryingCapacity;
            }
        } catch (EntityException e) {
            logEntity.error("Value carryingCapacity error = " + carryingCapacity);
        }
    }

    public Integer getCarryingCapacity() {
        return carryingCapacity;
    }

    @XmlElement
    public void setTeam(Team team) {

        this.team = team;
    }

    public Team getTeam() {
        return team;
    }


}
