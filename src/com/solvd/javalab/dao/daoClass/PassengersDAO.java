package com.solvd.javalab.dao.daoClass;

import com.solvd.javalab.dao.entity.Passengers;
import com.solvd.javalab.dao.entity.SeatsFlight;
import com.solvd.javalab.dao.interfaces.IPassengers;
import com.solvd.javalab.dao.transaction.IPassengerTransaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class PassengersDAO implements IPassengers,IPassengerTransaction {

    private static final Logger logDAO = Logger.getLogger(PassengersDAO.class);


    private Connection getConPassengers;
    private Connection getConSeatsFlight;

    private static PassengersDAO instance = null;
    public synchronized static PassengersDAO getInstance() {
        if (instance == null) {
            instance = new PassengersDAO();
            instance.getConPassengers();
            instance.getConSeatsFlight();
        }
        return instance;
    }

    public static final String getId = "SELECT * FROM Passengers WHERE id = ?";
    public static final String getAll = "SELECT * FROM Passengers";
    public static final String save = "INSERT INTO Passengers VALUES (?,?,?,?)";

    public static final String INSERT_Passengers = "INSERT INTO Passengers VALUES (?,?,?,?)";
    public static final String INSERT_SeatsFlight = "INSERT INTO SeatsFlight VALUES (?,?,?,?)";

    public static final String delete = "DELETE FROM Passengers WHERE id =?";
    public static final String update = "UPDATE Passengers SET firstName = ?, lastName = ?,dateBirth = ?, " +
            "gender = ?, passportSerialNumber = ?, Nationalities_id = ? WHERE id =?";

    @Override
    public Passengers getByID(Long id) {

        logDAO.trace("Try to find Passengers with id = " + id);

        Passengers passengers = null;
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
                        passengers = new Passengers();
                        passengers.setId(rSet.getLong("id"));
                        passengers.setFirstName(rSet.getString("firstName"));
                        passengers.setLastName(rSet.getString("lastName"));
                        passengers.setDateBirth(rSet.getString("dateBirth"));
                        passengers.setGender(rSet.getString("gender"));
                        passengers.setPassportSerialNumber(rSet.getDouble("passportSerialNumber"));
                        passengers.setNationalities_id(rSet.getLong("Nationalities_id"));
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
    public List<Passengers> getAll() {

        logDAO.trace("Try to find all passengers");
        Passengers passengers = null;
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
                    List<Passengers> passenger = new ArrayList<>();
                    while (rSet.next()) {
                        passengers = new Passengers();
                        passengers.setId(rSet.getLong("id"));
                        passengers.setFirstName(rSet.getString("firstName"));
                        passengers.setLastName(rSet.getString("lastName"));
                        passengers.setDateBirth(rSet.getString("dateBirth"));
                        passengers.setGender(rSet.getString("gender"));
                        passengers.setPassportSerialNumber(rSet.getDouble("passportSerialNumber"));
                        passengers.setNationalities_id(rSet.getLong("Nationalities_id"));
                        passenger.add(passengers);

                    }
                    return passenger;
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
    public void save(Passengers passengers) {

        logDAO.trace("Update Data in passengers");
        Connection connection = null;
        PreparedStatement prStatement = null;

        try {
            logDAO.trace("Open Connection");
            connection = ConnectionFactory.getConnection();
            try {
                logDAO.trace("Create PreparedStatement");
                prStatement = connection.prepareStatement(save);

                prStatement.setString(1, passengers.getFirstName());
                prStatement.setString(2, passengers.getLastName());
                prStatement.setString(3, passengers.getDateBirth());
                prStatement.setString(4, passengers.getGender());
                prStatement.setDouble(5, passengers.getPassportSerialNumber());
                prStatement.setLong(6, passengers.getNationalities_id());

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
    public void update(Passengers passengers) {

        logDAO.trace("Update Data in passengers");
        Connection connection = null;
        PreparedStatement prStatement = null;

        try {
            logDAO.trace("Open Connection");
            connection = ConnectionFactory.getConnection();
            try {
                logDAO.trace("Create PreparedStatement");
                prStatement = connection.prepareStatement(update);
                prStatement.setString(1, passengers.getFirstName());
                prStatement.setString(2, passengers.getLastName());
                prStatement.setString(3, passengers.getDateBirth());
                prStatement.setString(4, passengers.getGender());
                prStatement.setDouble(5, passengers.getPassportSerialNumber());
                prStatement.setLong(6, passengers.getNationalities_id());

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
    public void bookPlace(Passengers passengers, SeatsFlight seatsFlight) {

        private Connection getConPassengers (){

            logDAO.trace("Update Data in passengers");
            Connection connection = null;
            PreparedStatement prStatement = null;

            try {
                logDAO.trace("Open Connection");
                connection = ConnectionFactory.getConnection();
                try {
                    logDAO.trace("Create PreparedStatement");
                    prStatement = connection.prepareStatement(save);

                    prStatement.setString(1, passengers.getFirstName());
                    prStatement.setString(2, passengers.getLastName());
                    prStatement.setString(3, passengers.getDateBirth());
                    prStatement.setString(4, passengers.getGender());
                    prStatement.setDouble(5, passengers.getPassportSerialNumber());
                    prStatement.setLong(6, passengers.getNationalities_id());

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

        }

        private Connection getConSeatsFlight () {
            logDAO.trace("Update Data in seatsFlight");
            Connection connection = null;
            PreparedStatement prStatement = null;

            try {
                logDAO.trace("Open Connection");
                connection = ConnectionFactory.getConnection();
                try {
                    logDAO.trace("Create PreparedStatement");
                    prStatement = connection.prepareStatement(save);

                    prStatement.setLong(1, seatsFlight.getNumberSeet());
                    prStatement.setLong(2, seatsFlight.getTicketPrice());
                    prStatement.setLong(3, seatsFlight.getAirplanes_id());
                    prStatement.setLong(4, seatsFlight.getPassengers_id());
                    prStatement.setLong(5, seatsFlight.getClassSeets_id());

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
                logDAO.trace("Can't Updata Data in seatsFlight", e);
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

}
