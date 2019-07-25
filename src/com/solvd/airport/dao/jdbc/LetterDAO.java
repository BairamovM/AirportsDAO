package com.solvd.airport.dao.jdbc;

import com.solvd.airport.entity.Letter;
import com.solvd.airport.dao.ILetter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class LetterDAO implements ILetter {

    private static final Logger logDAO = Logger.getLogger(LetterDAO.class);

    public static final String getId = "SELECT * FROM Letters WHERE id = ?";
    public static final String getAll = "SELECT * FROM Letters";
    public static final String save = "INSERT INTO Letters VALUES (?,?,?,?)";
    public static final String delete = "DELETE FROM Letters WHERE id =?";
    public static final String update = "UPDATE Letters SET sender = ?, receiver = ?, " +
            "senderAddress = ?, receiverAddress = ?, weight = ?, Departures_id = ? WHERE id =?";

    @Override
    public Letter getByID(Long id) {

        logDAO.trace("Try to find Letters with id = " + id);

        Letter letters = null;
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
                        letters = new Letter();
                        letters.setId(rSet.getLong("id"));
                        letters.setSender(rSet.getString("sender"));
                        letters.setReceiver(rSet.getString("receiver"));
                        letters.setSenderAddress(rSet.getString("senderAddress"));
                        letters.setReceiverAddress(rSet.getString("receiverAddress"));
                        letters.setWeight(rSet.getLong("weight"));
                        //letters.setDeparture(rSet.getLong("Departures_id"));
                        return letters;
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
            logDAO.trace("Can't find letters");
        } finally {
            try {
                connection.close();
                logDAO.trace("Connection closed");
            } catch (SQLException e) {
                logDAO.warn("Can't close Connection", e);
            }
        }

        if (null == letters) {
            logDAO.debug("letters not found");
        } else {
            logDAO.trace("Find letters");
        }

        logDAO.trace("Return letters");
        return letters;
    }

    @Override
    public List<Letter> getAll() {

        logDAO.trace("Try to find all letters");
        Letter letters = null;
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
                    List<Letter> letter = new ArrayList<>();
                    while (rSet.next()) {
                        letters = new Letter();
                        letters.setId(rSet.getLong("id"));
                        letters.setSender(rSet.getString("sender"));
                        letters.setReceiver(rSet.getString("receiver"));
                        letters.setSenderAddress(rSet.getString("senderAddress"));
                        letters.setReceiverAddress(rSet.getString("receiverAddress"));
                        letters.setWeight(rSet.getLong("weight"));
                        //letters.setDeparture(rSet.getLong("Departures_id"));
                        letter.add(letters);

                    }
                    return letter;
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
            logDAO.trace("Can't find any letters", e);
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
    public void save(Letter letters) {

        logDAO.trace("Update Data in letters");
        Connection connection = null;
        PreparedStatement prStatement = null;

        try {
            logDAO.trace("Open Connection");
            connection = ConnectionFactory.getConnection();
            try {
                logDAO.trace("Create PreparedStatement");
                prStatement = connection.prepareStatement(save);

                prStatement.setString(1, letters.getSender());
                prStatement.setString(2, letters.getReceiver());
                prStatement.setString(3, letters.getSenderAddress());
                prStatement.setString(4, letters.getReceiverAddress());
                prStatement.setLong(5, letters.getWeight());
                //prStatement.setLong(6, letters.getDeparture());

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
            logDAO.trace("Can't Updata Data in letters", e);
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

        logDAO.trace("Delete Data from letters");
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
            logDAO.trace("Can't Delete Data in letters");
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
    public void update(Letter letters) {

        logDAO.trace("Update Data in letters");
        Connection connection = null;
        PreparedStatement prStatement = null;

        try {
            logDAO.trace("Open Connection");
            connection = ConnectionFactory.getConnection();
            try {
                logDAO.trace("Create PreparedStatement");
                prStatement = connection.prepareStatement(update);
                prStatement.setString(1, letters.getSender());
                prStatement.setString(2, letters.getReceiver());
                prStatement.setString(3, letters.getSenderAddress());
                prStatement.setString(4, letters.getReceiverAddress());
                prStatement.setLong(5, letters.getWeight());
                //prStatement.setLong(6, letters.getDeparture());

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
            logDAO.trace("Can't Update Data in letters", e);
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
