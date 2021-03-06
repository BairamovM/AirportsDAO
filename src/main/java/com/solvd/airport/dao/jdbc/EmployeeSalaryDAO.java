package com.solvd.airport.dao.jdbc;

import com.solvd.airport.entity.EmployeeSalary;
import com.solvd.airport.dao.IEmployeeSalary;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class EmployeeSalaryDAO implements IEmployeeSalary {

    private static final Logger logDAO = Logger.getLogger(EmployeeSalaryDAO.class);

    public static final String GET_ID = "SELECT * FROM EmployeeSalaries WHERE id = ?";
    public static final String GET_ALL = "SELECT * FROM EmployeeSalaries";
    public static final String SAVE = "INSERT INTO EmployeeSalaries VALUES (?,?,?,?)";
    public static final String DELETE = "DELETE FROM EmployeeSalaries WHERE id =?";
    public static final String UPDATE = "UPDATE EmployeeSalaries SET amount = ? WHERE id =?";

    @Override
    public EmployeeSalary getByID(Long id) {

        logDAO.trace("Try to find EmployeeSalaries with id = " + id);

        EmployeeSalary employeeSalaries = null;
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
                        employeeSalaries = new EmployeeSalary();
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
    public EmployeeSalary getAll() {

        logDAO.trace("Try to find all employeeSalaries");
        EmployeeSalary employeeSalaries = null;
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
                    List<EmployeeSalary> employeeSalarie = new ArrayList<>();
                    while (rSet.next()) {
                        employeeSalaries = new EmployeeSalary();
                        employeeSalaries.setId(rSet.getLong("id"));
                        employeeSalaries.setAmount(rSet.getDouble("amount"));
                        employeeSalarie.add(employeeSalaries);

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
    public EmployeeSalary save(EmployeeSalary employeeSalaries) {

        logDAO.trace("Update Data in employeeSalaries");
        Connection connection = null;
        PreparedStatement prStatement = null;

        try {
            logDAO.trace("Open Connection");
            connection = ConnectionFactory.getConnection();
            try {
                logDAO.trace("Create PreparedStatement");
                prStatement = connection.prepareStatement(SAVE);

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

        return employeeSalaries;
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
    public void update(EmployeeSalary employeeSalaries) {

        logDAO.trace("Update Data in employeeSalaries");
        Connection connection = null;
        PreparedStatement prStatement = null;

        try {
            logDAO.trace("Open Connection");
            connection = ConnectionFactory.getConnection();
            try {
                logDAO.trace("Create PreparedStatement");
                prStatement = connection.prepareStatement(UPDATE);
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
