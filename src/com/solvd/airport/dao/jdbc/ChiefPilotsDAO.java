package com.solvd.airport.dao.jdbc;

import com.solvd.airport.entity.ChiefPilots;
import com.solvd.airport.dao.IChiefPilots;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class ChiefPilotsDAO implements IChiefPilots {

    private static final Logger logDAO = Logger.getLogger(ChiefPilotsDAO.class);

    public static final String getId = "SELECT * FROM ChiefPilots WHERE id = ?";
    public static final String getAll = "SELECT * FROM ChiefPilots";
    public static final String save = "INSERT INTO ChiefPilots VALUES (?,?,?,?)";
    public static final String delete = "DELETE FROM ChiefPilots WHERE id =?";
    public static final String update = "UPDATE ChiefPilots SET firstName = ?, lastName = ?, " +
            "experience = ?, passportSerialNumber = ?, Nationalities_id = ? WHERE id =?";

    @Override
    public ChiefPilots getByID(Long id) {

        logDAO.trace("Try to find ChiefPilots with id = " + id);

        ChiefPilots chiefPilots = null;
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
                        chiefPilots = new ChiefPilots();
                        chiefPilots.setId(rSet.getLong("id"));
                        chiefPilots.setFirstName(rSet.getString("firstName"));
                        chiefPilots.setLastName(rSet.getString("lastName"));
                        chiefPilots.setExperience(rSet.getLong("experience"));
                        chiefPilots.setPassportSerialNumber(rSet.getDouble("passportSerialNumber"));
                        chiefPilots.setNationalities_id(rSet.getLong("Nationalities_id"));
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
    public List<ChiefPilots> getAll() {

        logDAO.trace("Try to find all chiefPilots");
        ChiefPilots chiefPilots = null;
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
                    List<ChiefPilots> chiefPilot = new ArrayList<>();
                    while (rSet.next()) {
                        chiefPilots = new ChiefPilots();
                        chiefPilots.setId(rSet.getLong("id"));
                        chiefPilots.setFirstName(rSet.getString("firstName"));
                        chiefPilots.setLastName(rSet.getString("lastName"));
                        chiefPilots.setExperience(rSet.getLong("experience"));
                        chiefPilots.setPassportSerialNumber(rSet.getDouble("passportSerialNumber"));
                        chiefPilots.setNationalities_id(rSet.getLong("Nationalities_id"));
                        chiefPilot.add(chiefPilots);

                    }
                    return chiefPilot;
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
    public void save(ChiefPilots chiefPilots) {

        logDAO.trace("Update Data in chiefPilots");
        Connection connection = null;
        PreparedStatement prStatement = null;

        try {
            logDAO.trace("Open Connection");
            connection = ConnectionFactory.getConnection();
            try {
                logDAO.trace("Create PreparedStatement");
                prStatement = connection.prepareStatement(save);

                prStatement.setString(1, chiefPilots.getFirstName());
                prStatement.setString(2, chiefPilots.getLastName());
                prStatement.setLong(3, chiefPilots.getExperience());
                prStatement.setDouble(4, chiefPilots.getPassportSerialNumber());
                prStatement.setLong(5, chiefPilots.getNationalities_id());

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
    public void update(ChiefPilots chiefPilots) {

        logDAO.trace("Update Data in chiefPilots");
        Connection connection = null;
        PreparedStatement prStatement = null;

        try {
            logDAO.trace("Open Connection");
            connection = ConnectionFactory.getConnection();
            try {
                logDAO.trace("Create PreparedStatement");
                prStatement = connection.prepareStatement(update);
                prStatement.setString(1, chiefPilots.getFirstName());
                prStatement.setString(2, chiefPilots.getLastName());
                prStatement.setLong(3, chiefPilots.getExperience());
                prStatement.setDouble(4, chiefPilots.getPassportSerialNumber());
                prStatement.setLong(5, chiefPilots.getNationalities_id());

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
