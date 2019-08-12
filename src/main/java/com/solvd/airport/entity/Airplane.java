package com.solvd.airport.entity;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import org.apache.log4j.Logger;

import java.util.List;

@XmlRootElement(name = "Airplane")
public class Airplane {

    private static final Logger logEntity = Logger.getLogger(Airplane.class);

    private Integer id;
    private String type;
    private Integer numberSeets;
    private Integer rangeFlight;
    private Integer carryingCapacity;
    private Team team;

    private List<SeatFlight> seatFlightServiceList;
    private Departure departureService;


    @JsonSetter ("id")
    @XmlAttribute
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonGetter ("id")
    public Integer getId() {
        return id;
    }


    @JsonSetter ("type")
    @XmlElement
    public void setType(String type) {

        try {
            if (type == null) {
                logEntity.error("Value type NULL error = " + type);
                throw new EntityException("Value type NULL error = " + type);
            } else if (type != null) {
                this.type = type;
            }
        } catch (EntityException e) {
            logEntity.error("Value type NULL error = " + type);
        }
    }

    @JsonGetter ("type")
    public String getType() {
        return type;
    }

    @JsonSetter ("numberSeets")
    @XmlElement
    public void setNumberSeets(Integer numberSeets) {
        this.numberSeets = numberSeets;
    }

    @JsonGetter ("numberSeets")
    public Integer getNumberSeets() {
        return numberSeets;
    }

    @JsonSetter ("rangeFlight")
    @XmlElement
    public void setRangeFlight(Integer rangeFlight) {

        try {
            if (rangeFlight <= 0) {
                logEntity.error("Value rangeFlight error = " + rangeFlight);
                throw new EntityException("Value rangeFlight error = " + rangeFlight);
            } else if (rangeFlight >= 1) {
                this.rangeFlight = rangeFlight;
            }
        } catch (EntityException e) {
            logEntity.error("Value rangeFlight error = " + rangeFlight);
        }
    }

    @JsonGetter ("rangeFlight")
    public Integer getRangeFlight() {
        return rangeFlight;
    }

    @JsonSetter ("carryingCapacity")
    @XmlElement
    public void setCarryingCapacity(Integer carryingCapacity) {

        try {
            if (carryingCapacity <= 0) {
                logEntity.error("Value carryingCapacity error = " + carryingCapacity);
                throw new EntityException("Value carryingCapacity error = " + carryingCapacity);
            } else if (carryingCapacity >= 1) {
                this.carryingCapacity = carryingCapacity;
            }
        } catch (EntityException e) {
            logEntity.error("Value carryingCapacity error = " + carryingCapacity);
        }
    }

    @JsonGetter ("carryingCapacity")
    public Integer getCarryingCapacity() {
        return carryingCapacity;
    }

    @JsonSetter ("team")
    @XmlElement
    public void setTeam(Team team) {
        this.team = team;
    }

    @JsonGetter ("team")
    public Team getTeam() {
        return team;
    }

    @JsonGetter ("seatFlightServiceList")
    public List<SeatFlight> getSeatFlightServiceList() {
        return seatFlightServiceList;
    }

    @JsonSetter ("seatFlightServiceList")
    @XmlElement
    public void setSeatFlightServiceList(List<SeatFlight> seatFlightServiceList) {
        this.seatFlightServiceList = seatFlightServiceList;
    }

    @JsonGetter ("departureService")
    public Departure getDepartureService() {
        return departureService;
    }

    @JsonSetter ("departureService")
    @XmlElement
    public void setDepartureService(Departure departureService) {
        this.departureService = departureService;
    }



    @Override
    public String toString() {
        return "Airplane { " + "\n" +
                "id = " + id + "\n" +
                "type = " + type + "\n" +
                "numberSeets = " + numberSeets + "\n" +
                "rangeFlight = " + rangeFlight + "\n" +
                "carryingCapacity = " + carryingCapacity + "\n" +
                "team = " + team + "\n" +
                '}' +
                "\n";
    }
}
