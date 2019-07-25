package com.solvd.airport.dao.daoClass;

import com.solvd.airport.dao.entity.AirportDepartments;
import com.solvd.airport.dao.interfaces.IAirportDepartments;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class AirportDepartmentsDAO implements IAirportDepartments {

    private static final Logger logDAO = Logger.getLogger(AirportDepartmentsDAO.class);

    public static final String getId = "SELECT * FROM AirportDepartments WHERE id = ?";
    public static final String getAll = "SELECT * FROM AirportDepartments";
    public static final String save = "INSERT INTO AirportDepartments VALUES (?,?,?,?)";
    public static final String delete = "DELETE FROM AirportDepartments WHERE id =?";
    public static final String update = "UPDATE AirportDepartments SET nameDepartment = ?, Airports_id = ? WHERE id =?";

    @Override
    public AirportDepartments getByID(Long id) {

        logDAO.trace("Try to find Airplane with id = " + id);

        AirportDepartments airportDepartments = null;
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
                        airportDepartments = new AirportDepartments();
                        airportDepartments.setId(rSet.getLong("id"));
                        airportDepartments.setNameDepartment(rSet.getString("nameDepartment"));
                        airportDepartments.setAirports_id(rSet.getLong("airports_id"));
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
    public List<AirportDepartments> getAll() {

        logDAO.trace("Try to find all Airplanes");
        AirportDepartments airportDepartments = null;
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
                    List<AirportDepartments> airportDepartment = new ArrayList<>();
                    while (rSet.next()) {
                        airportDepartments = new AirportDepartments();
                        airportDepartments.setId(rSet.getLong("id"));
                        airportDepartments.setNameDepartment(rSet.getString("nameDepartment"));
                        airportDepartments.setAirports_id(rSet.getLong("Airports_id"));
                        airportDepartment.add(airportDepartments);

                    }
                    return airportDepartment;
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
    public void save(AirportDepartments airportDepartments) {

        logDAO.trace("Update Data in airplane");
        Connection connection = null;
        PreparedStatement prStatement = null;

        try {
            logDAO.trace("Open Connection");
            connection = ConnectionFactory.getConnection();
            try {
                logDAO.trace("Create PreparedStatement");
                prStatement = connection.prepareStatement(save);

                prStatement.setString(1, airportDepartments.getNameDepartment());
                prStatement.setLong(2, airportDepartments.getAirports_id());

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
    public void update(AirportDepartments airportDepartments) {

        logDAO.trace("Update Data in airportDepartments");
        Connection connection = null;
        PreparedStatement prStatement = null;

        try {
            logDAO.trace("Open Connection");
            connection = ConnectionFactory.getConnection();
            try {
                logDAO.trace("Create PreparedStatement");
                prStatement = connection.prepareStatement(update);
                prStatement.setString(1, airportDepartments.getNameDepartment());
                prStatement.setLong(2, airportDepartments.getAirports_id());

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
