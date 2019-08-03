package com.solvd.airport.entity.service_relationship;

import com.solvd.airport.entity.Airplane;
import com.solvd.airport.entity.AllFlight;
import org.apache.log4j.Logger;

public class DepartureService {

    private static final Logger logEntity = Logger.getLogger(DepartureService.class);

    private Long id;
    private String departureDate;
    private AirplaneService airplaneService;
    private AllFlightService allFlightService;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public AirplaneService getAirplaneService() {
        return airplaneService;
    }

    public void setAirplaneService(AirplaneService airplaneService) {
        this.airplaneService = airplaneService;
    }

    public AllFlightService getAllFlightService() {
        return allFlightService;
    }

    public void setAllFlightService(AllFlightService allFlightService) {
        this.allFlightService = allFlightService;
    }
}
