package com.solvd.airport.entity;

import org.apache.log4j.Logger;

public class Airplane {

    private static final Logger logEntity = Logger.getLogger(Airplane.class);

    private Long id;
    private String type;
    private Long numberSeets;
    private Long rangeFlight;
    private Long carryingCapacity;
    private Long team;

    public void setId(long id) {

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

    public Long getId() {
        return id;
    }

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

    public void setNumberSeets(Long numberSeets) {

        try {
            if (numberSeets <= 0) {
                logEntity.error("Value numberSeets error = " + numberSeets);
                throw new EntityException("Value numberSeets error = " + numberSeets);
            } else if (numberSeets >= 1) {
                this.numberSeets = numberSeets;
            }
        } catch (EntityException e) {
            logEntity.error("Value numberSeets error = " + numberSeets);
        }
    }

    public Long getNumberSeets() {
        return numberSeets;
    }

    public void setRangeFlight(Long rangeFlight) {

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

    public Long getRangeFlight() {
        return rangeFlight;
    }

    public void setCarryingCapacity(Long carryingCapacity) {

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

    public Long getCarryingCapacity() {
        return carryingCapacity;
    }

    public void setTeam(Long team) {

        this.team = team;
    }

    public Long getTeam() {
        return team;
    }

}
