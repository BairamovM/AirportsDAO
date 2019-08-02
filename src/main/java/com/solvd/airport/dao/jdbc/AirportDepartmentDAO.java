package com.solvd.airport.dao.jdbc;

import com.solvd.airport.entity.AirportDepartment;
import com.solvd.airport.dao.IAirportDepartment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class AirportDepartmentDAO implements IAirportDepartment {

    private static final Logger logDAO = Logger.getLogger(AirportDepartmentDAO.class);

    public static final String GET_ID = "SELECT * FROM AirportDepartments WHERE id = ?";
    public static final String GET_ALL = "SELECT * FROM AirportDepartments";
    public static final String SAVE = "INSERT INTO AirportDepartments VALUES (?,?,?,?)";
    public static final String DELETE = "DELETE FROM AirportDepartments WHERE id =?";
    public static final String UPDATE = "UPDATE AirportDepartments SET nameDepartment = ?, Airports_id = ? WHERE id =?";

    @Override
    public AirportDepartment getByID(Long id) {

        logDAO.trace("Try to find Airplane with id = " + id);

        AirportDepartment airportDepartments = null;
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
                        airportDepartments = new AirportDepartment();
                        airportDepartments.setId(rSet.getLong("id"));
                        airportDepartments.setNameDepartment(rSet.getString("nameDepartment"));
                        //airportDepartments.setAirport(rSet.getLong("airports_id"));
                        return airportDepartments;
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
            logDAO.trace("Can't find AirportDepartments");
        } finally {
            try {
                connection.close();
                logDAO.trace("Connection closed");
            } catch (SQLException e) {
                logDAO.warn("Can't close Connection", e);
            }
        }

        if (null == airportDepartments) {
            logDAO.debug("Airplane not found");
        } else {
            logDAO.trace("Find Airplane");
        }

        logDAO.trace("Return Airplane");
        return airportDepartments;
    }

    @Override
    public AirportDepartment getAll() {

        logDAO.trace("Try to find all Airplanes");
        AirportDepartment airportDepartments = null;
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
                    List<AirportDepartment> airportDepartment = new ArrayList<>();
                    while (rSet.next()) {
                        airportDepartments = new AirportDepartment();
                        airportDepartments.setId(rSet.getLong("id"));
                        airportDepartments.setNameDepartment(rSet.getString("nameDepartment"));
                        //airportDepartments.setAirport(rSet.getLong("Airports_id"));
                        airportDepartment.add(airportDepartments);

                    }
                    //return airportDepartment;
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
            logDAO.trace("Can't find any AirportDepartments", e);
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
    public AirportDepartment save(AirportDepartment airportDepartments) {

        logDAO.trace("Update Data in airplane");
        Connection connection = null;
        PreparedStatement prStatement = null;

        try {
            logDAO.trace("Open Connection");
            connection = ConnectionFactory.getConnection();
            try {
                logDAO.trace("Create PreparedStatement");
                prStatement = connection.prepareStatement(SAVE);

                prStatement.setString(1, airportDepartments.getNameDepartment());
                //prStatement.setLong(2, airportDepartments.getAirport());

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
            logDAO.trace("Can't Updata Data in airportDepartments", e);
        } finally {
            try {
                connection.close();
                logDAO.trace("Connection closed");
            } catch (SQLException e) {
                logDAO.warn("Can't close Connection", e);
            }
        }

        return airportDepartments;
    }

    @Override
    public void delete(Long id) {

        logDAO.trace("Delete Data from airportDepartments");
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
            logDAO.trace("Can't Delete Data in airportDepartments");
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
    public void update(AirportDepartment airportDepartments) {

        logDAO.trace("Update Data in airportDepartments");
        Connection connection = null;
        PreparedStatement prStatement = null;

        try {
            logDAO.trace("Open Connection");
            connection = ConnectionFactory.getConnection();
            try {
                logDAO.trace("Create PreparedStatement");
                prStatement = connection.prepareStatement(UPDATE);
                prStatement.setString(1, airportDepartments.getNameDepartment());
                //prStatement.setLong(2, airportDepartments.getAirport());

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
            logDAO.trace("Can't Update Data in airportDepartments", e);
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
