package com.solvd.airport.entity;

import org.apache.log4j.Logger;

import java.util.List;

public class SeatFlight {

    private static final Logger logEntity = Logger.getLogger(SeatFlight.class);

    private Long id;
    private Long numberSeet;
    private Long ticketPrice;
    private Long airplane;
    private Long passenger;
    private Long classSeet;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {

        try {
            if (id <= 0) {
                logEntity.error("Value id error = " + id);
                throw new EntityException("Value id error = " + id);
            } else if (id >= 1) {
                this.id = id;
            }
        } catch (EntityException e) {
            logEntity.error("Value id error = " + id);
        }
    }

    public Long getNumberSeet() {
        return numberSeet;
    }

    public void setNumberSeet(Long numberSeet) {

        try {
            if (numberSeet <= 0) {
                logEntity.error("Value numberSeet error = " + numberSeet);
                throw new EntityException("Value numberSeet error = " + numberSeet);
            } else if (numberSeet >= 1) {
                this.numberSeet = numberSeet;
            }
        } catch (EntityException e) {
            logEntity.error("Value numberSeet error = " + numberSeet);
        }
    }

    public Long getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(Long ticketPrice) {

        try {
            if (ticketPrice <= 0) {
                logEntity.error("Value ticketPrice error = " + ticketPrice);
                throw new EntityException("Value ticketPrice error = " + ticketPrice);
            } else if (ticketPrice >= 1) {
                this.ticketPrice = ticketPrice;
            }
        } catch (EntityException e) {
            logEntity.error("Value ticketPrice error = " + ticketPrice);
        }
    }

    public Long getAirplane() {
        return airplane;
    }

    public void setAirplane(Long airplane) {
        this.airplane = airplane;
    }

    public Long getPassenger() {
        return passenger;
    }

    public void setPassenger(Long passenger) {
        this.passenger = passenger;
    }

    public Long getClassSeet() {
        return classSeet;
    }

    public void setClassSeet(Long classSeet) {
        this.classSeet = classSeet;
    }
}
