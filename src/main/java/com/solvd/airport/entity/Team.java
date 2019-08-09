package com.solvd.airport.entity;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.log4j.Logger;

import java.util.List;

@XmlRootElement (name = "Team")
public class Team {

    private static final Logger logEntity = Logger.getLogger(Team.class);

    private Integer id;
    private ChiefPilot chiefPilot;
    private SecondPilot secondPilot;
    private Stewardesse stewardesse;


    public Integer getId() {
        return id;
    }

    @XmlAttribute
    public void setId(Integer id) {

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

    @XmlElement
    public void setChiefPilot(ChiefPilot chiefPilot) {
                this.chiefPilot = chiefPilot;
    }

    public SecondPilot getSecondPilot() {
        return secondPilot;
    }

    @XmlElement
    public void setSecondPilot(SecondPilot secondPilot) {
                this.secondPilot = secondPilot;
    }

    public Stewardesse getStewardesse() {
        return stewardesse;
    }

    @XmlElement
    public void setStewardesse(Stewardesse stewardesse) {
                this.stewardesse = stewardesse;
    }

    @Override
    public String toString() {
        return "Team { " + "\n" +
                "id = " + id + "\n" +
                "chiefPilot = " + chiefPilot + "\n" +
                "secondPilot = " + secondPilot + "\n" +
                "stewardesse = " + stewardesse + "\n" +
                '}' +
                "\n";
    }
}
