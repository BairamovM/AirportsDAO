package com.solvd.airport.dao.jdbc;

import com.solvd.airport.entity.Airport;
import com.solvd.airport.dao.IAirport;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class AirportDAO implements IAirport {

    private static final Logger logDAO = Logger.getLogger(AirportDAO.class);

    public static final String getId = "SELECT * FROM Airports WHERE id = ?";
    public static final String getAll = "SELECT * FROM Airports";
    public static final String save = "INSERT INTO Airports VALUES (?,?,?,?)";
    public static final String delete = "DELETE FROM Airports WHERE id =?";
    public static final String update = "UPDATE Airports SET nameAirport = ?, AirportClasses_id = ?,Countries_id = ? " +
            "WHERE id =?";

    @Override
    public Airport getByID(Long id) {

        logDAO.trace("Try to find Airports with id = " + id);

        Airport airports = null;
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
                        airports = new Airport();
                        airports.setId(rSet.getLong("id"));
                        airports.setNameAirport(rSet.getString("nameAirport"));
                        airports.setAirportClasses_id(rSet.getLong("AirportClasses_id"));
                        airports.setCountries_id(rSet.getLong("Countries_id"));
                        return airports;
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
            logDAO.trace("Can't find Airports");
        } finally {
            try {
                connection.close();
                logDAO.trace("Connection closed");
            } catch (SQLException e) {
                logDAO.warn("Can't close Connection", e);
            }
        }

        if (null == airports) {
            logDAO.debug("Airports not found");
        } else {
            logDAO.trace("Find Airports");
        }

        logDAO.trace("Return Airports");
        return airports;
    }

    @Override
    public List<Airport> getAll() {

        logDAO.trace("Try to find all Airplanes");
        Airport airports = null;
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
                    List<Airport> airport = new ArrayList<>();
                    while (rSet.next()) {
                        airports = new Airport();
                        airports.setId(rSet.getLong("id"));
                        airports.setNameAirport(rSet.getString("nameAirport"));
                        airports.setAirportClasses_id(rSet.getLong("AirportClasses_id"));
                        airports.setCountries_id(rSet.getLong("Countries_id"));
                        airport.add(airports);

                    }
                    return airport;
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
            logDAO.trace("Can't find any airports", e);
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
    public void save(Airport airports) {

        logDAO.trace("Update Data in airports");
        Connection connection = null;
        PreparedStatement prStatement = null;

        try {
            logDAO.trace("Open Connection");
            connection = ConnectionFactory.getConnection();
            try {
                logDAO.trace("Create PreparedStatement");
                prStatement = connection.prepareStatement(save);

                prStatement.setString(1, airports.getNameAirport());
                prStatement.setLong(2, airports.getAirportClasses_id());
                prStatement.setLong(3, airports.getCountries_id());

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
            logDAO.trace("Can't Updata Data in airports", e);
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

        logDAO.trace("Delete Data from airports");
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
            logDAO.trace("Can't Delete Data in airports");
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
    public void update(Airport airports) {

        logDAO.trace("Update Data in airports");
        Connection connection = null;
        PreparedStatement prStatement = null;

        try {
            logDAO.trace("Open Connection");
            connection = ConnectionFactory.getConnection();
            try {
                logDAO.trace("Create PreparedStatement");
                prStatement = connection.prepareStatement(update);
                prStatement.setString(1, airports.getNameAirport());
                prStatement.setLong(2, airports.getAirportClasses_id());
                prStatement.setLong(3, airports.getCountries_id());

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
            logDAO.trace("Can't Update Data in airports", e);
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
