package com.solvd.airport.entity.service_relationship;

import com.solvd.airport.entity.Airplane;
import com.solvd.airport.entity.AllFlight;
import com.solvd.airport.entity.Letter;
import org.apache.log4j.Logger;

import java.util.List;

public class DeparturesService {

    private static final Logger logEntity = Logger.getLogger(DeparturesService.class);

    private Long id;
    private String departureDate;
    private AirplaneService airplaneService;
    private AllFlightService allFlightService;

    private List <LetterService> letterServiceList;

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

    public List<LetterService> getLetterServiceList() {
        return letterServiceList;
    }

    public void setLetterServiceList(List<LetterService> letterServiceList) {
        this.letterServiceList = letterServiceList;
    }
}
