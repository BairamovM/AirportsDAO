package com.solvd.airport.entity;

import org.apache.log4j.Logger;

import java.util.List;

public class Team {

    private static final Logger logEntity = Logger.getLogger(Team.class);

    private Long id;
    private List <ChiefPilot> chiefPilot;
    private List <SecondPilot> secondPilot;
    private List <Stewardesse> stewardesse;

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

    public List <ChiefPilot> getChiefPilot() {
        return chiefPilot;
    }

    public void setChiefPilot(List <ChiefPilot> chiefPilot) {
                this.chiefPilot = chiefPilot;
    }

    public List <SecondPilot> getSecondPilot() {
        return secondPilot;
    }

    public void setSecondPilot(List <SecondPilot> secondPilot) {
                this.secondPilot = secondPilot;
    }

    public List <Stewardesse> getStewardesse() {
        return stewardesse;
    }

    public void setStewardesse(List <Stewardesse> stewardesse) {
                this.stewardesse = stewardesse;
    }
}
