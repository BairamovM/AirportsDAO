package com.solvd.airport.entity;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.log4j.Logger;

import java.util.List;

@XmlRootElement (name = "SecondPilot")
public class SecondPilot {

    private static final Logger logEntity = Logger.getLogger(SecondPilot.class);

    private Integer id;
    private String firstName;
    private String lastName;
    private Integer experience;
    private Integer passportSerialNumber;
    private Nationality nationality;

    public Integer getId() {
        return id;
    }

    @XmlAttribute
    public void setId(Integer id) {

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

    @XmlElement
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

    @XmlElement
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

    public Integer getExperience() {
        return experience;
    }

    @XmlElement
    public void setExperience(Integer experience) {

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

    public Integer getPassportSerialNumber() {
        return passportSerialNumber;
    }

    @XmlElement
    public void setPassportSerialNumber(Integer passportSerialNumber) {

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

    public Nationality getNationality() {
        return nationality;
    }

    @XmlElement
    public void setNationality(Nationality nationality) {
        this.nationality = nationality;
    }

    @Override
    public String toString() {
        return "SecondPilot { " + "\n" +
                "id = " + id + "\n" +
                "firstName = " + firstName + "\n" +
                "lastName = " + lastName + "\n" +
                "experience = " + experience + "\n" +
                "passportSerialNumber = " + passportSerialNumber + "\n" +
                "nationality = " + nationality + "\n" +
                '}' +
                "\n";
    }
}
