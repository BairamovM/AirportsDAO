package com.solvd.javalab.dao.daoClasses;

import com.solvd.javalab.dao.entity.Airplanes;
import com.solvd.javalab.dao.daoClasses.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AirplanesDAO implements DAO <Airplanes>{

    final String getById = "SELECT * FROM Airplanes WHERE id = ?";
    final String getAll = "SELECT * FROM Airplanes";
    final String save = "INSERT INTO Airplanes VALUES (?,?,?,?)";
    final String delete = "DELETE FROM Airplanes WHERE id =?";
    final String update = "UPDATE Airplanes SET type = ?, numberSeets = ?,rangeFlight = ?, carryingCapacity = ?, Teams_id = ? WHERE id =?";

    @Override
    public Airplanes get(Long id) {

        return null;
    }

    @Override
    public List<Airplanes> getAll() {

        return null;
    }

    @Override
    public void save(Airplanes airplanes) {


    }

    @Override
    public void delete(Long id) {


    }

    @Override
    public void update(Airplanes airplanes) {


    }

}
