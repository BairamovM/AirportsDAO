package com.solvd.airport.dao.jdbc;

import com.solvd.airport.entity.AirportEmployee;
import com.solvd.airport.dao.IAirportEmployee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class AirportEmployeeDAO implements IAirportEmployee {

    private static final Logger logDAO = Logger.getLogger(AirportEmployeeDAO.class);

    public static final String GET_ID = "SELECT * FROM AirportEmployees WHERE id = ?";
    public static final String GET_ALL = "SELECT * FROM AirportEmployees";
    public static final String SAVE = "INSERT INTO AirportEmployees VALUES (?,?,?,?)";
    public static final String DELETE = "DELETE FROM AirportEmployees WHERE id =?";
    public static final String UPDATE = "UPDATE AirportEmployees SET firstName = ?, lastName = ?,gender = ?, " +
            "passportSerialNumber = ?, phoneNumber = ?, , EmployeeSalaries_id = ?, , EmployeePositions_id = ?, , " +
            "AirportDepartments_id = ?, , Nationalities_id = ? WHERE id =?";

    @Override
    public AirportEmployee getByID(Long id) {

        logDAO.trace("Try to find AirportEmployees with id = " + id);

        AirportEmployee airportEmployees = null;
        Connection connection = null;
        PreparedStatement prStatement = null;
        ResultSet rSet = null;

        try {
            logDAO.trace("Open Connection");
            connection = ConnectionFactory.getConnection();
            try {
                logDAO.trace("Create PreparedStatement");
                prStatement = connection.prepareStatement(GET_ID);
                prStatement.setLong(1, id);
                try {
                    logDAO.trace("Get ResultSet");
                    rSet = prStatement.executeQuery();
                    if (rSet.next()) {
                        airportEmployees = new AirportEmployee();
                        airportEmployees.setId(rSet.getLong("id"));
                        airportEmployees.setFirstName(rSet.getString("firstName"));
                        airportEmployees.setLastName(rSet.getString("lastName"));
                        airportEmployees.setGender(rSet.getString("gender"));
                        airportEmployees.setPassportSerialNumber(rSet.getDouble("passportSerialNumber"));
                        airportEmployees.setPhoneNumber(rSet.getDouble("phoneNumber"));
                        airportEmployees.setEmployeeSalary(rSet.getLong("EmployeeSalaries_id"));
                        airportEmployees.setEmployeePosition(rSet.getLong("EmployeePositions_id"));
                        airportEmployees.setAirportDepartment(rSet.getLong("AirportDepartments_id"));
                        airportEmployees.setNationality(rSet.getLong("Nationalities_id"));
                        return airportEmployees;
                    }
                } finally {
                    try {
                        rSet.close();
                        logDAO.trace("ResultSet closed");
                    } catch (SQLException e) {
                        logDAO.warn("Can't close ResultSet", e);
                    }
                }
            } finally {
                try {
                    prStatement.close();
                    logDAO.trace("PreparedStatement closed");
                } catch (SQLException e) {
                    logDAO.warn("Can't close PreparedStatement", e);
                }
            }
        } catch (SQLException e) {
            logDAO.trace("Can't find airportEmployees");
        } finally {
            try {
                connection.close();
                logDAO.trace("Connection closed");
            } catch (SQLException e) {
                logDAO.warn("Can't close Connection", e);
            }
        }

        if (null == airportEmployees) {
            logDAO.debug("airportEmployees not found");
        } else {
            logDAO.trace("Find airportEmployees");
        }

        logDAO.trace("Return airportEmployees");
        return airportEmployees;
    }

    @Override
    public AirportEmployee getAll() {

        logDAO.trace("Try to find all airportEmployees");
        AirportEmployee airportEmployees = null;
        Connection connection = null;
        PreparedStatement prStatement = null;
        ResultSet rSet = null;

        try {
            logDAO.trace("Open Connection");
            connection = ConnectionFactory.getConnection();
            try {
                logDAO.trace("Create PreparedStatement");
                prStatement = connection.prepareStatement(GET_ALL);
                try {
                    logDAO.trace("Get ResultSet");
                    rSet = prStatement.executeQuery();
                    List<AirportEmployee> airportEmployee = new ArrayList<>();
                    while (rSet.next()) {
                        airportEmployees = new AirportEmployee();
                        airportEmployees.setId(rSet.getLong("id"));
                        airportEmployees.setFirstName(rSet.getString("firstName"));
                        airportEmployees.setLastName(rSet.getString("lastName"));
                        airportEmployees.setGender(rSet.getString("gender"));
                        airportEmployees.setPassportSerialNumber(rSet.getDouble("passportSerialNumber"));
                        airportEmployees.setPhoneNumber(rSet.getDouble("phoneNumber"));
                        airportEmployees.setEmployeeSalary(rSet.getLong("EmployeeSalaries_id"));
                        airportEmployees.setEmployeePosition(rSet.getLong("EmployeePositions_id"));
                        airportEmployees.setAirportDepartment(rSet.getLong("AirportDepartments_id"));
                        airportEmployees.setNationality(rSet.getLong("Nationalities_id"));
                        airportEmployee.add(airportEmployees);

                    }

                } finally {
                    try {
                        rSet.close();
                        logDAO.trace("ResultSet closed");
                    } catch (SQLException e) {
                        logDAO.warn("Can't close ResultSet", e);
                    }
                }
            } finally {
                try {
                    prStatement.close();
                    logDAO.trace("PreparedStatement closed");
                } catch (SQLException e) {
                    logDAO.warn("Can't close PreparedStatement", e);
                }
            }
        } catch (SQLException e) {
            logDAO.trace("Can't find any airportEmployees", e);
        } finally {
            try {
                connection.close();
                logDAO.trace("Connection closed");
            } catch (SQLException e) {
                logDAO.warn("Can't close Connection", e);
            }
        }

        return null;
    }

    @Override
    public AirportEmployee save(AirportEmployee airportEmployees) {

        logDAO.trace("Update Data in airportEmployees");
        Connection connection = null;
        PreparedStatement prStatement = null;

        try {
            logDAO.trace("Open Connection");
            connection = ConnectionFactory.getConnection();
            try {
                logDAO.trace("Create PreparedStatement");
                prStatement = connection.prepareStatement(SAVE);

                prStatement.setString(1, airportEmployees.getFirstName());
                prStatement.setString(2, airportEmployees.getLastName());
                prStatement.setString(3, airportEmployees.getGender());
                prStatement.setDouble(4, airportEmployees.getPassportSerialNumber());
                prStatement.setDouble(5, airportEmployees.getPhoneNumber());
                prStatement.setLong(6, airportEmployees.getEmployeeSalary());
                prStatement.setLong(7, airportEmployees.getEmployeePosition());
                prStatement.setLong(8, airportEmployees.getAirportDepartment());
                prStatement.setLong(9, airportEmployees.getNationality());

                prStatement.executeUpdate();
            } finally {
                try {
                    prStatement.close();
                    logDAO.trace("PreparedStatement closed");
                } catch (SQLException e) {
                    logDAO.warn("Can't close PreparedStatement", e);
                }
            }
        } catch (SQLException e) {
            logDAO.trace("Can't Updata Data in airportEmployees", e);
        } finally {
            try {
                connection.close();
                logDAO.trace("Connection closed");
            } catch (SQLException e) {
                logDAO.warn("Can't close Connection", e);
            }
        }

        return airportEmployees;
    }

    @Override
    public void delete(Long id) {

        logDAO.trace("Delete Data from airportEmployees");
        Connection connection = null;
        PreparedStatement prStatement = null;

        try {
            logDAO.trace("Open Connection");
            connection = ConnectionFactory.getConnection();
            try {
                logDAO.trace("Create PreparedStatement");
                prStatement = connection.prepareStatement(DELETE);
                prStatement.setLong(1, id);
                prStatement.executeUpdate(DELETE);
            } finally {
                try {
                    prStatement.close();
                    logDAO.trace("PreparedStatement closed");
                } catch (SQLException e) {
                    logDAO.warn("Can't close PreparedStatement", e);
                }
            }
        } catch (SQLException e) {
            logDAO.trace("Can't Delete Data in airportEmployees");
        } finally {
            try {
                connection.close();
                logDAO.trace("Connection closed");
            } catch (SQLException e) {
                logDAO.warn("Can't close Connection", e);
            }
        }

    }

    @Override
    public void update(AirportEmployee airportEmployees) {

        logDAO.trace("Update Data in airportEmployees");
        Connection connection = null;
        PreparedStatement prStatement = null;

        try {
            logDAO.trace("Open Connection");
            connection = ConnectionFactory.getConnection();
            try {
                logDAO.trace("Create PreparedStatement");
                prStatement = connection.prepareStatement(UPDATE);
                prStatement.setString(1, airportEmployees.getFirstName());
                prStatement.setString(2, airportEmployees.getLastName());
                prStatement.setString(3, airportEmployees.getGender());
                prStatement.setDouble(4, airportEmployees.getPassportSerialNumber());
                prStatement.setDouble(5, airportEmployees.getPhoneNumber());
                prStatement.setLong(6, airportEmployees.getEmployeeSalary());
                prStatement.setLong(7, airportEmployees.getEmployeePosition());
                prStatement.setLong(8, airportEmployees.getAirportDepartment());
                prStatement.setLong(9, airportEmployees.getNationality());

                prStatement.executeUpdate();
            } finally {
                try {
                    prStatement.close();
                    logDAO.trace("PreparedStatement closed");
                } catch (SQLException e) {
                    logDAO.warn("Can't close PreparedStatement", e);
                }
            }
        } catch (SQLException e) {
            logDAO.trace("Can't Update Data in airportEmployees", e);
        } finally {
            try {
                connection.close();
                logDAO.trace("Connection closed");
            } catch (SQLException e) {
                logDAO.warn("Can't close Connection", e);
            }
        }

    }

}
