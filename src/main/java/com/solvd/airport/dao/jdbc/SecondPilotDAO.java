package com.solvd.airport.dao.jdbc;

import com.solvd.airport.entity.SecondPilot;
import com.solvd.airport.dao.ISecondPilot;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class SecondPilotDAO implements ISecondPilot {

    private static final Logger logDAO = Logger.getLogger(SecondPilotDAO.class);

    public static final String GET_ID = "SELECT * FROM SecondPilots WHERE id = ?";
    public static final String GET_ALL = "SELECT * FROM SecondPilots";
    public static final String SAVE = "INSERT INTO SecondPilots VALUES (?,?,?,?)";
    public static final String DELETE = "DELETE FROM SecondPilots WHERE id =?";
    public static final String UPDATE = "UPDATE SecondPilots SET firstName = ?, lastName = ?, " +
            "experience = ?, passportSerialNumber = ?, Nationalities_id = ? WHERE id =?";

    @Override
    public SecondPilot getByID(Long id) {

        logDAO.trace("Try to find SecondPilots with id = " + id);

        SecondPilot secondPilots = null;
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
                        secondPilots = new SecondPilot();
                        secondPilots.setId(rSet.getLong("id"));
                        secondPilots.setFirstName(rSet.getString("firstName"));
                        secondPilots.setLastName(rSet.getString("lastName"));
                        secondPilots.setExperience(rSet.getLong("experience"));
                        secondPilots.setPassportSerialNumber(rSet.getDouble("passportSerialNumber"));
                        //secondPilots.setNationality(rSet.getLong("Nationalities_id"));
                        return secondPilots;
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
            logDAO.trace("Can't find secondPilots");
        } finally {
            try {
                connection.close();
                logDAO.trace("Connection closed");
            } catch (SQLException e) {
                logDAO.warn("Can't close Connection", e);
            }
        }

        if (null == secondPilots) {
            logDAO.debug("secondPilots not found");
        } else {
            logDAO.trace("Find secondPilots");
        }

        logDAO.trace("Return secondPilots");
        return secondPilots;
    }

    @Override
    public List<SecondPilot> getAll() {

        logDAO.trace("Try to find all secondPilots");
        SecondPilot secondPilots = null;
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
                    List<SecondPilot> secondPilot = new ArrayList<>();
                    while (rSet.next()) {
                        secondPilots = new SecondPilot();
                        secondPilots.setId(rSet.getLong("id"));
                        secondPilots.setFirstName(rSet.getString("firstName"));
                        secondPilots.setLastName(rSet.getString("lastName"));
                        secondPilots.setExperience(rSet.getLong("experience"));
                        secondPilots.setPassportSerialNumber(rSet.getDouble("passportSerialNumber"));
                        //secondPilots.setNationality(rSet.getLong("Nationalities_id"));
                        secondPilot.add(secondPilots);

                    }
                    return secondPilot;
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
            logDAO.trace("Can't find any secondPilots", e);
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
    public SecondPilot save(SecondPilot secondPilots) {

        logDAO.trace("Update Data in secondPilots");
        Connection connection = null;
        PreparedStatement prStatement = null;

        try {
            logDAO.trace("Open Connection");
            connection = ConnectionFactory.getConnection();
            try {
                logDAO.trace("Create PreparedStatement");
                prStatement = connection.prepareStatement(SAVE);

                prStatement.setString(1, secondPilots.getFirstName());
                prStatement.setString(2, secondPilots.getLastName());
                prStatement.setLong(3, secondPilots.getExperience());
                prStatement.setDouble(4, secondPilots.getPassportSerialNumber());
                //prStatement.setLong(5, secondPilots.getNationality());

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
            logDAO.trace("Can't Updata Data in secondPilots", e);
        } finally {
            try {
                connection.close();
                logDAO.trace("Connection closed");
            } catch (SQLException e) {
                logDAO.warn("Can't close Connection", e);
            }
        }

        return secondPilots;
    }

    @Override
    public void delete(Long id) {

        logDAO.trace("Delete Data from secondPilots");
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
            logDAO.trace("Can't Delete Data in secondPilots");
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
    public void update(SecondPilot secondPilots) {

        logDAO.trace("Update Data in secondPilots");
        Connection connection = null;
        PreparedStatement prStatement = null;

        try {
            logDAO.trace("Open Connection");
            connection = ConnectionFactory.getConnection();
            try {
                logDAO.trace("Create PreparedStatement");
                prStatement = connection.prepareStatement(UPDATE);
                prStatement.setString(1, secondPilots.getFirstName());
                prStatement.setString(2, secondPilots.getLastName());
                prStatement.setLong(3, secondPilots.getExperience());
                prStatement.setDouble(4, secondPilots.getPassportSerialNumber());
                //prStatement.setLong(5, secondPilots.getNationality());

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
            logDAO.trace("Can't Update Data in secondPilots", e);
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
