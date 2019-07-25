package com.solvd.airport.dao.jdbc;

import com.solvd.airport.entity.Departure;
import com.solvd.airport.dao.IDeparture;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class DepartureDAO  implements IDeparture {

    private static final Logger logDAO = Logger.getLogger(DepartureDAO.class);

    public static final String getId = "SELECT * FROM Departures WHERE id = ?";
    public static final String getAll = "SELECT * FROM Departures";
    public static final String save = "INSERT INTO Departures VALUES (?,?,?,?)";
    public static final String delete = "DELETE FROM Departures WHERE id =?";
    public static final String update = "UPDATE Departures SET departureDate = ?, Airplanes_id = ?,AllFlights_id = ? " +
            "WHERE id =?";

    @Override
    public Departure getByID(Long id) {

        logDAO.trace("Try to find Departures with id = " + id);

        Departure departures = null;
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
                        departures = new Departure();
                        departures.setId(rSet.getLong("id"));
                        departures.setDepartureDate(rSet.getString("departureDate"));
                        departures.setAirplanes_id(rSet.getLong("Airplanes_id"));
                        departures.setAllFlights_id(rSet.getLong("AllFlights_id"));
                        return departures;
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
            logDAO.trace("Can't find departures");
        } finally {
            try {
                connection.close();
                logDAO.trace("Connection closed");
            } catch (SQLException e) {
                logDAO.warn("Can't close Connection", e);
            }
        }

        if (null == departures) {
            logDAO.debug("departures not found");
        } else {
            logDAO.trace("Find departures");
        }

        logDAO.trace("Return departures");
        return departures;
    }

    @Override
    public List<Departure> getAll() {

        logDAO.trace("Try to find all departures");
        Departure departures = null;
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
                    List<Departure> departure = new ArrayList<>();
                    while (rSet.next()) {
                        departures = new Departure();
                        departures.setId(rSet.getLong("id"));
                        departures.setDepartureDate(rSet.getString("departureDate"));
                        departures.setAirplanes_id(rSet.getLong("Airplanes_id"));
                        departures.setAllFlights_id(rSet.getLong("AllFlights_id"));
                        departure.add(departures);

                    }
                    return departure;
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
            logDAO.trace("Can't find any departures", e);
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
    public void save(Departure departures) {

        logDAO.trace("Update Data in departures");
        Connection connection = null;
        PreparedStatement prStatement = null;

        try {
            logDAO.trace("Open Connection");
            connection = ConnectionFactory.getConnection();
            try {
                logDAO.trace("Create PreparedStatement");
                prStatement = connection.prepareStatement(save);

                prStatement.setString(1, departures.getDepartureDate());
                prStatement.setLong(2, departures.getAirplanes_id());
                prStatement.setLong(3, departures.getAllFlights_id());

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
            logDAO.trace("Can't Updata Data in departures", e);
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

        logDAO.trace("Delete Data from departures");
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
            logDAO.trace("Can't Delete Data in departures");
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
    public void update(Departure departures) {

        logDAO.trace("Update Data in departures");
        Connection connection = null;
        PreparedStatement prStatement = null;

        try {
            logDAO.trace("Open Connection");
            connection = ConnectionFactory.getConnection();
            try {
                logDAO.trace("Create PreparedStatement");
                prStatement = connection.prepareStatement(update);
                prStatement.setString(1, departures.getDepartureDate());
                prStatement.setLong(2, departures.getAirplanes_id());
                prStatement.setLong(3, departures.getAllFlights_id());

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
            logDAO.trace("Can't Update Data in departures", e);
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
