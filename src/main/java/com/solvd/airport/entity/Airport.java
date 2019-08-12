package com.solvd.airport.entity;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import org.apache.log4j.Logger;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class Airport {

    private static final Logger logEntity = Logger.getLogger(Airport.class);

    private Integer id;
    private String nameAirport;
    private AirportClass airportClass;
    private Country country;

    private List <AirportDepartment> airportDepartmentServiceList;
    private List <AllFlight> allFlightServiceList;

    @JsonGetter ("id")
    public Integer getId() {
        return id;
    }

    @JsonSetter ("id")
    @XmlElement
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

    @JsonGetter ("nameAirport")
    public String getNameAirport() {
        return nameAirport;
    }

    @JsonSetter ("nameAirport")
    @XmlElement
    public void setNameAirport(String nameAirport) {

        try {
            if (nameAirport == null) {
                logEntity.error("Value nameAirport NULL error = " + nameAirport);
                throw new EntityException("Value nameAirport NULL error = " + nameAirport);
            } else if (nameAirport != null) {
                this.nameAirport = nameAirport;
            }
        } catch (EntityException e) {
            logEntity.error("Value nameAirport NULL error = " + nameAirport);
        }
    }

    @JsonGetter ("airportClass")
    public AirportClass getAirportClass() {
        return airportClass;
    }

    @JsonSetter ("airportClass")
    @XmlElement
    public void setAirportClass(AirportClass airportClass) {
        this.airportClass = airportClass;
    }

    @JsonGetter ("country")
    public Country getCountry() {
        return country;
    }

    @JsonSetter ("country")
    @XmlElement
    public void setCountry(Country country) {
        this.country = country;
    }

    @JsonGetter ("airportDepartmentServiceList")
    public List<AirportDepartment> getAirportDepartmentServiceList() {
        return airportDepartmentServiceList;
    }

    @JsonSetter ("airportDepartmentServiceList")
    @XmlElement
    public void setAirportDepartmentServiceList(List<AirportDepartment> airportDepartmentServiceList) {
        this.airportDepartmentServiceList = airportDepartmentServiceList;
    }

    @JsonGetter ("allFlightServiceList")
    public List<AllFlight> getAllFlightServiceList() {
        return allFlightServiceList;
    }

    @JsonSetter ("allFlightServiceList")
    @XmlElement
    public void setAllFlightServiceList(List<AllFlight> allFlightServiceList) {
        this.allFlightServiceList = allFlightServiceList;
    }

    @Override
    public String toString() {
        return "Airport { " + "\n" +
                "id = " + id + "\n" +
                "nameAirport = " + nameAirport + "\n" +
                "airportClass = " + airportClass + "\n" +
                "country = " + country + "\n" +
                '}' +
                "\n";
    }
}
