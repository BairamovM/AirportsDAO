package com.solvd.airport.dao.jdbc;

import com.solvd.airport.entity.Stewardesse;
import com.solvd.airport.dao.IStewardesse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class StewardesseDAO implements IStewardesse {

    private static final Logger logDAO = Logger.getLogger(StewardesseDAO.class);

    public static final String getId = "SELECT * FROM Stewardesses WHERE id = ?";
    public static final String getAll = "SELECT * FROM Stewardesses";
    public static final String save = "INSERT INTO Stewardesses VALUES (?,?,?,?)";
    public static final String delete = "DELETE FROM Stewardesses WHERE id =?";
    public static final String update = "UPDATE Stewardesses SET firstName = ?, lastName = ?, " +
            "experience = ?, passportSerialNumber = ?, Nationalities_id = ? WHERE id =?";

    @Override
    public Stewardesse getByID(Long id) {

        logDAO.trace("Try to find Stewardesses with id = " + id);

        Stewardesse stewardesses = null;
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
                        stewardesses = new Stewardesse();
                        stewardesses.setId(rSet.getLong("id"));
                        stewardesses.setFirstName(rSet.getString("firstName"));
                        stewardesses.setLastName(rSet.getString("lastName"));
                        stewardesses.setExperience(rSet.getLong("experience"));
                        stewardesses.setPassportSerialNumber(rSet.getDouble("passportSerialNumber"));
                        //stewardesses.setNationality(rSet.getLong("Nationalities_id"));
                        return stewardesses;
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
            logDAO.trace("Can't find stewardesses");
        } finally {
            try {
                connection.close();
                logDAO.trace("Connection closed");
            } catch (SQLException e) {
                logDAO.warn("Can't close Connection", e);
            }
        }

        if (null == stewardesses) {
            logDAO.debug("stewardesses not found");
        } else {
            logDAO.trace("Find stewardesses");
        }

        logDAO.trace("Return stewardesses");
        return stewardesses;
    }

    @Override
    public List<Stewardesse> getAll() {

        logDAO.trace("Try to find all stewardesses");
        Stewardesse stewardesses = null;
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
                    List<Stewardesse> stewardess = new ArrayList<>();
                    while (rSet.next()) {
                        stewardesses = new Stewardesse();
                        stewardesses.setId(rSet.getLong("id"));
                        stewardesses.setFirstName(rSet.getString("firstName"));
                        stewardesses.setLastName(rSet.getString("lastName"));
                        stewardesses.setExperience(rSet.getLong("experience"));
                        stewardesses.setPassportSerialNumber(rSet.getDouble("passportSerialNumber"));
                        //stewardesses.setNationality(rSet.getLong("Nationalities_id"));
                        stewardess.add(stewardesses);

                    }
                    return stewardess;
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
            logDAO.trace("Can't find any stewardesses", e);
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
    public Stewardesse save(Stewardesse stewardesses) {

        logDAO.trace("Update Data in stewardesses");
        Connection connection = null;
        PreparedStatement prStatement = null;

        try {
            logDAO.trace("Open Connection");
            connection = ConnectionFactory.getConnection();
            try {
                logDAO.trace("Create PreparedStatement");
                prStatement = connection.prepareStatement(save);

                prStatement.setString(1, stewardesses.getFirstName());
                prStatement.setString(2, stewardesses.getLastName());
                prStatement.setLong(3, stewardesses.getExperience());
                prStatement.setDouble(4, stewardesses.getPassportSerialNumber());
                //prStatement.setLong(5, stewardesses.getNationality());

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
            logDAO.trace("Can't Updata Data in stewardesses", e);
        } finally {
            try {
                connection.close();
                logDAO.trace("Connection closed");
            } catch (SQLException e) {
                logDAO.warn("Can't close Connection", e);
            }
        }

        return stewardesses;
    }

    @Override
    public void delete(Long id) {

        logDAO.trace("Delete Data from stewardesses");
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
            logDAO.trace("Can't Delete Data in stewardesses");
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
    public void update(Stewardesse stewardesses) {

        logDAO.trace("Update Data in stewardesses");
        Connection connection = null;
        PreparedStatement prStatement = null;

        try {
            logDAO.trace("Open Connection");
            connection = ConnectionFactory.getConnection();
            try {
                logDAO.trace("Create PreparedStatement");
                prStatement = connection.prepareStatement(update);
                prStatement.setString(1, stewardesses.getFirstName());
                prStatement.setString(2, stewardesses.getLastName());
                prStatement.setLong(3, stewardesses.getExperience());
                prStatement.setDouble(4, stewardesses.getPassportSerialNumber());
                //prStatement.setLong(5, stewardesses.getNationality());

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
            logDAO.trace("Can't Update Data in stewardesses", e);
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
