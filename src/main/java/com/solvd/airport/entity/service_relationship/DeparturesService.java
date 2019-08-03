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
    private Airplane airplane;
    private AllFlight allFlight;

    private List <Letter> letterList;

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

    public List<Letter> getLetterList() {
        return letterList;
    }

    public void setLetterList(List<Letter> letterList) {
        this.letterList = letterList;
    }
}
