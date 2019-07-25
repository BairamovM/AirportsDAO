package com.solvd.airport.dao.entity;

import org.apache.log4j.Logger;

public class AirportEmployees {

    private static final Logger logEntity = Logger.getLogger(AirportEmployees.class);

    private Long id;
    private String firstName;
    private String lastName;
    private String gender;
    private Double passportSerialNumber;
    private Double phoneNumber;
    private Long EmployeeSalaries_id;
    private Long EmployeePositions_id;
    private Long AirportDepartments_id;
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

    public Long getEmployeeSalaries_id() {
        return EmployeeSalaries_id;
    }

    public void setEmployeeSalaries_id(Long employeeSalaries_id) {

        try {
            if (employeeSalaries_id <= 0) {
                logEntity.error("Value employeeSalaries_id error = " + employeeSalaries_id);
                throw new EntityException("Value employeeSalaries_id error = " + employeeSalaries_id);
            } else if (employeeSalaries_id >= 1) {
                this.EmployeeSalaries_id = employeeSalaries_id;
            }
        } catch (EntityException e) {
            logEntity.error("Value employeeSalaries_id error = " + employeeSalaries_id);
        }
    }

    public Long getEmployeePositions_id() {
        return EmployeePositions_id;
    }

    public void setEmployeePositions_id(Long employeePositions_id) {

        try {
            if (employeePositions_id <= 0) {
                logEntity.error("Value employeePositions_id error = " + employeePositions_id);
                throw new EntityException("Value employeePositions_id error = " + employeePositions_id);
            } else if (employeePositions_id >= 1) {
                this.EmployeePositions_id = employeePositions_id;
            }
        } catch (EntityException e) {
            logEntity.error("Value employeePositions_id error = " + employeePositions_id);
        }
    }

    public Long getAirportDepartments_id() {
        return AirportDepartments_id;
    }

    public void setAirportDepartments_id(Long airportDepartments_id) {

        try {
            if (airportDepartments_id <= 0) {
                logEntity.error("Value airportDepartments_id error = " + airportDepartments_id);
                throw new EntityException("Value airportDepartments_id error = " + airportDepartments_id);
            } else if (airportDepartments_id >= 1) {
                this.AirportDepartments_id = airportDepartments_id;
            }
        } catch (EntityException e) {
            logEntity.error("Value airportDepartments_id error = " + airportDepartments_id);
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
