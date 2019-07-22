package com.solvd.javalab.dao.entity;

import org.apache.log4j.Logger;

public class Countries {

    private static final Logger logEntity = Logger.getLogger(Countries.class);

    private Long id;
    private String nameCountry;

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

    public String getNameCountry() {
        return nameCountry;
    }

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
}
