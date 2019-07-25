package com.solvd.airport.entity;

import org.apache.log4j.Logger;

public class ChiefPilots {

    private static final Logger logEntity = Logger.getLogger(ChiefPilots.class);

    private Long id;
    private String firstName;
    private String lastName;
    private Long experience;
    private Double passportSerialNumber;
    private Long Nationalities_id;

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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {

        try {
            if (firstName == null) {
                logEntity.error("Value firstName NULL error = " + firstName);
                throw new EntityException("Value firstName NULL error = " + firstName);
            } else if (firstName != null) {
                this.firstName = firstName;
            }
        } catch (EntityException e) {
            logEntity.error("Value firstName NULL error = " + firstName);
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {

        try {
            if (lastName == null) {
                logEntity.error("Value lastName NULL error = " + lastName);
                throw new EntityException("Value lastName NULL error = " + lastName);
            } else if (lastName != null) {
                this.lastName = lastName;
            }
        } catch (EntityException e) {
            logEntity.error("Value lastName NULL error = " + lastName);
        }
    }

    public Long getExperience() {
        return experience;
    }

    public void setExperience(Long experience) {

        try {
            if (experience <= 0) {
                logEntity.error("Value experience error = " + experience);
                throw new EntityException("Value experience error = " + experience);
            } else if (experience >= 1) {
                this.experience = experience;
            }
        } catch (EntityException e) {
            logEntity.error("Value experience error = " + experience);
        }
    }

    public Double getPassportSerialNumber() {
        return passportSerialNumber;
    }

    public void setPassportSerialNumber(Double passportSerialNumber) {

        try {
            if (passportSerialNumber <= 0) {
                logEntity.error("Value passportSerialNumber error = " + passportSerialNumber);
                throw new EntityException("Value passportSerialNumber error = " + passportSerialNumber);
            } else if (passportSerialNumber >= 1) {
                this.passportSerialNumber = passportSerialNumber;
            }
        } catch (EntityException e) {
            logEntity.error("Value passportSerialNumber error = " + passportSerialNumber);
        }
    }

    public Long getNationalities_id() {
        return Nationalities_id;
    }

    public void setNationalities_id(Long nationalities_id) {

        try {
            if (nationalities_id <= 0) {
                logEntity.error("Value nationalities_id error = " + nationalities_id);
                throw new EntityException("Value nationalities_id error = " + nationalities_id);
            } else if (nationalities_id >= 1) {
                this.Nationalities_id = nationalities_id;
            }
        } catch (EntityException e) {
            logEntity.error("Value nationalities_id error = " + nationalities_id);
        }
    }
}
