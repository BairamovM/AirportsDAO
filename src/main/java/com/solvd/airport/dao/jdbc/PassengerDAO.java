package com.solvd.airport.dao.jdbc;

import com.solvd.airport.entity.Passenger;
import com.solvd.airport.entity.SeatFlight;
import com.solvd.airport.dao.IPassenger;
import com.solvd.airport.service.IPassengerTransaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class PassengerDAO implements IPassenger, IPassengerTransaction {

    private static final Logger logDAO = Logger.getLogger(PassengerDAO.class);

    public static final String GET_ID = "SELECT * FROM Passengers WHERE id = ?";
    public static final String GET_ALL = "SELECT * FROM Passengers";
    public static final String SAVE = "INSERT INTO Passengers VALUES (?,?,?,?)";

    public static final String INSERT_Passengers = "INSERT INTO Passengers VALUES (?,?,?,?)";
    public static final String INSERT_SeatsFlight = "INSERT INTO SeatsFlight VALUES (?,?,?,?)";

    public static final String DELETE = "DELETE FROM Passengers WHERE id =?";
    public static final String UPDATE = "UPDATE Passengers SET firstName = ?, lastName = ?,dateBirth = ?, " +
            "gender = ?, passportSerialNumber = ?, Nationalities_id = ? WHERE id =?";

    @Override
    public Passenger getByID(Long id) {

        logDAO.trace("Try to find Passengers with id = " + id);

        Passenger passengers = null;
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
                        passengers = new Passenger();
                        passengers.setId(rSet.getLong("id"));
                        passengers.setFirstName(rSet.getString("firstName"));
                        passengers.setLastName(rSet.getString("lastName"));
                        passengers.setDateBirth(rSet.getString("dateBirth"));
                        passengers.setGender(rSet.getString("gender"));
                        passengers.setPassportSerialNumber(rSet.getDouble("passportSerialNumber"));
                        //passengers.setNationality(rSet.getLong("Nationalities_id"));
                        return passengers;
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
            logDAO.trace("Can't find passengers");
        } finally {
            try {
                connection.close();
                logDAO.trace("Connection closed");
            } catch (SQLException e) {
                logDAO.warn("Can't close Connection", e);
            }
        }

        if (null == passengers) {
            logDAO.debug("passengers not found");
        } else {
            logDAO.trace("Find passengers");
        }

        logDAO.trace("Return passengers");
        return passengers;
    }

    @Override
    public Passenger getAll() {

        logDAO.trace("Try to find all passengers");
        Passenger passengers = null;
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
                    List<Passenger> passenger = new ArrayList<>();
                    while (rSet.next()) {
                        passengers = new Passenger();
                        passengers.setId(rSet.getLong("id"));
                        passengers.setFirstName(rSet.getString("firstName"));
                        passengers.setLastName(rSet.getString("lastName"));
                        passengers.setDateBirth(rSet.getString("dateBirth"));
                        passengers.setGender(rSet.getString("gender"));
                        passengers.setPassportSerialNumber(rSet.getDouble("passportSerialNumber"));
                        //passengers.setNationality(rSet.getLong("Nationalities_id"));
                        passenger.add(passengers);

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
            logDAO.trace("Can't find any passengers", e);
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
    public Passenger save(Passenger passengers) {

        logDAO.trace("Update Data in passengers");
        Connection connection = null;
        PreparedStatement prStatement = null;

        try {
            logDAO.trace("Open Connection");
            connection = ConnectionFactory.getConnection();
            try {
                logDAO.trace("Create PreparedStatement");
                prStatement = connection.prepareStatement(SAVE);

                prStatement.setString(1, passengers.getFirstName());
                prStatement.setString(2, passengers.getLastName());
                prStatement.setString(3, passengers.getDateBirth());
                prStatement.setString(4, passengers.getGender());
                prStatement.setDouble(5, passengers.getPassportSerialNumber());
                //prStatement.setLong(6, passengers.getNationality());

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
            logDAO.trace("Can't Updata Data in passengers", e);
        } finally {
            try {
                connection.close();
                logDAO.trace("Connection closed");
            } catch (SQLException e) {
                logDAO.warn("Can't close Connection", e);
            }
        }

        return passengers;
    }

    @Override
    public void delete(Long id) {

        logDAO.trace("Delete Data from passengers");
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
            logDAO.trace("Can't Delete Data in passengers");
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
    public void update(Passenger passengers) {

        logDAO.trace("Update Data in passengers");
        Connection connection = null;
        PreparedStatement prStatement = null;

        try {
            logDAO.trace("Open Connection");
            connection = ConnectionFactory.getConnection();
            try {
                logDAO.trace("Create PreparedStatement");
                prStatement = connection.prepareStatement(UPDATE);
                prStatement.setString(1, passengers.getFirstName());
                prStatement.setString(2, passengers.getLastName());
                prStatement.setString(3, passengers.getDateBirth());
                prStatement.setString(4, passengers.getGender());
                prStatement.setDouble(5, passengers.getPassportSerialNumber());
                //prStatement.setLong(6, passengers.getNationality());

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
            logDAO.trace("Can't Update Data in passengers", e);
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
    public void bookPlace(Passenger passengers, SeatFlight seatsFlight) {



            logDAO.trace("Update Data in passengers and seatsFlight");
            Connection connectionpass = null;
            PreparedStatement prStatementpass = null;

            try {
                logDAO.trace("Open Connection");
                connectionpass = ConnectionFactory.getConnection();
                try {
                    logDAO.trace("Create PreparedStatement");
                    prStatementpass = connectionpass.prepareStatement(SAVE);

                    prStatementpass.setString(1, passengers.getFirstName());
                    prStatementpass.setString(2, passengers.getLastName());
                    prStatementpass.setString(3, passengers.getDateBirth());
                    prStatementpass.setString(4, passengers.getGender());
                    prStatementpass.setDouble(5, passengers.getPassportSerialNumber());
                    //prStatementpass.setLong(6, passengers.getNationality());

                    prStatementpass.executeUpdate();
                } finally {
                    try {
                        prStatementpass.close();
                        logDAO.trace("PreparedStatement closed");
                    } catch (SQLException e) {
                        logDAO.warn("Can't close PreparedStatement", e);
                    }
                }
            } catch (SQLException e) {
                logDAO.trace("Can't Updata Data in passengers", e);
            } finally {
                try {
                    connectionpass.close();
                    logDAO.trace("Connection closed");
                } catch (SQLException e) {
                    logDAO.warn("Can't close Connection", e);
                }
            }




            logDAO.trace("Update Data in seatsFlight");
            Connection connectionseats = null;
            PreparedStatement prStatementseats = null;

            try {
                logDAO.trace("Open Connection");
                connectionseats = ConnectionFactory.getConnection();
                try {
                    logDAO.trace("Create PreparedStatement");
                    prStatementseats = connectionseats.prepareStatement(SAVE);

                    prStatementseats.setLong(1, seatsFlight.getNumberSeet());
                    prStatementseats.setLong(2, seatsFlight.getTicketPrice());
                    //prStatementseats.setLong(3, seatsFlight.getAirplane());
                    //prStatementseats.setLong(4, seatsFlight.getPassenger());
                    //prStatementseats.setLong(5, seatsFlight.getClassSeet());

                    prStatementseats.executeUpdate();
                } finally {
                    try {
                        prStatementseats.close();
                        logDAO.trace("PreparedStatement closed");
                    } catch (SQLException e) {
                        logDAO.warn("Can't close PreparedStatement", e);
                    }
                }
            } catch (SQLException e) {
                logDAO.trace("Can't Updata Data in seatsFlight", e);
            } finally {
                try {
                    connectionseats.close();
                    logDAO.trace("Connection closed");
                } catch (SQLException e) {
                    logDAO.warn("Can't close Connection", e);
                }
            }





    }

}
