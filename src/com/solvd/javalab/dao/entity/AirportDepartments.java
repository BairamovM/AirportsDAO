package com.solvd.javalab.dao.entity;

import org.apache.log4j.Logger;

public class AirportDepartments {

    private static final Logger logEntity = Logger.getLogger(AirportDepartments.class);

    private Long id;
    private String nameDepartment;
    private Long Airports_id;

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

    public Long getAirports_id() {
        return Airports_id;
    }

    public void setAirports_id(Long airports_id) {

        try {
            if (airports_id <= 0) {
                logEntity.error("Value airports_id error = " + airports_id);
                throw new EntityException("Value airports_id error = " + airports_id);
            } else if (airports_id >= 1) {
                this.Airports_id = airports_id;
            }
        } catch (EntityException e) {
            logEntity.error("Value airports_id error = " + airports_id);
        }
    }
}
