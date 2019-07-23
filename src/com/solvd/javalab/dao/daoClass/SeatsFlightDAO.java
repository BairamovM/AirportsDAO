package com.solvd.javalab.dao.daoClass;

import com.solvd.javalab.dao.entity.SeatsFlight;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class SeatsFlightDAO implements DAO <SeatsFlight> {

    private static final Logger logDAO = Logger.getLogger(SeatsFlightDAO.class);

    public static final String getId = "SELECT * FROM SeatsFlight WHERE id = ?";
    public static final String getAll = "SELECT * FROM SeatsFlight";
    public static final String save = "INSERT INTO SeatsFlight VALUES (?,?,?,?)";
    public static final String delete = "DELETE FROM SeatsFlight WHERE id =?";
    public static final String update = "UPDATE SeatsFlight SET numberSeet = ?, " +
            "ticketPrice = ?, Airplanes_id = ?, Passengers_id = ?, ClassSeets_id = ? WHERE id =?";

    @Override
    public SeatsFlight getByID(Long id) {

        logDAO.trace("Try to find SeatsFlight with id = " + id);

        SeatsFlight seatsFlight = null;
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
                        seatsFlight = new SeatsFlight();
                        seatsFlight.setId(rSet.getLong("id"));
                        seatsFlight.setNumberSeet(rSet.getLong("numberSeet"));
                        seatsFlight.setTicketPrice(rSet.getLong("ticketPrice"));
                        seatsFlight.setAirplanes_id(rSet.getLong("Airplanes_id"));
                        seatsFlight.setPassengers_id(rSet.getLong("Passengers_id"));
                        seatsFlight.setClassSeets_id(rSet.getLong("ClassSeets_id"));
                        return seatsFlight;
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
            logDAO.trace("Can't find seatsFlight");
        } finally {
            try {
                connection.close();
                logDAO.trace("Connection closed");
            } catch (SQLException e) {
                logDAO.warn("Can't close Connection", e);
            }
        }

        if (null == seatsFlight) {
            logDAO.debug("seatsFlight not found");
        } else {
            logDAO.trace("Find seatsFlight");
        }

        logDAO.trace("Return seatsFlight");
        return seatsFlight;
    }

    @Override
    public List<SeatsFlight> getAll() {

        logDAO.trace("Try to find all seatsFlight");
        SeatsFlight seatsFlight = null;
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
                    List<SeatsFlight> seatFlight = new ArrayList<>();
                    while (rSet.next()) {
                        seatsFlight = new SeatsFlight();
                        seatsFlight.setId(rSet.getLong("id"));
                        seatsFlight.setNumberSeet(rSet.getLong("numberSeet"));
                        seatsFlight.setTicketPrice(rSet.getLong("ticketPrice"));
                        seatsFlight.setAirplanes_id(rSet.getLong("Airplanes_id"));
                        seatsFlight.setPassengers_id(rSet.getLong("Passengers_id"));
                        seatsFlight.setClassSeets_id(rSet.getLong("ClassSeets_id"));
                        seatFlight.add(seatsFlight);

                    }
                    return seatFlight;
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
            logDAO.trace("Can't find any seatsFlight", e);
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
    public void save(SeatsFlight seatsFlight) {

        logDAO.trace("Update Data in seatsFlight");
        Connection connection = null;
        PreparedStatement prStatement = null;

        try {
            logDAO.trace("Open Connection");
            connection = ConnectionFactory.getConnection();
            try {
                logDAO.trace("Create PreparedStatement");
                prStatement = connection.prepareStatement(save);

                prStatement.setLong(1, seatsFlight.getNumberSeet());
                prStatement.setLong(2, seatsFlight.getTicketPrice());
                prStatement.setLong(3, seatsFlight.getAirplanes_id());
                prStatement.setLong(4, seatsFlight.getPassengers_id());
                prStatement.setLong(5, seatsFlight.getClassSeets_id());

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
            logDAO.trace("Can't Updata Data in seatsFlight", e);
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

        logDAO.trace("Delete Data from seatsFlight");
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
            logDAO.trace("Can't Delete Data in seatsFlight");
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
    public void update(SeatsFlight seatsFlight) {

        logDAO.trace("Update Data in seatsFlight");
        Connection connection = null;
        PreparedStatement prStatement = null;

        try {
            logDAO.trace("Open Connection");
            connection = ConnectionFactory.getConnection();
            try {
                logDAO.trace("Create PreparedStatement");
                prStatement = connection.prepareStatement(update);
                prStatement.setLong(1, seatsFlight.getNumberSeet());
                prStatement.setLong(2, seatsFlight.getTicketPrice());
                prStatement.setLong(3, seatsFlight.getAirplanes_id());
                prStatement.setLong(4, seatsFlight.getPassengers_id());
                prStatement.setLong(5, seatsFlight.getClassSeets_id());

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
            logDAO.trace("Can't Update Data in seatsFlight", e);
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