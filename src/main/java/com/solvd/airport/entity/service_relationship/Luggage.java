package com.solvd.airport.entity.service_relationship;

import org.apache.log4j.Logger;

public class Luggage {

    private static final Logger logEntity = Logger.getLogger(Luggage.class);

    private Long id;
    private Long barcode;
    private Long weight;
    private Passenger passenger;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBarcode() {
        return barcode;
    }

    public void setBarcode(Long barcode) {
        this.barcode = barcode;
    }

    public Long getWeight() {
        return weight;
    }

    public void setWeight(Long weight) {
        this.weight = weight;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }
}
