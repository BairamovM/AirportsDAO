package com.solvd.airport.entity;

import org.apache.log4j.Logger;

public class ClassSeet {

    private static final Logger logEntity = Logger.getLogger(ClassSeet.class);

    private Long id;
    private String classseets;

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

    public String getClassseets() {
        return classseets;
    }

    public void setClassseets(String classseets) {

        try {
            if (classseets == null) {
                logEntity.error("Value classseets NULL error = " + classseets);
                throw new EntityException("Value classseets NULL error = " + classseets);
            } else if (classseets != null) {
                this.classseets = classseets;
            }
        } catch (EntityException e) {
            logEntity.error("Value classseets NULL error = " + classseets);
        }
    }
}
