package com.solvd.airport.entity.service_relationship;

import com.solvd.airport.entity.Airplane;
import com.solvd.airport.entity.AllFlight;
import org.apache.log4j.Logger;

public class DepartureService {

    private static final Logger logEntity = Logger.getLogger(DepartureService.class);

    private Long id;
    private String departureDate;
    private Airplane airplane;
    private AllFlight allFlight;

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

    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }

    public AllFlight getAllFlight() {
        return allFlight;
    }

    public void setAllFlight(AllFlight allFlight) {
        this.allFlight = allFlight;
    }
}
