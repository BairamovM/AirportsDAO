package com.solvd.airport.entity;

import org.apache.log4j.Logger;

import java.util.List;

public class AirportEmployee {

    private static final Logger logEntity = Logger.getLogger(AirportEmployee.class);

    private Long id;
    private String firstName;
    private String lastName;
    private String gender;
    private Double passportSerialNumber;
    private Double phoneNumber;
    private Long employeeSalary;
    private Long employeePosition;
    private Long airportDepartment;
    private Long nationality;

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

    public Double getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Double phoneNumber) {

        try {
            if (phoneNumber <= 0) {
                logEntity.error("Value phoneNumber error = " + phoneNumber);
                throw new EntityException("Value phoneNumber error = " + phoneNumber);
            } else if (phoneNumber >= 1) {
                this.phoneNumber = phoneNumber;
            }
        } catch (EntityException e) {
            logEntity.error("Value phoneNumber error = " + phoneNumber);
        }
    }

    public Long getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(Long employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public Long getEmployeePosition() {
        return employeePosition;
    }

    public void setEmployeePosition(Long employeePosition) {
        this.employeePosition = employeePosition;
    }

    public Long getAirportDepartment() {
        return airportDepartment;
    }

    public void setAirportDepartment(Long airportDepartment) {
        this.airportDepartment = airportDepartment;
    }

    public Long getNationality() {
        return nationality;
    }

    public void setNationality(Long nationality) {
        this.nationality = nationality;
    }
}
