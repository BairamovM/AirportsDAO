package com.solvd.airport.entity;

import org.apache.log4j.Logger;

import java.util.List;

public class Stewardesse {

    private static final Logger logEntity = Logger.getLogger(Stewardesse.class);

    private Long id;
    private String firstName;
    private String lastName;
    private Long experience;
    private Double passportSerialNumber;
    private List <Nationality> nationality;

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

    public List <Nationality> getNationality() {
        return nationality;
    }

    public void setNationality(List <Nationality> nationality) {
        this.nationality = nationality;
    }

}
