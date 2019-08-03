package com.solvd.airport.entity.service_relationship;

import com.solvd.airport.entity.Airport;
import org.apache.log4j.Logger;

public class AirportDepartmentService {

    private static final Logger logEntity = Logger.getLogger(AirportDepartmentService.class);

    private Long id;
    private String nameDepartment;
    private Airport airport;

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

    public Airport getAirport() {
        return airport;
    }

    public void setAirport(Airport airport) {
        this.airport = airport;
    }
}
