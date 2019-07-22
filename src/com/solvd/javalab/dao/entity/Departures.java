package com.solvd.javalab.dao.entity;

import org.apache.log4j.Logger;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Departures {

    private static final Logger logEntity = Logger.getLogger(Departures.class);

    private Long id;
    private Calendar departureDate;
    private Long Airplanes_id;
    private Long AllFlights_id;

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

    public Calendar getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Calendar departureDate) {

        try {
            Calendar dateDefault = new GregorianCalendar(1990, Calendar.JANUARY, 1);
            if (departureDate.before(dateDefault)) {
                logEntity.error("Value departureDate error = " + departureDate);
                throw new EntityException("Value departureDate error = " + departureDate);
            } else if (departureDate.after(dateDefault)) {
                this.departureDate = departureDate;
            }
        } catch (EntityException e) {
            logEntity.error("Value departureDate error = " + departureDate);
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

    public Long getAllFlights_id() {
        return AllFlights_id;
    }

    public void setAllFlights_id(Long allFlights_id) {

        try {
            if (allFlights_id <= 0) {
                logEntity.error("Value allFlights_id error = " + allFlights_id);
                throw new EntityException("Value allFlights_id error = " + allFlights_id);
            } else if (allFlights_id >= 1) {
                this.AllFlights_id = allFlights_id;
            }
        } catch (EntityException e) {
            logEntity.error("Value allFlights_id error = " + allFlights_id);
        }
    }
}