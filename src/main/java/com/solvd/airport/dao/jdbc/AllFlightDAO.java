package com.solvd.airport.dao.jdbc;

import com.solvd.airport.dao.DAO;
import com.solvd.airport.entity.AllFlight;
import com.solvd.airport.dao.IAllFlight;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class AllFlightDAO implements IAllFlight {

    private static final Logger logDAO = Logger.getLogger(AllFlightDAO.class);

    public static final String GET_ID = "SELECT * FROM AllFlights WHERE id = ?";
    public static final String GET_ALL = "SELECT * FROM AllFlights";
    public static final String SAVE = "INSERT INTO AllFlights VALUES (?,?,?,?)";
    public static final String DELETE = "DELETE FROM AllFlights WHERE id =?";
    public static final String UPDATE = "UPDATE AllFlights SET numberFlight = ?, idDepartureAirport = ?, " +
            "idAirportArrival = ?, flightTime = ? WHERE id =?";

    @Override
    public AllFlight getByID(Long id) {

        logDAO.trace("Try to find AllFlights with id = " + id);

        AllFlight allFlights = null;
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
                        allFlights = new AllFlight();
                        allFlights.setId(rSet.getLong("id"));
                        allFlights.setNumberFlight(rSet.getDouble("numberFlight"));
                        //allFlights.setIdDepartureAirport(rSet.getLong("idDepartureAirport"));
                        //allFlights.setIdAirportArrival(rSet.getLong("idAirportArrival"));
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
    public AllFlight getAll() {

        logDAO.trace("Try to find all Airplanes");
        AllFlight allFlights = null;
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
                    List<AllFlight> allFlight = new ArrayList<>();
                    while (rSet.next()) {
                        allFlights = new AllFlight();
                        allFlights.setId(rSet.getLong("id"));
                        allFlights.setNumberFlight(rSet.getDouble("numberFlight"));
                        //allFlights.setIdDepartureAirport(rSet.getLong("idDepartureAirport"));
                        //allFlights.setIdAirportArrival(rSet.getLong("idAirportArrival"));
                        allFlights.setFlightTime(rSet.getLong("flightTime"));
                        allFlight.add(allFlights);

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
    public AllFlight save(AllFlight allFlights) {

        logDAO.trace("Update Data in allFlights");
        Connection connection = null;
        PreparedStatement prStatement = null;

        try {
            logDAO.trace("Open Connection");
            connection = ConnectionFactory.getConnection();
            try {
                logDAO.trace("Create PreparedStatement");
                prStatement = connection.prepareStatement(SAVE);

                prStatement.setDouble(1, allFlights.getNumberFlight());
                //prStatement.setLong(2, allFlights.getIdDepartureAirport());
                //prStatement.setLong(3, allFlights.getIdAirportArrival());
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

        return allFlights;
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
    public void update(AllFlight allFlights) {

        logDAO.trace("Update Data in allFlights");
        Connection connection = null;
        PreparedStatement prStatement = null;

        try {
            logDAO.trace("Open Connection");
            connection = ConnectionFactory.getConnection();
            try {
                logDAO.trace("Create PreparedStatement");
                prStatement = connection.prepareStatement(UPDATE);
                prStatement.setDouble(1, allFlights.getNumberFlight());
                //prStatement.setLong(2, allFlights.getIdDepartureAirport());
                //prStatement.setLong(3, allFlights.getIdAirportArrival());
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
