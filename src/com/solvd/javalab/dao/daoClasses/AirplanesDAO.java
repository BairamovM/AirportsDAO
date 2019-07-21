package com.solvd.javalab.dao.daoClasses;

import com.solvd.javalab.dao.entity.Airplanes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AirplanesDAO implements DAO <Airplanes>{

    public static final String getById = "SELECT * FROM Airplanes WHERE id = ?";
    public static final String getAll = "SELECT * FROM Airplanes";
    public static final String save = "INSERT INTO Airplanes VALUES (?,?,?,?)";
    public static final String delete = "DELETE FROM Airplanes WHERE id =?";
    public static final String update = "UPDATE Airplanes SET type = ?, numberSeets = ?,rangeFlight = ?, carryingCapacity = ?, Teams_id = ? WHERE id =?";

    @Override
    public Airplanes get(Long id) {

        Connection connection = ConnectionFactory.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(getById);
            preparedStatement.setLong(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                Airplanes airplane = new Airplanes();
                airplane.setId(rs.getLong("id"));
                airplane.setType(rs.getString("type"));
                airplane.setNumberSeets(rs.getLong("numberSeets"));
                airplane.setRangeFlight(rs.getLong("rangeFlight"));
                airplane.setCarryingCapacity(rs.getLong("carryingCapacity"));
                airplane.setTeams_id(rs.getLong("Teams_id"));
                return airplane;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    @Override
    public List<Airplanes> getAll() {

        Connection connection = ConnectionFactory.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(getAll);
            ResultSet rs = preparedStatement.executeQuery();
            List<Airplanes> airplanes = new ArrayList<>();

            while (rs.next()) {
                Airplanes airplane = new Airplanes();
                airplane.setId(rs.getLong("id"));
                airplane.setType(rs.getString("type"));
                airplane.setNumberSeets(rs.getLong("numberSeets"));
                airplane.setRangeFlight(rs.getLong("rangeFlight"));
                airplane.setCarryingCapacity(rs.getLong("carryingCapacity"));
                airplane.setTeams_id(rs.getLong("Teams_id"));
                airplanes.add(airplane);

            }
            return airplanes;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    @Override
    public void save(Airplanes airplane) {

        Connection connection = ConnectionFactory.getConnection();

        try {

            PreparedStatement preparedStatement = connection.prepareStatement(save);
            preparedStatement.setString(1, airplane.getType());
            preparedStatement.setLong(2, airplane.getNumberSeets());
            preparedStatement.setLong(3, airplane.getRangeFlight());
            preparedStatement.setLong(4, airplane.getCarryingCapacity());
            preparedStatement.setLong(5, airplane.getTeams_id());

            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void delete(Long id) {

        Connection connection = ConnectionFactory.getConnection();

        try {

            PreparedStatement preparedStatement = connection.prepareStatement(delete);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate(delete);

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void update(Airplanes airplane) {

        Connection connection = ConnectionFactory.getConnection();

        try {

            PreparedStatement preparedStatement = connection.prepareStatement(update);
            preparedStatement.setString(1, airplane.getType());
            preparedStatement.setLong(2, airplane.getNumberSeets());
            preparedStatement.setLong(3, airplane.getRangeFlight());
            preparedStatement.setLong(4, airplane.getCarryingCapacity());
            preparedStatement.setLong(5, airplane.getTeams_id());

            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

}
