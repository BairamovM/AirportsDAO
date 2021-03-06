package com.solvd.airport.dao.jdbc;

import com.solvd.airport.entity.SeatFlight;
import com.solvd.airport.dao.ISeatFlight;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class SeatFlightDAO implements ISeatFlight {

    private static final Logger logDAO = Logger.getLogger(SeatFlightDAO.class);

    public static final String GET_ID = "SELECT * FROM SeatsFlight WHERE id = ?";
    public static final String GET_ALL = "SELECT * FROM SeatsFlight";
    public static final String SAVE = "INSERT INTO SeatsFlight VALUES (?,?,?,?)";
    public static final String DELETE = "DELETE FROM SeatsFlight WHERE id =?";
    public static final String UPDATE = "UPDATE SeatsFlight SET numberSeet = ?, " +
            "ticketPrice = ?, Airplanes_id = ?, Passengers_id = ?, ClassSeets_id = ? WHERE id =?";

    @Override
    public SeatFlight getByID(Long id) {

        logDAO.trace("Try to find SeatsFlight with id = " + id);

        SeatFlight seatsFlight = null;
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
                        seatsFlight = new SeatFlight();
                        seatsFlight.setId(rSet.getLong("id"));
                        seatsFlight.setNumberSeet(rSet.getLong("numberSeet"));
                        seatsFlight.setTicketPrice(rSet.getLong("ticketPrice"));
                        seatsFlight.setId(rSet.getLong("Airplanes_id"));
                        seatsFlight.setId(rSet.getLong("Passengers_id"));
                        seatsFlight.setId(rSet.getLong("ClassSeets_id"));
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
    public SeatFlight getAll() {

        logDAO.trace("Try to find all seatsFlight");
        SeatFlight seatsFlight = null;
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
                    List<SeatFlight> seatFlight = new ArrayList<>();
                    while (rSet.next()) {
                        seatsFlight = new SeatFlight();
                        seatsFlight.setId(rSet.getLong("id"));
                        seatsFlight.setNumberSeet(rSet.getLong("numberSeet"));
                        seatsFlight.setTicketPrice(rSet.getLong("ticketPrice"));
                        seatsFlight.setId(rSet.getLong("Airplanes_id"));
                        seatsFlight.setId(rSet.getLong("Passengers_id"));
                        seatsFlight.setId(rSet.getLong("ClassSeets_id"));
                        seatFlight.add(seatsFlight);

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
    public SeatFlight save(SeatFlight seatsFlight) {

        logDAO.trace("Update Data in seatsFlight");
        Connection connection = null;
        PreparedStatement prStatement = null;

        try {
            logDAO.trace("Open Connection");
            connection = ConnectionFactory.getConnection();
            try {
                logDAO.trace("Create PreparedStatement");
                prStatement = connection.prepareStatement(SAVE);

                prStatement.setLong(1, seatsFlight.getNumberSeet());
                prStatement.setLong(2, seatsFlight.getTicketPrice());
                prStatement.setLong(3, seatsFlight.getId());
                prStatement.setLong(4, seatsFlight.getId());
                prStatement.setLong(5, seatsFlight.getId());

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

        return seatsFlight;
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
    public void update(SeatFlight seatsFlight) {

        logDAO.trace("Update Data in seatsFlight");
        Connection connection = null;
        PreparedStatement prStatement = null;

        try {
            logDAO.trace("Open Connection");
            connection = ConnectionFactory.getConnection();
            try {
                logDAO.trace("Create PreparedStatement");
                prStatement = connection.prepareStatement(UPDATE);
                prStatement.setLong(1, seatsFlight.getNumberSeet());
                prStatement.setLong(2, seatsFlight.getTicketPrice());
                prStatement.setLong(3, seatsFlight.getId());
                prStatement.setLong(4, seatsFlight.getId());
                prStatement.setLong(5, seatsFlight.getId());

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
