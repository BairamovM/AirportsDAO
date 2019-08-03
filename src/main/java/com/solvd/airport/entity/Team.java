package com.solvd.airport.entity;

import org.apache.log4j.Logger;

import java.util.List;

public class Team {

    private static final Logger logEntity = Logger.getLogger(Team.class);

    private Long id;
    private Long chiefPilot;
    private Long secondPilot;
    private Long stewardesse;

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

    public Long getChiefPilot() {
        return chiefPilot;
    }

    public void setChiefPilot(Long chiefPilot) {
                this.chiefPilot = chiefPilot;
    }

    public Long getSecondPilot() {
        return secondPilot;
    }

    public void setSecondPilot(Long secondPilot) {
                this.secondPilot = secondPilot;
    }

    public Long getStewardesse() {
        return stewardesse;
    }

    public void setStewardesse(Long stewardesse) {
                this.stewardesse = stewardesse;
    }
}
