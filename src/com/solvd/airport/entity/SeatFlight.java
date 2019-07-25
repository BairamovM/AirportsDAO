package com.solvd.airport.entity;

import org.apache.log4j.Logger;

public class SeatFlight {

    private static final Logger logEntity = Logger.getLogger(SeatFlight.class);

    private Long id;
    private Long numberSeet;
    private Long ticketPrice;
    private Long Airplanes_id;
    private Long Passengers_id;
    private Long ClassSeets_id;

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

    public Long getAirplanes_id() {
        return Airplanes_id;
    }

    public void setAirplanes_id(Long airplanes_id) {

        try {
            if (airplanes_id <= 0) {
                logEntity.error("Value airplanes_id error = " + airplanes_id);
                throw new EntityException("Value airplanes_id error = " + airplanes_id);
            } else if (airplanes_id >= 1) {
                this.Airplanes_id = airplanes_id;
            }
        } catch (EntityException e) {
            logEntity.error("Value airplanes_id error = " + airplanes_id);
        }
    }

    public Long getPassengers_id() {
        return Passengers_id;
    }

    public void setPassengers_id(Long passengers_id) {

        try {
            if (passengers_id <= 0) {
                logEntity.error("Value passengers_id error = " + passengers_id);
                throw new EntityException("Value passengers_id error = " + passengers_id);
            } else if (passengers_id >= 1) {
                this.Passengers_id = passengers_id;
            }
        } catch (EntityException e) {
            logEntity.error("Value passengers_id error = " + passengers_id);
        }
    }

    public Long getClassSeets_id() {
        return ClassSeets_id;
    }

    public void setClassSeets_id(Long classSeets_id) {

        try {
            if (classSeets_id <= 0) {
                logEntity.error("Value classSeets_id error = " + classSeets_id);
                throw new EntityException("Value classSeets_id error = " + classSeets_id);
            } else if (classSeets_id >= 1) {
                this.ClassSeets_id = classSeets_id;
            }
        } catch (EntityException e) {
            logEntity.error("Value classSeets_id error = " + classSeets_id);
        }
    }
}
