package com.solvd.airport.dao.jdbc;

import com.solvd.airport.entity.Airplane;
import com.solvd.airport.dao.IAirplane;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class AirplaneDAO implements IAirplane {

    private static final Logger logDAO = Logger.getLogger(AirplaneDAO.class);

    public static final String GET_ID = "SELECT * FROM Airplanes WHERE id = ?";
    public static final String GET_ALL = "SELECT * FROM Airplanes";
    public static final String SAVE = "INSERT INTO Airplanes VALUES (?,?,?,?)";
    public static final String DELETE = "DELETE FROM Airplanes WHERE id =?";
    public static final String UPDATE = "UPDATE Airplanes SET type = ?, numberSeets = ?,rangeFlight = ?, carryingCapacity = ?, Teams_id = ? WHERE id =?";

    @Override
    public Airplane getByID(Long id) {

        logDAO.trace("Try to find Airplane with id = " + id);

        Airplane airplane = null;
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
                        airplane = new Airplane();
                        airplane.setId(rSet.getLong("id"));
                        airplane.setType(rSet.getString("type"));
                        airplane.setNumberSeets(rSet.getInt("numberSeets"));
                        airplane.setRangeFlight(rSet.getInt("rangeFlight"));
                        airplane.setCarryingCapacity(rSet.getInt("carryingCapacity"));
                        airplane.setTeam(rSet.getInt("Team"));
                        return airplane;
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
            logDAO.trace("Can't find Airplane");
        } finally {
            try {
                connection.close();
                logDAO.trace("Connection closed");
            } catch (SQLException e) {
                logDAO.warn("Can't close Connection", e);
            }
        }

        if (null == airplane) {
            logDAO.debug("Airplane not found");
        } else {
            logDAO.trace("Find Airplane");
        }

        logDAO.trace("Return Airplane");
        return airplane;
    }

    @Override
    public Airplane getAll() {

        logDAO.trace("Try to find all Airplanes");
        Airplane airplane = null;
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
                    List<Airplane> airplanes = new ArrayList<>();
                    while (rSet.next()) {
                        airplane = new Airplane();
                        airplane.setId(rSet.getLong("id"));
                        airplane.setType(rSet.getString("type"));
                        airplane.setNumberSeets(rSet.getInt("numberSeets"));
                        airplane.setRangeFlight(rSet.getInt("rangeFlight"));
                        airplane.setCarryingCapacity(rSet.getInt("carryingCapacity"));
                        airplane.setTeam(rSet.getInt("Team"));
                        airplanes.add(airplane);

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
            logDAO.trace("Can't find any Airplanes", e);
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
    public Airplane save(Airplane airplane) {

        logDAO.trace("Update Data in airplane");
        Connection connection = null;
        PreparedStatement prStatement = null;

        try {
            logDAO.trace("Open Connection");
            connection = ConnectionFactory.getConnection();
            try {
                logDAO.trace("Create PreparedStatement");
                prStatement = connection.prepareStatement(SAVE);

                prStatement.setString(1, airplane.getType());
                prStatement.setLong(2, airplane.getNumberSeets());
                prStatement.setLong(3, airplane.getRangeFlight());
                prStatement.setLong(4, airplane.getCarryingCapacity());
                prStatement.setLong(5, airplane.getTeam());

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
            logDAO.trace("Can't Updata Data in Airplane", e);
        } finally {
            try {
                connection.close();
                logDAO.trace("Connection closed");
            } catch (SQLException e) {
                logDAO.warn("Can't close Connection", e);
            }
        }

        return airplane;
    }

    @Override
    public void delete(Long id) {

        logDAO.trace("Delete Data from Airplanes");
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
            logDAO.trace("Can't Delete Data in Airplane");
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
    public void update(Airplane airplane) {

        logDAO.trace("Update Data in Airplanes");
        Connection connection = null;
        PreparedStatement prStatement = null;

        try {
            logDAO.trace("Open Connection");
            connection = ConnectionFactory.getConnection();
            try {
                logDAO.trace("Create PreparedStatement");
                prStatement = connection.prepareStatement(UPDATE);
                prStatement.setString(1, airplane.getType());
                prStatement.setLong(2, airplane.getNumberSeets());
                prStatement.setLong(3, airplane.getRangeFlight());
                prStatement.setLong(4, airplane.getCarryingCapacity());
                prStatement.setLong(5, airplane.getTeam());

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
            logDAO.trace("Can't Update Data in Airplanes", e);
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
