package com.solvd.javalab.dao.daoClass;

import com.solvd.javalab.dao.entity.AirportEmployees;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class AirportEmployeesDAO implements DAO <AirportEmployees> {

    private static final Logger logDAO = Logger.getLogger(AirportEmployeesDAO.class);

    public static final String getId = "SELECT * FROM AirportEmployees WHERE id = ?";
    public static final String getAll = "SELECT * FROM AirportEmployees";
    public static final String save = "INSERT INTO AirportEmployees VALUES (?,?,?,?)";
    public static final String delete = "DELETE FROM AirportEmployees WHERE id =?";
    public static final String update = "UPDATE AirportEmployees SET firstName = ?, lastName = ?,gender = ?, " +
            "passportSerialNumber = ?, phoneNumber = ?, , EmployeeSalaries_id = ?, , EmployeePositions_id = ?, , " +
            "AirportDepartments_id = ?, , Nationalities_id = ? WHERE id =?";

    @Override
    public AirportEmployees getByID(Long id) {

        logDAO.trace("Try to find AirportEmployees with id = " + id);

        AirportEmployees airportEmployees = null;
        Connection connection = null;
        PreparedStatement prStatement = null;
        ResultSet rSet = null;

        try {
            logDAO.trace("Open Connection");
            connection = ConnectionFactory.getConnection();
            try {
                logDAO.trace("Create PreparedStatement");
                prStatement = connection.prepareStatement(getId);
                prStatement.setLong(1, id);
                try {
                    logDAO.trace("Get ResultSet");
                    rSet = prStatement.executeQuery();
                    if (rSet.next()) {
                        airportEmployees = new AirportEmployees();
                        airportEmployees.setId(rSet.getLong("id"));
                        airportEmployees.setFirstName(rSet.getString("firstName"));
                        airportEmployees.setLastName(rSet.getString("lastName"));
                        airportEmployees.setGender(rSet.getString("gender"));
                        airportEmployees.setPassportSerialNumber(rSet.getDouble("passportSerialNumber"));
                        airportEmployees.setPhoneNumber(rSet.getDouble("phoneNumber"));
                        airportEmployees.setEmployeeSalaries_id(rSet.getLong("EmployeeSalaries_id"));
                        airportEmployees.setEmployeePositions_id(rSet.getLong("EmployeePositions_id"));
                        airportEmployees.setAirportDepartments_id(rSet.getLong("AirportDepartments_id"));
                        airportEmployees.setNationalities_id(rSet.getLong("Nationalities_id"));
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
    public List<AirportEmployees> getAll() {

        logDAO.trace("Try to find all airportEmployees");
        AirportEmployees airportEmployees = null;
        Connection connection = null;
        PreparedStatement prStatement = null;
        ResultSet rSet = null;

        try {
            logDAO.trace("Open Connection");
            connection = ConnectionFactory.getConnection();
            try {
                logDAO.trace("Create PreparedStatement");
                prStatement = connection.prepareStatement(getAll);
                try {
                    logDAO.trace("Get ResultSet");
                    rSet = prStatement.executeQuery();
                    List<AirportEmployees> airportEmployee = new ArrayList<>();
                    while (rSet.next()) {
                        airportEmployees = new AirportEmployees();
                        airportEmployees.setId(rSet.getLong("id"));
                        airportEmployees.setFirstName(rSet.getString("firstName"));
                        airportEmployees.setLastName(rSet.getString("lastName"));
                        airportEmployees.setGender(rSet.getString("gender"));
                        airportEmployees.setPassportSerialNumber(rSet.getDouble("passportSerialNumber"));
                        airportEmployees.setPhoneNumber(rSet.getDouble("phoneNumber"));
                        airportEmployees.setEmployeeSalaries_id(rSet.getLong("EmployeeSalaries_id"));
                        airportEmployees.setEmployeePositions_id(rSet.getLong("EmployeePositions_id"));
                        airportEmployees.setAirportDepartments_id(rSet.getLong("AirportDepartments_id"));
                        airportEmployees.setNationalities_id(rSet.getLong("Nationalities_id"));
                        airportEmployee.add(airportEmployees);

                    }
                    return airportEmployee;
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
    public void save(AirportEmployees airportEmployees) {

        logDAO.trace("Update Data in airportEmployees");
        Connection connection = null;
        PreparedStatement prStatement = null;

        try {
            logDAO.trace("Open Connection");
            connection = ConnectionFactory.getConnection();
            try {
                logDAO.trace("Create PreparedStatement");
                prStatement = connection.prepareStatement(save);

                prStatement.setString(1, airportEmployees.getFirstName());
                prStatement.setString(2, airportEmployees.getLastName());
                prStatement.setString(3, airportEmployees.getGender());
                prStatement.setDouble(4, airportEmployees.getPassportSerialNumber());
                prStatement.setDouble(5, airportEmployees.getPhoneNumber());
                prStatement.setLong(6, airportEmployees.getEmployeeSalaries_id());
                prStatement.setLong(7, airportEmployees.getEmployeePositions_id());
                prStatement.setLong(8, airportEmployees.getAirportDepartments_id());
                prStatement.setLong(9, airportEmployees.getNationalities_id());

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
                prStatement = connection.prepareStatement(delete);
                prStatement.setLong(1, id);
                prStatement.executeUpdate(delete);
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
    public void update(AirportEmployees airportEmployees) {

        logDAO.trace("Update Data in airportEmployees");
        Connection connection = null;
        PreparedStatement prStatement = null;

        try {
            logDAO.trace("Open Connection");
            connection = ConnectionFactory.getConnection();
            try {
                logDAO.trace("Create PreparedStatement");
                prStatement = connection.prepareStatement(update);
                prStatement.setString(1, airportEmployees.getFirstName());
                prStatement.setString(2, airportEmployees.getLastName());
                prStatement.setString(3, airportEmployees.getGender());
                prStatement.setDouble(4, airportEmployees.getPassportSerialNumber());
                prStatement.setDouble(5, airportEmployees.getPhoneNumber());
                prStatement.setLong(6, airportEmployees.getEmployeeSalaries_id());
                prStatement.setLong(7, airportEmployees.getEmployeePositions_id());
                prStatement.setLong(8, airportEmployees.getAirportDepartments_id());
                prStatement.setLong(9, airportEmployees.getNationalities_id());

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
