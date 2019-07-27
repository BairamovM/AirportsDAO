package com.solvd.airport.entity;

import org.apache.log4j.Logger;

public class EmployeeSalary {

    private static final Logger logEntity = Logger.getLogger(EmployeeSalary.class);

    private Long id;
    private Double amount;

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

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {

        try {
            if (amount <= 0) {
                logEntity.error("Value amount error = " + amount);
                throw new EntityException("Value amount error = " + amount);
            } else if (amount >= 1) {
                this.amount = amount;
            }
        } catch (EntityException e) {
            logEntity.error("Value amount error = " + amount);
        }
    }
}
