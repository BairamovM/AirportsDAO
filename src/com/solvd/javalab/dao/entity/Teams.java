package com.solvd.javalab.dao.entity;

import org.apache.log4j.Logger;

public class Teams {

    private static final Logger logEntity = Logger.getLogger(Teams.class);

    private Long id;
    private Long ChiefPilots_id;
    private Long SecondPilots_id;
    private Long Stewardesses_id;

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

    public Long getChiefPilots_id() {
        return ChiefPilots_id;
    }

    public void setChiefPilots_id(Long chiefPilots_id) {

        try {
            if (chiefPilots_id <= 0) {
                logEntity.error("Value chiefPilots_id error = " + chiefPilots_id);
                throw new EntityException("Value chiefPilots_id error = " + chiefPilots_id);
            } else if (chiefPilots_id >= 1) {
                this.ChiefPilots_id = chiefPilots_id;
            }
        } catch (EntityException e) {
            logEntity.error("Value chiefPilots_id error = " + chiefPilots_id);
        }
    }

    public Long getSecondPilots_id() {
        return SecondPilots_id;
    }

    public void setSecondPilots_id(Long secondPilots_id) {

        try {
            if (secondPilots_id <= 0) {
                logEntity.error("Value secondPilots_id error = " + secondPilots_id);
                throw new EntityException("Value secondPilots_id error = " + secondPilots_id);
            } else if (secondPilots_id >= 1) {
                this.SecondPilots_id = secondPilots_id;
            }
        } catch (EntityException e) {
            logEntity.error("Value secondPilots_id error = " + secondPilots_id);
        }
    }

    public Long getStewardesses_id() {
        return Stewardesses_id;
    }

    public void setStewardesses_id(Long stewardesses_id) {

        try {
            if (stewardesses_id <= 0) {
                logEntity.error("Value stewardesses_id error = " + stewardesses_id);
                throw new EntityException("Value stewardesses_id error = " + stewardesses_id);
            } else if (stewardesses_id >= 1) {
                this.Stewardesses_id = stewardesses_id;
            }
        } catch (EntityException e) {
            logEntity.error("Value stewardesses_id error = " + stewardesses_id);
        }
    }
}
