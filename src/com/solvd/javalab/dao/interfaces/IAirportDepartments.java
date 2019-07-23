package com.solvd.javalab.dao.interfaces;

import com.solvd.javalab.dao.entity.AirportDepartments;
import java.util.List;

public interface IAirportDepartments {

    AirportDepartments getByID(Long id);

    List<AirportDepartments> getAll();

    void save(AirportDepartments value);

    void delete(Long id);

    void update(AirportDepartments value);

}
