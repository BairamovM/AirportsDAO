package com.solvd.airport.dao.jdbc;

import com.solvd.airport.entity.ChiefPilot;
import com.solvd.airport.dao.IChiefPilot;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class ChiefPilotDAO implements IChiefPilot {

    private static final Logger logDAO = Logger.getLogger(ChiefPilotDAO.class);

    public static final String GET_ID = "SELECT * FROM ChiefPilots WHERE id = ?";
    public static final String GET_ALL = "SELECT * FROM ChiefPilots";
    public static final String SAVE = "INSERT INTO ChiefPilots VALUES (?,?,?,?)";
    public static final String DELETE = "DELETE FROM ChiefPilots WHERE id =?";
    public static final String UPDATE = "UPDATE ChiefPilots SET firstName = ?, lastName = ?, " +
            "experience = ?, passportSerialNumber = ?, Nationalities_id = ? WHERE id =?";

    @Override
    public ChiefPilot getByID(Long id) {

        logDAO.trace("Try to find ChiefPilots with id = " + id);

        ChiefPilot chiefPilots = null;
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
                        chiefPilots = new ChiefPilot();
                        chiefPilots.setId(rSet.getInt("id"));
                        chiefPilots.setFirstName(rSet.getString("firstName"));
                        chiefPilots.setLastName(rSet.getString("lastName"));
                        chiefPilots.setExperience(rSet.getInt("experience"));
                        chiefPilots.setPassportSerialNumber(rSet.getInt("passportSerialNumber"));
                        chiefPilots.setId(rSet.getInt("Nationalities_id"));
                        return chiefPilots;
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
            logDAO.trace("Can't find chiefPilots");
        } finally {
            try {
                connection.close();
                logDAO.trace("Connection closed");
            } catch (SQLException e) {
                logDAO.warn("Can't close Connection", e);
            }
        }

        if (null == chiefPilots) {
            logDAO.debug("chiefPilots not found");
        } else {
            logDAO.trace("Find chiefPilots");
        }

        logDAO.trace("Return chiefPilots");
        return chiefPilots;
    }

    @Override
    public ChiefPilot getAll() {

        logDAO.trace("Try to find all chiefPilots");
        ChiefPilot chiefPilots = null;
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
                    List<ChiefPilot> chiefPilot = new ArrayList<>();
                    while (rSet.next()) {
                        chiefPilots = new ChiefPilot();
                        chiefPilots.setId(rSet.getInt("id"));
                        chiefPilots.setFirstName(rSet.getString("firstName"));
                        chiefPilots.setLastName(rSet.getString("lastName"));
                        chiefPilots.setExperience(rSet.getInt("experience"));
                        chiefPilots.setPassportSerialNumber(rSet.getInt("passportSerialNumber"));
                        chiefPilots.setId(rSet.getInt("Nationalities_id"));
                        chiefPilot.add(chiefPilots);

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
            logDAO.trace("Can't find any chiefPilots", e);
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
    public ChiefPilot save(ChiefPilot chiefPilots) {

        logDAO.trace("Update Data in chiefPilots");
        Connection connection = null;
        PreparedStatement prStatement = null;

        try {
            logDAO.trace("Open Connection");
            connection = ConnectionFactory.getConnection();
            try {
                logDAO.trace("Create PreparedStatement");
                prStatement = connection.prepareStatement(SAVE);

                prStatement.setString(1, chiefPilots.getFirstName());
                prStatement.setString(2, chiefPilots.getLastName());
                prStatement.setLong(3, chiefPilots.getExperience());
                prStatement.setDouble(4, chiefPilots.getPassportSerialNumber());
                prStatement.setLong(5, chiefPilots.getId());

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
            logDAO.trace("Can't Updata Data in chiefPilots", e);
        } finally {
            try {
                connection.close();
                logDAO.trace("Connection closed");
            } catch (SQLException e) {
                logDAO.warn("Can't close Connection", e);
            }
        }

        return chiefPilots;
    }

    @Override
    public void delete(Long id) {

        logDAO.trace("Delete Data from chiefPilots");
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
            logDAO.trace("Can't Delete Data in chiefPilots");
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
    public void update(ChiefPilot chiefPilots) {

        logDAO.trace("Update Data in chiefPilots");
        Connection connection = null;
        PreparedStatement prStatement = null;

        try {
            logDAO.trace("Open Connection");
            connection = ConnectionFactory.getConnection();
            try {
                logDAO.trace("Create PreparedStatement");
                prStatement = connection.prepareStatement(UPDATE);
                prStatement.setString(1, chiefPilots.getFirstName());
                prStatement.setString(2, chiefPilots.getLastName());
                prStatement.setLong(3, chiefPilots.getExperience());
                prStatement.setDouble(4, chiefPilots.getPassportSerialNumber());
                prStatement.setLong(5, chiefPilots.getId());

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
            logDAO.trace("Can't Update Data in chiefPilots", e);
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
