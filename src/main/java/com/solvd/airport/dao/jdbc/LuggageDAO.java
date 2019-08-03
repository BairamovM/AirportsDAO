package com.solvd.airport.dao.jdbc;

import com.solvd.airport.dao.DAO;
import com.solvd.airport.entity.Luggage;
import com.solvd.airport.dao.ILuggage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class LuggageDAO implements ILuggage {

    private static final Logger logDAO = Logger.getLogger(LuggageDAO.class);

    public static final String GET_ID = "SELECT * FROM Luggage WHERE id = ?";
    public static final String GET_ALL = "SELECT * FROM Luggage";
    public static final String SAVE = "INSERT INTO Luggage VALUES (?,?,?,?)";
    public static final String DELETE = "DELETE FROM Luggage WHERE id =?";
    public static final String UPDATE = "UPDATE Luggage SET barcode = ?, weight = ?,Passengers_id = ? WHERE id =?";

    @Override
    public Luggage getByID(Long id) {

        logDAO.trace("Try to find Luggage with id = " + id);

        Luggage luggage = null;
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
                        luggage = new Luggage();
                        luggage.setId(rSet.getLong("id"));
                        luggage.setBarcode(rSet.getLong("barcode"));
                        luggage.setWeight(rSet.getLong("weight"));
                        luggage.setPassenger(rSet.getLong("Passengers_id"));
                        return luggage;
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
            logDAO.trace("Can't find luggage");
        } finally {
            try {
                connection.close();
                logDAO.trace("Connection closed");
            } catch (SQLException e) {
                logDAO.warn("Can't close Connection", e);
            }
        }

        if (null == luggage) {
            logDAO.debug("luggage not found");
        } else {
            logDAO.trace("Find luggage");
        }

        logDAO.trace("Return luggage");
        return luggage;
    }

    @Override
    public Luggage getAll() {

        logDAO.trace("Try to find all luggage");
        Luggage luggage = null;
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
                    List<Luggage> luggag = new ArrayList<>();
                    while (rSet.next()) {
                        luggage = new Luggage();
                        luggage.setId(rSet.getLong("id"));
                        luggage.setBarcode(rSet.getLong("barcode"));
                        luggage.setWeight(rSet.getLong("weight"));
                        luggage.setPassenger(rSet.getLong("Passengers_id"));
                        luggag.add(luggage);

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
            logDAO.trace("Can't find any luggage", e);
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
    public Luggage save(Luggage luggage) {

        logDAO.trace("Update Data in luggage");
        Connection connection = null;
        PreparedStatement prStatement = null;

        try {
            logDAO.trace("Open Connection");
            connection = ConnectionFactory.getConnection();
            try {
                logDAO.trace("Create PreparedStatement");
                prStatement = connection.prepareStatement(SAVE);

                prStatement.setLong(1, luggage.getBarcode());
                prStatement.setLong(2, luggage.getWeight());
                prStatement.setLong(3, luggage.getPassenger());

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
            logDAO.trace("Can't Updata Data in luggage", e);
        } finally {
            try {
                connection.close();
                logDAO.trace("Connection closed");
            } catch (SQLException e) {
                logDAO.warn("Can't close Connection", e);
            }
        }

        return luggage;
    }

    @Override
    public void delete(Long id) {

        logDAO.trace("Delete Data from luggage");
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
            logDAO.trace("Can't Delete Data in luggage");
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
    public void update(Luggage luggage) {

        logDAO.trace("Update Data in luggage");
        Connection connection = null;
        PreparedStatement prStatement = null;

        try {
            logDAO.trace("Open Connection");
            connection = ConnectionFactory.getConnection();
            try {
                logDAO.trace("Create PreparedStatement");
                prStatement = connection.prepareStatement(UPDATE);
                prStatement.setLong(1, luggage.getBarcode());
                prStatement.setLong(2, luggage.getWeight());
                prStatement.setLong(3, luggage.getPassenger());


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
            logDAO.trace("Can't Update Data in luggage", e);
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
