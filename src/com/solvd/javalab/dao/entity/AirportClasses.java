package com.solvd.javalab.dao.entity;

import org.apache.log4j.Logger;

public class AirportClasses {

    private static final Logger logEntity = Logger.getLogger(AirportClasses.class);

    private Long id;
    private Long classType;

    public void setId (Long id) {

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

    public Long getId () {
        return id;
    }

    public void setClassType (Long classType) {

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

    public Long getClassType () {
        return classType;
    }
}
