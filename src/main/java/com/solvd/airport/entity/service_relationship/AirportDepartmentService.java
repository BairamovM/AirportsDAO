package com.solvd.airport.entity.service_relationship;

import org.apache.log4j.Logger;

public class AirportDepartmentService {

    private static final Logger logEntity = Logger.getLogger(AirportDepartmentService.class);

    private Long id;
    private String nameDepartment;
    private AirportService airportService;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameDepartment() {
        return nameDepartment;
    }

    public void setNameDepartment(String nameDepartment) {
        this.nameDepartment = nameDepartment;
    }

    public AirportService getAirportService() {
        return airportService;
    }

    public void setAirportService(AirportService airportService) {
        this.airportService = airportService;
    }
}
