package com.solvd.javalab.dao.interfaces;

import com.solvd.javalab.dao.entity.Airports;
import java.util.List;

public interface IAirports {

    Airports getByID(Long id);

    List<Airports> getAll();

    void save(Airports value);

    void delete(Long id);

    void update(Airports value);

}
