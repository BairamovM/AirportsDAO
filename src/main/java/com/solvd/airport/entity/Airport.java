package com.solvd.airport.entity;

import org.apache.log4j.Logger;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class Airport {

    private static final Logger logEntity = Logger.getLogger(Airport.class);

    private Long id;
    private String nameAirport;
    private AirportClass airportClass;
    private Country country;

    private List <AirportDepartment> airportDepartmentServiceList;
    private List <AllFlight> allFlightServiceList;

    public Long getId() {
        return id;
    }

    @XmlElement
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

    public String getNameAirport() {
        return nameAirport;
    }

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

    public AirportClass getAirportClass() {
        return airportClass;
    }

    @XmlElement
    public void setAirportClass(AirportClass airportClass) {
        this.airportClass = airportClass;
    }

    public Country getCountry() {
        return country;
    }

    @XmlElement
    public void setCountry(Country country) {
        this.country = country;
    }

    public List<AirportDepartment> getAirportDepartmentServiceList() {
        return airportDepartmentServiceList;
    }

    @XmlElement
    public void setAirportDepartmentServiceList(List<AirportDepartment> airportDepartmentServiceList) {
        this.airportDepartmentServiceList = airportDepartmentServiceList;
    }

    public List<AllFlight> getAllFlightServiceList() {
        return allFlightServiceList;
    }

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
