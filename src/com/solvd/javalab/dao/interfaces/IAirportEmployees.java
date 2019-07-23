package com.solvd.javalab.dao.interfaces;

import com.solvd.javalab.dao.entity.AirportEmployees;
import java.util.List;

public interface IAirportEmployees {

    AirportEmployees getByID(Long id);

    List<AirportEmployees> getAll();

    void save(AirportEmployees value);

    void delete(Long id);

    void update(AirportEmployees value);

}
