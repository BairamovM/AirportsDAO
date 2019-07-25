package com.solvd.airport.dao.entity;

import org.apache.log4j.Logger;

public class Luggage {

    private static final Logger logEntity = Logger.getLogger(Luggage.class);

    private Long id;
    private Long barcode;
    private Long weight;
    private Long Passengers_id;

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

    public Long getBarcode() {
        return barcode;
    }

    public void setBarcode(Long barcode) {

        try {
            if (barcode <= 0) {
                logEntity.error("Value barcode error = " + barcode);
                throw new EntityException("Value barcode error = " + barcode);
            } else if (barcode >= 1) {
                this.barcode = barcode;
            }
        } catch (EntityException e) {
            logEntity.error("Value barcode error = " + barcode);
        }
    }

    public Long getWeight() {
        return weight;
    }

    public void setWeight(Long weight) {

        try {
            if (weight <= 0) {
                logEntity.error("Value weight error = " + weight);
                throw new EntityException("Value weight error = " + weight);
            } else if (weight >= 1) {
                this.weight = weight;
            }
        } catch (EntityException e) {
            logEntity.error("Value weight error = " + weight);
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
}
