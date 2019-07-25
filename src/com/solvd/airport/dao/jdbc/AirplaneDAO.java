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

    public static final String getId = "SELECT * FROM Airplanes WHERE id = ?";
    public static final String getAll = "SELECT * FROM Airplanes";
    public static final String save = "INSERT INTO Airplanes VALUES (?,?,?,?)";
    public static final String delete = "DELETE FROM Airplanes WHERE id =?";
    public static final String update = "UPDATE Airplanes SET type = ?, numberSeets = ?,rangeFlight = ?, carryingCapacity = ?, Teams_id = ? WHERE id =?";

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
                prStatement = connection.prepareStatement(getId);
                prStatement.setLong(1, id);
                try {
                    logDAO.trace("Get ResultSet");
                    rSet = prStatement.executeQuery();
                    if (rSet.next()) {
                        airplane = new Airplane();
                        airplane.setId(rSet.getLong("id"));
                        airplane.setType(rSet.getString("type"));
                        airplane.setNumberSeets(rSet.getLong("numberSeets"));
                        airplane.setRangeFlight(rSet.getLong("rangeFlight"));
                        airplane.setCarryingCapacity(rSet.getLong("carryingCapacity"));
                        //airplane.setTeam(rSet.getTeam("Team"));
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
    public List<Airplane> getAll() {

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
                prStatement = connection.prepareStatement(getAll);
                try {
                    logDAO.trace("Get ResultSet");
                    rSet = prStatement.executeQuery();
                    List<Airplane> airplanes = new ArrayList<>();
                    while (rSet.next()) {
                        airplane = new Airplane();
                        airplane.setId(rSet.getLong("id"));
                        airplane.setType(rSet.getString("type"));
                        airplane.setNumberSeets(rSet.getLong("numberSeets"));
                        airplane.setRangeFlight(rSet.getLong("rangeFlight"));
                        airplane.setCarryingCapacity(rSet.getLong("carryingCapacity"));
                        //airplane.setTeam(rSet.getTeam("Team"));
                        airplanes.add(airplane);

                    }
                    return airplanes;
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
    public void save(Airplane airplane) {

        logDAO.trace("Update Data in airplane");
        Connection connection = null;
        PreparedStatement prStatement = null;

        try {
            logDAO.trace("Open Connection");
            connection = ConnectionFactory.getConnection();
            try {
                logDAO.trace("Create PreparedStatement");
                prStatement = connection.prepareStatement(save);

                prStatement.setString(1, airplane.getType());
                prStatement.setLong(2, airplane.getNumberSeets());
                prStatement.setLong(3, airplane.getRangeFlight());
                prStatement.setLong(4, airplane.getCarryingCapacity());
                //prStatement.setTeam(5, airplane.getTeam());

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
                prStatement = connection.prepareStatement(update);
                prStatement.setString(1, airplane.getType());
                prStatement.setLong(2, airplane.getNumberSeets());
                prStatement.setLong(3, airplane.getRangeFlight());
                prStatement.setLong(4, airplane.getCarryingCapacity());
                //prStatement.setTeam(5, airplane.getTeam());

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
