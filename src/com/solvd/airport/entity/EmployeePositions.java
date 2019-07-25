package com.solvd.airport.entity;

import org.apache.log4j.Logger;

public class EmployeePositions {

    private static final Logger logEntity = Logger.getLogger(EmployeePositions.class);

    private Long id;
    private String namePosition;

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

    public String getNamePosition() {
        return namePosition;
    }

    public void setNamePosition(String namePosition) {

        try {
            if (namePosition == null) {
                logEntity.error("Value namePosition NULL error = " + namePosition);
                throw new EntityException("Value namePosition NULL error = " + namePosition);
            } else if (namePosition != null) {
                this.namePosition = namePosition;
            }
        } catch (EntityException e) {
            logEntity.error("Value namePosition NULL error = " + namePosition);
        }
    }
}
