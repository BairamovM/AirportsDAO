package com.solvd.airport.dao.jdbc;

import com.solvd.airport.entity.AllFlights;
import com.solvd.airport.dao.IAllFlights;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class AllFlightsDAO implements IAllFlights {

    private static final Logger logDAO = Logger.getLogger(AllFlightsDAO.class);

    public static final String getId = "SELECT * FROM AllFlights WHERE id = ?";
    public static final String getAll = "SELECT * FROM AllFlights";
    public static final String save = "INSERT INTO AllFlights VALUES (?,?,?,?)";
    public static final String delete = "DELETE FROM AllFlights WHERE id =?";
    public static final String update = "UPDATE AllFlights SET numberFlight = ?, idDepartureAirport = ?, " +
            "idAirportArrival = ?, flightTime = ? WHERE id =?";

    @Override
    public AllFlights getByID(Long id) {

        logDAO.trace("Try to find AllFlights with id = " + id);

        AllFlights allFlights = null;
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
                        allFlights = new AllFlights();
                        allFlights.setId(rSet.getLong("id"));
                        allFlights.setNumberFlight(rSet.getDouble("numberFlight"));
                        allFlights.setIdDepartureAirport(rSet.getLong("idDepartureAirport"));
                        allFlights.setIdAirportArrival(rSet.getLong("idAirportArrival"));
                        allFlights.setFlightTime(rSet.getLong("flightTime"));
                        return allFlights;
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
            logDAO.trace("Can't find allFlights");
        } finally {
            try {
                connection.close();
                logDAO.trace("Connection closed");
            } catch (SQLException e) {
                logDAO.warn("Can't close Connection", e);
            }
        }

        if (null == allFlights) {
            logDAO.debug("allFlights not found");
        } else {
            logDAO.trace("Find allFlights");
        }

        logDAO.trace("Return allFlights");
        return allFlights;
    }

    @Override
    public List<AllFlights> getAll() {

        logDAO.trace("Try to find all Airplanes");
        AllFlights allFlights = null;
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
                    List<AllFlights> allFlight = new ArrayList<>();
                    while (rSet.next()) {
                        allFlights = new AllFlights();
                        allFlights.setId(rSet.getLong("id"));
                        allFlights.setNumberFlight(rSet.getDouble("numberFlight"));
                        allFlights.setIdDepartureAirport(rSet.getLong("idDepartureAirport"));
                        allFlights.setIdAirportArrival(rSet.getLong("idAirportArrival"));
                        allFlights.setFlightTime(rSet.getLong("flightTime"));
                        allFlight.add(allFlights);

                    }
                    return allFlight;
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
            logDAO.trace("Can't find any allFlights", e);
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
    public void save(AllFlights allFlights) {

        logDAO.trace("Update Data in allFlights");
        Connection connection = null;
        PreparedStatement prStatement = null;

        try {
            logDAO.trace("Open Connection");
            connection = ConnectionFactory.getConnection();
            try {
                logDAO.trace("Create PreparedStatement");
                prStatement = connection.prepareStatement(save);

                prStatement.setDouble(1, allFlights.getNumberFlight());
                prStatement.setLong(2, allFlights.getIdDepartureAirport());
                prStatement.setLong(3, allFlights.getIdAirportArrival());
                prStatement.setLong(4, allFlights.getFlightTime());

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
            logDAO.trace("Can't Updata Data in allFlights", e);
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

        logDAO.trace("Delete Data from allFlights");
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
            logDAO.trace("Can't Delete Data in allFlights");
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
    public void update(AllFlights allFlights) {

        logDAO.trace("Update Data in allFlights");
        Connection connection = null;
        PreparedStatement prStatement = null;

        try {
            logDAO.trace("Open Connection");
            connection = ConnectionFactory.getConnection();
            try {
                logDAO.trace("Create PreparedStatement");
                prStatement = connection.prepareStatement(update);
                prStatement.setDouble(1, allFlights.getNumberFlight());
                prStatement.setLong(2, allFlights.getIdDepartureAirport());
                prStatement.setLong(3, allFlights.getIdAirportArrival());
                prStatement.setLong(4, allFlights.getFlightTime());

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
            logDAO.trace("Can't Update Data in allFlights", e);
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
