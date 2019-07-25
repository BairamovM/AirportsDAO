package com.solvd.airport.entity;

import org.apache.log4j.Logger;

public class Team {

    private static final Logger logEntity = Logger.getLogger(Team.class);

    private Long id;
    private ChiefPilot chiefPilot;
    private SecondPilot secondPilot;
    private Stewardesse stewardesse;

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

    public ChiefPilot getChiefPilot() {
        return chiefPilot;
    }

    public void setChiefPilot(ChiefPilot chiefPilot) {
                this.chiefPilot = chiefPilot;
    }

    public SecondPilot getSecondPilot() {
        return secondPilot;
    }

    public void setSecondPilot(SecondPilot secondPilot) {
                this.secondPilot = secondPilot;
    }

    public Stewardesse getStewardesse() {
        return stewardesse;
    }

    public void setStewardesse(Stewardesse stewardesse) {
                this.stewardesse = stewardesse;
    }
}
