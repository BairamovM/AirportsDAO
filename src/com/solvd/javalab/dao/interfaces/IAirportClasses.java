package com.solvd.javalab.dao.interfaces;

import com.solvd.javalab.dao.entity.AirportClasses;
import java.util.List;

public interface IAirportClasses {

    AirportClasses getByID(Long id);

    List<AirportClasses> getAll();

    void save(AirportClasses value);

    void delete(Long id);

    void update(AirportClasses value);

}
