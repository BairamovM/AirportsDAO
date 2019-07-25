package com.solvd.airport.entity;

import org.apache.log4j.Logger;

public class Nationality {

    private static final Logger logEntity = Logger.getLogger(Nationality.class);

    private Long id;
    private String citizenship;

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

    public String getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(String citizenship) {

        try {
            if (citizenship == null) {
                logEntity.error("Value citizenship NULL error = " + citizenship);
                throw new EntityException("Value citizenship NULL error = " + citizenship);
            } else if (citizenship != null) {
                this.citizenship = citizenship;
            }
        } catch (EntityException e) {
            logEntity.error("Value citizenship NULL error = " + citizenship);
        }
    }
}
