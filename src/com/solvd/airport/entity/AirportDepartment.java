package com.solvd.airport.entity;

import org.apache.log4j.Logger;

public class AirportDepartment {

    private static final Logger logEntity = Logger.getLogger(AirportDepartment.class);

    private Long id;
    private String nameDepartment;
    private Airport airport;

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

    public String getNameDepartment() {
        return nameDepartment;
    }

    public void setNameDepartment(String nameDepartment) {

        try {
            if (nameDepartment == null) {
                logEntity.error("Value nameDepartment NULL error = " + nameDepartment);
                throw new EntityException("Value nameDepartment NULL error = " + nameDepartment);
            } else if (nameDepartment != null) {
                this.nameDepartment = nameDepartment;
            }
        } catch (EntityException e) {
            logEntity.error("Value type NULL error = " + nameDepartment);
        }
    }

    public Airport getAirport() {
        return airport;
    }

    public void setAirport(Airport airport) {
        this.airport = airport;
    }
}
