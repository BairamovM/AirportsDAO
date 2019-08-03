package com.solvd.airport.entity.service_relationship;

import com.solvd.airport.entity.AirportClass;
import com.solvd.airport.entity.AirportDepartment;
import com.solvd.airport.entity.AllFlight;
import com.solvd.airport.entity.Country;
import org.apache.log4j.Logger;

import java.util.List;

public class AirportService {

    private static final Logger logEntity = Logger.getLogger(AirportService.class);

    private Long id;
    private String nameAirport;
    private AirportClass airportClass;
    private Country country;

    private List <AirportDepartment> airportDepartmentList;
    private List <AllFlight> allFlightList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameAirport() {
        return nameAirport;
    }

    public void setNameAirport(String nameAirport) {
        this.nameAirport = nameAirport;
    }

    public AirportClass getAirportClass() {
        return airportClass;
    }

    public void setAirportClass(AirportClass airportClass) {
        this.airportClass = airportClass;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public List<AirportDepartment> getAirportDepartmentList() {
        return airportDepartmentList;
    }

    public void setAirportDepartmentList(List<AirportDepartment> airportDepartmentList) {
        this.airportDepartmentList = airportDepartmentList;
    }

    public List<AllFlight> getAllFlightList() {
        return allFlightList;
    }

    public void setAllFlightList(List<AllFlight> allFlightList) {
        this.allFlightList = allFlightList;
    }
}
