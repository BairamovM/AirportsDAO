package com.solvd.javalab.dao.entity;

import org.apache.log4j.Logger;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Passengers {

    private static final Logger logEntity = Logger.getLogger(Passengers.class);

    private Long id;
    private String firstName;
    private String lastName;
    private String dateBirth;
    private String gender;
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

    public String getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(String dateBirth) {

        try {
            if (dateBirth == null) {
                logEntity.error("Value dateBirth NULL error = " + dateBirth);
                throw new EntityException("Value dateBirth NULL error = " + dateBirth);
            } else if (dateBirth != null) {
                this.dateBirth = dateBirth;
            }
        } catch (EntityException e) {
            logEntity.error("Value nameCountry NULL error = " + dateBirth);
        }
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {

        try {
            if (gender == null) {
                logEntity.error("Value gender NULL error = " + gender);
                throw new EntityException("Value gender NULL error = " + gender);
            } else if (gender != null) {
                this.gender = gender;
            }
        } catch (EntityException e) {
            logEntity.error("Value gender NULL error = " + gender);
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
