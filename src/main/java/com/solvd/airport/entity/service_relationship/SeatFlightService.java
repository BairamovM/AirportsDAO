package com.solvd.airport.entity.service_relationship;

import com.solvd.airport.entity.Airplane;
import com.solvd.airport.entity.ClassSeet;
import com.solvd.airport.entity.Passenger;
import org.apache.log4j.Logger;

public class SeatFlightService {

    private static final Logger logEntity = Logger.getLogger(SeatFlightService.class);

    private Long id;
    private Long numberSeet;
    private Long ticketPrice;
    private Airplane airplane;
    private Passenger passenger;
    private ClassSeet classSeet;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumberSeet() {
        return numberSeet;
    }

    public void setNumberSeet(Long numberSeet) {
        this.numberSeet = numberSeet;
    }

    public Long getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(Long ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public ClassSeet getClassSeet() {
        return classSeet;
    }

    public void setClassSeet(ClassSeet classSeet) {
        this.classSeet = classSeet;
    }
}
