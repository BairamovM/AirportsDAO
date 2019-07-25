package com.solvd.airport.dao.jdbc;

import com.solvd.airport.entity.Teams;
import com.solvd.airport.dao.ITeams;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class TeamsDAO implements ITeams {

    private static final Logger logDAO = Logger.getLogger(TeamsDAO.class);

    public static final String getId = "SELECT * FROM Teams WHERE id = ?";
    public static final String getAll = "SELECT * FROM Teams";
    public static final String save = "INSERT INTO Teams VALUES (?,?,?,?)";
    public static final String delete = "DELETE FROM Teams WHERE id =?";
    public static final String update = "UPDATE Teams SET ChiefPilots_id = ?, SecondPilots_id = ?, " +
            "Stewardesses_id = ? WHERE id =?";

    @Override
    public Teams getByID(Long id) {

        logDAO.trace("Try to find Teams with id = " + id);

        Teams teams = null;
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
                        teams = new Teams();
                        teams.setId(rSet.getLong("id"));
                        teams.setChiefPilots_id(rSet.getLong("ChiefPilots_id"));
                        teams.setSecondPilots_id(rSet.getLong("SecondPilots_id"));
                        teams.setStewardesses_id(rSet.getLong("Stewardesses_id"));
                        return teams;
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
            logDAO.trace("Can't find teams");
        } finally {
            try {
                connection.close();
                logDAO.trace("Connection closed");
            } catch (SQLException e) {
                logDAO.warn("Can't close Connection", e);
            }
        }

        if (null == teams) {
            logDAO.debug("teams not found");
        } else {
            logDAO.trace("Find teams");
        }

        logDAO.trace("Return teams");
        return teams;
    }

    @Override
    public List<Teams> getAll() {

        logDAO.trace("Try to find all teams");
        Teams teams = null;
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
                    List<Teams> team = new ArrayList<>();
                    while (rSet.next()) {
                        teams = new Teams();
                        teams.setId(rSet.getLong("id"));
                        teams.setChiefPilots_id(rSet.getLong("ChiefPilots_id"));
                        teams.setSecondPilots_id(rSet.getLong("SecondPilots_id"));
                        teams.setStewardesses_id(rSet.getLong("Stewardesses_id"));
                        team.add(teams);

                    }
                    return team;
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
            logDAO.trace("Can't find any teams", e);
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
    public void save(Teams teams) {

        logDAO.trace("Update Data in teams");
        Connection connection = null;
        PreparedStatement prStatement = null;

        try {
            logDAO.trace("Open Connection");
            connection = ConnectionFactory.getConnection();
            try {
                logDAO.trace("Create PreparedStatement");
                prStatement = connection.prepareStatement(save);

                prStatement.setLong(1, teams.getChiefPilots_id());
                prStatement.setLong(2, teams.getSecondPilots_id());
                prStatement.setLong(3, teams.getStewardesses_id());

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
            logDAO.trace("Can't Updata Data in teams", e);
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

        logDAO.trace("Delete Data from teams");
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
            logDAO.trace("Can't Delete Data in teams");
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
    public void update(Teams teams) {

        logDAO.trace("Update Data in teams");
        Connection connection = null;
        PreparedStatement prStatement = null;

        try {
            logDAO.trace("Open Connection");
            connection = ConnectionFactory.getConnection();
            try {
                logDAO.trace("Create PreparedStatement");
                prStatement = connection.prepareStatement(update);
                prStatement.setLong(1, teams.getChiefPilots_id());
                prStatement.setLong(2, teams.getSecondPilots_id());
                prStatement.setLong(3, teams.getStewardesses_id());

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
            logDAO.trace("Can't Update Data in teams", e);
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
