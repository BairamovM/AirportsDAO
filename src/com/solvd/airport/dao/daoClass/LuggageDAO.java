package com.solvd.airport.dao.daoClass;

import com.solvd.airport.dao.entity.Luggage;
import com.solvd.airport.dao.interfaces.ILuggage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class LuggageDAO implements ILuggage {

    private static final Logger logDAO = Logger.getLogger(LuggageDAO.class);

    public static final String getId = "SELECT * FROM Luggage WHERE id = ?";
    public static final String getAll = "SELECT * FROM Luggage";
    public static final String save = "INSERT INTO Luggage VALUES (?,?,?,?)";
    public static final String delete = "DELETE FROM Luggage WHERE id =?";
    public static final String update = "UPDATE Luggage SET barcode = ?, weight = ?,Passengers_id = ? WHERE id =?";

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
                prStatement = connection.prepareStatement(getId);
                prStatement.setLong(1, id);
                try {
                    logDAO.trace("Get ResultSet");
                    rSet = prStatement.executeQuery();
                    if (rSet.next()) {
                        luggage = new Luggage();
                        luggage.setId(rSet.getLong("id"));
                        luggage.setBarcode(rSet.getLong("barcode"));
                        luggage.setWeight(rSet.getLong("weight"));
                        luggage.setPassengers_id(rSet.getLong("Passengers_id"));
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
    public List<Luggage> getAll() {

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
                prStatement = connection.prepareStatement(getAll);
                try {
                    logDAO.trace("Get ResultSet");
                    rSet = prStatement.executeQuery();
                    List<Luggage> luggag = new ArrayList<>();
                    while (rSet.next()) {
                        luggage = new Luggage();
                        luggage.setId(rSet.getLong("id"));
                        luggage.setBarcode(rSet.getLong("barcode"));
                        luggage.setWeight(rSet.getLong("weight"));
                        luggage.setPassengers_id(rSet.getLong("Passengers_id"));
                        luggag.add(luggage);

                    }
                    return luggag;
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
    public void save(Luggage luggage) {

        logDAO.trace("Update Data in luggage");
        Connection connection = null;
        PreparedStatement prStatement = null;

        try {
            logDAO.trace("Open Connection");
            connection = ConnectionFactory.getConnection();
            try {
                logDAO.trace("Create PreparedStatement");
                prStatement = connection.prepareStatement(save);

                prStatement.setLong(1, luggage.getBarcode());
                prStatement.setLong(2, luggage.getWeight());
                prStatement.setLong(3, luggage.getPassengers_id());

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
                prStatement = connection.prepareStatement(update);
                prStatement.setLong(1, luggage.getBarcode());
                prStatement.setLong(2, luggage.getWeight());
                prStatement.setLong(3, luggage.getPassengers_id());


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
