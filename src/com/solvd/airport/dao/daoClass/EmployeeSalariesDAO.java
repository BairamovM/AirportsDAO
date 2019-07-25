package com.solvd.airport.dao.daoClass;

import com.solvd.airport.dao.entity.EmployeeSalaries;
import com.solvd.airport.dao.interfaces.IEmployeeSalaries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class EmployeeSalariesDAO implements IEmployeeSalaries {

    private static final Logger logDAO = Logger.getLogger(EmployeeSalariesDAO.class);

    public static final String getId = "SELECT * FROM EmployeeSalaries WHERE id = ?";
    public static final String getAll = "SELECT * FROM EmployeeSalaries";
    public static final String save = "INSERT INTO EmployeeSalaries VALUES (?,?,?,?)";
    public static final String delete = "DELETE FROM EmployeeSalaries WHERE id =?";
    public static final String update = "UPDATE EmployeeSalaries SET amount = ? WHERE id =?";

    @Override
    public EmployeeSalaries getByID(Long id) {

        logDAO.trace("Try to find EmployeeSalaries with id = " + id);

        EmployeeSalaries employeeSalaries = null;
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
                        employeeSalaries = new EmployeeSalaries();
                        employeeSalaries.setId(rSet.getLong("id"));
                        employeeSalaries.setAmount(rSet.getDouble("amount"));
                        return employeeSalaries;
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
            logDAO.trace("Can't find employeeSalaries");
        } finally {
            try {
                connection.close();
                logDAO.trace("Connection closed");
            } catch (SQLException e) {
                logDAO.warn("Can't close Connection", e);
            }
        }

        if (null == employeeSalaries) {
            logDAO.debug("employeeSalaries not found");
        } else {
            logDAO.trace("Find employeeSalaries");
        }

        logDAO.trace("Return employeeSalaries");
        return employeeSalaries;
    }

    @Override
    public List<EmployeeSalaries> getAll() {

        logDAO.trace("Try to find all employeeSalaries");
        EmployeeSalaries employeeSalaries = null;
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
                    List<EmployeeSalaries> employeeSalarie = new ArrayList<>();
                    while (rSet.next()) {
                        employeeSalaries = new EmployeeSalaries();
                        employeeSalaries.setId(rSet.getLong("id"));
                        employeeSalaries.setAmount(rSet.getDouble("amount"));
                        employeeSalarie.add(employeeSalaries);

                    }
                    return employeeSalarie;
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
            logDAO.trace("Can't find any employeeSalaries", e);
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
    public void save(EmployeeSalaries employeeSalaries) {

        logDAO.trace("Update Data in employeeSalaries");
        Connection connection = null;
        PreparedStatement prStatement = null;

        try {
            logDAO.trace("Open Connection");
            connection = ConnectionFactory.getConnection();
            try {
                logDAO.trace("Create PreparedStatement");
                prStatement = connection.prepareStatement(save);

                prStatement.setDouble(1, employeeSalaries.getAmount());

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
            logDAO.trace("Can't Updata Data in employeeSalaries", e);
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

        logDAO.trace("Delete Data from employeeSalaries");
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
            logDAO.trace("Can't Delete Data in employeeSalaries");
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
    public void update(EmployeeSalaries employeeSalaries) {

        logDAO.trace("Update Data in employeeSalaries");
        Connection connection = null;
        PreparedStatement prStatement = null;

        try {
            logDAO.trace("Open Connection");
            connection = ConnectionFactory.getConnection();
            try {
                logDAO.trace("Create PreparedStatement");
                prStatement = connection.prepareStatement(update);
                prStatement.setDouble(1, employeeSalaries.getAmount());

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
            logDAO.trace("Can't Update Data in employeeSalaries", e);
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
