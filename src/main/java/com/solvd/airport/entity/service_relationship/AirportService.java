package com.solvd.airport.entity.service_relationship;

import com.solvd.airport.entity.AirportClass;
import com.solvd.airport.entity.Country;
import org.apache.log4j.Logger;

import java.util.List;

public class AirportService {

    private static final Logger logEntity = Logger.getLogger(AirportService.class);

    private Long id;
    private String nameAirport;
    private AirportClassService airportClassService;
    private CountryService countryService;

    private List <AirportDepartmentService> airportDepartmentServiceList;
    private List <AllFlightService> allFlightServiceList;

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

    public AirportClassService getAirportClassService() {
        return airportClassService;
    }

    public void setAirportClassService(AirportClassService airportClassService) {
        this.airportClassService = airportClassService;
    }

    public CountryService getCountryService() {
        return countryService;
    }

    public void setCountryService(CountryService countryService) {
        this.countryService = countryService;
    }

    public List<AirportDepartmentService> getAirportDepartmentServiceList() {
        return airportDepartmentServiceList;
    }

    public void setAirportDepartmentServiceList(List<AirportDepartmentService> airportDepartmentServiceList) {
        this.airportDepartmentServiceList = airportDepartmentServiceList;
    }

    public List<AllFlightService> getAllFlightServiceList() {
        return allFlightServiceList;
    }

    public void setAllFlightServiceList(List<AllFlightService> allFlightServiceList) {
        this.allFlightServiceList = allFlightServiceList;
    }
}
